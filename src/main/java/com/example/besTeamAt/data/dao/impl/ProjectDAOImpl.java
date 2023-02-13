package com.example.besTeamAt.data.dao.impl;

import com.example.besTeamAt.data.dao.ProjectDAO;
import com.example.besTeamAt.data.entity.Project;
import com.example.besTeamAt.data.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectDAOImpl implements ProjectDAO {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectDAOImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project) {
        projectRepository.save(project);
        return project;
    }

    @Override
    public Project getById(Long id) {
        Project project = projectRepository.getById(id);
        return project;
    }

    @Override
    public List<Project> getByUserId(Long userId) {
        return projectRepository.findByUserId(userId);
    }
}
