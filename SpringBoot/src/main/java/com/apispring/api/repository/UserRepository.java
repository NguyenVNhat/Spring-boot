package com.apispring.api.repository;

import com.apispring.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByid(Integer id);

    List<User> findByname(String name);
    List<User> findByaddress(String address);
    User findByphone(String phone);
}
