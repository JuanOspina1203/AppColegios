package com.backend.services;

import com.backend.model.dtos.GradeGroupDto;

import java.util.List;

public interface IGradeGroupService {

    void saveGradeGroup(GradeGroupDto gradeGroupDto);
    GradeGroupDto findGradeGroup(String gradeGroupId);
    List<GradeGroupDto> findAll();
    List<GradeGroupDto> findAllGradeGroupsByShift(String gradeGroupShift);
    List<GradeGroupDto> findAllGradesGroupsByCampus(String gradeGroupCampus);
    Integer getCountOfStudentsInGradeGroup(String gradeGroupId);
    void assignTeacher(String teacherIdentificationNumber, String gradeGroupId);
    void updateGradeGroup(GradeGroupDto gradeGroupDto) throws Exception;
    void deleteGradeGroup(String gradeGroupId);
}
