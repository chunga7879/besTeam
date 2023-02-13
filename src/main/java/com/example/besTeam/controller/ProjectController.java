package com.example.besTeam.controller;

import com.example.besTeam.data.dto.*;
import com.example.besTeam.service.ProjectService;
import com.example.besTeam.validation.ProjectValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/projects")

public class ProjectController {
    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @PostMapping(value = "/create")
    public ProjectDto create(@RequestBody CreateProjectDto createProjectDto) throws Exception {
        ProjectValidation.checkProjectRoleNumber(createProjectDto.getNumPerGroup(), createProjectDto.getRoles());

        ProjectDto project = projectService.create(createProjectDto.getName(), createProjectDto.getCategoryId(), createProjectDto.getNumPerGroup(), createProjectDto.getUserId());

        return p
    }

}