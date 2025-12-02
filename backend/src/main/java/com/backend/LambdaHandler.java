package com.backend;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LambdaHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {

        String httpMethod = Optional.ofNullable(event.getHttpMethod()).orElse(null);
        String path = Optional.ofNullable(event.getPath()).orElse(null);
        String body = Optional.ofNullable(event.getBody()).orElse(null);
        String resource = Optional.ofNullable(event.getResource()).orElse(null);
        Map<String, String> pathParams = Optional.ofNullable(event.getPathParameters()).orElse(null);
        Map<String, String> queryParams = Optional.ofNullable(event.getQueryStringParameters()).orElse(null);
        Map<String, String> headers = Optional.ofNullable(event.getHeaders()).orElse(null);

        context.getLogger().log("========== INICIO DE LA PETICIÓN ==========");
        context.getLogger().log("HTTP Method: " + httpMethod);
        context.getLogger().log("Path: " + path);
        context.getLogger().log("Resource: " + resource);
        context.getLogger().log("Query Parameters: " + queryParams.toString());
        context.getLogger().log("Query Parameters: null o vacíos");        
        context.getLogger().log("Path Parameters: " + pathParams.toString());
        context.getLogger().log("Path Parameters: null o vacíos");
        context.getLogger().log("Headers: " + headers.toString());
        context.getLogger().log("Body: " + body);
        context.getLogger().log("Body: null o vacío");
        context.getLogger().log("========== FIN DE LA PETICIÓN ==========");

        Map<String, String> responseData = new HashMap<>();
        responseData.put("message", "¡Lambda ejecutada exitosamente!");
        responseData.put("receivedMethod", httpMethod);
        responseData.put("receivedPath", path);
        responseData.put("hasBody", body);

         try {
            String responseBody = objectMapper.writeValueAsString(responseData);
            APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
            response.setStatusCode(200);
            response.setBody(responseBody);
            Map<String, String> responseHeaders = new HashMap<>();
            responseHeaders.put("Content-Type", "application/json");
            response.setHeaders(responseHeaders);
            return response;
        } catch (Exception e) {
            context.getLogger().log("ERROR al crear la respuesta JSON: " + e.getMessage());
            APIGatewayProxyResponseEvent errorResponse = new APIGatewayProxyResponseEvent();
            errorResponse.setStatusCode(500);
            errorResponse.setBody("{\"error\":\"Error interno procesando la solicitud\"}");
            return errorResponse;
        }
    }
}
