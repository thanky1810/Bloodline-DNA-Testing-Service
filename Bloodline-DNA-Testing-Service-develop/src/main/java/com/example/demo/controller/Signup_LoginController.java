package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Signup_Login;
import com.example.demo.repository.Signup_LoginRepository;

@RestController
@RequestMapping("/api")
public class Signup_LoginController {

    @Autowired
    private Signup_LoginRepository signup_loginRepository;

    // Xử lý Đăng ký
    @PostMapping("/register")
    public String register(@RequestBody Signup_Login signup_login) {
        if (signup_loginRepository.existsByUsername(signup_login.getUsername()) || signup_loginRepository.existsByEmail(signup_login.getEmail())) {
            return "Username hoac Email da ton tai!";
        }

        signup_loginRepository.save(signup_login);
        return "Dang ky thanh cong!";
    }

    // Xử lý Đăng nhập
    @PostMapping("/login")
    public String login(@RequestBody Signup_Login loginUser) {
        Signup_Login user = signup_loginRepository.findByUsernameAndPassword(
                loginUser.getUsername(), loginUser.getPassword());

        if (user != null) {
            return "Dang nhap thanh cong!"; // "Login successful!"
        } else {
            return "Sai username hoac password!";
        }
    }
}
