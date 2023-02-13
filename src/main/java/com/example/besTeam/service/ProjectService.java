package com.example.besTeam.service;

import com.example.besTeam.data.dto.ProjectDto;
import com.example.besTeam.data.entity.Category;
import com.example.besTeam.data.entity.User;

public interface ProjectService {
        ProjectDto create(String name, Category category, Integer numPerGroup, User user);

}
