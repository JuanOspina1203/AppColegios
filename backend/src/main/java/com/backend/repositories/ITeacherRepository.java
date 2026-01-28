package com.backend.repositories;

import com.backend.model.entities.TeacherEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ITeacherRepository extends JpaRepository<TeacherEntity, String> {}
