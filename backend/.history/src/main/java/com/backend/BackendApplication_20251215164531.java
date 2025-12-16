package com.backend;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@SpringBootApplication
public class BackendApplication {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public Function<Message<String>, APIGatewayProxyResponseEvent> handleRequest() {
        return message -> {
            try {
                System.out.println("====== HEADERS DEL MENSAJE ======");
                System.out.println("Headers: " + message.getHeaders());
                System.out.println("Payload: " + message.getPayload());
                Map<String, Object> eventData = objectMapper.readValue(message.getPayload(), Map.class);
                String httpMethod = (String) eventData.get("httpMethod");
                String path = (String) eventData.get("path");
                String body = (String) eventData.get("body");
                Map<String, String> queryParams = (Map<String, String>) eventData.get("queryStringParameters");
                Map<String, String> headers = (Map<String, String>) eventData.get("headers");
                System.out.println("====== DATOS DEL REQUEST ======");
                System.out.println("HTTP Method: " + httpMethod);
                System.out.println("Path: " + path);
                System.out.println("Body: " + body);
                System.out.println("Query params: " + queryParams);
                System.out.println("Headers: " + headers);
                if ("GET".equalsIgnoreCase(httpMethod)) {
                    return handleGetRequest(eventData);
                } else if ("POST".equalsIgnoreCase(httpMethod)) {
                    return handlePostRequest(eventData);
                } else if ("PUT".equalsIgnoreCase(httpMethod)) {
                    return handlePutRequest(eventData);
                } else if ("DELETE".equalsIgnoreCase(httpMethod)) {
                    return handleDeleteRequest(eventData);
                } else {
                    return createResponse(400, "{\"error\":\"Método no soportado\"}");
                }
            } catch (Exception e) {
                System.err.println("ERROR: " + e.getMessage());
                e.printStackTrace();
                return createResponse(500, "{\"error\":\"Error interno del servidor\"}");
            }
        };
    }

    private APIGatewayProxyResponseEvent handleGetRequest(Map<String, Object> eventData) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", "GET request recibido");
        responseBody.put("method", "GET");
        responseBody.put("path", eventData.get("path"));
        responseBody.put("queryParams", eventData.get("queryStringParameters"));
        try {
            String jsonResponse = objectMapper.writeValueAsString(responseBody);
            return createResponse(200, jsonResponse);
        } catch (Exception e) {
            return createResponse(500, "{\"error\":\"Error al procesar GET\"}");
        }
    }

    private APIGatewayProxyResponseEvent handlePostRequest(Map<String, Object> eventData) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", "POST request recibido");
        responseBody.put("method", "POST");
        responseBody.put("path", eventData.get("path"));
        responseBody.put("body", eventData.get("body"));
        try {
            String jsonResponse = objectMapper.writeValueAsString(responseBody);
            return createResponse(200, jsonResponse);
        } catch (Exception e) {
            return createResponse(500, "{\"error\":\"Error al procesar POST\"}");
        }
    }

    private APIGatewayProxyResponseEvent handlePutRequest(Map<String, Object> eventData) {
        return createResponse(200, "{\"message\":\"PUT request recibido\"}");
    }

    private APIGatewayProxyResponseEvent handleDeleteRequest(Map<String, Object> eventData) {
        return createResponse(200, "{\"message\":\"DELETE request recibido\"}");
    }

    private APIGatewayProxyResponseEvent createResponse(int statusCode, String body) {
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.setStatusCode(statusCode);
        response.setBody(body);
        response.setHeaders(Map.of(
                "Content-Type", "application/json",
                "Access-Control-Allow-Origin", "*"
        ));
        return response;
    }
}
