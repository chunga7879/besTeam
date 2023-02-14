package com.example.besTeam.data.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

    // TODO: If it extended for the company, it can be employee id
    @Column(nullable = false, unique = true)
    private Long studentNumber;

    @Column(nullable = false, unique = true)
    private String email;

}
