package com.backend.services.implementeds;

import com.backend.model.Mapper;
import com.backend.model.dtos.StudentDto;
import com.backend.model.entities.BookEntity;
import com.backend.model.entities.GradeGroupEntity;
import com.backend.model.entities.StudentEntity;
import com.backend.repositories.IBookRepository;
import com.backend.repositories.IGradeGroupRepository;
import com.backend.repositories.IStudentRepository;
import com.backend.services.IStudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplemented implements IStudentService {

    private final IStudentRepository repository;
    private final Mapper mapper;
    private final IBookRepository bookRepository;
    private final IGradeGroupRepository gradeGroupRepository;

    public StudentServiceImplemented(IStudentRepository repository,
                                     Mapper mapper,
                                     IBookRepository bookRepository,
                                     IGradeGroupRepository gradeGroupRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.bookRepository = bookRepository;
        this.gradeGroupRepository = gradeGroupRepository;
    }

    @Override
    public void saveStudent(StudentDto student) {
        this.repository.save(this.mapper.convertStudentDtoToStudentEntity(student));
    }

    @Override
    public StudentDto findStudent(String studentIdentificationNumber) {
        return this.mapper.convertStudentEntityToStudentDto(this.repository.findById(studentIdentificationNumber).orElseThrow(() -> new RuntimeException("Student not found")));
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::convertStudentEntityToStudentDto)
                .toList();
    }

    @Override
    public List<StudentDto> getAllStudentsWithBook() {
        return this.repository.findAll()
                .stream()
                .filter(student -> student.getBook() != null)
                .map(this.mapper::convertStudentEntityToStudentDto).toList();
    }

    @Override
    public void updateStudent(StudentDto student) {
        StudentEntity studentEntity = this.repository.findById(student.getStudentIdentificationNumber()).orElseThrow(() -> new RuntimeException("Student not found"));
        StudentEntity studentToSave = this.mapper.convertStudentDtoToStudentEntity(student);
        if(studentEntity.getBook() == null) this.repository.save(studentToSave);
        studentToSave.setBook(studentEntity.getBook());
        this.repository.save(studentToSave);
    }

    @Override
    public void deleteStudent(String studentIdentificationNumber) {
        StudentEntity studentEntity = this.repository.findById(studentIdentificationNumber)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        if(studentEntity.getBook() != null) {
            Integer bookId = studentEntity.getBook().getBookId();
            BookEntity bookEntity = this.bookRepository.findById(bookId).orElse(null);
            if(bookEntity != null) {
                bookEntity.setStudent(null);
                this.bookRepository.save(bookEntity);
            }
        }
        this.repository.deleteById(studentIdentificationNumber);
    }

    @Override
    public void enrollStudentInGradeGroup(String studentIdentificationNumber, String gradeGroupId) {
        GradeGroupEntity gradeGroupEntity = this.gradeGroupRepository.findById(gradeGroupId).orElseThrow(() -> new RuntimeException("Grade group not found"));
        StudentEntity studentEntity = this.repository.findById(studentIdentificationNumber).orElseThrow(() -> new RuntimeException("Student not found"));
        studentEntity.setStudentGradeAssigned(gradeGroupEntity);
        this.repository.save(studentEntity);
    }
}