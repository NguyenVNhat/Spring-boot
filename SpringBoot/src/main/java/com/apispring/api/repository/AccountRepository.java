package com.apispring.api.repository;

import com.apispring.api.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByusername(String username);
    Account findByid(Integer id);
    List<Account> findByrole(String role);
    List<Account> findByactive(Boolean active);
    Boolean existsByUsername(String username);
}
