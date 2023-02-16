package com.example.besTeam.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "prefer_mate_answer")
public class PreferMateAnswer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentNumber;

    @Builder
    public PreferMateAnswer(Long id, Long studentNumber) {
        this.id = id;
        this.studentNumber = studentNumber;
    }
}
