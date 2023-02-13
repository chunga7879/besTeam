package com.example.besTeam.data.dao.impl;

import com.example.besTeam.data.dao.RoleDAO;
import com.example.besTeam.data.entity.Role;
import com.example.besTeam.data.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleDAOImpl implements RoleDAO {
    private RoleRepository roleRepository;

    @Autowired
    public RoleDAOImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleById(Long id) throws Exception {
        Role role = roleRepository.findById(id).orElseThrow(() -> new Exception("role matched with id does not exists"));
        return role;
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }


}
