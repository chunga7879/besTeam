package com.example.besTeam.data.entity;

import com.example.besTeam.data.dto.AnswerDto;
import com.example.besTeam.data.dto.ParticipantDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "participant")
public class Participant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: If it extended for the company, it can be employee id
    @Column(nullable = false, unique = true)
    private Long studentNumber;

    @Column(nullable = false, unique = true)
    private String email;

    @Builder
    public Participant(Long id, Long studentNumber, String email) {
        this.id = id;
        this.studentNumber = studentNumber;
        this.email = email;
    }

    public ParticipantDto toDto() {
        // most recent
        return ParticipantDto.builder().id(id).email(email)
                .studentNumber(studentNumber).build();
    }
}
