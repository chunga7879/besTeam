package com.example.besTeam.data.dao;

import com.example.besTeam.data.entity.Project;

import java.util.List;

public interface ProjectDAO {

    Project save(Project project);

    Project getById(Long id) throws Exception;

    List<Project> getByUserId(Long userId);
}

