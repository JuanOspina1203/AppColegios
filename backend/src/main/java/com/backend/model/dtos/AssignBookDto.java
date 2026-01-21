package com.backend.model.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AssignBookDto {
    private UUID studentId;
    private Integer bookId;
    private boolean isAssign;
}
