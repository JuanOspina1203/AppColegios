package com.project;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.project.components.ResponseComponent;
import com.project.service.BookService;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.services.dynamodb.model.*;
import java.util.HashMap;
import java.util.Map;

public class App implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(App.class);
    private final BookService service;
    private final ResponseComponent responseComponent;

    public App(BookService service, ResponseComponent responseComponent) {
        this.service = service;
        this.responseComponent = responseComponent;
    }

    public App(){
        this(new BookService());
    }

    /**
     * Método principal que maneja todas las solicitudes HTTP.
     * Router central: dirige cada verbo HTTP (GET, POST, PUT, DELETE)
     * a su operación CRUD correspondiente (crear, leer, actualizar, eliminar libros).
     * Valida parámetros requeridos y maneja errores globales.
     */
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {
        try {
            String method = (event.getHttpMethod() != null) ? event.getHttpMethod() : "GET";
            Map<String, String> pathParams = (event.getPathParameters() != null)
                    ? event.getPathParameters()
                    : new HashMap<>();
            String id = pathParams.get("id");
            switch (method.toUpperCase()) {
                case "POST":
                    if (event.getBody() == null)
                        return this.responseComponent.buildResponse(400, Map.of("message", "Body is required"));
                    return this.service.createBook(event.getBody());
                case "GET":
                    return (id != null && !id.isEmpty()) ? this.service.readBook(id) : this.service.listBooks();
                case "PUT":
                    if (id == null || id.isEmpty())
                        return this.responseComponent.buildResponse(400, Map.of("message", "ID is required"));
                    if (event.getBody() == null)
                        return this.responseComponent.buildResponse(400, Map.of("message", "Body is required"));
                    return this.service.updateBook(id, event.getBody());
                case "DELETE":
                    if (id == null || id.isEmpty())
                        return this.responseComponent.buildResponse(400, Map.of("message", "ID is required"));
                    return this.service.deleteBook(id);
                default:
                    return this.responseComponent.buildResponse(405, Map.of("message", "Method not allowed"));
            }
        } catch (Exception e) {
            logger.error("Error in request", e);
            return this.responseComponent.buildResponse(500, Map.of("message", "Internal server error: " + e.getMessage()));
        }
    }
}
