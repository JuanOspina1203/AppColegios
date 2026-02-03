package com.backend.model.dtos;

public class AssignTeacherToAGradeGroupDto {
    private String teacherIdentificationNumber;
    private String gradeGroupId;

    public String getTeacherIdentificationNumber() {return this.teacherIdentificationNumber;}

    public String getGradeGroupId() {return this.gradeGroupId;}

    public void setTeacherIdentificationNumber(String teacherIdentificationNumber) {this.teacherIdentificationNumber = teacherIdentificationNumber;}

    public void setGradeGroupId(String gradeGroupId) {this.gradeGroupId = gradeGroupId;}
}
