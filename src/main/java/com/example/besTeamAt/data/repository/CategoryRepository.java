package com.example.besTeamAt.data.repository;

import com.example.besTeamAt.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "UPDATE category SET is_destroyed = ?2 WHERE id = ?1", nativeQuery = true)
    Category IsDestroyed(Long id, boolean isDestroyed);
}
