package com.example.demo.model;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Trungtam")
public class CenterAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Double price;
    private String name;
    private String phone;
    private String address;
    private String email;
    private String appointmentTime;
    private String location;
    private String sampleType;
    private String relationship;
    private String doctor;
    private String result; // Kết quả xét nghiệm, có thể để trống nếu chưa có kết quả

    private LocalDateTime appointmentTime1 = LocalDateTime.now();  // 🟢 mặc định lấy thời gian hiện tại

    public LocalDateTime getAppointmentTime1() {
        return appointmentTime1;
    }

    public void setAppointmentTime1(LocalDateTime appointmentTime1) {
        this.appointmentTime1 = appointmentTime1;
    }

    private String status="Chưa xác nhận"; // Trạng thái của cuộc hẹn, ví dụ: "Chưa xác nhận", "Đã xác nhận", "Hoàn thành"

    public CenterAppointment() {
        this.status = "Chưa xác nhận"; // Lặp lại ở constructor để chắc chắn
    }

    public Long getId() {
        return id;
    }
    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAppointmentTime() {
        return appointmentTime;
    }
    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getSampleType() {
        return sampleType;
    }
    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
    }
    public String getRelationship() {
        return relationship;
    }
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
    public String getDoctor() {
        return doctor;
    }
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }

    
}