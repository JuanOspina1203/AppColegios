package com.backend.repositories;

import com.backend.model.entities.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDirectorRepository extends JpaRepository<DirectorEntity,String> {
    Optional<DirectorEntity> findByDirectorUsername(String directorUsername);
    boolean existsByDirectorUsername(String directorUsername);
}
