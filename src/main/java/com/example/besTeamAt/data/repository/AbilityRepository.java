package com.example.besTeamAt.data.repository;

import com.example.besTeamAt.data.entity.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityRepository extends JpaRepository<Ability, Long> {
    Ability findByName(String name);
}
