package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller; // Thêm import này
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.registrationFormData;
import com.example.demo.repository.IregistrationFormRepository; // Đảm bảo bạn có interface này

@Controller
public class registrationFormController { 

    @Autowired
    private IregistrationFormRepository repository; // Đúng tên repository

    @PostMapping("/submitForm")
    public String submitForm(
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam String address,
            @RequestParam String email,
            @RequestParam("sample-type") String sampleType,

            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime appointmentTime,

            @RequestParam(required = false) String location,
            @RequestParam(required = false) String testType,

            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime homeTime,

            @RequestParam(required = false) String noteHome,
            @RequestParam(required = false) String noteSelf
    ) 
    {
        registrationFormData form = new registrationFormData(); // Đúng tên class model
        form.setName(name);
        form.setPhone(phone);
        form.setAddress(address);
        form.setEmail(email);
        form.setSampleType(sampleType);

        form.setAppointmentTime(appointmentTime);
        form.setLocation(location);
        form.setTestType(testType);

        form.setHomeTime(homeTime);
        form.setNoteHome(noteHome);
        form.setNoteSelf(noteSelf);

        repository.save(form);

       return "redirect:/Home.html?success=true"; // Đảm bảo đường dẫn này đúng với cấu hình của bạn
    }

    @GetMapping("/success")
    @ResponseBody
    public String successPage() {
        return "<h2>Gửi thông tin thành công! Chúng tôi sẽ liên hệ bạn sớm.</h2>";
    }
}