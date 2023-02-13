package com.example.besTeam.data.repository;

import com.example.besTeam.data.entity.ProjectRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRoleRepository extends JpaRepository<ProjectRole, Long> {

    @Query(value = "SELECT * FROM project_role pr WHERE project_id = ?1 AND role_id = ?2", nativeQuery = true)
    List<ProjectRole> findByProjectAndRole(Long projectId, Long roleId);

    @Query(value = "UPDATE project_role SET num_for_role = ?2 WHERE id = ?1", nativeQuery = true)
    ProjectRole updateNumForRole(Long id, Integer numForRole);
}
