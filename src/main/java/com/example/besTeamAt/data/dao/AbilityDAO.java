package com.example.besTeamAt.data.dao;

import com.example.besTeamAt.data.entity.Ability;

public interface AbilityDAO {
    Ability saveAbility(Ability ability);

    Ability getAbilityById(Long id) throws Exception;
}
