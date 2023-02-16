package com.example.besTeam.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SurveyDto {
    private Long id;
    private String name;
    private ProjectDto project;
    private boolean isAllowWritePreferTeamMates;
    private Integer preferPersonOptionMax;
    private boolean isPossibleSameRolePreference;
    private Integer minRangeRolePreference;
    private Integer maxRangeRolePreference;
    private boolean isPossibleSameAbilityRating;
    private Integer minRangeAbilityRating;
    private Integer maxRangeAbilityRating;
    private List<ParticipantDto> participants;
}
