package com.project.components;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResponseComponent {

    public APIGatewayProxyResponseEvent buildResponse(Integer statusCode, Object body) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            Object responseBody = body;
            if (body instanceof List) {
                List<?> bodyList = (List<?>) body;
                if (!bodyList.isEmpty() && bodyList.get(0) instanceof Map) {
                    @SuppressWarnings("unchecked")
                    List<Map<String, AttributeValue>> dynamoItems =
                            (List<Map<String, AttributeValue>>) body;
                    responseBody = convertDynamoItems(dynamoItems);
                }
            } else if (body instanceof Map) {
                Map<?, ?> bodyMap = (Map<?, ?>) body;
                if (!bodyMap.isEmpty() && bodyMap.values().iterator().next() instanceof AttributeValue) {
                    @SuppressWarnings("unchecked")
                    Map<String, AttributeValue> dynamoItem = (Map<String, AttributeValue>) body;
                    responseBody = convertDynamoItem(dynamoItem);
                }
            }
            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(statusCode)
                    .withBody(mapper.writeValueAsString(responseBody))
                    .withHeaders(Map.of("Content-Type", "application/json"));
        } catch (Exception e) {
            throw new RuntimeException("Error building response", e);
        }
    }


    /**
     * Convierte un ítem de DynamoDB (Map<String, AttributeValue>) a un Map<String, Object> simple.
     * Itera sobre cada atributo y aplica convertAttributeValue para transformar los valores.
     */
    private Map<String, Object> convertDynamoItem(Map<String, AttributeValue> item) {
        Map<String, Object> result = new HashMap<>();
        item.forEach((key, value) -> result.put(key, convertAttributeValue(value)));
        return result;
    }

    /**
     * Convierte una lista de ítems de DynamoDB a una lista de Maps simples.
     * Aplica convertDynamoItem a cada elemento de la lista usando streams.
     */
    private List<Map<String, Object>> convertDynamoItems(List<Map<String, AttributeValue>> items) {
        return items.stream()
                .map(this::convertDynamoItem)
                .collect(Collectors.toList());
    }

    /**
     * Convierte un AttributeValue de DynamoDB a tipos de Java nativos.
     * Maneja todos los tipos de datos de DynamoDB: String (S), Number (N), Boolean (BOOL),
     * Map (M), List (L), Null, Binary (B), StringSet (SS), NumberSet (NS), BinarySet (BS).
     */
    private Object convertAttributeValue(AttributeValue value) {
        if (value.s() != null)
            return value.s();
        else if (value.n() != null)
            return value.n();
        else if (value.bool() != null)
            return value.bool();
        else if (value.hasM())
            return convertDynamoItem(value.m());
        else if (value.hasL())
            return value.l().stream()
                    .map(this::convertAttributeValue)
                    .collect(Collectors.toList());
        else if (value.nul() != null && value.nul())
            return null;
        else if (value.b() != null)
            return value.b().asByteArray();
        else if (value.ss() != null)
            return value.ss();
        else if (value.ns() != null)
            return value.ns();
        else if (value.bs() != null)
            return value.bs().stream()
                    .map(SdkBytes::asByteArray)
                    .collect(Collectors.toList());
        return null;
    }
}
