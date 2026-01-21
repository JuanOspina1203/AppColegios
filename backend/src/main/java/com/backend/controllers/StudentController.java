package com.backend.controllers;

import com.backend.model.entities.StudentEntity;
import com.backend.services.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final IStudentService service;

    public StudentController(IStudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> saveStudent(@Validated @RequestBody StudentEntity student) {
        this.service.saveStudent(student);
        return ResponseEntity.ok("Student saved");
    }

    @GetMapping
    public ResponseEntity<StudentEntity> findStudent(@PathVariable UUID studentId) {
        return ResponseEntity.status(HttpStatus.FOUND).body(this.service.findStudent(studentId));
    }

    @GetMapping
    public ResponseEntity<List<StudentEntity>> findAllStudents() {
        return ResponseEntity.ok(this.service.getAllStudents());
    }

    @GetMapping
    public ResponseEntity<List<StudentEntity>> findAllStudentsWithBook() {
        return ResponseEntity.ok(this.service.getAllStudentsWithBook());
    }

    @PutMapping
    public ResponseEntity<String> updateStudent(@Validated @RequestBody StudentEntity student) {
        this.service.updateStudent(student);
        return ResponseEntity.ok("Student updated");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@PathVariable UUID studentId) {
        this.service.deleteStudent(studentId);
        return ResponseEntity.ok("Student deleted");
    }
}
