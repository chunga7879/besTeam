package com.example.besTeamAt.data.dto;
import com.example.besTeamAt.data.entity.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Builder
public class RoleDto {
    private Long id;
    private String name;
    private List<AbilityDto> abilities;
}
