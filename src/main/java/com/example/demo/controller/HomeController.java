package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Trang chủ chung cho tất cả
    @GetMapping("/")
    public String showHomePage() {
        return "common/home"; // tương ứng với templates/home.html
    }

    // Trang chủ của user
    @GetMapping("/user/home")
    public String showUserHome() {
        return "user/home"; // tương ứng templates/user/home.html
    }

    // Trang chủ của admin
    @GetMapping("/admin/home")
    public String showAdminHome() {
        return "admin/home"; // tương ứng templates/admin/home.html
    }
}
