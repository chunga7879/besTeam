package com.example.besTeamAt.service.impl;

import com.example.besTeamAt.data.dao.AbilityDAO;
import com.example.besTeamAt.data.dao.RoleDAO;
import com.example.besTeamAt.data.dto.RoleDto;
import com.example.besTeamAt.data.entity.Ability;
import com.example.besTeamAt.data.entity.Role;
import com.example.besTeamAt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleDAO roleDAO;
    private AbilityDAO abilityDAO;


    @Autowired
    public RoleServiceImpl(RoleDAO roleDAO, AbilityDAO abilityDAO) {
        this.roleDAO = roleDAO;
        this.abilityDAO = abilityDAO;
    }


    @Override
    public RoleDto createRole(String name, List<String> abilities) {
        Role role = Role.builder().name(name).build();
        if (abilities.size() > 0) {
            for (String abilityName : abilities) {
                Ability ability  = abilityDAO.getByName(abilityName);
                if (ability == null) {
                    ability = abilityDAO.save(Ability.builder().name(abilityName).build());
                }
                role.addAbility(ability);
            }
        }
        role = roleDAO.saveRole(role);

        return role.toDto();
    }

    @Override
    public RoleDto getRoleById(Long id) throws Exception {
        Role role = roleDAO.getRoleById(id);
        return role.toDto();
    }
}
