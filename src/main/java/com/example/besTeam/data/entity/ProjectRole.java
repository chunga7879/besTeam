package com.example.besTeam.data.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Getter
@Setter
@ToString
public class ProjectRole {
    @Id
    @GeneratedValue
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
}
