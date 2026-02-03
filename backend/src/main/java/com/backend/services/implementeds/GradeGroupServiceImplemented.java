package com.backend.services.implementeds;

import com.backend.model.Mapper;
import com.backend.model.dtos.GradeGroupDto;
import com.backend.model.entities.GradeGroupEntity;
import com.backend.model.entities.TeacherEntity;
import com.backend.repositories.IGradeGroupRepository;
import com.backend.repositories.IStudentRepository;
import com.backend.repositories.ITeacherRepository;
import com.backend.services.IGradeGroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeGroupServiceImplemented implements IGradeGroupService{

    private final IGradeGroupRepository repository;
    private final Mapper mapper;
    private final ITeacherRepository teacherRepository;
    private final IStudentRepository studentRepository;

    public GradeGroupServiceImplemented(IGradeGroupRepository repository,
                                        Mapper mapper,
                                        ITeacherRepository teacherRepository,
                                        IStudentRepository studentRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void saveGradeGroup(GradeGroupDto gradeGroupDto) {
        GradeGroupEntity gradeGroupEntity = this.mapper.convertGradeGroupDtoToGradeGroupEntity(gradeGroupDto);
        this.repository.save(gradeGroupEntity);
    }

    @Override
    public GradeGroupDto findGradeGroup(String gradeGroupId) {
        return this.mapper.convertGradeGroupEntityToGradeGroupDto(this.repository.findById(gradeGroupId).orElseThrow(() -> new RuntimeException("Grade group not found")));
    }

    @Override
    public List<GradeGroupDto> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::convertGradeGroupEntityToGradeGroupDto)
                .toList();
    }

    @Override
    public List<GradeGroupDto> findAllGradeGroupsByShift(String gradeGroupShift) {
        return this.repository.findAll()
                .stream()
                .filter(gradeGroupEntity -> gradeGroupEntity.getGradeGroupShift().equals(gradeGroupShift))
                .map(this.mapper::convertGradeGroupEntityToGradeGroupDto)
                .toList();
    }

    @Override
    public List<GradeGroupDto> findAllGradesGroupsByCampus(String gradeGroupCampus) {
        return this.repository.findAll()
                .stream()
                .filter(gradeGroupEntity -> gradeGroupEntity.getGradeGroupCampus().equals(gradeGroupCampus))
                .map(this.mapper::convertGradeGroupEntityToGradeGroupDto)
                .toList();
    }

    @Override
    public Integer getCountOfStudentsInGradeGroup(String gradeGroupId) {
        return Math.toIntExact(this.studentRepository.findAll()
                .stream()
                .filter(student -> student.getStudentGradeAssigned() != null)
                .filter(student -> gradeGroupId.equals(student.getStudentGradeAssigned().getGradeGroupId()))
                .count());
    }

    @Override
    public void assignTeacher(String teacherIdentificationNumber, String gradeGroupId) {
        TeacherEntity teacherEntity = this.teacherRepository.findById(teacherIdentificationNumber).orElseThrow(() -> new RuntimeException("Teacher not found"));
        GradeGroupEntity gradeGroupEntity = this.repository.findById(gradeGroupId).orElseThrow(() -> new RuntimeException("Grade group not found"));
        gradeGroupEntity.setGradeGroupTeacherInCharge(teacherEntity);
        this.repository.save(gradeGroupEntity);
    }

    @Override
    public void updateGradeGroup(GradeGroupDto gradeGroupDto) {
        String gradeGroupId = gradeGroupDto.getGradeGroupGradeLevel() + gradeGroupDto.getGradeGroupLetter();
        GradeGroupEntity gradeGroupEntity = this.repository.findById(gradeGroupId).orElseThrow(() -> new RuntimeException("Grade group not found"));
        GradeGroupEntity gradeGroupToSave = this.mapper.convertGradeGroupDtoToGradeGroupEntity(gradeGroupDto);
        if(gradeGroupEntity.getGradeGroupTeacherInCharge() == null) this.repository.save(gradeGroupToSave);
        gradeGroupToSave.setGradeGroupTeacherInCharge(gradeGroupEntity.getGradeGroupTeacherInCharge());
        this.repository.save(gradeGroupToSave);
    }

    @Override
    public void deleteGradeGroup(String gradeGroupId) {
        this.repository.deleteById(gradeGroupId);
    }
}