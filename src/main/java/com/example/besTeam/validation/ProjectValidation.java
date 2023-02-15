package com.example.besTeam.validation;

import com.example.besTeam.data.dto.ProjectRoleDto;

import java.util.List;
import java.util.Map;

public class ProjectValidation {

    public static void checkProjectRoleNumber(Integer numPerGroup, List<ProjectRoleDto> roles) throws Exception {
        int totalNumberInProjectRole = 0;

        for (ProjectRoleDto pr : roles) {
            totalNumberInProjectRole += pr.getNumForRole();
        }

        if (numPerGroup < totalNumberInProjectRole) {
            throw new Exception("It is not possible to assign more people in roles than it needs for a project");
        }

        if (numPerGroup > totalNumberInProjectRole) {
            throw new Exception("It needs more people assigned for role to fulfill total number for a group in this project");
        }
    }

    // TODO: LOTS OF VALIDATION NEEDED TO PREVENT UNEXPECTED ACTION
}
