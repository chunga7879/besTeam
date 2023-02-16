package com.example.besTeam.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "ability_answer")
public class AbilityAnswer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="ability_id")
    private Ability ability;

    // how they are good at (from min - max)
    private Integer rating;

    @Builder
    public AbilityAnswer(Long id, Ability ability, Integer rating) {
        this.id = id;
        this.ability = ability;
        this.rating = rating;
    }
}
