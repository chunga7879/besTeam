package com.example.besTeamAt.data.entity;
import com.example.besTeamAt.data.dto.CategoryDto;
import com.example.besTeamAt.data.dto.UserDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

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

    @Builder
    public Category(Long id, String name, boolean isDestroyed) {
        this.id = id;
        this.name = name;
        this.isDestroyed = isDestroyed;
    }

    public CategoryDto toDto(){
        return CategoryDto.builder()
                .id(id)
                .name(name)
                .isDestroyed(isDestroyed)
                .build();
    }
}
