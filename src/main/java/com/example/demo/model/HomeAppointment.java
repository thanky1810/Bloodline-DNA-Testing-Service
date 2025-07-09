package com.example.demo.model;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tainha")

public class HomeAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String address;
    private String email;
    private String sampleTime;
    private String sampleType;
    private String relationship;
    private String addressNote;
    private String status = "Chưa xác nhận"; // Trạng thái của cuộc hẹn, ví dụ: "Chưa xác nhận", "Đã xác nhận", "Hoàn thành"
    private String result; // Kết quả xét nghiệm, có thể để trống nếu chưa có kết quả

    private LocalDateTime appointmentTime1 = LocalDateTime.now();  // 🟢 mặc định lấy thời gian hiện tại

    public LocalDateTime getAppointmentTime1() {
            return appointmentTime1;
    }


    public void setAppointmentTime1(LocalDateTime appointmentTime1) {
        this.appointmentTime1 = appointmentTime1;
    }


    
    public HomeAppointment() {
        this.status = "Chưa xác nhận"; // Lặp lại ở constructor để chắc chắn
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    public String getSampleTime() {
        return sampleTime;
    }
    public void setSampleTime(String sampleTime) {
        this.sampleTime = sampleTime;
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
    public String getAddressNote() {
        return addressNote;
    }
    public void setAddressNote(String addressNote) {
        this.addressNote = addressNote;
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