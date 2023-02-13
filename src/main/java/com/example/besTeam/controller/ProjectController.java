package com.example.besTeam.controller;

import com.example.besTeam.data.dto.*;
import com.example.besTeam.service.ProjectService;
import com.example.besTeam.validation.ProjectValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/projects")

public class ProjectController {
    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @PostMapping(value = "/create")
    public ProjectDto create(@RequestBody ProjectDto projectDto) throws Exception {
        ProjectValidation.checkProjectRoleNumber(projectDto.getNumPerGroup(), projectDto.getRoles());
        return projectService.create(projectDto.getUser(), projectDto.getName(), projectDto.getCategory(), projectDto.getNumPerGroup(), projectDto.getRoles());
    }

    @GetMapping(value = "/{id}")
    public ProjectDto getById(@PathVariable Long id) throws Exception {
        return projectService.getById(id);
    }

}