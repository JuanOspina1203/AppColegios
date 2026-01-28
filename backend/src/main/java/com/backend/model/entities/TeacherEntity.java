package com.backend.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teachers_tbl")
public class TeacherEntity {


    @Id
    @Column(name = "teacher_identification_number")
    private String teacherIdentificationNumber;

    @Column(name = "teacher_identification_type")
    private String teacherIdentificationType;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "teacher_email")
    private String teacherEmail;

    @Column(name = "teacher_phone")
    private String teacherPhone;

    @Column(name = "teacher_subject")
    private String teacherSubject;

    @OneToMany(mappedBy = "gradeGroupTeacherInCharge", fetch = FetchType.LAZY)
    private List<GradeGroupEntity> teacherAssignedGroups;

    public TeacherEntity() {}

    public String getTeacherIdentificationNumber() {return teacherIdentificationNumber;}

    public void setTeacherIdentificationNumber(String teacherIdentificationNumber) {this.teacherIdentificationNumber = teacherIdentificationNumber;}

    public String getTeacherIdentificationType() {return teacherIdentificationType;}

    public void setTeacherIdentificationType(String teacherIdentificationType) {this.teacherIdentificationType = teacherIdentificationType;}

    public String getTeacherName() {return teacherName;}

    public void setTeacherName(String teacherName) {this.teacherName = teacherName;}

    public String getTeacherEmail() {return teacherEmail;}

    public void setTeacherEmail(String teacherEmail) {this.teacherEmail = teacherEmail;}

    public String getTeacherPhone() {return teacherPhone;}

    public void setTeacherPhone(String teacherPhone) {this.teacherPhone = teacherPhone;}

    public String getTeacherSubject() {return teacherSubject;}

    public void setTeacherSubject(String teacherSubject) {this.teacherSubject = teacherSubject;}

    public List<GradeGroupEntity> getTeacherAssignedGroups() {return this.teacherAssignedGroups;}

    public void setTeacherAssignedGroups(List<GradeGroupEntity> teacherAssignedGroups) {this.teacherAssignedGroups = teacherAssignedGroups;}
}
