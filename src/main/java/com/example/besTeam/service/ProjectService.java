package com.example.besTeam.service;

import com.example.besTeam.data.dto.*;
import com.example.besTeam.data.entity.Category;
import com.example.besTeam.data.entity.Project;
import com.example.besTeam.data.entity.User;

import java.util.List;
import java.util.Map;

public interface ProjectService {
        ProjectDto create(UserDto userDto, String name, CategoryDto category, Integer numPerGroup, List<ProjectRoleDto> roles) throws Exception;

        ProjectDto getById(Long id) throws Exception;

        ProjectDto updateRoles(Long projectId, List<ProjectRoleDto> roles) throws Exception;
}
