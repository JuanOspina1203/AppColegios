package com.backend.model.dtos;

import lombok.*;

public class StudentDto {

    @NonNull
    private String studentName;
    @NonNull
    private String studentIdentificationType;
    @NonNull
    private String studentIdentificationNumber;
    private String bookName;
    private Integer bookId;
    private String studentGradeGroupAssigned;

    public StudentDto() {}

    public String getStudentName() {return studentName;}
    public String getStudentIdentificationType() {return studentIdentificationType;}
    public String getStudentIdentificationNumber() {return studentIdentificationNumber;}
    public String getBookName() {return bookName;}
    public Integer getBookId() {return bookId;}
    public void setStudentName(String studentName) {this.studentName = studentName;}
    public void setStudentIdentificationType(String studentIdentificationType) {this.studentIdentificationType = studentIdentificationType;}
    public void setStudentIdentificationNumber(String studentIdentificationNumber) {this.studentIdentificationNumber = studentIdentificationNumber;}
    public void setBookName(String bookName) {this.bookName = bookName;}
    public void setBookId(Integer bookId) {this.bookId = bookId;}
    public String getStudentGradeGroupAssigned() {return this.studentGradeGroupAssigned;}
    public void setStudentGradeGroupAssigned(String studentGradeGroupAssigned) {this.studentGradeGroupAssigned = studentGradeGroupAssigned;}
}