package com.backend.controllers;

import com.backend.model.dtos.PutStudentInGradeGroupDto;
import com.backend.model.dtos.StudentDto;
import com.backend.routes.Routes;
import com.backend.services.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Routes.STUDENTS_ROUTE)
public class StudentController {

    private final IStudentService service;

    public StudentController(IStudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> saveStudent(@Validated @RequestBody StudentDto student) {
        this.service.saveStudent(student);
        return ResponseEntity.ok("Student saved");
    }

    @GetMapping(Routes.STUDENT_ID)
    public ResponseEntity<StudentDto> findStudent(@PathVariable String studentIdentificationNumber) {
        return ResponseEntity.status(HttpStatus.FOUND).body(this.service.findStudent(studentIdentificationNumber));
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> findAllStudents() {
        return ResponseEntity.ok(this.service.getAllStudents());
    }

    @GetMapping(Routes.STUDENTS_WITH_BOOKS)
    public ResponseEntity<List<StudentDto>> findAllStudentsWithBook() {
        return ResponseEntity.ok(this.service.getAllStudentsWithBook());
    }

    @PutMapping
    public ResponseEntity<String> updateStudent(@Validated @RequestBody StudentDto student) throws Exception {
        this.service.updateStudent(student);
        return ResponseEntity.ok("Student updated");
    }

    @DeleteMapping(Routes.STUDENT_ID)
    public ResponseEntity<String> deleteStudent(@PathVariable String studentIdentificationNumber) {
        this.service.deleteStudent(studentIdentificationNumber);
        return ResponseEntity.ok("Student deleted");
    }

    @PostMapping(Routes.ENROLL_STUDENT_IN_GRADE_GROUP)
    public ResponseEntity<String> enrollStudentInGradeGroup(@Validated @RequestBody PutStudentInGradeGroupDto putStudentInGradeGroupDto) {
        this.service.enrollStudentInGradeGroup(putStudentInGradeGroupDto.getStudentIdentificationNumber(), putStudentInGradeGroupDto.getGradeGroupId());
        return ResponseEntity.ok("Student enrolled");
    }
}
