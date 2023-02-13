package com.example.besTeamAt.data.dao;

import com.example.besTeamAt.data.entity.Project;

import java.util.List;

public interface ProjectDAO {

    Project save(Project project);

    Project getById(Long id);

    List<Project> getByUserId(Long userId);
}

