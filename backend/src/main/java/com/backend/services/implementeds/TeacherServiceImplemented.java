package com.backend.services.implementeds;

import com.backend.model.Mapper;
import com.backend.model.dtos.TeacherDto;
import com.backend.model.entities.GradeGroupEntity;
import com.backend.model.entities.TeacherEntity;
import com.backend.repositories.IGradeGroupRepository;
import com.backend.repositories.ITeacherRepository;
import com.backend.services.ITeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImplemented implements ITeacherService {

    private final ITeacherRepository repository;
    private final Mapper mapper;
    private final IGradeGroupRepository gradeGroupRepository;

    public TeacherServiceImplemented(ITeacherRepository repository,
                                     Mapper mapper,
                                     IGradeGroupRepository gradeGroupRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.gradeGroupRepository = gradeGroupRepository;
    }

    @Override
    public void saveTeacher(TeacherDto teacherDto) {
        this.repository.save(this.mapper.convertTeacherDtoToTeacherEntity(teacherDto));
    }

    @Override
    public TeacherDto findTeacher(String teacherIdentificationNumber) {
        return this.mapper.convertTeacherEntityToTeacherDto(this.repository.findById(teacherIdentificationNumber).orElseThrow());
    }

    @Override
    public List<TeacherDto> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::convertTeacherEntityToTeacherDto)
                .toList();
    }

    @Override
    public List<String> findAllGradeGroupsAssignedByATeacher(String teacherIdentificationNumber) {
        Optional<TeacherEntity> teacherHasGroupGrades = this.repository.findById(teacherIdentificationNumber);
        return teacherHasGroupGrades.map(teacherEntity -> teacherEntity.getTeacherAssignedGroups()
                                                                                    .stream()
                                                                                    .map(GradeGroupEntity::getGradeGroupId)
                                                                                    .toList())
                .orElseGet(() -> List.of("Teacher doesn't have grade groups assigned"));
    }

    @Override
    public void updateTeacher(TeacherDto teacherDto) throws Exception {
        if(this.repository.findById(teacherDto.getTeacherIdentificationNumber()).isPresent())
            this.repository.save(this.mapper.convertTeacherDtoToTeacherEntity(teacherDto));
        else throw new Exception("Teacher not found");
    }

    @Override
    public void deleteTeacher(String teacherIdentificationNumber) {
        Optional<TeacherEntity> teacherEntity = this.repository.findById(teacherIdentificationNumber);
        if(teacherEntity.isPresent()) {
            List<GradeGroupEntity> gradeGroupEntities = this.gradeGroupRepository.findAll()
                    .stream()
                    .filter(gradeGroupEntity -> gradeGroupEntity.getGradeGroupTeacherInCharge().getTeacherIdentificationNumber().equals(teacherIdentificationNumber))
                    .toList();
            if(!gradeGroupEntities.isEmpty()) {
                for (GradeGroupEntity gradeGroupEntity : gradeGroupEntities)
                    gradeGroupEntity.setGradeGroupTeacherInCharge(null);
                this.repository.deleteById(teacherIdentificationNumber);
            }
            this.repository.deleteById(teacherIdentificationNumber);
        }
    }
}