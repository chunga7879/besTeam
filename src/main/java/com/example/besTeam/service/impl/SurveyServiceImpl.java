package com.example.besTeam.service.impl;

import com.example.besTeam.data.dao.ProjectDAO;
import com.example.besTeam.data.dao.SurveyDAO;
import com.example.besTeam.data.dto.SurveyDto;
import com.example.besTeam.data.entity.Project;
import com.example.besTeam.data.entity.Survey;
import com.example.besTeam.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

        Survey survey = Survey.builder().project(project)
                .name(surveyDto.getName())
                .isAllowWritePreferTeamMates(surveyDto.isAllowWritePreferTeamMates())
                .preferPersonOptionMax(surveyDto.getPreferPersonOptionMax())
                .isPossibleSameRolePreference(surveyDto.isPossibleSameRolePreference())
                .minRangeRolePreference(surveyDto.getMinRangeRolePreference())
                .maxRangeRolePreference(surveyDto.getMaxRangeRolePreference())
                .isPossibleSameAbilityRating(surveyDto.isPossibleSameAbilityRating())
                .minRangeAbilityRating(surveyDto.getMinRangeAbilityRating())
                .maxRangeAbilityRating(surveyDto.getMaxRangeAbilityRating())
                .participants(new ArrayList<>())
                .build();

        return surveyDAO.save(survey).toDto();
    }

    @Override
    public SurveyDto getSurveyById(Long id) throws Exception {
        Survey survey = surveyDAO.getById(id);
        return survey.toDto();
    }

    @Override
    public List<SurveyDto> getSurveyByProjectId(Long projectId) throws Exception {
        List<SurveyDto> surveyDtos = new ArrayList<>();
        List<Survey> surveys = surveyDAO.getAllByProjectId(projectId);

        for(Survey survey : surveys) {
            surveyDtos.add(survey.toDto());
        }

        return surveyDtos;
    }


}
