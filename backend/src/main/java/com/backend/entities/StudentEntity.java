package com.backend.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "students_tbl")
public class StudentEntity {

    public StudentEntity(){}

    public StudentEntity(
            UUID studentId,
            String studentGrade,
            String studentIdentificationType,
            String studentIdentificationNumber
    ) {
        this.studentId = studentId;
        this.studentGrade = studentGrade;
        this.studentIdentificationType = studentIdentificationType;
        this.studentIdentificationNumber = studentIdentificationNumber;
    }

    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "student_id")
    @Id
    private UUID studentId;

    @Column(name = "student_grade")
    private String studentGrade;

    @Column(name = "student_identification_type")
    private String studentIdentificationType;

    @Column(name = "student_identification_number")
    private String studentIdentificationNumber;

    @OneToOne(mappedBy = "student")
    private BookEntity book;

    public UUID getStudentId() {
        return this.studentId;
    }

    public String getStudentGrade() { return this.studentGrade; }

    public void setStudentGrade(String studentGrade) { this.studentGrade = studentGrade; }

    public String getStudentIdentificationType() { return this.studentIdentificationType; }

    public void setStudentIdentificationType(String studentIdentificationType) { this.studentIdentificationType = studentIdentificationType; }

    public String getStudentIdentificationNumber() { return this.studentIdentificationNumber; }

    public BookEntity getBook() { return this.book; }

    public void setBook(BookEntity book) { this.book = book; }
}
