package com.example.besTeam.data.repository;

import com.example.besTeam.data.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
