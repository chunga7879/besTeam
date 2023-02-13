package com.example.besTeam.service.impl;

import com.example.besTeam.data.dao.ProjectDAO;
import com.example.besTeam.data.dto.ProjectDto;
import com.example.besTeam.data.entity.Category;
import com.example.besTeam.data.entity.Project;
import com.example.besTeam.data.entity.User;
import com.example.besTeam.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectDAO projectDAO;

    @Autowired
    public ProjectServiceImpl(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Override
    public ProjectDto create(String name, Category category, Integer numPerGroup, User user) {
        Project project = projectDAO.save(Project.builder().name(name).category(category).numPerGroup(numPerGroup).user(user).build());

        return project.toDto();
    }
}
