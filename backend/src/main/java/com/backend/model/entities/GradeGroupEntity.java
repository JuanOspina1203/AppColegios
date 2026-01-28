package com.backend.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "grade_groups_tbl")
public class GradeGroupEntity {

    @Id
    @Column(name = "grade_group_id")
    private String gradeGroupId;

    @Column(name = "grade_group_floor_number")
    private Integer gradeGroupFloorNumber;

    @Column(name = "grade_group_campus")
    private String gradeGroupCampus;

    @Column(name = "grade_group_letter")
    private String gradeGroupLetter;

    @Column(name = "grade_group_grade_level")
    private String gradeGroupGradeLevel;

    @Column(name = "grade_group_shift")
    private String gradeGroupShift;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_group_teacher_in_charge_id")
    private TeacherEntity gradeGroupTeacherInCharge;

    @OneToMany(mappedBy = "studentGradeAssigned", fetch = FetchType.LAZY)
    private List<StudentEntity> gradeGroupStudents;

    public GradeGroupEntity() {}

    public GradeGroupEntity(String gradeGroupShift,
                            String gradeGroupGradeLevel,
                            String gradeGroupLetter,
                            String gradeGroupCampus,
                            Integer gradeGroupFloorNumber) {
        this.gradeGroupId = gradeGroupGradeLevel + gradeGroupLetter;
        this.gradeGroupShift = gradeGroupShift;
        this.gradeGroupGradeLevel = gradeGroupGradeLevel;
        this.gradeGroupLetter = gradeGroupLetter;
        this.gradeGroupCampus = gradeGroupCampus;
        this.gradeGroupFloorNumber = gradeGroupFloorNumber;
    }

    public String getGradeGroupId() {return gradeGroupId;}

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

    public TeacherEntity getGradeGroupTeacherInCharge() {return this.gradeGroupTeacherInCharge;}

    public void setGradeGroupTeacherInCharge(TeacherEntity teacherEntity) {this.gradeGroupTeacherInCharge = teacherEntity;}

    public List<StudentEntity> getGradeGroupStudents() {return this.gradeGroupStudents;}

    public void setGradeGroupStudents(List<StudentEntity> gradeGroupStudents) {this.gradeGroupStudents = gradeGroupStudents;}
}
