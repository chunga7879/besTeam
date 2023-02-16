package com.example.besTeam.data.entity;


import com.example.besTeam.data.dto.AbilityDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

@Table(name = "ability")
public class Ability extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Builder
    public Ability(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public AbilityDto toDto() {
        return AbilityDto.builder().id(id).name(name).build();
    }
}
