package com.backend.model.dtos;


import lombok.NonNull;

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
    private String studentIdentificationNumber;

    public BookDto() {}

    public Integer getBookId() {return this.bookId;}

    public String getBookName() {return this.bookName;}

    public String getBookAuthor() {return this.bookAuthor;}

    public String getBookCategory() {return this.bookCategory;}

    public String getStudentName() {return this.studentName;}

    public String getStudentIdentificationNumber() {return this.studentIdentificationNumber;}

    public void setBookId(Integer bookId) {this.bookId = bookId;}

    public void setBookName(String bookName) {this.bookName = bookName;}

    public void setBookAuthor(String bookAuthor) {this.bookAuthor = bookAuthor;}

    public void setBookCategory(String bookCategory) {this.bookCategory = bookCategory;}

    public void setStudentName(String studentName) {this.studentName = studentName;}

    public void setStudentIdentificationNumber(String studentIdentificationNumber) {this.studentIdentificationNumber = studentIdentificationNumber;}
}
