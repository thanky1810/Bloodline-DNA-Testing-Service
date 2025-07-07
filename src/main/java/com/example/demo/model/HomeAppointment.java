package com.example.demo.model;
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

    private String fullName;
    private String phone;
    private String address;
    private String email;
    private String sampleTime;
    private String sampleType;
    private String relationship;
    private String addressNote;

    // Getters and Setters
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
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
}
