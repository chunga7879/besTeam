package com.example.besTeamAt.data.entity;

import com.example.besTeamAt.data.dto.AbilityDto;
import com.example.besTeamAt.data.dto.RoleDto;
import com.example.besTeamAt.data.dto.UserDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString

@Table(name = "role")
public class Role extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProjectRole> roles = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "role_ability"
            , joinColumns = @JoinColumn(name = "role_id")
            , inverseJoinColumns = @JoinColumn(name = "ability_id"))
    private List<Ability> abilities = new ArrayList<>();

    public RoleDto toDto(){
        List<AbilityDto> abilityDtos = new ArrayList<>();
        for (Ability ability : abilities) {
            abilityDtos.add(ability.toDto());
        }
        return RoleDto.builder()
                .name(name)
                .category(category.toDto())
                .abilities(abilityDtos)
                .build();
    }
}