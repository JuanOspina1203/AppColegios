package com.backend.model.dtos;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    @NonNull
    private Integer bookId;
    @NonNull
    private String bookName;
    @NonNull
    private String bookAuthor;
    @NonNull
    private String bookCategory;
    private String studentName;
    private UUID studentId;
}
