/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import service.ChiTietLichTrinhService;
import service.LichTrinhService;
import service.UserService;
import tools.EncryptedPass;

@Controller
@RequestMapping(value = "admin/user")
public class QuanLyTaiKhoanController {

    @Autowired
    UserService userService;
    @Autowired
    ChiTietLichTrinhService chiTietLichTrinhService;
    @Autowired
    LichTrinhService lichTrinhService;

    EncryptedPass encrypted;

    // index
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap mm, HttpServletRequest request) {
        String url = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + "/" + request.getContextPath() + "/admin/user/login";
        mm.put("url", url);
        setPages(mm, 0);
        return "admin/manager_taiKhoan";
    }
    // index phan trang

    @RequestMapping(value = "/indexp", method = RequestMethod.GET)
    public String index(ModelMap mm, @RequestParam int p) {
        setPages(mm, p);

        return "admin/manager_taiKhoan";
    }

    // đăng nhập hệ thống
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index() {
        return "admin/login";
    }

    // đăng xuất hệ thống
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("taiKhoan");
        return "admin/login";
    }
//    doi mat khau

    @RequestMapping(value = "/forgetpass", method = RequestMethod.GET)
    public String forgetPass() {
        return "admin/forgetpass";
    }

    //    doi mat khau
    @RequestMapping(value = "/forgetpass", method = RequestMethod.POST)
    public String forgetPass(ModelMap mm, HttpSession session, @RequestParam String matKhauCu, @RequestParam String matKhauMoi, @RequestParam String nmatKhauMoi) {
        TaiKhoan tk = (TaiKhoan) session.getAttribute("taiKhoan");
            String err_matKhauCu;
            String err_matKhauMoi;
            String err_matKhauNMoi;
        if (!matKhauCu.equals("") && !matKhauMoi.equals("") && !nmatKhauMoi.equalsIgnoreCase("")) {
//            mat khau user = mat khau moi khong
            if (tk.getMatKhau().equals(new EncryptedPass().EncryptedMD5(matKhauCu)) && matKhauMoi.equalsIgnoreCase(nmatKhauMoi)) {
                userService.resetPass(tk.getIdTaiKhoan(), new EncryptedPass().EncryptedMD5(matKhauMoi));
                tk.setMatKhau(new EncryptedPass().EncryptedMD5(matKhauMoi));
                return "admin/index";
            } else {
//                mat khau cu ko trung vs user
                if (!tk.getMatKhau().equals(new EncryptedPass().EncryptedMD5(matKhauCu))) {
                    err_matKhauCu="Nhập mật khẩu không đúng!";
                    mm.put("err_matKhauCu", err_matKhauCu);
                }
                if (!nmatKhauMoi.equals(matKhauMoi)) {
                    err_matKhauNMoi="Nhập lại mật khẩu mới không đúng!";
                    mm.put("err_matKhauNMoi",err_matKhauNMoi);
                }
                return "admin/forgetpass";
            }
        } else {
            if (matKhauCu.equals("")) {
                err_matKhauCu=" Chưa nhập mật khẩu cũ!";
                mm.put("err_matKhauCu", err_matKhauCu);
            }
            if (matKhauMoi.equals("")) {
                err_matKhauMoi= " Chưa nhập mật khẩu mới!";
                mm.put("err_matKhauMoi",err_matKhauMoi);
            }
            if (nmatKhauMoi.equalsIgnoreCase("")) {
                err_matKhauNMoi=" Chưa nhập lại mật khẩu mới!";
                mm.put("err_matKhauNMoi",err_matKhauNMoi);
            }
            return "admin/forgetpass";
        }
    }

    // đăng nhập hệ thống
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String index(ModelMap mm, @ModelAttribute(value = "taiKhoan") TaiKhoan taiKhoan,
            HttpSession session) {
        encrypted = new EncryptedPass();
        TaiKhoan tk = userService.login(taiKhoan.getEmail(),
                encrypted.EncryptedMD5(taiKhoan.getMatKhau()));
        String url = "";
        if (tk == null) {
            mm.put("msg", "Email hoặc mật khẩu không đúng!");
            url = "admin/login";
        } else if (tk.getQuyen() == 0) {
            mm.put("msg", "Tài khoản không đủ quyền truy cập vào hệ thống!");
            url = "admin/login";
        } else {
            session.setAttribute("taiKhoan", tk);
            mm.put("allUser", userService.allUser());
            mm.put("tonglichtrinh", chiTietLichTrinhService.tongChiTietLichTrinhCanDuyet());
            mm.put("allLichTrinh", lichTrinhService.getAll_LichTrinh());
            url = "admin/index";
        }

        return url;
    }
    // phân trang

    private void setPages(ModelMap mm, int p) {
        int size = userService.getListUser().size();
        int maxResult = 5, pages = 0;
        if (size <= 5) {
            pages = 1;
            maxResult = size;
        } else {
            pages = (size / 5) + 1;
        }
        mm.put("listTaiKhoan", userService.getList(5 * p, maxResult));
        mm.put("size", pages);
    }
}
