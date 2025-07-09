package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.AdminAccount;
import com.example.demo.repository.AdminAccountRepository;

@SpringBootApplication
public class DemoApplication implements org.springframework.boot.CommandLineRunner {

@Autowired
    private AdminAccountRepository adminAccountRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // Tạo cứng tài khoản admin nếu chưa tồn tại
        if (adminAccountRepository.findByUsername("admin") == null) {
            AdminAccount admin = new AdminAccount();
            admin.setUsername("admin");
            admin.setPassword("123456"); // Nên mã hóa mật khẩu khi dùng thực tế!
            adminAccountRepository.save(admin);
        }
    }
}
	    