package com.backend.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "students_tbl")
public class StudentEntity {

    public StudentEntity(
            UUID studentId,
            String studentGrade,
            String studentIdentificationType,
            String studentIdentificationNumber,
            BookEntity book
    ) {
        this.studentId = studentId;
        this.studentGrade = studentGrade;
        this.studentIdentificationType = studentIdentificationType;
        this.studentIdentificationNumber = studentIdentificationNumber;
        this.book = book;
    }

    @UuidGenerator
    @Column(name = "student_id")
    @Id
    private final UUID studentId;

    @Column(name = "student_grade")
    private String studentGrade;

    @Column(name = "student_identification_type")
    private String studentIdentificationType;

    @Column(name = "student_identification_number")
    private final String studentIdentificationNumber;

    @OneToOne(mappedBy = "student")
    private BookEntity book;

    public UUID getStudentId() {
        return this.studentId;
    }

    public String getStudentGrade() {
        return this.studentGrade;
    }

    public String getStudentIdentificationType() {
        return this.studentIdentificationType;
    }

    public String getStudentIdentificationNumber() {
        return this.studentIdentificationNumber;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    public void setStudentIdentificationType(String studentIdentificationType) {
        this.studentIdentificationType = studentIdentificationType;
    }

    public BookEntity getBook() {
        return this.book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }
}
