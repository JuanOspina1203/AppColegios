package com.project.service;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.components.ResponseComponent;
import com.project.model.BookModel;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.*;

public class BookService {

    private final BookModel model;
    private final ResponseComponent responseComponent;

    public BookService(BookModel model, ResponseComponent responseComponent) {
        this.model = model;
        this.responseComponent = responseComponent;
    }

    public BookService() {
        this(new BookModel());
    }

    private final ObjectMapper objectMapper = new ObjectMapper();

    public APIGatewayProxyResponseEvent readBook(String id) {
        return Optional.ofNullable(this.model.getItem(id))
                .map(book -> this.responseComponent.buildResponse(200, book))
                .orElse(this.responseComponent.buildResponse(404, Map.of("Message", "Book not found")));
    }

    public APIGatewayProxyResponseEvent updateBook(String id, String body) {
        try {
            Map<String, Object> data = this.objectMapper.readValue(body, new com.fasterxml.jackson.core.type.TypeReference<>() {
            });
            if (!data.containsKey("title") || !data.containsKey("author"))
                return this.responseComponent.buildResponse(400, Map.of("message", "Title and author are required"));
            boolean updated = this.model.updateBook(id, data);
            return updated
                    ? this.responseComponent.buildResponse(200, Map.of("message", "Book updated successfully"))
                    : this.responseComponent.buildResponse(404, Map.of("message", "Book not found"));
        } catch (JsonProcessingException e) {
            return this.responseComponent.buildResponse(400, Map.of("message", "Invalid JSON format"));
        } catch (Exception e) {
            return this.responseComponent.buildResponse(500, Map.of("message", "Internal server error"));
        }
    }

    public APIGatewayProxyResponseEvent createBook(String body) {
        try {
            Map<String, Object> data = this.objectMapper.readValue(body, new com.fasterxml.jackson.core.type.TypeReference<>() {});
            if (!data.containsKey("title") || !data.containsKey("author"))
                return this.responseComponent.buildResponse(400, Map.of("message", "Title and author are required"));
            String bookId = this.model.createBook(data);
            return this.responseComponent.buildResponse(201, Map.of("message", "Book created successfully", "id", bookId));
        } catch (JsonProcessingException e) {
            return this.responseComponent.buildResponse(400, Map.of("message", "Invalid JSON format"));
        } catch (Exception e) {
            return this.responseComponent.buildResponse(500, Map.of("message", "Error creating book"));
        }
    }

    public APIGatewayProxyResponseEvent deleteBook(String id) {
        boolean deleted = this.model.deleteBook(id);

        return deleted
                ? this.responseComponent.buildResponse(200, Map.of("message", "Book deleted successfully"))
                : this.responseComponent.buildResponse(404, Map.of("message", "Book not found"));
    }

    public APIGatewayProxyResponseEvent listBooks() {
        try {
            List<Map<String, AttributeValue>> books = this.model.listBooks();
            return this.responseComponent.buildResponse(200, books);
        } catch (Exception e) {
            return this.responseComponent.buildResponse(500, Map.of("message", "Error listing books"));
        }
    }

    

    

    
}
