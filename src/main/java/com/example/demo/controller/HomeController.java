package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

import com.example.demo.model.CenterAppointment;
import com.example.demo.model.HomeAppointment;
import com.example.demo.model.SelfCollectAppointment;
import com.example.demo.repository.CenterAppointmentRepository;
import com.example.demo.repository.HomeAppointmentRepository;
import com.example.demo.repository.SelfCollectAppointmentRepository;

@Controller
public class HomeController {
    @Autowired
    private CenterAppointmentRepository centerRepository;
    @Autowired
    private HomeAppointmentRepository homeRepository;
    @Autowired
    private SelfCollectAppointmentRepository selfCollectRepository;

    // Trang chủ chung cho tất cả
    @GetMapping("/")
    public String showHomePage() {
        return "common/home";
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

    @GetMapping("/admin/Dashboard")
    public String dashboardPage(Model model) {
        // Tổng số khách hàng (dựa trên số lượng bản ghi trong các bảng)
        long totalCustomers = centerRepository.count() + homeRepository.count() + selfCollectRepository.count();
        model.addAttribute("totalCustomers", totalCustomers);

        // Tổng số xét nghiệm (giả sử mỗi bản ghi là một xét nghiệm)
        long totalTests = totalCustomers;
        model.addAttribute("totalTests", totalTests);

        // Tổng doanh thu thực tế từ CenterAppointment (nếu có cột price)
        Double totalRevenue = centerRepository.getTotalRevenue();
        if (totalRevenue == null) totalRevenue = 0.0;
        model.addAttribute("totalRevenue", String.format("%.1fM+", totalRevenue / 1_000_000));

        // Tổng số hồ sơ (tương tự tổng khách hàng)
        model.addAttribute("totalRecords", totalCustomers);

        // Dữ liệu cho biểu đồ doanh thu (theo tháng)
        double[] revenueData = new double[12]; // Doanh thu 12 tháng
        // TODO: Populate revenueData with actual monthly revenue if needed
        model.addAttribute("revenueData", revenueData);

        // Dữ liệu cho biểu đồ đánh giá
        int[] ratingData = new int[]{2, 5, 10, 20, 63}; // Thay bằng dữ liệu thực từ cơ sở dữ liệu
        model.addAttribute("ratingData", ratingData);

        return "admin/Dashboard";
    }

    @GetMapping("/admin/History")
    public String historyPage(Model model) {
        List<CenterAppointment> centerAppointments = centerRepository.findAll();
        List<HomeAppointment> homeAppointments = homeRepository.findAll();
        List<SelfCollectAppointment> selfCollectAppointments = selfCollectRepository.findAll();

        model.addAttribute("centerAppointments", centerAppointments);
        model.addAttribute("homeAppointments", homeAppointments);
        model.addAttribute("selfCollectAppointments", selfCollectAppointments);

        return "admin/History";
    }

    @GetMapping("/admin/Management")
    public String managementPage(Model model) {
        List<CenterAppointment> centerAppointments = centerRepository.findAll();
        List<HomeAppointment> homeAppointments = homeRepository.findAll();
        List<SelfCollectAppointment> selfCollectAppointments = selfCollectRepository.findAll();

        model.addAttribute("centerAppointments", centerAppointments);
        model.addAttribute("homeAppointments", homeAppointments);
        model.addAttribute("selfCollectAppointments", selfCollectAppointments);

        return "admin/Management";
    }
}