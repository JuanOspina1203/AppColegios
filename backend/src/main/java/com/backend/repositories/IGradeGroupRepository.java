package com.backend.repositories;

import com.backend.model.entities.GradeGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGradeGroupRepository extends JpaRepository<GradeGroupEntity, String> {}
