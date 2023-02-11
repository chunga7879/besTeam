package com.example.besTeamAt.data.dto;

import com.example.besTeamAt.data.entity.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategoryDto {
    private Long id;
    private String name;
    private boolean isDestroyed;
}
