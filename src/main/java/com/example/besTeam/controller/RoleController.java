package com.example.besTeam.controller;

import com.example.besTeam.data.dto.RoleDto;
import com.example.besTeam.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping(value = "/create")
    public RoleDto create(@RequestBody Map<String, Object> requestBody) throws Exception {
        if (!(requestBody.get("name") instanceof String)) {
            throw new Exception("It does not get correct type of role name");
        }

        if (!(requestBody.get("abilities") instanceof List)) {
            throw new Exception("It does not get correct type of abilities");
        }

        String name = (String) requestBody.get("name");
        List<String> abilities = (List<String>) requestBody.get("abilities");

        return roleService.createRole(name, abilities);
    }

    // role update abilities



    @GetMapping("/{id}")
    public RoleDto getById(@PathVariable Long id) throws Exception {
        return roleService.getRoleById(id);
    }
}
