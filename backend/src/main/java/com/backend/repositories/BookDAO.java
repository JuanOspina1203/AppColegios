package com.backend.repositories;

import com.backend.entities.BookEntity;
import com.backend.entities.StudentEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

@Repository
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveBook(BookEntity book) {
        if(book.getStudent() != null && book.getStudent().getStudentId() == null)
            throw new IllegalArgumentException("The student associated to the book should be previously saved in the Database");
        String sql = """
                    INSERT INTO books_tbl (book_name, book_author, book_category, student_id)
                    VALUES (?,?,?,?)
                """;
        UUID studentId = book.getStudent() != null ? book.getStudent().getStudentId() : null;
        jdbcTemplate.update(
                sql,
                book.getBookName(),
                book.getBookAuthor(),
                book.getBookCategory(),
                studentId
        );
    }

    public Optional<BookEntity> findByStudentIdWithStudent(UUID studentId) {
        String sql = """
            SELECT b.*, s.student_grade, s.student_identification_type, s.student_identification_number
            FROM books_tbl b
            LEFT JOIN students_tbl s ON b.student_id = s.student_id
            WHERE b.student_id = ?
        """;
        return jdbcTemplate.query(sql, new Object[]{studentId}, rs -> {
                if(rs.next()) {
                    BookEntity book = mapBook(rs);
                    if(rs.getString("student_id") != null) {
                        StudentEntity student = new StudentEntity(
                                UUID.fromString(rs.getString("student_id")),
                                rs.getString("student_grade"),
                                rs.getString("student_identification_type"),
                                rs.getString("student.identification_number"),
                                book
                        );
                        book.setStudent(student);
                    }
                    return Optional.of(book);
                }
                return Optional.empty();
            }
        );
    }

        private BookEntity mapBook(ResultSet rs) throws SQLException {
            return new BookEntity(
                    rs.getInt("book_id"),
                    rs.getString("book_name"),
                    rs.getString("book_author"),
                    rs.getString("book_category"),
                    null
            );
        }

}
