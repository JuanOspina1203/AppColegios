package com.backend.services.implementeds;

import com.backend.entities.StudentEntity;
import com.backend.repositories.IStudentRepository;
import com.backend.services.IStudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentServiceImplemented implements IStudentService {

    private final IStudentRepository repository;

    public StudentServiceImplemented(IStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveStudent(StudentEntity student) {
        this.repository.save(student);
    }

    @Override
    public StudentEntity findStudent(UUID studentId) {
        return this.repository.findById(studentId).orElseThrow();
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        return this.repository.findAll();
    }

    @Override
    public List<StudentEntity> getAllStudentsWithBook() {
        return this.repository.findAll().stream().filter(student -> student.getBook() != null).collect(Collectors.toList());
    }

    @Override
    public void updateStudent(StudentEntity student) {
        this.repository.findById(student.getStudentId()).orElseThrow();
        this.repository.save(student);
    }

    @Override
    public void deleteStudent(UUID studentId) {
        this.repository.deleteById(studentId);
    }
}
