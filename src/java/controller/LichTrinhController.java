/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import javax.servlet.http.HttpSession;
import model.ChiTietLichTrinh;
import model.LichTrinh;
import model.TaiKhoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.ChiTietLichTrinhService;
import service.UserService;
import tools.EncryptedPass;
import tools.SendMail;


@Controller
@RequestMapping(value = "/lichtrinh")
public class LichTrinhController {
    
    @Autowired
    ChiTietLichTrinhService chiTietLichTrinhService;
    @Autowired
    UserService userService;

    // index
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap mm) {
        return "pages/travels";
    }
    
    @RequestMapping(value = "/register1", method = RequestMethod.GET)
    public String register1(ModelMap mm) {
        return "pages/index";
    }
    
    @RequestMapping(value = "/register2", method = RequestMethod.GET)
    public String register2(ModelMap mm) {
        return "pages/index";
    }
    
    // đăng ký đ'ã có tài khoản
    @RequestMapping(value = "/register1", method = RequestMethod.POST)
    public String register1(ModelMap mm, HttpSession session, @RequestParam int soVe, 
            @RequestParam long idLichTrinh) {
        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("taiKhoan");
        ChiTietLichTrinh ctlt = new ChiTietLichTrinh();
        ctlt.setUser(taiKhoan);
        ctlt.setLichTrinh(new LichTrinh(idLichTrinh));
        ctlt.setTinhTrang(0);
        chiTietLichTrinhService.insertChiTietLichTrinh(ctlt);
        return "pages/success";
    }
    
    // đăng ký chưa có tài khoản thì tạo mới tài khoản luôn
    @RequestMapping(value = "/register2", method = RequestMethod.POST)
    public String register2(ModelMap mm, HttpSession session, @RequestParam int soVe, 
            @RequestParam long idLichTrinh, @RequestParam String email, @RequestParam String dienThoai,
           @RequestParam String hoTen) {
        long idTaiKhoan = new Date().getTime();
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setIdTaiKhoan(idTaiKhoan);
        taiKhoan.setEmail(email);
        taiKhoan.setDienThoai(dienThoai);
        taiKhoan.setHoTen(hoTen);
        taiKhoan.setQuyen(0);
        taiKhoan.setMatKhau(new EncryptedPass().EncryptedMD5("12345"));
        taiKhoan.setNgayTao(new Date());
        // tạo tài khoản
        userService.addUser(taiKhoan);
        SendMail.sendMail("j2eeteam2016@gmail.com", "j2eeteam", email, "Vietravel", "Pass: 12345");

        // thêm chi tiết lịch trình
        ChiTietLichTrinh ctlt = new ChiTietLichTrinh();
        ctlt.setUser(taiKhoan);
        ctlt.setLichTrinh(new LichTrinh(idLichTrinh));
        ctlt.setTinhTrang(0);
        chiTietLichTrinhService.insertChiTietLichTrinh(ctlt);
        return "pages/success";
    }
    
}
