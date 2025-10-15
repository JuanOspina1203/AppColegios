package com.project.model;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BookModel {
    private final DynamoDbClient dynamoDbClient = DynamoDbClient.builder()
            .region(Region.US_EAST_2)
            .build();
    private final String tableName = "books";

    public Map<String,AttributeValue> getItem (String id) {
        return this.dynamoDbClient.getItem(GetItemRequest.builder()
                .tableName(this.tableName)
                .key(Map.of("id", AttributeValue.builder().s(id).build()))
                .consistentRead(true)
                .build()).item();
    }

    public boolean updateBook(String id, Map<String, Object> data) {
        try {
            this.dynamoDbClient.updateItem(UpdateItemRequest.builder()
                    .tableName(this.tableName)
                    .key(Map.of("id", AttributeValue.builder().s(id).build()))
                    .updateExpression("SET #title = :title, #author = :author")
                    .conditionExpression("attribute_exists(id)")
                    .expressionAttributeNames(Map.of(
                            "#title", "title",
                            "#author", "author"))
                    .expressionAttributeValues(Map.of(
                            ":title", AttributeValue.builder().s(data.get("title").toString()).build(),
                            ":author", AttributeValue.builder().s(data.get("author").toString()).build()
                    ))
                    .build());
            return true;
        } catch (ConditionalCheckFailedException e) {
            return false;
        }
    }

    public String createBook(Map<String, Object> data) {
        String uuid = UUID.randomUUID().toString();
        data.put("id", uuid);

        Map<String, AttributeValue> item = new HashMap<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            item.put(entry.getKey(), AttributeValue.builder().s(entry.getValue().toString()).build());
        }

        this.dynamoDbClient.putItem(PutItemRequest.builder()
                .tableName(this.tableName)
                .item(item)
                .build());

        return uuid;
    }

    public boolean deleteBook(String id) {
        try {
            this.dynamoDbClient.deleteItem(DeleteItemRequest.builder()
                    .tableName(this.tableName)
                    .key(Map.of("id", AttributeValue.builder().s(id).build()))
                    .conditionExpression("attribute_exists(id)")
                    .build());
            return true; // Eliminación exitosa
        } catch (ConditionalCheckFailedException e) {
            return false; // Libro no encontrado
        }
    }

    public List<Map<String, AttributeValue>> listBooks() {
        ScanResponse response = this.dynamoDbClient.scan(ScanRequest.builder()
                .tableName(this.tableName)
                .build());
        return response.items();
    }
}
