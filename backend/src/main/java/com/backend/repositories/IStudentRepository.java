package com.backend.repositories;

import com.backend.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IStudentRepository extends JpaRepository<StudentEntity, UUID> {
}
