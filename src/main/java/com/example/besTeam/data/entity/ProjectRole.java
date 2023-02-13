package com.example.besTeam.data.entity;

import com.example.besTeam.data.dto.ProjectRoleDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "project_role", uniqueConstraints = {@UniqueConstraint(name = "ProjectAndRole", columnNames = { "project_id", "role_id" })})
public class ProjectRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ColumnDefault("1")
    @Min(value = 1)
    @Column(nullable = false)
    private Integer numForRole;

    @Builder
    public ProjectRole(Project project, Role role, Integer numForRole) {
        this.project = project;
        this.role = role;
        this.numForRole = numForRole;
    }

    public ProjectRoleDto toDto() {
        return ProjectRoleDto.builder().role(role.toDto()).numForRole(numForRole).id(id).build();
    }
}
