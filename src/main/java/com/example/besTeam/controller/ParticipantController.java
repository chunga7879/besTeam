package com.example.besTeam.controller;

import com.example.besTeam.data.dto.ParticipantDto;
import com.example.besTeam.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/participant")
public class ParticipantController {
    private ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping("/create/survey/{surveyId}")
    public ParticipantDto create(@PathVariable Long surveyId, @RequestBody ParticipantDto participantDto) throws Exception {
        return participantService.create(surveyId, participantDto);
    }

    @GetMapping("/")
    public List<ParticipantDto> getAllBySurvey(@RequestParam Long surveyId) {
        return participantService.getAllBySurvey(surveyId);
    }
}
