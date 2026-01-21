package com.backend.model;

import com.backend.model.dtos.BookDto;
import com.backend.model.dtos.StudentDto;
import com.backend.model.entities.BookEntity;
import com.backend.model.entities.StudentEntity;

public class Mapper {

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
        studentDto.setStudentId(studentEntity.getStudentId());
        studentDto.setStudentGrade(studentEntity.getStudentGrade());
        studentDto.setStudentIdentificationType(studentEntity.getStudentIdentificationType());
        studentDto.setStudentIdentificationNumber(studentEntity.getStudentIdentificationNumber());
        BookEntity book = studentEntity.getBook();
        if(book != null) {
            studentDto.setBookName(book.getBookName());
            studentDto.setBookId(book.getBookId());
        }
        return studentDto;
    }

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
        bookDto.setBookCategory(bookEntity.getBookCategory());
        bookDto.setBookAuthor(bookEntity.getBookAuthor());
        StudentEntity studentEntity = bookEntity.getStudent();
        if(studentEntity != null) {
            bookDto.setStudentName(studentEntity.getStudentName());
            bookDto.setStudentId(studentEntity.getStudentId());
        }
        return bookDto;
    }
}