package com.example.besTeam.service.impl;

import com.example.besTeam.data.dao.*;
import com.example.besTeam.data.dto.*;
import com.example.besTeam.data.entity.*;
import com.example.besTeam.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectDAO projectDAO;
    private UserDAO userDAO;
    private CategoryDAO categoryDAO;
    private RoleDAO roleDAO;
    private ProjectRoleDAO projectRoleDAO;

    @Autowired
    public ProjectServiceImpl(ProjectDAO projectDAO, UserDAO userDAO, CategoryDAO categoryDAO, RoleDAO roleDAO, ProjectRoleDAO projectRoleDAO) {
        this.userDAO = userDAO;
        this.categoryDAO = categoryDAO;
        this.roleDAO = roleDAO;
        this.projectDAO = projectDAO;
        this.projectRoleDAO = projectRoleDAO;
    }

    @Override
    public ProjectDto create(UserDto userDto, String name, CategoryDto categoryDto, Integer numPerGroup, List<ProjectRoleDto> roles) throws Exception {
        User creator = userDAO.getById(userDto.getId());
        Category category = categoryDAO.getById(categoryDto.getId());

        Project project = Project.builder().name(name).user(creator).category(category).numPerGroup(numPerGroup).build();
        project = projectDAO.save(project);

        for (ProjectRoleDto pr : roles) {
            Role role = roleDAO.getRoleById(pr.getRole().getId());
            ProjectRole projectRole = ProjectRole.builder().project(project).role(role).numForRole(pr.getNumForRole()).build();

            projectRole = projectRoleDAO.create(projectRole);
            project.addProjectRole(projectRole);
            role.addProjectRole(projectRole);
        }

        return project.toDto();
    }

    @Override
    public ProjectDto getById(Long id) throws Exception {
        Project project = projectDAO.getById(id);
        return project.toDto();
    }

    @Override
    public ProjectDto updateRoles(Long projectId, List<ProjectRoleDto> roles) throws Exception {
        Project project = projectDAO.getById(projectId);
        System.out.println(project.toDto());

        // TODO: VALIDATION FOR TOTAL NUMBER PER ROLE DOES NOT EXCEED NUM PER GROUP

        for (ProjectRoleDto pr : roles) {
            Role role = roleDAO.getRoleById(pr.getRole().getId());
            ProjectRole projectRole = ProjectRole.builder().project(project).role(role).numForRole(pr.getNumForRole()).build();

            switch (projectRoleDAO.getByProjectAndRole(projectRole).size()) {
                case 0 :
                    projectRole = projectRoleDAO.create(projectRole);
                    project.addProjectRole(projectRole);
                    break;
                case 1:
                    projectRole = projectRoleDAO.getByProjectAndRole(projectRole).get(0);
                    projectRoleDAO.updateNumForRole(projectRole);
                    break;
                default:
                    throw new Exception("unique constraint does not work");
            }
        }

        return project.toDto();
    }
}
