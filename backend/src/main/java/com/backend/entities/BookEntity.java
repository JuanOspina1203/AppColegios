package com.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "books_tbl")
public class BookEntity {

    public BookEntity (
            Integer bookId,
            String bookName,
            String bookCategory,
            String bookAuthor,
            StudentEntity student
    ) {
        this.bookId = bookId;
        this.bookAuthor = bookAuthor;
        this.bookCategory = bookCategory;
        this.bookName = bookName;
        this.student = student;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_author")
    private String bookAuthor;

    @Column(name = "book_category")
    private String bookCategory;

    @OneToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    public Integer getBookId() {
        return this.bookId;
    }

    public String getBookName() {
        return this.bookName;
    }

    public String getBookAuthor() {
        return this.bookAuthor;
    }

    public String getBookCategory() {
        return this.bookCategory;
    }

    public StudentEntity getStudent() {
        return this.student;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }
}
