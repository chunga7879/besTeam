package com.example.besTeamAt.data.entity;
import com.example.besTeamAt.data.dto.CategoryDto;
import com.example.besTeamAt.data.dto.RoleDto;
import com.example.besTeamAt.data.dto.UserDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
// connected with role and project
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @ColumnDefault("false")
    @Column(nullable = false)
    private boolean isDestroyed;

    @ManyToMany
    @JoinTable(name = "category_role"
            , joinColumns = @JoinColumn(name = "category_id")
            , inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();

    @Builder
    public Category(Long id, String name, boolean isDestroyed, List<Role> roles) {
        this.id = id;
        this.name = name;
        this.isDestroyed = isDestroyed;
        this.roles = roles;
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public CategoryDto toDto(){
        List<RoleDto> roleDtos = new ArrayList<>();
        for (Role r: roles) {
            roleDtos.add(r.toDto());
        }
        return CategoryDto.builder()
                .id(id)
                .name(name)
                .isDestroyed(isDestroyed)
                .roles(roleDtos)
                .build();
    }
}
