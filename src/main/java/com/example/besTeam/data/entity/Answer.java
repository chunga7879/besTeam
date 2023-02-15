package com.example.besTeam.data.entity;

import com.example.besTeam.data.dto.AnswerDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "answer_id")
    private List<PreferMateAnswer> preferMateAnswers = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "answer_id")
    private List<RoleAnswer> roleAnswers = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "answer_id")
    private List<AbilityAnswer> abilityAnswers = new ArrayList<>();

    public void addPreferMateAnswers(PreferMateAnswer preferMateAnswer) {
        preferMateAnswers.add(preferMateAnswer);
    }

    public void addRoleAnswers(RoleAnswer roleAnswer) {
        roleAnswers.add(roleAnswer);
    }

    public void addAbilityAnswer(AbilityAnswer abilityAnswer) {
        abilityAnswers.add(abilityAnswer);
    }

    @Builder
    public Answer(Long id, List<PreferMateAnswer> preferMateAnswers, List<RoleAnswer> roleAnswers, List<AbilityAnswer> abilityAnswers) {
        this.id = id;
        this.abilityAnswers = abilityAnswers;
        this.preferMateAnswers = preferMateAnswers;
        this.roleAnswers = roleAnswers;
    }

    public AnswerDto toDto() {
        return AnswerDto.builder().id(id).preferMateAnswers(preferMateAnswers).roleAnswers(roleAnswers).abilityAnswers(abilityAnswers).build();
    }

}
