package com.example.besTeam.data.dao;

import com.example.besTeam.data.entity.Ability;

public interface AbilityDAO {
    Ability save(Ability ability);

    Ability getById(Long id) throws Exception;

    Ability getByName(String name);
}
