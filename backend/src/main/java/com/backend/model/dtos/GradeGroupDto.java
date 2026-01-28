package com.backend.model.dtos;

import lombok.NonNull;

public class GradeGroupDto {

    @NonNull
    private String gradeGroupId;
    @NonNull
    private Integer gradeGroupFloorNumber;
    @NonNull
    private String gradeGroupCampus;
    @NonNull
    private String gradeGroupLetter;
    @NonNull
    private String gradeGroupGradeLevel;
    @NonNull
    private String gradeGroupShift;
    private String gradeGroupTeacherInChargeName;
    private String gradeGroupTeacherInChargeIdentificationNumber;

    public GradeGroupDto() {}

    public String getGradeGroupId() {return gradeGroupId;}

    public void setGradeGroupId(String gradeGroupId) {this.gradeGroupId = gradeGroupId;}

    public Integer getGradeGroupFloorNumber() {return gradeGroupFloorNumber;}

    public void setGradeGroupFloorNumber(Integer gradeGroupFloorNumber) {this.gradeGroupFloorNumber = gradeGroupFloorNumber;}

    public String getGradeGroupCampus() {return gradeGroupCampus;}

    public void setGradeGroupCampus(String gradeGroupCampus) {this.gradeGroupCampus = gradeGroupCampus;}

    public String getGradeGroupLetter() {return gradeGroupLetter;}

    public void setGradeGroupLetter(String gradeGroupLetter) {this.gradeGroupLetter = gradeGroupLetter;}

    public String getGradeGroupGradeLevel() {return gradeGroupGradeLevel;}

    public void setGradeGroupGradeLevel(String gradeGroupGradeLevel) {this.gradeGroupGradeLevel = gradeGroupGradeLevel;}

    public String getGradeGroupShift() {return gradeGroupShift;}

    public void setGradeGroupShift(String gradeGroupShift) {this.gradeGroupShift = gradeGroupShift;}

    public String getGradeGroupTeacherInChargeName() {return gradeGroupTeacherInChargeName;}

    public void setGradeGroupTeacherInChargeName(String gradeGroupTeacherInChargeName) {this.gradeGroupTeacherInChargeName = gradeGroupTeacherInChargeName;}

    public String getGradeGroupTeacherInChargeIdentificationNumber() {return gradeGroupTeacherInChargeIdentificationNumber;}

    public void setGradeGroupTeacherInChargeIdentificationNumber(String gradeGroupTeacherInChargeIdentificationNumber) {this.gradeGroupTeacherInChargeIdentificationNumber = gradeGroupTeacherInChargeIdentificationNumber;}
}
