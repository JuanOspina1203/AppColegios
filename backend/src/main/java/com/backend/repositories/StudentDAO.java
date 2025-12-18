package com.backend.repositories;

import com.backend.entities.StudentEntity;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

@Repository
public class StudentDAO {

    private final JdbcTemplate jdbcTemplate;

    public StudentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveStudent(StudentEntity student) {
        String sql = """
                    INSERT INTO students_tbl
                    (student_id, student_grade, student_identification_type, student_identification_number)
                    VALUES (?,?,?,?)
                """;
        jdbcTemplate.update(
                sql,
                student.getStudentId(),
                student.getStudentGrade(),
                student.getStudentIdentificationType(),
                student.getStudentIdentificationNumber()
        );
    }

    public Optional<StudentEntity> findById(UUID studentId) {
        String sql = "SELECT * FROM students_tbl WHERE student_id = ?";
        return jdbcTemplate.query(
                sql,
                new Object[]{studentId},
                rs -> rs.next() ? Optional.of(mapStudent(rs)) : Optional.empty()
        );
    }

    private StudentEntity mapStudent(ResultSet rs) throws SQLException {
        return new StudentEntity(
                UUID.fromString(rs.getString("student_id")),
                rs.getString("student_grade"),
                rs.getString("student_identification_type"),
                rs.getString("student_identification_number"),
                null
        );
    }
}
