package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.HomeAppointment;
import com.example.demo.repository.HomeAppointmentRepository;
@Controller
@RequestMapping("/home")
public class HomeAppointmentController {

    @Autowired
    private HomeAppointmentRepository repository;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("appointment", new HomeAppointment());
        return "common/Lienhe";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute HomeAppointment appointment, Model model) {
        repository.save(appointment);
        model.addAttribute("message", "Đặt lịch tại nhà thành công!");
        model.addAttribute("appointment", new HomeAppointment());
        return "common/Lienhe";
    }
}
