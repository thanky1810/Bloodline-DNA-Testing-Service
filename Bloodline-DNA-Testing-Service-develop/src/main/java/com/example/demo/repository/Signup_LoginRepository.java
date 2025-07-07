package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Signup_Login;

public interface Signup_LoginRepository extends JpaRepository<Signup_Login, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Signup_Login findByUsernameAndPassword(String username, String password);
}
