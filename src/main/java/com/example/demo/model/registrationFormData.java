package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
public class registrationFormData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String address;
    private String email;

    private String sampleType; // center, home, self

    // Dữ liệu cho từng loại
    private LocalDateTime appointmentTime;
    private String location;
    private String testType;

    private LocalDateTime homeTime;
    private String noteHome;
    private String noteSelf;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSampleType() { return sampleType; }
    public void setSampleType(String sampleType) { this.sampleType = sampleType; }

    public LocalDateTime getAppointmentTime() { return appointmentTime; }
    public void setAppointmentTime(LocalDateTime appointmentTime) { this.appointmentTime = appointmentTime; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getTestType() { return testType; }
    public void setTestType(String testType) { this.testType = testType; }

    public LocalDateTime getHomeTime() { return homeTime; }
    public void setHomeTime(LocalDateTime homeTime) { this.homeTime = homeTime; }

    public String getNoteHome() { return noteHome; }
    public void setNoteHome(String noteHome) { this.noteHome = noteHome; }

    public String getNoteSelf() { return noteSelf; }
    public void setNoteSelf(String noteSelf) { this.noteSelf = noteSelf; }
}