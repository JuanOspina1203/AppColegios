package com.backend.services;

import com.backend.model.dtos.StudentDto;

import java.util.List;

public interface IStudentService {
    void saveStudent(StudentDto student);
    StudentDto findStudent(String studentIdentificationNumber);
    List<StudentDto> getAllStudents();
    List<StudentDto> getAllStudentsWithBook();
    void updateStudent(StudentDto student);
    void deleteStudent(String studentIdentificationNumber);
    void enrollStudentInGradeGroup(String studentIdentificationNumber, String gradeGroupId);
}