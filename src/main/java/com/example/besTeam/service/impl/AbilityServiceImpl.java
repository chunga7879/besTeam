package com.example.besTeam.service.impl;

import com.example.besTeam.data.dao.AbilityDAO;
import com.example.besTeam.data.dto.AbilityDto;
import com.example.besTeam.data.entity.Ability;
import com.example.besTeam.service.AbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbilityServiceImpl implements AbilityService {
    private AbilityDAO abilityDAO;

    @Autowired
    public AbilityServiceImpl(AbilityDAO abilityDAO) {
        this.abilityDAO = abilityDAO;
    }


    @Override
    public AbilityDto create(String name) {
        Ability ability = abilityDAO.save(Ability.builder().name(name).build());
        return ability.toDto();
    }

    @Override
    public AbilityDto getById(Long id) throws Exception {
        Ability ability = abilityDAO.getById(id);
        return ability.toDto();
    }
}
