package com.example.besTeam.service;

import com.example.besTeam.data.dto.SurveyDto;
import org.springframework.stereotype.Service;

@Service
public interface SurveyService {
    SurveyDto create(SurveyDto surveyDto) throws Exception;

    SurveyDto getSurveyById(Long id);
}
