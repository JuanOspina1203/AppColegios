package com.backend.controllers;

import com.backend.model.dtos.BookDto;
import com.backend.model.dtos.AssignBookDto;
import com.backend.routes.Routes;
import com.backend.services.IBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Routes.BOOKS_ROUTE)
public class BookController {

    private final IBookService service;

    public BookController(IBookService service) {
        this.service = service;
    }

    @PostMapping(Routes.ASSIGN_OR_UNASSIGN_BOOK)
    public ResponseEntity<String> assignOrUnassignedToStudent (@Validated @RequestBody AssignBookDto assignBookDto) throws Exception {
        this.service.assignOrUnassignedToStudent(assignBookDto);
        return ResponseEntity.status(HttpStatus.GONE).body("Book processed");
    }

    @PostMapping
    public ResponseEntity<String> saveBook(@Validated @RequestBody BookDto book) throws Exception {
        this.service.saveBook(book);
        return ResponseEntity.ok("Book saved");
    }

    @GetMapping(Routes.BOOK_ID)
    public ResponseEntity<BookDto> findBook (@PathVariable Integer bookId) {
        return ResponseEntity.status(HttpStatus.FOUND).body(this.service.findBook(bookId));
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(this.service.getAllBooks());
    }

    @PutMapping
    public ResponseEntity<String> updateBook(@Validated @RequestBody BookDto book) throws Exception {
        this.service.updateBook(book);
        return ResponseEntity.ok("Book updated");
    }

    @DeleteMapping(Routes.BOOK_ID)
    public ResponseEntity<String> deleteBook(@PathVariable Integer bookId) {
        this.service.deleteBook(bookId);
        return ResponseEntity.ok("Book deleted");
    }
}