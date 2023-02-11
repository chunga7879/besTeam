package com.example.besTeamAt.validation;

import com.example.besTeamAt.data.dto.ProjectRoleDto;

import java.util.List;

public class ProjectValidation {

    public static void checkProjectRoleNumber(Integer numPerGroup, List<ProjectRoleDto> ProjectRoleDtoList) throws Exception {
        int totalNumberInProjectRole = 0;

        for (ProjectRoleDto r : ProjectRoleDtoList) {
            totalNumberInProjectRole += r.getNumForRole();
        }

        if (numPerGroup < totalNumberInProjectRole) {
            throw new Exception("It is not possible to assign more people in roles than it needs for a project");
        }

        if (numPerGroup > totalNumberInProjectRole) {
            throw new Exception("It needs more people assigned for role to fulfill total number for a group in this project");
        }

    }
}
