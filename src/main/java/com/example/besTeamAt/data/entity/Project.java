package com.example.besTeamAt.data.entity;

import com.example.besTeamAt.data.dto.ProjectDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "project")
public class Project extends BaseEntity{
    @Id
    @GeneratedValue
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
    private List<ProjectRole> roles = new ArrayList<>();

    @Builder
    public Project(Long id, String name, Category category, Integer numPerGroup, User user) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.numPerGroup = numPerGroup;
        this.user = user;
    }

    public ProjectDto toDto(){
        return ProjectDto.builder()
                .name(name)
                .numPerGroup(numPerGroup)
                .category(category.toDto())
                .user(user.toDto())
                .build();
    }
}
