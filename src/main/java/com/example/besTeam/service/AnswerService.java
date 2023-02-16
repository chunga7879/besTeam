package com.example.besTeam.service;

import com.example.besTeam.data.dto.AnswerDto;
import com.example.besTeam.data.entity.RoleAnswer;

public interface AnswerService {
    AnswerDto create(Long surveyId, Long participantId, AnswerDto answerDto) throws Exception;


}
