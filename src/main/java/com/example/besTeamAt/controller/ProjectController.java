package com.example.besTeamAt.controller;

import com.example.besTeamAt.data.dto.ProjectDto;
import com.example.besTeamAt.data.dto.ProjectRoleDto;
import com.example.besTeamAt.service.ProjectService;
import com.example.besTeamAt.validation.ProjectValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Tuple;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {
    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


//    @PostMapping(value = "/create")
//    public ProjectDto create(@Valid ProjectDto projectDto, List<Long> Role) throws Exception {
//        ProjectValidation.checkProjectRoleNumber(projectDto.getNumPerGroup(), projectRoleDtoList);
//
//        ProjectDto project = projectService.create(projectDto.getName(), projectDto.getCategory(), projectDto.getNumPerGroup(), projectDto.getUser());
//
//        return p
//    }

}
