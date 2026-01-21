package com.backend.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "books_tbl")
@Getter
@Setter
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

    public void assignToStudent(StudentEntity student) {
        if(this.student != null)
            this.student.setBook(null);
        this.student  = student;
        if(student != null)
            student.setBook(this);
    }
}