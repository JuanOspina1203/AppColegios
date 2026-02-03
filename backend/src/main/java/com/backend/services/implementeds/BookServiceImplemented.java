package com.backend.services.implementeds;

import com.backend.model.Mapper;
import com.backend.model.dtos.AssignBookDto;
import com.backend.model.dtos.BookDto;
import com.backend.model.dtos.StudentDto;
import com.backend.model.entities.BookEntity;
import com.backend.model.entities.StudentEntity;
import com.backend.repositories.IBookRepository;
import com.backend.repositories.IStudentRepository;
import com.backend.services.IBookService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImplemented implements IBookService {

    private final IBookRepository repository;
    private final IStudentRepository studentRepository;
    private final Mapper mapper;

    public BookServiceImplemented(IBookRepository repository, IStudentRepository studentRepository, Mapper mapper) {
        this.repository = repository;
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public void assignOrUnassignedToStudent(AssignBookDto assignBookDto) {
        StudentEntity student = this.studentRepository.findById(assignBookDto.getStudentIdentificationNumber()).orElseThrow(() -> new RuntimeException("Student not found"));
        StudentDto studentDto = this.mapper.convertStudentEntityToStudentDto(student);
        BookEntity book = this.repository.findById(assignBookDto.getBookId()).orElseThrow(() -> new RuntimeException("Book not found"));
        BookDto bookDto = this.mapper.convertBookEntityToBookDto(book);
        if(assignBookDto.getIsAssign()) {
            if (studentDto.getBookId() != null) throw new RuntimeException("The student already has a book: " + student.getBook().getBookName() + ", he has to release it first");
            if (bookDto.getStudentIdentificationNumber() != null) throw new RuntimeException("Book already assigned: " + bookDto.getStudentIdentificationNumber() + ", it has to release it first");
            book.setStudent(student);
            student.setBook(book);
            this.repository.save(book);
            this.studentRepository.save(student);
        } else {
            if (studentDto.getBookId() == null) throw new RuntimeException("The student does not have a book");
            if (bookDto.getStudentIdentificationNumber() == null) throw new RuntimeException("Book is not assigned");
            book.setStudent(null);
            student.setBook(null);
        }
    }

    @Override
    public void saveBook(BookDto book) {
        BookEntity bookEntity = this.mapper.convertBookDtoToBookEntity(book);
        this.repository.save(bookEntity);
    }

    @Override
    public BookDto findBook(Integer bookId) {
        return this.mapper.convertBookEntityToBookDto(this.repository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found")));
    }

    @Override
    public List<BookDto> getAllBooks() {
        return this.repository.findAll().stream().map(this.mapper::convertBookEntityToBookDto).toList();
    }

    @Override
    public void updateBook(BookDto book) {
        BookEntity bookEntity = this.repository.findById(book.getBookId()).orElseThrow(() -> new RuntimeException("Book not found"));
        BookEntity bookEntityToSave = this.mapper.convertBookDtoToBookEntity(book);
        if(bookEntity.getStudent() == null) this.repository.save(bookEntityToSave);
        bookEntityToSave.setStudent(bookEntity.getStudent());
        this.repository.save(bookEntityToSave);
    }

    @Override
    public void deleteBook(Integer bookId) {
        BookEntity bookEntity = this.repository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        if(bookEntity.getStudent() != null) {
            StudentEntity studentEntity = this.studentRepository
                    .findById(bookEntity.getStudent().getStudentIdentificationNumber())
                    .orElse(null);
            if(studentEntity != null) {
                studentEntity.setBook(null);
                this.studentRepository.save(studentEntity);
            }
        }
        this.repository.deleteById(bookId);
    }
}