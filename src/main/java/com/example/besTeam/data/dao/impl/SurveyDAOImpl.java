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
    public Survey create(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Override
    public Survey getById(Long id) throws Exception {
        return surveyRepository.findById(id).orElseThrow(() -> new Exception("survey matched with id does not exist"));
    }
}
