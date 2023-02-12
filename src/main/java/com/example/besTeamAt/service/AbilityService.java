package com.example.besTeamAt.service;

import com.example.besTeamAt.data.dto.AbilityDto;

public interface AbilityService {
    AbilityDto create(String name);

    AbilityDto getById(Long id) throws Exception;
}
