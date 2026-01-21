package com.backend.model.dtos;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    @NonNull
    private UUID studentId;
    @NonNull
    private String studentName;
    @NonNull
    private String studentGrade;
    @NonNull
    private String studentIdentificationType;
    @NonNull
    private String studentIdentificationNumber;
    private String bookName;
    private Integer bookId;
}
