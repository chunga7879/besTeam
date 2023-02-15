package com.example.besTeam.data.dao.impl;

import com.example.besTeam.data.dao.ParticipantDAO;
import com.example.besTeam.data.entity.Participant;
import com.example.besTeam.data.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantDAOImpl implements ParticipantDAO {
    private ParticipantRepository participantRepository;

    @Autowired
    public ParticipantDAOImpl(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @Override
    public Participant save(Participant participant) {
        return participantRepository.save(participant);
    }

    @Override
    public List<Participant> getParticipantsBySurveyId(Long surveyId) {
        return participantRepository.getParticipantsBySurveyId(surveyId);
    }
}
