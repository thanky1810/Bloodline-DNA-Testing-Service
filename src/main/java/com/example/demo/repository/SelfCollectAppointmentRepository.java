package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SelfCollectAppointment;

@Repository
public interface SelfCollectAppointmentRepository extends JpaRepository<SelfCollectAppointment, Long> {
}
