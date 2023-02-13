package com.example.besTeam.data.repository;

import com.example.besTeam.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "UPDATE category SET is_destroyed = ?2 WHERE id = ?1", nativeQuery = true)
    Category IsDestroyed(Long id, boolean isDestroyed);

    List<Category> findAllByIsDestroyedEquals(boolean isDestroyed);
}
