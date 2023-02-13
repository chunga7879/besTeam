package com.example.besTeam.data.repository;

import com.example.besTeam.data.entity.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityRepository extends JpaRepository<Ability, Long> {
    Ability findByName(String name);
}
