package com.example.demo.repository;

import com.example.demo.model.registrationFormData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IregistrationFormRepository extends JpaRepository<registrationFormData, Long> {}