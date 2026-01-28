package com.backend.services;

import com.backend.model.dtos.AssignBookDto;
import com.backend.model.dtos.BookDto;
import com.backend.model.entities.BookEntity;

import java.util.List;
import java.util.UUID;

public interface IBookService {
    void assignOrUnassignedToStudent(AssignBookDto assignBookDto) throws Exception;
    void saveBook(BookDto book) throws Exception;
    BookDto findBook(Integer bookId);
    List<BookDto> getAllBooks();
    void updateBook(BookDto book) throws Exception;
    void deleteBook(Integer bookId);
}
