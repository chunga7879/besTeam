package com.example.besTeam.data.dao;

import com.example.besTeam.data.entity.ProjectRole;

import java.util.List;

public interface ProjectRoleDAO {
    ProjectRole create(ProjectRole projectRole);

    List<ProjectRole> getByProjectAndRole(ProjectRole projectRole);

    List<ProjectRole> getByProjectId(Long projectId);


    ProjectRole updateNumForRole(ProjectRole projectRole);
}
