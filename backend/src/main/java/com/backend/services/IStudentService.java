package com.backend.services;

import com.backend.entities.StudentEntity;

import java.util.List;
import java.util.UUID;

public interface IStudentService {
    void saveStudent(StudentEntity student);
    StudentEntity findStudent(UUID studentId);
    List<StudentEntity> getAllStudents();
    List<StudentEntity> getAllStudentsWithBook();
    void updateStudent(StudentEntity student);
    void deleteStudent(UUID studentId);
}
