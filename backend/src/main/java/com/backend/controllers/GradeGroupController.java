package com.backend.controllers;

import com.backend.model.dtos.AssignTeacherDto;
import com.backend.model.dtos.GradeGroupDto;
import com.backend.routes.Routes;
import com.backend.services.IGradeGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Routes.GRADE_GROUPS_ROUTE)
public class GradeGroupController {

    private final IGradeGroupService service;

    public GradeGroupController(IGradeGroupService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> saveGradeGroup(@Validated @RequestBody GradeGroupDto gradeGroupDto) {
        this.service.saveGradeGroup(gradeGroupDto);
        return ResponseEntity.ok("Grade group saved");
    }

    @GetMapping(Routes.GRADE_GROUP_ID)
    public ResponseEntity<GradeGroupDto> findGradeGroup(@PathVariable String gradeGroupId) {
        return ResponseEntity.ok(this.service.findGradeGroup(gradeGroupId));
    }

    @GetMapping
    public ResponseEntity<List<GradeGroupDto>> findAll() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping(Routes.GRADE_GROUP_ALL_GROUPS_BY_SHIFT)
    public ResponseEntity<List<GradeGroupDto>> findAllGradesGroupByShift(@PathVariable String gradeGroupShift) {
        return ResponseEntity.ok(this.service.findAllGradeGroupsByShift(gradeGroupShift));
    }

    @GetMapping(Routes.GRADE_GROUP_ALL_GROUPS_BY_CAMPUS)
    public ResponseEntity<List<GradeGroupDto>> findAllGradeGroupsByCampus(@PathVariable String gradeGroupCampus) {
        return ResponseEntity.ok(this.service.findAllGradesGroupsByCampus(gradeGroupCampus));
    }

    @GetMapping(Routes.GRADE_GROUP_COUNT_OF_STUDENTS)
    public ResponseEntity<Integer> getCountOfStudentsInGradeGroup(@PathVariable String gradeGroupId){
         return ResponseEntity.ok(this.service.getCountOfStudentsInGradeGroup(gradeGroupId));
    }

    @PostMapping(Routes.GRADE_GROUP_ASSIGN_TEACHER)
    public ResponseEntity<String> assignTeacher(@Validated @RequestBody AssignTeacherDto assignTeacherDto) {
        this.service.assignTeacher(assignTeacherDto.getTeacherIdentificationNumber(), assignTeacherDto.getGradeGroupId());
        return ResponseEntity.ok("Teacher assigned to grade group");
    }

    @PutMapping
    public ResponseEntity<String> updateGradeGroup(@Validated @RequestBody  GradeGroupDto gradeGroupDto) throws Exception {
        this.service.updateGradeGroup(gradeGroupDto);
        return ResponseEntity.ok("Grade group updated");
    }

    @DeleteMapping(Routes.GRADE_GROUP_ID)
    public ResponseEntity<String> deleteMapping(@PathVariable String gradeGroupId) {
        this.service.deleteGradeGroup(gradeGroupId);
        return ResponseEntity.ok("Grade group deleted");
    }
}
