package com.apispring.api.repository;

import com.apispring.api.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category findByid(Integer id);
}
