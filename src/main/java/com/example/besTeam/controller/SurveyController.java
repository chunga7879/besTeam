package com.example.besTeam.controller;

import com.example.besTeam.data.dto.SurveyDto;
import com.example.besTeam.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/survey")
public class SurveyController {
    private SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping("/create")
    public SurveyDto create(@RequestBody SurveyDto surveyDto) throws Exception {
        return surveyService.create(surveyDto);
    }

    @GetMapping("/{id}")
    public SurveyDto getById(@PathVariable Long id) throws Exception {
        return surveyService.getSurveyById(id);
    }

    @GetMapping("/project/{projectId}")
    public List<SurveyDto> getByProjectId(@PathVariable Long projectId) throws Exception {
        return surveyService.getSurveyByProjectId(projectId);
    }
}
