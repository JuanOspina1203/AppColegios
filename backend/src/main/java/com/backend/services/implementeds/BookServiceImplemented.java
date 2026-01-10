package com.backend.services.implementeds;

import com.backend.entities.BookEntity;
import com.backend.entities.StudentEntity;
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

    public BookServiceImplemented(IBookRepository repository, IStudentRepository studentRepository) {
        this.repository = repository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void assignOrUnassignedToStudent(UUID studentId, Integer bookId, boolean assign) throws Exception {
        StudentEntity student = this.studentRepository.findById(studentId).orElseThrow(() -> new Exception("Student not found with id: " + studentId));
        BookEntity book = this.repository.findById(bookId).orElseThrow(() -> new Exception("Book not found"));
        if(assign) {
            if (student.getBook() != null)
                throw new Exception("The student already has a book: " + student.getBook().getBookName() + ", he has to release it first");
            if (book.getStudent() != null)
                throw new Exception("Book already assigned: " + book.getStudent().getStudentId() + ", it has to release it first");
            book.setStudent(student);
            student.setBook(book);
        } else {
            if (student.getBook() == null)
                throw new Exception("The student does not have a book");
            if (book.getStudent() == null)
                throw new Exception("Book is not assigned");
            book.setStudent(null);
            student.setBook(null);
        }
    }

    @Override
    public void saveBook(BookEntity book) throws Exception {
        this.repository.save(book);
    }

    @Override
    public BookEntity findBook(Integer bookId) {
        return Optional.of(this.repository.findById(bookId)).get().orElseThrow();
    }

    @Override
    public List<BookEntity> getAllBooks() {
        return this.repository.findAll();
    }

    @Override
    public void updateBook(BookEntity book) throws Exception {
        this.repository.findById(book.getBookId()).orElseThrow();
        this.repository.save(book);
    }

    @Override
    public void deleteBook(Integer bookId) {
        this.repository.deleteById(bookId);
    }
}
