package com.project.service;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.project.model.BookModel;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class BookService {

    private final BookModel model;

    public BookService(BookModel model) {
        this.model = model;
    }

    public BookService() {
        this(new BookModel());
    }

    private final ObjectMapper objectMapper = new ObjectMapper();

    public APIGatewayProxyResponseEvent readBook(String id) {
        return Optional.ofNullable(this.model.getItem(id))
                .map(book -> buildResponse(200, book))
                .orElse(buildResponse(404, Map.of("Message", "Book not found")));
    }

    public APIGatewayProxyResponseEvent updateBook(String id, String body) {
        try {
            Map<String, Object> data = this.objectMapper.readValue(body, new com.fasterxml.jackson.core.type.TypeReference<>() {
            });
            if (!data.containsKey("title") || !data.containsKey("author"))
                return buildResponse(400, Map.of("message", "Title and author are required"));
            boolean updated = this.model.updateBook(id, data);
            return updated
                    ? buildResponse(200, Map.of("message", "Book updated successfully"))
                    : buildResponse(404, Map.of("message", "Book not found"));
        } catch (JsonProcessingException e) {
            return buildResponse(400, Map.of("message", "Invalid JSON format"));
        } catch (Exception e) {
            return buildResponse(500, Map.of("message", "Internal server error"));
        }
    }

    public APIGatewayProxyResponseEvent createBook(String body) {
        try {
            Map<String, Object> data = this.objectMapper.readValue(body, new com.fasterxml.jackson.core.type.TypeReference<>() {});
            if (!data.containsKey("title") || !data.containsKey("author"))
                return buildResponse(400, Map.of("message", "Title and author are required"));
            String bookId = this.model.createBook(data);
            return buildResponse(201, Map.of("message", "Book created successfully", "id", bookId));
        } catch (JsonProcessingException e) {
            return buildResponse(400, Map.of("message", "Invalid JSON format"));
        } catch (Exception e) {
            return buildResponse(500, Map.of("message", "Error creating book"));
        }
    }

    public APIGatewayProxyResponseEvent deleteBook(String id) {
        boolean deleted = this.model.deleteBook(id);

        return deleted
                ? buildResponse(200, Map.of("message", "Book deleted successfully"))
                : buildResponse(404, Map.of("message", "Book not found"));
    }

    public APIGatewayProxyResponseEvent listBooks() {
        try {
            List<Map<String, AttributeValue>> books = this.model.listBooks();
            return buildResponse(200, books);
        } catch (Exception e) {
            return buildResponse(500, Map.of("message", "Error listing books"));
        }
    }

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
        if (value.s() != null) {
            return value.s();
        } else if (value.n() != null) {
            return value.n();
        } else if (value.bool() != null) {
            return value.bool();
        } else if (value.hasM()) {
            return convertDynamoItem(value.m());
        } else if (value.hasL()) {
            return value.l().stream()
                    .map(this::convertAttributeValue)
                    .collect(Collectors.toList());
        } else if (value.nul() != null && value.nul()) {
            return null;
        } else if (value.b() != null) {
            return value.b().asByteArray();
        } else if (value.ss() != null) {
            return value.ss();
        } else if (value.ns() != null) {
            return value.ns();
        } else if (value.bs() != null) {
            return value.bs().stream()
                    .map(SdkBytes::asByteArray)
                    .collect(Collectors.toList());
        }
        return null;
    }
}
