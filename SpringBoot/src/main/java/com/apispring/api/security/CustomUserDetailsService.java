package com.apispring.api.security;

import com.apispring.api.models.Account;
import com.apispring.api.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService  implements UserDetailsService {

    private AccountRepository userRepository;

    @Autowired
    public CustomUserDetailsService(AccountRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = userRepository.findByusername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        String role = user.getRole();
        System.out.println("Detail :"+role);
        return new User(user.getUsername(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority( role)));
    }


}
