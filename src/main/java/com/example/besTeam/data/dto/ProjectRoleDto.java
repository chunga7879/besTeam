package com.example.besTeam.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProjectRoleDto {
    private Long id;
    private RoleDto role;
    private Integer numForRole;
}
