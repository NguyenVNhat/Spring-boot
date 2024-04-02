package com.apispring.api.repository;

import com.apispring.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByid(Integer id);
}
