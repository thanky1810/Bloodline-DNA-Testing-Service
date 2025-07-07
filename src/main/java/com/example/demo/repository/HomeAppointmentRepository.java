package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.HomeAppointment;

@Repository
public interface HomeAppointmentRepository extends JpaRepository<HomeAppointment, Long> {
}
