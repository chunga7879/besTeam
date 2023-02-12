package com.example.besTeamAt.controller;

import com.example.besTeamAt.data.dto.AbilityDto;
import com.example.besTeamAt.service.AbilityService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/ability")
public class AbilityController {
    private AbilityService abilityService;

    public AbilityController(AbilityService abilityService) {
        this.abilityService = abilityService;
    }

    @PostMapping("/create")
    public AbilityDto create(@RequestParam @Valid String name) {
        return this.abilityService.create(name);
    }

    @GetMapping("/{id}")
    public AbilityDto getById(@PathVariable Long id) throws Exception {
        return this.abilityService.getById(id);
    }
}
