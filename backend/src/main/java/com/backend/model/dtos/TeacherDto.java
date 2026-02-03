package com.backend.model.dtos;

import lombok.NonNull;

import java.util.List;

public class TeacherDto {

    @NonNull
    private String teacherIdentificationNumber;
    @NonNull
    private String teacherIdentificationType;
    @NonNull
    private String teacherName;
    @NonNull
    private String teacherEmail;
    @NonNull
    private String teacherPhone;
    @NonNull
    private String teacherSubject;
    private List<String> teacherAssignedGroups;
    private String directorIdentificationNumber;
    private String directorName;

    public TeacherDto() {}

    public String getTeacherSubject() {return teacherSubject;}
    public void setTeacherSubject(String teacherSubject) {this.teacherSubject = teacherSubject;}
    public String getTeacherPhone() {return teacherPhone;}
    public void setTeacherPhone(String teacherPhone) {this.teacherPhone = teacherPhone;}
    public String getTeacherEmail() {return teacherEmail;}
    public void setTeacherEmail(String teacherEmail) {this.teacherEmail = teacherEmail;}
    public String getTeacherName() {return teacherName;}
    public void setTeacherName(String teacherName) {this.teacherName = teacherName;}
    public String getTeacherIdentificationType() {return teacherIdentificationType;}
    public void setTeacherIdentificationType(String teacherIdentificationType) {this.teacherIdentificationType = teacherIdentificationType;}
    public String getTeacherIdentificationNumber() {return teacherIdentificationNumber;}
    public void setTeacherIdentificationNumber(String teacherIdentificationNumber) {this.teacherIdentificationNumber = teacherIdentificationNumber;}
    public void setTeacherAssignedGroups(List<String> teacherAssignedGroups) {this.teacherAssignedGroups = teacherAssignedGroups;}
    public String getDirectorIdentificationNumber() {return this.directorIdentificationNumber;}
    public String getDirectorName() {return this.directorName;}
    public void setDirectorIdentificationNumber(String directorIdentificationNumber) {this.directorIdentificationNumber = directorIdentificationNumber;}
    public void setDirectorName(String directorName) {this.directorName = directorName;}
    public List<String> getTeacherAssignedGroups() {return this.teacherAssignedGroups;}
}