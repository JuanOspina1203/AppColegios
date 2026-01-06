package com.backend.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "books_tbl")
public class BookEntity {

    public BookEntity (){}

    public BookEntity (
            Integer bookId,
            String bookName,
            String bookCategory,
            String bookAuthor
    ) {
        this.bookId = bookId;
        this.bookAuthor = bookAuthor;
        this.bookCategory = bookCategory;
        this.bookName = bookName;
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", unique = true)
    private StudentEntity student;

    public Integer getBookId() { return this.bookId; }

    public String getBookName() { return this.bookName; }

    public String getBookAuthor() { return this.bookAuthor; }

    public String getBookCategory() { return this.bookCategory; }

    public StudentEntity getStudent() { return this.student; }

    public void setBookId(Integer bookId) { this.bookId = bookId; }

    public void setBookName(String bookName) { this.bookName = bookName; }

    public void setBookCategory(String bookCategory) { this.bookCategory = bookCategory; }

    public void setBookAuthor(String bookAuthor) { this.bookAuthor = bookAuthor; }

    public void setStudent(StudentEntity student) { this.student = student; }

    public void assignToStudent(StudentEntity student) {
        if(this.student != null)
            this.student.setBook(null);
        this.student  = student;
        if(student != null)
            student.setBook(this);
    }
}
