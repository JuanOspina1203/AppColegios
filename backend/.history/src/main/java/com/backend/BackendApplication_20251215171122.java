package com.backend;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@SpringBootApplication
public class BackendApplication{

    private final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    Function<Map<String, Object>, APIGatewayProxyResponseEvent> handleMapRequest() {
        return eventMap -> {
            System.out.println("========== EVENT MAP RECIBIDO ==========");
            System.out.println("Event Map: " + eventMap);
            System.out.println("=========================================");
            try {
                String httpMethod = (String) eventMap.get("httpMethod");
                String path = (String) eventMap.get("path");
                String body = (String) eventMap.get("body");
                Map<String, String> queryParams = (Map<String, String>) eventMap.get("queryStringParameters");
                Map<String, String> headers = (Map<String, String>) eventMap.get("headers");
                System.out.println("HTTP Method: " + httpMethod);
                System.out.println("Path: " + path);
                System.out.println("Body: " + body);
                System.out.println("Query params: " + queryParams);
                System.out.println("Headers: " + headers);
                Map<String, String> responseData = new HashMap<>();
                responseData.put("message", "¡Lambda ejecutada exitosamente con Spring Boot!");
                responseData.put("receivedMethod", httpMethod != null ? httpMethod : "null");
                responseData.put("receivedPath", path != null ? path : "null");
                responseData.put("hasBody", body != null ? "Sí" : "No");
                String responseBody = objectMapper.writeValueAsString(responseData);
                APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
                response.setStatusCode(200);
                response.setBody(responseBody);
                response.setHeaders(Map.of("Content-Type", "application/json"));
                return response;
            } catch (Exception e) {
                System.err.println("ERROR: " + e.getMessage());
                APIGatewayProxyResponseEvent errorResponse = new APIGatewayProxyResponseEvent();
                errorResponse.setStatusCode(500);
                errorResponse.setBody("{\"error\":\"Error interno\"}");
                return errorResponse;
            }
        };
    }


}
