package com.project;

/*import com.amazonaws.services.lambda.runtime.Context;
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
        this(new BookService(), new ResponseComponent());
    }

    /**
     * Método principal que maneja todas las solicitudes HTTP.
     * Router central: dirige cada verbo HTTP (GET, POST, PUT, DELETE)
     * a su operación CRUD correspondiente (crear, leer, actualizar, eliminar libros).
     * Valida parámetros requeridos y maneja errores globales.

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
}*/

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;


public class App implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {


    private static final Logger logger = LoggerFactory.getLogger(App.class);
    private static final HikariDataSource dataSource;


    static {
        try {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:mysql://school-database.c94k8uuyaa36.us-east-2.rds.amazonaws.com:3306/school-database");
            config.setUsername("admin");
            config.setPassword("giovani2J#");
            config.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource = new HikariDataSource(config);
        } catch (Exception e) {
            logger.error("Error inicializando la conexion RDS: {}", e.getMessage(), e);
            throw new RuntimeException("Exception de conexion a la base de datos", e);
        }
    }

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {
        System.out.println("🎯 API GATEWAY FUNCIONANDO CORRECTAMENTE!");
        System.out.println("📝 Método HTTP: " + event.getHttpMethod());
        System.out.println("🔗 Path: " + event.getPath());
        System.out.println("📦 Body: " + event.getBody());
        System.out.println("🔍 Query Params: " + event.getQueryStringParameters());
        System.out.println("📋 Headers: " + event.getHeaders());
        return new APIGatewayProxyResponseEvent()
                .withStatusCode(200)
                .withBody("{\"status\":\"success\", \"message\":\"✅ API Gateway funcionando!\"}")
                .withHeaders(Map.of(
                        "Content-Type", "application/json",
                        "Access-Control-Allow-Origin", "*"
                ));
        /*logger.info("Iniciando prueba de conexión a RDS");
        Map<String, Object> responseBody = new HashMap<>();
        try {
            testDatabaseConnection();
            responseBody.put("status", "success");
            responseBody.put("message", "Conexión a RDS exitosa");
            responseBody.put("timestamp", System.currentTimeMillis());
            logger.info("Prueba de conexión completada exitosamente");
            return buildResponse(200, responseBody);
        } catch (Exception e) {
            logger.error("Error en la prueba de conexión: {}", e.getMessage(), e);
            responseBody.put("status", "error");
            responseBody.put("message", "Error de conexión: " + e.getMessage());
            responseBody.put("timestamp", System.currentTimeMillis());
            return buildResponse(500, responseBody);
        }*/
    }

    private void testDatabaseConnection() throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            logger.info("Conexión obtenida del pool");
            String testQuery = "SELECT 1 as test_result, NOW() as current_time";
            try (PreparedStatement stmt = connection.prepareStatement(testQuery);
                 ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int testResult = rs.getInt("test_result");
                    String currentTime = rs.getString("current_time");
                    logger.info("Resultado de prueba: {}", testResult);
                    logger.info("Hora de la base de datos: {}", currentTime);
                    if (testResult != 1)
                        throw new Exception("La consulta de prueba no retornó el resultado esperado");
                } else {
                    throw new Exception("No se obtuvo resultado de la consulta de prueba");
                }
            }
            logger.info("Consulta de prueba ejecutada correctamente");
        }
    }

    private APIGatewayProxyResponseEvent buildResponse(int statusCode, Object body) {
        try {
            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(statusCode)
                    .withBody(new com.fasterxml.jackson.databind.ObjectMapper().writeValueAsString(body))
                    .withHeaders(Map.of(
                            "Content-Type", "application/json",
                            "Access-Control-Allow-Origin", "*"
                    ));
        } catch (Exception e) {
            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(500)
                    .withBody("{\"error\": \"Error building response\"}");
        }
    }
}
