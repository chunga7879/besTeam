package com.example.besTeam.data.repository;

import com.example.besTeam.data.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    @Query(value = "SELECT * FROM participant p WHERE p.survey_id = ?1", nativeQuery = true)
    List<Participant> getParticipantsBySurveyId(Long surveyId);
}
