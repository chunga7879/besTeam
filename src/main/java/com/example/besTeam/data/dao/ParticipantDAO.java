package com.example.besTeam.data.dao;

import com.example.besTeam.data.entity.Participant;

import java.util.List;

public interface ParticipantDAO {
    Participant save(Participant participant);

    Participant getById(Long id) throws Exception;

    List<Participant> getParticipantsBySurveyId(Long surveyId);
}
