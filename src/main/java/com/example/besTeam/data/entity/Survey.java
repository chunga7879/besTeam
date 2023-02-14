package com.example.besTeam.data.entity;

import com.example.besTeam.data.dto.SurveyDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "survey")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    // # to work together

    @Column(nullable = false)
    private boolean isAllowWritePreferTeamMates;

    @Min(value = 0)
    @Column
    private Integer preferPersonOptionMax;

    // range to check preference for role
    @Column(nullable = false)
    private boolean isPossibleSameRolePreference;

    @Min(value = 0)
    @Column(nullable = false)
    private Integer minRangeRolePreference;

    @Max(value = 10)
    @Column(nullable = false)
    private Integer maxRangeRolePreference;

    // range to check preference for ability
    @Column(nullable = false)
    private boolean isPossibleSameAbilityRating;

    @Min(value = 0)
    @Column(nullable = false)
    private Integer minRangeAbilityRating;

    @Max(value = 10)
    @Column(nullable = false)
    private Integer maxRangeAbilityRating;

    @OneToMany(mappedBy = "survey",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Participant> participants = new ArrayList<>();

    public void addParticipant(Participant participant) {
        participants.add(participant);
    }


    public SurveyDto toDto() {
        return SurveyDto.builder()
                .id(id)
                .project(project.toDto())
                .isAllowWritePreferTeamMates(isAllowWritePreferTeamMates)
                .preferPersonOptionMax(preferPersonOptionMax)
                .isPossibleSameRolePreference(isPossibleSameRolePreference)
                .minRangeRolePreference(minRangeRolePreference)
                .maxRangeRolePreference(maxRangeRolePreference)
                .isPossibleSameAbilityRating(isPossibleSameAbilityRating)
                .minRangeAbilityRating(minRangeAbilityRating)
                .maxRangeAbilityRating(maxRangeAbilityRating)
                .build();
    }
}
