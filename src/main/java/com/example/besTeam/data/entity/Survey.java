package com.example.besTeam.data.entity;

import com.example.besTeam.data.dto.ParticipantDto;
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
@Table(name = "survey", uniqueConstraints = {@UniqueConstraint(name = "ProjectAndSurveyName", columnNames = { "name", "project_id" })})
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name="project_id")
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="survey_id")
    private List<Participant> participants = new ArrayList<>();

    public void addParticipant(Participant participant) {
        participants.add(participant);
    }


    public SurveyDto toDto() {
        List<ParticipantDto> participantDTOs = new ArrayList<>();

        for (Participant participant : participants) {
            participantDTOs.add(participant.toDto());
        }

        return SurveyDto.builder()
                .id(id)
                .name(name)
                .project(project.toDto())
                .isAllowWritePreferTeamMates(isAllowWritePreferTeamMates)
                .preferPersonOptionMax(preferPersonOptionMax)
                .isPossibleSameRolePreference(isPossibleSameRolePreference)
                .minRangeRolePreference(minRangeRolePreference)
                .maxRangeRolePreference(maxRangeRolePreference)
                .isPossibleSameAbilityRating(isPossibleSameAbilityRating)
                .minRangeAbilityRating(minRangeAbilityRating)
                .maxRangeAbilityRating(maxRangeAbilityRating)
                .participants(participantDTOs)
                .build();
    }
}
