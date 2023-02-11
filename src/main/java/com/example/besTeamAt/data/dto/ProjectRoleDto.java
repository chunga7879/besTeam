package com.example.besTeamAt.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class ProjectRoleDto {
    private ProjectDto projectDto;
    private RoleDto roleDto;
    private Integer numForRole;
}
