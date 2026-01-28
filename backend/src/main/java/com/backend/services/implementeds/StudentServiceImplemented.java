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
        return this.mapper.convertStudentEntityToStudentDto(this.repository.findById(studentIdentificationNumber).orElseThrow());
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
    public void updateStudent(StudentDto student) throws Exception {
        Optional<StudentEntity> studentEntity = this.repository.findById(student.getStudentIdentificationNumber());
        if(studentEntity.isPresent()) {
            StudentEntity studentToSave = this.mapper.convertStudentDtoToStudentEntity(student);
            if(studentEntity.get().getBook() == null) this.repository.save(studentToSave);
            studentToSave.setBook(studentEntity.get().getBook());
            this.repository.save(studentToSave);
        }
        else throw new Exception("Student not found");
    }

    @Override
    public void deleteStudent(String studentIdentificationNumber) {
       Optional<StudentEntity> studentEntity = this.repository.findById(studentIdentificationNumber);
        if(studentEntity.isPresent()) {
            GradeGroupEntity gradeGroupEntity = this.gradeGroupRepository.findById(studentEntity.get().getStudentGradeAssigned().getGradeGroupId()).orElse(null);
            BookEntity bookEntity = this.bookRepository.findById(studentEntity.get().getBook().getBookId()).orElse(null);
            assert bookEntity != null;
            assert gradeGroupEntity != null;
            bookEntity.setStudent(null);

            this.bookRepository.save(bookEntity);
            this.repository.deleteById(studentIdentificationNumber);
        }
        this.repository.deleteById(studentIdentificationNumber);
    }

    @Override
    public void enrollStudentInGradeGroup(String studentIdentificationNumber, String gradeGroupId) {
        GradeGroupEntity gradeGroupEntity = this.gradeGroupRepository.findById(gradeGroupId).orElseThrow();
        StudentEntity studentEntity = this.repository.findById(studentIdentificationNumber).orElseThrow();
        studentEntity.setStudentGradeAssigned(gradeGroupEntity);
        this.repository.save(studentEntity);
    }
}