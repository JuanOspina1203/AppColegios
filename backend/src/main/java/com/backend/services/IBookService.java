package com.backend.services;

import com.backend.entities.BookEntity;
import com.backend.entities.StudentEntity;

import java.util.List;
import java.util.UUID;

public interface IBookService {
    void assignOrUnassignedToStudent(UUID studentId, Integer bookId, boolean assign) throws Exception;
    void saveBook(BookEntity book);
    BookEntity findBook(Integer bookId);
    List<BookEntity> getAllBooks();
    void updateBook(BookEntity book);
    void deleteBook(Integer bookId);
}
