package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import com.example.demo.model.CenterAppointment;

@Repository
public interface CenterAppointmentRepository extends JpaRepository<CenterAppointment, Long> {
    @Query("SELECT SUM(c.price) FROM CenterAppointment c")
    Double getTotalRevenue();
    List<CenterAppointment> findByNameAndPhoneAndEmailAndStatus(String name, String phone, String email, String status);

    // Lấy doanh thu theo tháng (giả sử có trường c.date kiểu java.time.LocalDate)
    // @Query("SELECT SUM(c.price) FROM CenterAppointment c WHERE MONTH(c.date) = ?1 AND YEAR(c.date) = ?2")
    // Double getRevenueByMonth(int month, int year);
}