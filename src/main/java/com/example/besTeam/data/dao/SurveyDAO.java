package com.example.besTeam.data.dao;

import com.example.besTeam.data.entity.Survey;

public interface SurveyDAO {
    Survey create(Survey survey);

    Survey getById(Long id) throws Exception;
}