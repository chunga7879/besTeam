package com.example.besTeam.data.dto;

import com.example.besTeam.data.entity.Answer;
import com.example.besTeam.data.entity.Survey;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ParticipantDto {
    private Long id;
    // TODO: If it extended for the company, it can be employee id
    private Long studentNumber;
    private String email;
    private AnswerDto answer;
}
