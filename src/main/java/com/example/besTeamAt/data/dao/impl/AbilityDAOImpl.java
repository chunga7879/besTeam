package com.example.besTeamAt.data.dao.impl;

import com.example.besTeamAt.data.dao.AbilityDAO;
import com.example.besTeamAt.data.entity.Ability;
import com.example.besTeamAt.data.repository.AbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbilityDAOImpl implements AbilityDAO {

    private AbilityRepository abilityRepository;

    @Autowired
    public AbilityDAOImpl(AbilityRepository abilityRepository) {
        this.abilityRepository = abilityRepository;
    }

    @Override
    public Ability save(Ability ability) {
        return abilityRepository.save(ability);
    }

    @Override
    public Ability getById(Long id) throws Exception {
        return abilityRepository.findById(id).orElseThrow(() -> new Exception("ability by id not exist"));
    }

    @Override
    public Ability getByName(String name) {
        return abilityRepository.findByName(name);
    }
}
