package com.example.besTeam.data.dto;

import com.example.besTeam.data.entity.AbilityAnswer;
import com.example.besTeam.data.entity.PreferMateAnswer;
import com.example.besTeam.data.entity.RoleAnswer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class AnswerDto {
    private Long id;
    private List<PreferMateAnswer> preferMateAnswers = new ArrayList<>();
    private List<RoleAnswer> roleAnswers = new ArrayList<>();
    private List<AbilityAnswer> abilityAnswers = new ArrayList<>();
}
