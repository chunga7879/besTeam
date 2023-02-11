package com.example.besTeamAt.data.dto;

import com.example.besTeamAt.data.entity.Category;
import com.example.besTeamAt.data.entity.Project;
import com.example.besTeamAt.data.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ProjectDto {
    private String name;
    private CategoryDto category;
    private Integer numPerGroup;
    private UserDto user; // 나중에 auth 으로 변경
    List<ProjectRoleDto> projectRoleDtoList;
}
