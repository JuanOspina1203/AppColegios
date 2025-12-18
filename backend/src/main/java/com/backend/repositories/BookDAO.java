package com.backend.repositories;

import com.backend.entities.BookEntity;
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

    public Optional<BookEntity> findByStudentId(UUID studentId) {
        String sql = """
            SELECT b.* FROM books_tbl b
            WHERE b.student_id = ?
        """;
        return jdbcTemplate.query(
                sql,
                new Object[]{studentId},
                rs -> rs.next() ? Optional.of(mapBook(rs)) : Optional.empty()
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
