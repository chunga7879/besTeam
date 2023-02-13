package com.example.besTeam.service;

import com.example.besTeam.data.dto.AbilityDto;

public interface AbilityService {
    AbilityDto create(String name);

    AbilityDto getById(Long id) throws Exception;
}
