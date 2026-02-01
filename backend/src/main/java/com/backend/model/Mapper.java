package com.backend.model;

import com.backend.model.dtos.*;
import com.backend.model.entities.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {

    private final PasswordEncoder passwordEncoder;

    public Mapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    //STUDENT

    public StudentEntity convertStudentDtoToStudentEntity(StudentDto studentDto) {
        if(studentDto == null) return null;
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentName(studentDto.getStudentName());
        studentEntity.setStudentGrade(studentDto.getStudentGrade());
        studentEntity.setStudentIdentificationType(studentDto.getStudentIdentificationType());
        studentEntity.setStudentIdentificationNumber(studentDto.getStudentIdentificationNumber());
        return studentEntity;
    }

    public StudentDto convertStudentEntityToStudentDto(StudentEntity studentEntity) {
        if(studentEntity == null) return null;
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentName(studentEntity.getStudentName());
        studentDto.setStudentGrade(studentEntity.getStudentGrade());
        studentDto.setStudentIdentificationType(studentEntity.getStudentIdentificationType());
        studentDto.setStudentIdentificationNumber(studentEntity.getStudentIdentificationNumber());
        BookEntity book = studentEntity.getBook();
        if(book != null) {
            studentDto.setBookName(book.getBookName());
            studentDto.setBookId(book.getBookId());
        }
        GradeGroupEntity gradeGroupEntity = studentEntity.getStudentGradeAssigned();
        if(gradeGroupEntity != null) studentDto.setStudentGradeGroupAssigned(gradeGroupEntity.getGradeGroupGradeLevel() + gradeGroupEntity.getGradeGroupLetter());
        return studentDto;
    }

    //BOOK

    public BookEntity convertBookDtoToBookEntity(BookDto bookDto) {
        if(bookDto == null) return null;
        return new BookEntity(bookDto.getBookId(),
                bookDto.getBookName(),
                bookDto.getBookCategory(),
                bookDto.getBookAuthor());
    }

    public BookDto convertBookEntityToBookDto(BookEntity bookEntity) {
        if(bookEntity == null) return null;
        BookDto bookDto = new BookDto();
        bookDto.setBookId(bookEntity.getBookId());
        bookDto.setBookName(bookEntity.getBookName());
        bookDto.setBookCategory(bookEntity.getBookCategory());
        bookDto.setBookAuthor(bookEntity.getBookAuthor());
        StudentEntity studentEntity = bookEntity.getStudent();
        if(studentEntity != null) {
            bookDto.setStudentName(studentEntity.getStudentName());
            bookDto.setStudentIdentificationNumber(studentEntity.getStudentIdentificationNumber());
        }
        return bookDto;
    }

    //TEACHER

    public TeacherEntity convertTeacherDtoToTeacherEntity(TeacherDto teacherDto) {
        if(teacherDto ==  null) return null;
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setTeacherIdentificationNumber(teacherDto.getTeacherIdentificationNumber());
        teacherEntity.setTeacherIdentificationType(teacherDto.getTeacherIdentificationType());
        teacherEntity.setTeacherEmail(teacherDto.getTeacherEmail());
        teacherEntity.setTeacherName(teacherDto.getTeacherName());
        teacherEntity.setTeacherPhone(teacherDto.getTeacherPhone());
        teacherEntity.setTeacherSubject(teacherDto.getTeacherSubject());
        return teacherEntity;
    }

    public TeacherDto convertTeacherEntityToTeacherDto(TeacherEntity teacherEntity) {
        if(teacherEntity == null) return null;
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherIdentificationNumber(teacherEntity.getTeacherIdentificationNumber());
        teacherDto.setTeacherIdentificationType(teacherEntity.getTeacherIdentificationType());
        teacherDto.setTeacherEmail(teacherEntity.getTeacherEmail());
        teacherDto.setTeacherPhone(teacherEntity.getTeacherPhone());
        teacherDto.setTeacherName(teacherEntity.getTeacherName());
        teacherDto.setTeacherSubject(teacherEntity.getTeacherSubject());
        List<GradeGroupEntity> assignedGroups = teacherEntity.getTeacherAssignedGroups();
        if(assignedGroups != null) {
            List<String> groupCodes = assignedGroups
                    .stream()
                    .map(GradeGroupEntity::getGradeGroupId)
                    .toList();
            teacherDto.setTeacherAssignedGroups(groupCodes);
        } else {
            teacherDto.setTeacherAssignedGroups(new ArrayList<>());
        }
        return teacherDto;
    }

    //GRADE GROUPS

    public GradeGroupEntity convertGradeGroupDtoToGradeGroupEntity(GradeGroupDto gradeGroupDto) {
        if(gradeGroupDto == null) return null;
        return new GradeGroupEntity(
                gradeGroupDto.getGradeGroupShift(),
                gradeGroupDto.getGradeGroupGradeLevel(),
                gradeGroupDto.getGradeGroupLetter(),
                gradeGroupDto.getGradeGroupCampus(),
                gradeGroupDto.getGradeGroupFloorNumber()
        );
    }

    public GradeGroupDto convertGradeGroupEntityToGradeGroupDto(GradeGroupEntity gradeGroupEntity) {
        if(gradeGroupEntity == null) return null;
        GradeGroupDto gradeGroupDto = new GradeGroupDto();
        gradeGroupDto.setGradeGroupId(gradeGroupEntity.getGradeGroupId());
        gradeGroupDto.setGradeGroupFloorNumber(gradeGroupEntity.getGradeGroupFloorNumber());
        gradeGroupDto.setGradeGroupCampus(gradeGroupEntity.getGradeGroupCampus());
        gradeGroupDto.setGradeGroupLetter(gradeGroupEntity.getGradeGroupLetter());
        gradeGroupDto.setGradeGroupShift(gradeGroupEntity.getGradeGroupShift());
        gradeGroupDto.setGradeGroupGradeLevel(gradeGroupEntity.getGradeGroupGradeLevel());
        if(gradeGroupEntity.getGradeGroupTeacherInCharge() != null) {
            gradeGroupDto.setGradeGroupTeacherInChargeName(gradeGroupEntity.getGradeGroupTeacherInCharge().getTeacherName());
            gradeGroupDto.setGradeGroupTeacherInChargeIdentificationNumber(gradeGroupEntity.getGradeGroupTeacherInCharge().getTeacherIdentificationNumber());
        }
        return gradeGroupDto;
    }

    //DIRECTOR

    public DirectorEntity convertDirectorDtoToDirectorEntity(DirectorDto directorDto) {
        if(directorDto == null) return null;
        String passwordEncoded = this.passwordEncoder.encode(directorDto.getDirectorPassword());
        return new DirectorEntity(
                directorDto.getDirectorIdentificationNumber(),
                directorDto.getDirectorName(),
                directorDto.getDirectorEmail(),
                directorDto.getDirectorIdentificationType(),
                directorDto.getDirectorUsername(),
                passwordEncoded,
                directorDto.getRole()
        );
    }

    public DirectorDto convertDirectorEntityToDirectorDto(DirectorEntity directorEntity) {
        if(directorEntity == null) return null;
        return new DirectorDto(
                directorEntity.getDirectorIdentificationNumber(),
                directorEntity.getDirectorIdentificationType(),
                directorEntity.getDirectorName(),
                directorEntity.getDirectorEmail(),
                directorEntity.getDirectorUsername(),
                null
        );
    }
}