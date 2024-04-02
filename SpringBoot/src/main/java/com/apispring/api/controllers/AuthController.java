package com.apispring.api.controllers;

import com.apispring.api.dto.AuthResponseDTO;
import com.apispring.api.dto.LoginDto;
import com.apispring.api.models.Account;
import com.apispring.api.repository.AccountRepository;
import com.apispring.api.security.JWTGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private AccountRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, AccountRepository userRepository,
                          PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(),
                loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Account account) {
        if (userRepository.existsByUsername(account.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        Account user = new Account();
        user.setId(account.getId());
        user.setUsername(account.getUsername());
        user.setPassword(passwordEncoder.encode((account.getPassword())));
        user.setRole(account.getRole());
        user.setActive(account.getActive());
        userRepository.save(user);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }

}
