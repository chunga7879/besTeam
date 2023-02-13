package com.example.besTeam.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class CreateProjectDto {
    private String name;
    private Long categoryId;
    private Integer numPerGroup;
    private Long userId; // TODO: USING AUTH LATER
    private Map<Long, Integer> roles; // roleId - num for this role
}
