package com.backend.model.dtos;

public class AssignBookDto {
    private String studentIdentificationNumber;
    private Integer bookId;
    private Boolean isAssign;

    public String getStudentIdentificationNumber() {return this.studentIdentificationNumber;}

    public void setStudentIdentificationNumber(String studentIdentificationNumber) {this.studentIdentificationNumber = studentIdentificationNumber;}

    public Integer getBookId() {return this.bookId;}

    public void setBookId(Integer bookId) {this.bookId = bookId;}

    public Boolean getIsAssign() {return this.isAssign;}

    public void setAssign(Boolean assign) {this.isAssign = assign;}
}
