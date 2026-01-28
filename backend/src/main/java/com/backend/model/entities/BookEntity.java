package com.backend.model.entities;

import jakarta.persistence.*;

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
    @JoinColumn(name = "student_identification_number", unique = true)
    private StudentEntity student;

    public Integer getBookId() {return bookId;}

    public String getBookName() {return bookName;}

    public String getBookAuthor() {return bookAuthor;}

    public String getBookCategory() {return bookCategory;}

    public StudentEntity getStudent() {return student;}

    public void setStudent(StudentEntity student) {this.assignToStudent(student);}

    public void assignToStudent(StudentEntity student) {
        if(this.student != null)
            this.student.setBook(null);
        this.student  = student;
        if(student != null)
            student.setBook(this);
    }
}