package com.example.besTeamAt.data.repository;

import com.example.besTeamAt.data.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query(value = "SELECT * FROM Project p WHERE p.user.id = ?1", nativeQuery = true)
    List<Project> findByUserId(Long userId);
}
