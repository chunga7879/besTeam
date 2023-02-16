package com.example.besTeam.service;

import com.example.besTeam.data.dto.SurveyDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SurveyService {
    SurveyDto create(SurveyDto surveyDto) throws Exception;

    SurveyDto getSurveyById(Long id) throws Exception;

    List<SurveyDto> getSurveyByProjectId(Long projectId) throws Exception;


}
