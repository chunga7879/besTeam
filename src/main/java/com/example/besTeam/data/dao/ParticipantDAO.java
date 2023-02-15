package com.example.besTeam.data.dao;

import com.example.besTeam.data.entity.Participant;

import java.util.List;

public interface ParticipantDAO {
    Participant save(Participant participant);

    List<Participant> getParticipantsBySurveyId(Long surveyId);
}
