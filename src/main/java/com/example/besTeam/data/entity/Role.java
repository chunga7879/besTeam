package com.example.besTeam.data.entity;

import com.example.besTeam.data.dto.AbilityDto;
import com.example.besTeam.data.dto.RoleDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "role")
public class Role extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProjectRole> projectRoles = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "role_ability"
            , joinColumns = @JoinColumn(name = "role_id")
            , inverseJoinColumns = @JoinColumn(name = "ability_id"))
    private List<Ability> abilities = new ArrayList<>();

    public void addAbility(Ability ability) {
        abilities.add(ability);
    }

    public void addProjectRole(ProjectRole projectRole) {
        projectRoles.add(projectRole);
    }

    @Builder
    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public RoleDto toDto(){
        List<String> abilityNames = new ArrayList<>();
        for (Ability ability : abilities) {
            abilityNames.add(ability.getName());
        }
        return RoleDto.builder()
                .id(id)
                .name(name)
                .abilities(abilityNames)
                .build();
    }
}