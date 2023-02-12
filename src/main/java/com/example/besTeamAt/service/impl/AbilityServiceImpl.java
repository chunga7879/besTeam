package com.example.besTeamAt.service.impl;

import com.example.besTeamAt.data.dao.AbilityDAO;
import com.example.besTeamAt.data.dto.AbilityDto;
import com.example.besTeamAt.data.entity.Ability;
import com.example.besTeamAt.service.AbilityService;
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
        Ability ability = abilityDAO.saveAbility(Ability.builder().name(name).build());
        return ability.toDto();
    }

    @Override
    public AbilityDto getById(Long id) throws Exception {
        Ability ability = abilityDAO.getAbilityById(id);
        return ability.toDto();
    }
}
