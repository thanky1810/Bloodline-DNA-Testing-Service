package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.SelfCollectAppointment;
import java.util.List;

@Repository
public interface SelfCollectAppointmentRepository extends JpaRepository<SelfCollectAppointment, Long> {
    List<SelfCollectAppointment> findByNameAndPhoneAndEmailAndStatus(String name, String phone, String email, String status);
}
