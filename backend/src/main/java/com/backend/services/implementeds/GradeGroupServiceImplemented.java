package com.backend.services.implementeds;

import com.backend.model.Mapper;
import com.backend.model.dtos.GradeGroupDto;
import com.backend.model.entities.GradeGroupEntity;
import com.backend.model.entities.TeacherEntity;
import com.backend.repositories.IGradeGroupRepository;
import com.backend.repositories.ITeacherRepository;
import com.backend.services.IGradeGroupService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeGroupServiceImplemented implements IGradeGroupService{

    private final IGradeGroupRepository repository;
    private final Mapper mapper;
    private final ITeacherRepository teacherRepository;

    public GradeGroupServiceImplemented(IGradeGroupRepository repository,
                                        Mapper mapper,
                                        ITeacherRepository teacherRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void saveGradeGroup(GradeGroupDto gradeGroupDto) {
        GradeGroupEntity gradeGroupEntity = this.mapper.convertGradeGroupDtoToGradeGroupEntity(gradeGroupDto);
        this.repository.save(gradeGroupEntity);
    }

    @Override
    public GradeGroupDto findGradeGroup(String gradeGroupId) {
        return this.mapper.convertGradeGroupEntityToGradeGroupDto(this.repository.findById(gradeGroupId).orElseThrow());
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
        return 0;
    }

    @Override
    public void assignTeacher(String teacherIdentificationNumber, String gradeGroupId) {
        TeacherEntity teacherEntity = this.teacherRepository.findById(teacherIdentificationNumber).orElseThrow();
        GradeGroupEntity gradeGroupEntity = this.repository.findById(gradeGroupId).orElseThrow();
        gradeGroupEntity.setGradeGroupTeacherInCharge(teacherEntity);
        this.repository.save(gradeGroupEntity);
    }

    @Override
    public void updateGradeGroup(GradeGroupDto gradeGroupDto) {
        String gradeGroupId = gradeGroupDto.getGradeGroupGradeLevel() + gradeGroupDto.getGradeGroupLetter();
        Optional<GradeGroupEntity> gradeGroupEntity = this.repository.findById(gradeGroupId);
        if(gradeGroupEntity.isPresent()) {
            GradeGroupEntity gradeGroupToSave = this.mapper.convertGradeGroupDtoToGradeGroupEntity(gradeGroupDto);
            if(gradeGroupEntity.get().getGradeGroupTeacherInCharge() == null) this.repository.save(gradeGroupToSave);
            gradeGroupToSave.setGradeGroupTeacherInCharge(gradeGroupEntity.get().getGradeGroupTeacherInCharge());
            this.repository.save(gradeGroupToSave);
        }
    }

    @Override
    public void deleteGradeGroup(String gradeGroupId) {
        this.repository.deleteById(gradeGroupId);
    }
}