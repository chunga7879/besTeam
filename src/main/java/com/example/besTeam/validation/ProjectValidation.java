package com.example.besTeam.validation;

import java.util.Map;

public class ProjectValidation {

    public static void checkProjectRoleNumber(Integer numPerGroup, Map<Long, Integer> roles) throws Exception {
        int totalNumberInProjectRole = 0;

        for (Integer i : roles.values()) {
            totalNumberInProjectRole += i;
        }

        if (numPerGroup < totalNumberInProjectRole) {
            throw new Exception("It is not possible to assign more people in roles than it needs for a project");
        }

        if (numPerGroup > totalNumberInProjectRole) {
            throw new Exception("It needs more people assigned for role to fulfill total number for a group in this project");
        }

    }
}
