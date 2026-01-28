package com.backend.model.dtos;

public class PutStudentInGradeGroupDto {

    private String studentIdentificationNumber;
    private String gradeGroupId;

    public String getStudentIdentificationNumber() {return this.studentIdentificationNumber;}

    public void setStudentIdentificationNumber(String studentIdentificationNumber) {this.studentIdentificationNumber = studentIdentificationNumber;}

    public String getGradeGroupId() {return this.gradeGroupId;}

    public void setGradeGroupId(String gradeGroupId) {this.gradeGroupId = gradeGroupId;}
}