/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LoaiTin;
import model.TaiKhoan;
import model.TinTuc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import service.LoaiTinService;
import service.TinTucService;

@Controller
@RequestMapping(value = "/admin/news")
public class QuanLyTinTucController {

    @Autowired
    TinTucService tinTucService;
    @Autowired
    LoaiTinService loaiTinService;

    // index
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap mm, HttpServletRequest request) {
        String url = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + "/" + request.getContextPath() + "/admin/user/login";
        mm.put("url", url);
        setPages(mm, 0);
        return "admin/manager_tintuc";
    }

    // index
    @RequestMapping(value = "/indexp", method = RequestMethod.GET)
    public String index(ModelMap mm, @RequestParam int p) {
        setPages(mm, p);
        return "admin/manager_tintuc";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert(ModelMap mm, HttpServletRequest request) {
        String url = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + "/" + request.getContextPath() + "/admin/user/login";
        mm.put("url", url);
        mm.put("listLoaiTin", loaiTinService.getAll());
        return "admin/add_tintuc";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(ModelMap mm, HttpSession session, @RequestParam CommonsMultipartFile[] hinhAnh,
            @RequestParam String tenTinTuc, @RequestParam long idLoaiTen, @RequestParam String moTaNgan,
            @RequestParam String moTaChiTiet) throws ParseException {
        if (checkData(mm, hinhAnh, tenTinTuc, moTaNgan, moTaChiTiet)) {
            if (hinhAnh != null && hinhAnh.length > 0) {
                for (CommonsMultipartFile aFile : hinhAnh) {
                    TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("taiKhoan");
                    TinTuc tt = new TinTuc();
                    tt.setTenTinTuc(tenTinTuc);
                    tt.setLoaiTin(new LoaiTin(idLoaiTen));
                    tt.setMoTaNgan(moTaNgan);
                    tt.setMoTaChiTiet(moTaChiTiet);
                    tt.setNgayDang(new Date());
                    tt.setUser(taiKhoan);
                    tt.setHinhAnh(aFile.getBytes());
                    tinTucService.addTinTuc(tt);
                }
            }
            setPages(mm, 0);
            return "admin/manager_tintuc";
        } else {
            mm.put("listLoaiTin", loaiTinService.getAll());
            return "admin/add_tintuc";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(ModelMap mm, @RequestParam long id, HttpServletRequest request) {
        String url = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + "/" + request.getContextPath() + "/admin/user/login";
        mm.put("url", url);
        TinTuc tt = tinTucService.findTinTuc(id);
        mm.put("tintuc", tt);
        mm.put("listLoaiTin", loaiTinService.getAll());
        return "admin/update_tintuc";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(ModelMap mm, HttpSession session, @RequestParam CommonsMultipartFile[] hinhAnh,
            @RequestParam String tenTinTuc, @RequestParam long idLoaiTen, @RequestParam String moTaNgan,
            @RequestParam String moTaChiTiet, @RequestParam long idTinTuc) throws ParseException {
        if (checkData(mm, hinhAnh, tenTinTuc, moTaNgan, moTaChiTiet)) {
            TinTuc tinTuc = tinTucService.findTinTuc(idTinTuc);
            tinTuc.setHinhAnh(tinTuc.getHinhAnh());
            tinTuc.setTenTinTuc(tenTinTuc);
            tinTuc.setLoaiTin(new LoaiTin(idLoaiTen));
            tinTuc.setMoTaNgan(moTaNgan);
            tinTuc.setMoTaChiTiet(moTaChiTiet);
            if (hinhAnh != null && hinhAnh.length > 0) {
                for (CommonsMultipartFile aFile : hinhAnh) {
                    tinTuc.setHinhAnh(aFile.getBytes());
                }
                tinTucService.updateTinTuc(tinTuc);
            } else {
                tinTucService.updateDoNotImg(tinTuc);
            }
            setPages(mm, 0);
            return "admin/manager_tintuc";
        } else {
            TinTuc tt = tinTucService.findTinTuc(idTinTuc);
            mm.put("tintuc", tt);
            mm.put("listLoaiTin", loaiTinService.getAll());
            return "admin/update_tintuc";
        }

    }

    // xóa
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(ModelMap mm, @RequestParam long id) {
        TinTuc tt = tinTucService.findTinTuc(id);
        tinTucService.deleteTinTuc(tt);
        setPages(mm, 0);
        return "admin/manager_tintuc";
    }

    // hiển thị hình ảnh từ csdl
    @RequestMapping(value = "/img")
    public void showImage(ModelMap mm, HttpServletRequest request, HttpServletResponse response,
            @RequestParam long id) throws IOException {
        try {
            byte[] img = tinTucService.findTinTuc(id).getHinhAnh();
            if (img != null) {
                response.setContentType("image/jpeg");
                ServletOutputStream outputStream = response.getOutputStream();
                outputStream.write(img);
                outputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // phân trang
    private void setPages(ModelMap mm, int p) {
        int size = tinTucService.getAll().size();
        int maxResult = 5, pages = 0;
        if (size <= 5) {
            pages = 1;
            maxResult = size;
        } else {
            pages = (size / 5) + 1;
        }
        mm.put("listNews", tinTucService.getList(5 * p, maxResult));
        mm.put("size", pages);
    }

    // kiểm tra nhập dữ liệu
    private boolean checkData(ModelMap mm, @RequestParam CommonsMultipartFile[] hinhAnh,
            @RequestParam String tenTinTuc, @RequestParam String moTaNgan,
            @RequestParam String moTaChiTiet) {
        String err_hinhAnh = "";
        if (hinhAnh == null && hinhAnh.length == 0) {
            err_hinhAnh = "Dữ liệu bắt buộc!";
            mm.put("err_hinhAnh", err_hinhAnh);
        }
        String err_tenTinTuc = "";
        if (tenTinTuc.equals("")) {
            err_tenTinTuc = "Dữ liệu bắt buộc!";
            mm.put("err_tenTinTuc", err_tenTinTuc);
        }
        String err_moTaNgan = "";
        if (moTaNgan.equals("")) {
            err_moTaNgan = "Dữ liệu bắt buộc!";
            mm.put("err_moTaNgan", err_moTaNgan);
        }
        String err_moTaChiTiet = "";
        if (moTaChiTiet.equals("")) {
            err_moTaChiTiet = "Dữ liệu bắt buộc!";
            mm.put("err_moTaChiTiet", err_moTaChiTiet);
        }
        mm.put("tenTinTuc", tenTinTuc);
        mm.put("moTaNgan", moTaNgan);
        mm.put("moTaChiTiet", moTaChiTiet);
        if (err_hinhAnh.length() == 0 && err_tenTinTuc.length() == 0
                && err_moTaNgan.length() == 0 && err_moTaChiTiet.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

}
