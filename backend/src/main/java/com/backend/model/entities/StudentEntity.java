package com.backend.model.entities;

import com.backend.model.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "students_tbl")
public class StudentEntity {

    @Column(name = "student_identification_number", length = 12, nullable = false)
    @Id
    private String studentIdentificationNumber;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_grade")
    private String studentGrade;

    @Column(name = "student_identification_type")
    private String studentIdentificationType;

    @Enumerated(EnumType.STRING)
    private Role role = Role.STUDENT;

    @OneToOne(mappedBy = "student")
    private BookEntity book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_grade_related")
    private GradeGroupEntity studentGradeAssigned;

    public StudentEntity() {}

    public String getStudentName() {return studentName;}

    public String getStudentGrade() {return studentGrade;}

    public String getStudentIdentificationType() {return studentIdentificationType;}

    public String getStudentIdentificationNumber() {return studentIdentificationNumber;}

    public BookEntity getBook() {return book;}

    public void setStudentName(String studentName) {this.studentName = studentName;}

    public void setStudentGrade(String studentGrade) {this.studentGrade = studentGrade;}

    public void setStudentIdentificationType(String studentIdentificationType) {this.studentIdentificationType = studentIdentificationType;}

    public void setStudentIdentificationNumber(String studentIdentificationNumber) {this.studentIdentificationNumber = studentIdentificationNumber;}

    public GradeGroupEntity getStudentGradeAssigned() {return this.studentGradeAssigned;}

    public void setStudentGradeAssigned(GradeGroupEntity gradeGroupEntity) {this.studentGradeAssigned = gradeGroupEntity;}

    public void setBook(BookEntity book) {
        if (this.book == book) return;
        BookEntity previousBook = this.book;
        this.book = book;
        if (previousBook != null) previousBook.setStudent(null);
        if (book != null && book.getStudent() != this) book.setStudent(this);
    }
}