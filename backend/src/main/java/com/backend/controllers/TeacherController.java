package com.backend.controllers;

import com.backend.model.dtos.TeacherDto;
import com.backend.routes.Routes;
import com.backend.services.ITeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Routes.TEACHERS_ROUTE)
public class TeacherController {

    private final ITeacherService service;

    public TeacherController(ITeacherService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> saveTeacher(@Validated @RequestBody TeacherDto teacherDto) {
        this.service.saveTeacher(teacherDto);
        return ResponseEntity.ok("Teacher saved");
    }

    @GetMapping(Routes.TEACHER_IDENTIFICATION_NUMBER)
    public ResponseEntity<TeacherDto> findTeacher(@PathVariable String teacherIdentificationNumber) {
        return ResponseEntity.ok(this.service.findTeacher(teacherIdentificationNumber));
    }

    @GetMapping
    public ResponseEntity<List<TeacherDto>> findAll() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping(Routes.TEACHER_ALL_GRADES_ASSIGNED + Routes.TEACHER_IDENTIFICATION_NUMBER)
    public ResponseEntity<List<String>> findAllGradeGroupsAssignedByATeacher(@PathVariable String teacherIdentificationNumber) {
        return ResponseEntity.ok(this.service.findAllGradeGroupsAssignedByATeacher(teacherIdentificationNumber));
    }

    @PutMapping
    public ResponseEntity<String> updateTeacher(@Validated @RequestBody TeacherDto teacherDto) throws Exception {
        this.service.updateTeacher(teacherDto);
        return ResponseEntity.ok("Teacher updated");
    }

    @DeleteMapping(Routes.TEACHER_IDENTIFICATION_NUMBER)
    public ResponseEntity<String> deleteTeacher(@PathVariable String teacherIdentificationNumber) {
        this.service.deleteTeacher(teacherIdentificationNumber);
        return ResponseEntity.ok("Teacher deleted");
    }
}
