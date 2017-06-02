/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.TaiKhoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;
import tools.EncryptedPass;
import tools.SendMail;

@Controller
@RequestMapping(value = "/user")
public class TaiKhoanController {

    @Autowired
    UserService userService;
    UserDAO udo;
    EncryptedPass encrypted;

    // đăng nhập hệ thống
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "pages/login";
    }

    // đăng nhập hệ thống
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(ModelMap mm, @ModelAttribute(value = "taiKhoan") TaiKhoan taiKhoan,
            HttpSession session) {
        encrypted = new EncryptedPass();
        TaiKhoan tk = userService.login(taiKhoan.getEmail(), encrypted.EncryptedMD5(taiKhoan.getMatKhau()));
        String url = "";
        if (tk != null) {
            
            session.setAttribute("taiKhoan", tk);
            url = "pages/index";
        } else {
            mm.put("msg", "Email hoặc mật khẩu đã sai !");
            url = "pages/login";
        }
        return url;
    }

    // đăng xuất
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("taiKhoan");
        return "pages/index";
    }

    // đăng ký tài khoản
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(ModelMap mm,HttpSession session,@RequestParam String email, @RequestParam String dienThoai,
           @RequestParam String hoTen,@RequestParam String matKhau) { 
            TaiKhoan tk= new TaiKhoan();
            long idTaiKhoan = new Date().getTime();
            tk.setIdTaiKhoan(idTaiKhoan);
            tk.setHoTen(hoTen);
            tk.setEmail(email);
            tk.setDienThoai(dienThoai);
            tk.setMatKhau(matKhau);
            tk.setQuyen(0);
            tk.setMatKhau(new EncryptedPass().EncryptedMD5(matKhau));
            tk.setNgayTao(new Date());
            userService.addUser(tk);
            
            return "pages/login";
       
    }
    // quên mật khẩu 
    @RequestMapping(value = "/forgetpass", method = RequestMethod.GET)
    public String forgetpass() {
        return "pages/forgetpass";
    }

    // quên mật khẩu
    @RequestMapping(value = "/forgetpass", method = RequestMethod.POST)
    public String forgetpass(ModelMap mm, @RequestParam String email, HttpServletRequest request) {
        if (email.equals("")) {
            mm.put("msg", "Nhập địa chỉ Email của bạn!");
        } else {
            TaiKhoan tk = userService.checkEmail(email);
            if (tk != null) {
                String url = request.getScheme() + "://" + request.getServerName() + ":"
                        + request.getServerPort() + "/" + request.getContextPath() + "/user/resetpass?id=" + tk.getIdTaiKhoan() + "&t=" + new Date().getTime();
                boolean temp = SendMail.sendMail("j2eeteam2016@gmail.com", "j2eeteam", email, "viettravel", "Link: " + url);
                if (temp) {
                    mm.put("msg", "Đăng nhập Email để lấy lại mật khẩu!");
                } else {
                    mm.put("msg", "Có lỗi xảy ra, vui lòng thử lại!");
                }
            } else {
                mm.put("msg", "Địa chỉ Email không tồn tại!");
            }
        }
        return "pages/forgetpass";
    }

    // reset mật khẩu
    @RequestMapping(value = "/resetpass", method = RequestMethod.GET)
    public String resetpass(ModelMap mm, @RequestParam long id, @RequestParam long t) {
        long date = new Date().getTime();
        // nếu thời gian xác thực trước 
        if (date + 15 * 60 * 1000 < t) {
            mm.put("msg", "Quá hạn thời gian xác thực tài khoản!");
        } else {
            TaiKhoan tk = userService.findUser(id);
            if (tk != null) {
                EncryptedPass encryptedPass = new EncryptedPass();
                String pass = encryptedPass.randomString(8);
                boolean temp = SendMail.sendMail("j2eeteam2016@gmail.com", "j2eeteam", tk.getEmail(),
                        "viettravel", pass);
                if (temp) {
                    userService.resetPass(id, encryptedPass.EncryptedMD5(pass));
                    mm.put("msg", "Đăng nhập Email để lấy lại mật khẩu!");
                } else {
                    mm.put("msg", "Có lỗi xảy ra, vui lòng thử lại!");
                }
            } else {
                mm.put("msg", "Có lỗi xảy ra, vui lòng thử lại!");
            }
        }
        return "pages/resetpass";
    }

}
