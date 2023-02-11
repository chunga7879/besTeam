package com.example.besTeamAt.service;

import com.example.besTeamAt.data.dto.ProjectDto;
import com.example.besTeamAt.data.entity.Category;
import com.example.besTeamAt.data.entity.User;

public interface ProjectService {
        ProjectDto create(String name, Category category, Integer numPerGroup, User user);

}
