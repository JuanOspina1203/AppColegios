package com.backend;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
    public Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> handleRequest() {
        return event -> {
            String httpMethod = event.getHttpMethod();
            String path = event.getPath();
            String body = event.getBody();
            System.out.println("========== INICIO DE LA PETICIÓN ==========");
            System.out.println("HTTP Method: " + httpMethod);
            System.out.println("Path: " + path);
            System.out.println("Body: " + body);
            System.out.println("========== FIN DE LA PETICIÓN ==========");
            Map<String, String> responseData = new HashMap<>();
            responseData.put("message", "¡Lambda ejecutada exitosamente con Spring Boot!");
            responseData.put("receivedMethod", httpMethod);
            responseData.put("receivedPath", path);
            responseData.put("hasBody", body != null ? "Sí" : "No");
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
                System.err.println("ERROR: " + e.getMessage());
                APIGatewayProxyResponseEvent errorResponse = new APIGatewayProxyResponseEvent();
                errorResponse.setStatusCode(500);
                errorResponse.setBody("{\"error\":\"Error interno\"}");
                return errorResponse;
            }
        };
    }
}
