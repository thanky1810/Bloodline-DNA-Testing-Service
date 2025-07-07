package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.CenterAppointment;
import com.example.demo.repository.CenterAppointmentRepository;

@Controller
@RequestMapping("/center")
public class CenterAppointmentController {

    @Autowired
    private CenterAppointmentRepository repository;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("appointment", new CenterAppointment());
        return "common/Lienhe";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute CenterAppointment appointment, Model model) {
        try {
            repository.save(appointment);
            model.addAttribute("message", "Đặt lịch tại trung tâm thành công!");
        } catch (Exception e) {
            model.addAttribute("message", "Đặt lịch thất bại. Vui lòng thử lại sau!");
        }
        model.addAttribute("appointment", new CenterAppointment());
        return "common/Lienhe";
    }
}
