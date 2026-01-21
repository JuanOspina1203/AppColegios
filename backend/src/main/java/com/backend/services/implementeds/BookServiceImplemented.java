package com.backend.services.implementeds;

import com.backend.model.Mapper;
import com.backend.model.dtos.BookDto;
import com.backend.model.dtos.StudentDto;
import com.backend.model.entities.BookEntity;
import com.backend.model.entities.StudentEntity;
import com.backend.repositories.IBookRepository;
import com.backend.repositories.IStudentRepository;
import com.backend.services.IBookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public void assignOrUnassignedToStudent(UUID studentId, Integer bookId, boolean assign) throws Exception {
        StudentEntity student = this.studentRepository.findById(studentId).orElseThrow();
        StudentDto studentDto = this.mapper.convertStudentEntityToStudentDto(student);
        BookEntity book = this.repository.findById(bookId).orElseThrow();
        BookDto bookDto = this.mapper.convertBookEntityToBookDto(book);
        if(assign) {
            if (studentDto.getBookId() != null)
                throw new Exception("The student already has a book: " + student.getBook().getBookName() + ", he has to release it first");
            if (bookDto.getStudentId() != null)
                throw new Exception("Book already assigned: " + bookDto.getStudentId() + ", it has to release it first");
            book.setStudent(student);
            student.setBook(book);
        } else {
            if (studentDto.getBookId() == null)
                throw new Exception("The student does not have a book");
            if (bookDto.getStudentId() == null)
                throw new Exception("Book is not assigned");
            book.setStudent(null);
            student.setBook(null);
        }
    }

    @Override
    public void saveBook(BookDto book) throws Exception {
        BookEntity bookEntity = this.mapper.convertBookDtoToBookEntity(book);
        this.repository.save(bookEntity);
    }

    @Override
    public BookDto findBook(Integer bookId) {
        return this.mapper.convertBookEntityToBookDto(this.repository.findById(bookId).isPresent() ? this.repository.findById(bookId).get() : null);
    }

    @Override
    public List<BookDto> getAllBooks() {
        return this.repository.findAll().stream().map(this.mapper::convertBookEntityToBookDto).toList();
    }

    @Override
    public void updateBook(BookDto book) throws Exception {
        BookEntity bookEntity = this.mapper.convertBookDtoToBookEntity(this.repository.findById(book.getBookId()).isPresent() ? this.repository.findById(book.getBookId()).get() : null);

        this.repository.save(bookEntity);
    }

    @Override
    public void deleteBook(Integer bookId) {
        this.repository.deleteById(bookId);
    }
}
