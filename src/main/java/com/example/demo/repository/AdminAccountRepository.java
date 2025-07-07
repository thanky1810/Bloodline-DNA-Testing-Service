package com.example.demo.repository;

import com.example.demo.model.AdminAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminAccountRepository extends JpaRepository<AdminAccount, Long> {
    AdminAccount findByUsername(String username);
}