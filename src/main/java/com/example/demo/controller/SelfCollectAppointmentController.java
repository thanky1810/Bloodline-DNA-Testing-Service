package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.SelfCollectAppointment;
import com.example.demo.repository.SelfCollectAppointmentRepository;

@Controller
@RequestMapping("/self")
public class SelfCollectAppointmentController {

    @Autowired
    private SelfCollectAppointmentRepository repository;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("appointment", new SelfCollectAppointment());
        return "common/Lienhe";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute SelfCollectAppointment appointment, Model model) {
        repository.save(appointment);
        model.addAttribute("message", "Đặt lịch tự thu thành công!");
        model.addAttribute("appointment", new SelfCollectAppointment());
        return "common/Lienhe";
    }
}