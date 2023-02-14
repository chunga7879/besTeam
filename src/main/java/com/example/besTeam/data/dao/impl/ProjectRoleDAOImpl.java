package com.example.besTeam.data.dao.impl;

import com.example.besTeam.data.dao.ProjectRoleDAO;
import com.example.besTeam.data.entity.ProjectRole;
import com.example.besTeam.data.repository.ProjectRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectRoleDAOImpl implements ProjectRoleDAO {
    private ProjectRoleRepository projectRoleRepository;

    @Autowired
    public ProjectRoleDAOImpl(ProjectRoleRepository projectRoleRepository) {
        this.projectRoleRepository = projectRoleRepository;
    }

    @Override
    public ProjectRole create(ProjectRole projectRole) {
        return projectRoleRepository.save(projectRole);
    }

    @Override
    public List<ProjectRole> getByProjectAndRole(ProjectRole projectRole) {
        return projectRoleRepository.findByProjectAndRole(projectRole.getProject().getId(), projectRole.getRole().getId());
    }

    @Override
    public List<ProjectRole> getByProjectId(Long projectId) {
        return projectRoleRepository.findByProjectId(projectId);
    }

    @Override
    public ProjectRole updateNumForRole(ProjectRole projectRole) {
        projectRoleRepository.updateNumForRole(projectRole.getId(), projectRole.getNumForRole());
        return projectRole;
    }
}
