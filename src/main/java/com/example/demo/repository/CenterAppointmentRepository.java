package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CenterAppointment;

@Repository
public interface CenterAppointmentRepository extends JpaRepository<CenterAppointment, Long> {
}
