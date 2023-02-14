package com.example.besTeam.data.dao.impl;

import com.example.besTeam.data.dao.SurveyDAO;
import com.example.besTeam.data.entity.Survey;
import com.example.besTeam.data.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyDAOImpl implements SurveyDAO {
    private SurveyRepository surveyRepository;

    @Autowired
    public SurveyDAOImpl(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public Survey save(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Override
    public Survey getById(Long id) throws Exception {
        return surveyRepository.findById(id).orElseThrow(() -> new Exception("survey matched with id does not exist"));
    }

    @Override
    public Survey getByProjectId(Long projectId) throws Exception {
        if (surveyRepository.findByProjectId(projectId).size() != 1) {
            throw new Exception("there is no or more than one survey created by project id" + projectId);
        }
        return surveyRepository.findByProjectId(projectId).get(0);
    }
}
