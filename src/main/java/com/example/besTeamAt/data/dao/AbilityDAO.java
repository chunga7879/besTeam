package com.example.besTeamAt.data.dao;

import com.example.besTeamAt.data.entity.Ability;

public interface AbilityDAO {
    Ability save(Ability ability);

    Ability getById(Long id) throws Exception;

    Ability getByName(String name);
}
