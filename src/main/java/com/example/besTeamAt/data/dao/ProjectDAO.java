package com.example.besTeamAt.data.dao;

import com.example.besTeamAt.data.entity.Project;

import java.util.List;

public interface ProjectDAO {

    Project saveProject(Project project);

    Project getProject(Long id);

    List<Project> getProjectByUserId(Long userId);
}

