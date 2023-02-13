package com.example.besTeam.data.dto;
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
    private List<String> abilities;
}
