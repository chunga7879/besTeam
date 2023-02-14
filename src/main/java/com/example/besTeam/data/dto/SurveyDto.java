package com.example.besTeam.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@Builder
public class SurveyDto {
    private Long id;
    private ProjectDto project;
    private boolean isAllowWritePreferTeamMates;
    private Integer preferPersonOptionMax;
    private boolean isPossibleSameRolePreference;
    private Integer minRangeRolePreference;
    private Integer maxRangeRolePreference;
    private boolean isPossibleSameAbilityRating;
    private Integer minRangeAbilityRating;
    private Integer maxRangeAbilityRating;
}
