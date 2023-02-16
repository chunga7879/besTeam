package com.example.besTeam.service.impl;

import com.example.besTeam.data.dao.ParticipantDAO;
import com.example.besTeam.data.dao.SurveyDAO;
import com.example.besTeam.data.dto.ParticipantDto;
import com.example.besTeam.data.entity.Participant;
import com.example.besTeam.data.entity.Survey;
import com.example.besTeam.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService {
    private ParticipantDAO participantDAO;
    private SurveyDAO surveyDAO;

    @Autowired
    public ParticipantServiceImpl(ParticipantDAO participantDAO, SurveyDAO surveyDAO) {
        this.participantDAO = participantDAO;
        this.surveyDAO = surveyDAO;
    }


    @Override
    public ParticipantDto create(Long surveyId, ParticipantDto participantDto) throws Exception {
        Survey survey = surveyDAO.getById(surveyId);

        Participant participant = Participant.builder()
                .email(participantDto.getEmail())
                .studentNumber(participantDto.getStudentNumber())
                .build();
        survey.addParticipant(participant);
        participant = participantDAO.save(participant);

        return participant.toDto();
    }

    @Override
    public List<ParticipantDto> getAllBySurvey(Long surveyId) {
        List<ParticipantDto> participants = new ArrayList<>();

        for (Participant participant : participantDAO.getParticipantsBySurveyId(surveyId)) {
            participants.add(participant.toDto());
        }

        return participants;
    }
}
