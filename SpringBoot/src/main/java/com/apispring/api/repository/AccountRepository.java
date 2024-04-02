package com.apispring.api.repository;

import com.apispring.api.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByUsername(String username);
    Account findByid(Integer id);
    Boolean existsByUsername(String username);
}
