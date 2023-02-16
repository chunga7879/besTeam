package com.example.besTeam.service.impl;

import com.example.besTeam.data.dao.AnswerDAO;
import com.example.besTeam.data.dao.ParticipantDAO;
import com.example.besTeam.data.dto.AnswerDto;
import com.example.besTeam.data.entity.*;
import com.example.besTeam.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    private AnswerDAO answerDAO;
    private ParticipantDAO participantDAO;

    @Autowired
    public AnswerServiceImpl(AnswerDAO answerDAO, ParticipantDAO participantDAO) {
        this.answerDAO = answerDAO;
        this.participantDAO = participantDAO;
    }

    public AnswerDto create(Long surveyId, Long participantId, AnswerDto answerDto) throws Exception {
        Participant participant = participantDAO.getById(participantId);

        Answer answer = Answer.builder()
                .roleAnswers(new ArrayList<>())
                .abilityAnswers(new ArrayList<>())
                .preferMateAnswers(new ArrayList<>())
                .participant(participant)
                .build();

        for (PreferMateAnswer preferMateAnswer : answerDto.getPreferMateAnswers()) {
            answer.addPreferMateAnswers(answerDAO.savePreferMateAnswer(preferMateAnswer));
        }

        for (RoleAnswer roleAnswer : answerDto.getRoleAnswers()) {
            answer.addRoleAnswers(answerDAO.saveRoleAnswer(roleAnswer));
        }

        for (AbilityAnswer abilityAnswer : answerDto.getAbilityAnswers()) {
            answer.addAbilityAnswer(answerDAO.saveAbilityAnswer(abilityAnswer));
        }

        return answerDAO.save(answer).toDto();
    }
}
