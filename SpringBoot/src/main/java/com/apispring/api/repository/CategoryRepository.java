package com.apispring.api.repository;

import com.apispring.api.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category findByid(Integer id);
    Category findBycategory(String category);
    List<Category> findByactive(Boolean active);
}
