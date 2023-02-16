package com.example.besTeam.data.dao;

import com.example.besTeam.data.entity.Survey;

import java.util.List;

public interface SurveyDAO {
    Survey save(Survey survey);

    Survey getById(Long id) throws Exception;

    List<Survey> getAllByProjectId(Long projectId) throws Exception;
}
