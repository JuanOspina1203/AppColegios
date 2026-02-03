package com.backend.model.dtos;

public class AssignDirectorToATeacherDto {
    private String directorUsername;
    private String teacherIdentificationNumber;

    public String getDirectorUsername() {return this.directorUsername;}
    public void setDirectorUsername(String directorUsername) {this.directorUsername = directorUsername;}
    public String getTeacherIdentificationNumber() {return this.teacherIdentificationNumber;}
    public void setTeacherIdentificationNumber(String teacherIdentificationNumber) {this.teacherIdentificationNumber = teacherIdentificationNumber;}
}