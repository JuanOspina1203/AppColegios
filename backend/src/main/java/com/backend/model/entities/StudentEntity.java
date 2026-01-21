package com.backend.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "students_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "student_id")
    @Id
    private UUID studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_grade")
    private String studentGrade;

    @Column(name = "student_identification_type")
    private String studentIdentificationType;

    @Column(name = "student_identification_number")
    private String studentIdentificationNumber;

    @OneToOne(mappedBy = "student")
    private BookEntity book;
}