package com.backend.services;

import com.backend.model.dtos.TeacherDto;

import java.util.List;

public interface ITeacherService {
    void saveTeacher(TeacherDto teacherDto);
    TeacherDto findTeacher(String teacherIdentificationNumber);
    List<TeacherDto> findAll();
    List<String> findAllGradeGroupsAssignedByATeacher(String teacherIdentificationNumber);
    void updateTeacher(TeacherDto teacherDto);
    void deleteTeacher(String teacherIdentificationNumber);
}
