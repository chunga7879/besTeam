package com.example.besTeam.data.entity;

import com.example.besTeam.data.dto.ParticipantDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "participant")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: If it extended for the company, it can be employee id
    @Column(nullable = false, unique = true)
    private Long studentNumber;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @Builder
    public Participant(Long id, Long studentNumber, String email, Answer answer) {
        this.id = id;
        this.studentNumber = studentNumber;
        this.email = email;
        this.answer = answer;
    }

    public ParticipantDto toDto() {
        return ParticipantDto.builder().id(id).email(email)
                .studentNumber(studentNumber).answer(answer.toDto()).build();
    }

}
