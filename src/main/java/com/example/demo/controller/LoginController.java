
package com.example.demo.controller;

import com.example.demo.model.AdminAccount;
import com.example.demo.repository.AdminAccountRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private AdminAccountRepository adminAccountRepository;

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {
        AdminAccount admin = adminAccountRepository.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            session.setAttribute("admin", admin.getUsername());
            return "redirect:/admin/Dashboard";
        } else {
            model.addAttribute("loginError", "Sai tài khoản hoặc mật khẩu!");
            return "common/home"; // hoặc trả về trang hiện tại
        }
    }
}