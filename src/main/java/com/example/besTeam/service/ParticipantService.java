package com.example.besTeam.service;

import com.example.besTeam.data.dto.ParticipantDto;

import java.util.List;

public interface ParticipantService {
    ParticipantDto create(Long surveyId, ParticipantDto participantDto) throws Exception;

    List<ParticipantDto> getAllBySurvey(Long surveyId);
}
