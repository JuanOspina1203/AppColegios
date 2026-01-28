package com.backend.model.dtos;

import lombok.NonNull;

import java.util.List;
import java.util.UUID;

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
}
