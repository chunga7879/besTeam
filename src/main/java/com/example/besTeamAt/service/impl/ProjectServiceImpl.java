package com.example.besTeamAt.service.impl;

import com.example.besTeamAt.data.dao.ProjectDAO;
import com.example.besTeamAt.data.dto.ProjectDto;
import com.example.besTeamAt.data.entity.Category;
import com.example.besTeamAt.data.entity.Project;
import com.example.besTeamAt.data.entity.User;
import com.example.besTeamAt.service.ProjectService;
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
