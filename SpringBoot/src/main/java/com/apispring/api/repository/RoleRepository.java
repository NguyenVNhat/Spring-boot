package com.apispring.api.repository;

import com.apispring.api.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles,Integer> {
    Roles findByid(Integer id);
}
