package com.example.besTeam.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
public class ProjectDto {
    private Long id;
    private String name;
    private CategoryDto category;
    private Integer numPerGroup;
    private UserDto user; // TODO: USING AUTH LATER
    private List<ProjectRoleDto> roles;
}
