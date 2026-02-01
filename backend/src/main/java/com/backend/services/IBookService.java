package com.backend.services;

import com.backend.model.dtos.AssignBookDto;
import com.backend.model.dtos.BookDto;

import java.util.List;

public interface IBookService {
    void assignOrUnassignedToStudent(AssignBookDto assignBookDto);
    void saveBook(BookDto book);
    BookDto findBook(Integer bookId);
    List<BookDto> getAllBooks();
    void updateBook(BookDto book);
    void deleteBook(Integer bookId);
}
