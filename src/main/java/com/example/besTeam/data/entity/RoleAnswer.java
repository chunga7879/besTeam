package com.example.besTeam.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "role_answer")
public class RoleAnswer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;

    // preference (from min - max)
    private Integer preference;

    @Builder
    public RoleAnswer(Long id, Role role, Integer preference) {
        this.id = id;
        this.role = role;
        this.preference = preference;
    }
}
