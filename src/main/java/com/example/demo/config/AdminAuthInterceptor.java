package com.example.demo.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class AdminAuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        // Kiểm tra session có thuộc tính "admin" không
        if (session != null && session.getAttribute("admin") != null) {
            return true; // Đã đăng nhập
        }
        // Nếu chưa đăng nhập, chuyển hướng về trang chủ hoặc trang đăng nhập
        response.sendRedirect("/");
        return false;
    }
}