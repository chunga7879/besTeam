package com.example.besTeam.service.impl;

import com.example.besTeam.data.dao.ProjectDAO;
import com.example.besTeam.data.dao.SurveyDAO;
import com.example.besTeam.data.dto.SurveyDto;
import com.example.besTeam.data.entity.Project;
import com.example.besTeam.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImpl implements SurveyService {
    private SurveyDAO surveyDAO;
    private ProjectDAO projectDAO;

    @Autowired
    public SurveyServiceImpl(SurveyDAO surveyDAO, ProjectDAO projectDAO) {
        this.surveyDAO = surveyDAO;
        this.projectDAO = projectDAO;
    }

    @Override
    public SurveyDto create(SurveyDto surveyDto) throws Exception {
        Project project = projectDAO.getById(surveyDto.getProject().getId());

        return null;
    }

    @Override
    public SurveyDto getSurveyById(Long id) {
        return null;
    }
}
