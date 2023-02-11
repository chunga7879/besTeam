package com.example.besTeamAt.data.entity;


import com.example.besTeamAt.data.dto.AbilityDto;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "ability")
public class Ability {
    @Id
    @GeneratedValue
    private Long Id;

    @Column(unique = true, nullable = false)
    private String name;

    public AbilityDto toDto() {
        return AbilityDto.builder().name(name).build();
    }
}
