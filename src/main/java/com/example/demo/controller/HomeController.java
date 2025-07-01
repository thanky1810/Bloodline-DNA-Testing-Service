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

    @GetMapping("/common/Gioithieu")
    public String showGioiThieuPage() {
        return "common/Gioithieu";
    }

    @GetMapping("/common/Dichvu")
    public String showDichVuPage() {
        return "common/Dichvu";
    }

    @GetMapping("/common/Huongdan")
    public String showHuongDanPage() {
        return "common/Huongdan";
    }

    @GetMapping("/common/Lienhe")
    public String showHLienHePage() {
        return "common/Lienhe";
    }

    @GetMapping("/common/Blog")
    public String showBlogPage() {
        return "common/Blog";
    }

    @GetMapping("/home.html")
    public String homePage() {
        return "common/home";
    }

    @GetMapping("/common/Blog1")
    public String blog1Page() {
        return "common/Blog1";
    }

    @GetMapping("/common/Blog2")
    public String blog2Page() {
        return "common/Blog2";
    }

    @GetMapping("/common/Blog3")
    public String blog3Page() {
        return "common/Blog3";
    }

    @GetMapping("/common/Blog4")
    public String blog4Page() {
        return "common/Blog4";
    }

    @GetMapping("/common/Datlich")
    public String DatlichPage() {
        return "common/Datlich";
    }
}
