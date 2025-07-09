package com.example.demo.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.CenterAppointment;
import com.example.demo.model.HomeAppointment;
import com.example.demo.model.SelfCollectAppointment;
import com.example.demo.repository.CenterAppointmentRepository;
import com.example.demo.repository.HomeAppointmentRepository;
import com.example.demo.repository.SelfCollectAppointmentRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CommonController {

    @Autowired
    private CenterAppointmentRepository centerRepo;

    @Autowired
    private HomeAppointmentRepository homeRepo;

    @Autowired
    private SelfCollectAppointmentRepository selfRepo;

    @GetMapping("/common/ConfirmPage")
    public String confirmPage(@RequestParam("appointmentId") Long id, Model model) {
        Object appointment = centerRepo.findById(id).orElse(null);
        if (appointment == null) appointment = homeRepo.findById(id).orElse(null);
        if (appointment == null) appointment = selfRepo.findById(id).orElse(null);

        if (appointment == null) {
            return "redirect:/admin/Management";
        }

        model.addAttribute("appointment", appointment);
        return "common/ConfirmPage";
    }

    @PostMapping("/common/ConfirmResult")
    public String confirmResult(@RequestParam("appointmentId") Long id,
                                @RequestParam("result") String result,
                                RedirectAttributes redirectAttributes) {

        boolean updated = false;

        Optional<CenterAppointment> center = centerRepo.findById(id);
        if (center.isPresent()) {
            CenterAppointment c = center.get();
            c.setStatus("Đã xác nhận");
            c.setResult(result);
            centerRepo.save(c);
            updated = true;
        }

        Optional<HomeAppointment> home = homeRepo.findById(id);
        if (home.isPresent()) {
            HomeAppointment h = home.get();
            h.setStatus("Đã xác nhận");
            h.setResult(result);
            homeRepo.save(h);
            updated = true;
        }

        Optional<SelfCollectAppointment> self = selfRepo.findById(id);
        if (self.isPresent()) {
            SelfCollectAppointment s = self.get();
            s.setStatus("Đã xác nhận");
            s.setResult(result);
            selfRepo.save(s);
            updated = true;
        }

        if (updated) {
            redirectAttributes.addFlashAttribute("message", "Đã xác nhận kết quả thành công.");
        } else {
            redirectAttributes.addFlashAttribute("message", "Không tìm thấy hồ sơ để cập nhật.");
        }

        return "redirect:/admin/Management";
    }
    
    @GetMapping("/common/Tracuu")
    public void traCuuKetQua(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "phone", required = false) String phone,
                            @RequestParam(value = "email", required = false) String email,
                            HttpServletResponse response) throws IOException, DocumentException {
        if (name == null || phone == null || email == null) {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("<h3>Vui lòng nhập đầy đủ thông tin.</h3>");
            return;
        }


    List<CenterAppointment> centerList = centerRepo.findByNameAndPhoneAndEmailAndStatus(name, phone, email, "Đã xác nhận");
    List<HomeAppointment> homeList = homeRepo.findByNameAndPhoneAndEmailAndStatus(name, phone, email, "Đã xác nhận");
    List<SelfCollectAppointment> selfList = selfRepo.findByNameAndPhoneAndEmailAndStatus(name, phone, email, "Đã xác nhận");

    // Tìm bản ghi mới nhất
    Object latest = null;
    LocalDateTime latestTime = null;

    for (CenterAppointment c : centerList) {
        if (latestTime == null || c.getAppointmentTime1().isAfter(latestTime)) {
            latest = c;
            latestTime = c.getAppointmentTime1();
        }
    }

    for (HomeAppointment h : homeList) {
        if (latestTime == null || h.getAppointmentTime1().isAfter(latestTime)) {
            latest = h;
            latestTime = h.getAppointmentTime1();
        }
    }

    for (SelfCollectAppointment s : selfList) {
        if (latestTime == null || s.getAppointmentTime1().isAfter(latestTime)) {
            latest = s;
            latestTime = s.getAppointmentTime1();
        }
    }

    if (latest == null) {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<h3>Không tìm thấy hồ sơ đã xác nhận.</h3>");
        return;
    }

    // Tạo PDF
    response.setContentType("application/pdf");
    response.setHeader("Content-Disposition", "attachment; filename=result.pdf");

    Document document = new Document();
    PdfWriter.getInstance(document, response.getOutputStream());
    document.open();

    if (latest instanceof CenterAppointment c) {
        writePDF(document, c.getName(), c.getSampleType(), c.getRelationship(), c.getResult());
    } else if (latest instanceof HomeAppointment h) {
        writePDF(document, h.getName(), h.getSampleType(), h.getRelationship(), h.getResult());
    } else if (latest instanceof SelfCollectAppointment s) {
        writePDF(document, s.getName(), s.getSampleType(), s.getRelationship(), s.getResult());
    }

    document.close();
}
    private void writePDF(Document document, String name, String sampleType, String relationship, String result) throws DocumentException {
        document.add(new Paragraph("Kết quả xét nghiệm", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
        document.add(new Paragraph("Tên: " + name));
        document.add(new Paragraph("Loại mẫu: " + sampleType));
        document.add(new Paragraph("Mối quan hệ: " + relationship));
        document.add(new Paragraph("Kết quả: " + result));
        document.add(new Paragraph("Thời gian: " + LocalDateTime.now()));
    }
}