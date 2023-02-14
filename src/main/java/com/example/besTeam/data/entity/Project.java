package com.example.besTeam.data.entity;

import com.example.besTeam.data.dto.ProjectDto;
import com.example.besTeam.data.dto.ProjectRoleDto;
import com.example.besTeam.data.dto.RoleDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "project")
public class Project extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Min(value = 1)
    @Column(nullable = false)
    private Integer numPerGroup;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProjectRole> projectRoles = new ArrayList<>();

    @OneToOne(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Survey survey;

    public void addProjectRole(ProjectRole projectRole) {
        projectRoles.add(projectRole);
    }

    @Builder
    public Project(Long id, String name, Category category, Integer numPerGroup, User user) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.numPerGroup = numPerGroup;
        this.user = user;
    }

    public ProjectDto toDto(){
        List<ProjectRoleDto> roles = new ArrayList<>();

        for (ProjectRole projectRole : projectRoles) {
            roles.add(projectRole.toDto());
        }

        return ProjectDto.builder()
                .id(id)
                .name(name)
                .numPerGroup(numPerGroup)
                .category(category.toDto())
                .user(user.toDto())
                .roles(roles)
                .build();
    }
}
