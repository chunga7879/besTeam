package com.example.besTeam.controller;

import com.example.besTeam.data.dto.AnswerDto;
import com.example.besTeam.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/answer")
public class AnswerController {
    private AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }
    @PostMapping("/create/survey/{surveyId}/participant/{participantId}")
    public AnswerDto create(@PathVariable Long surveyId, @PathVariable Long participantId, @RequestBody AnswerDto answerDto) throws Exception {
        return answerService.create(surveyId, participantId, answerDto);
    }
}
