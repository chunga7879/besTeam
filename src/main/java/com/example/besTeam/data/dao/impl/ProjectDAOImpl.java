package com.example.besTeam.data.dao.impl;

import com.example.besTeam.data.dao.ProjectDAO;
import com.example.besTeam.data.entity.Project;
import com.example.besTeam.data.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectDAOImpl implements ProjectDAO {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectDAOImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project getById(Long id) throws Exception {
        Project project = projectRepository.findById(id).orElseThrow(() -> new Exception("no project exist matched with id"));

        return project;
    }

    @Override
    public List<Project> getByUserId(Long userId) {
        return projectRepository.findByUserId(userId);
    }
}
