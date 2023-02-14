package com.example.besTeam.data.repository;

import com.example.besTeam.data.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

    @Query(value = "SELECT * FROM survey s WHERE project_id = ?1", nativeQuery = true)
    List<Survey> findByProjectId(Long projectId);
}
