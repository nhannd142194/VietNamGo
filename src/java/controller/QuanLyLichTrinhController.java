/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import model.DiaDiem;
import model.LichTrinh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.DiaDiemService;
import service.LichTrinhService;

@Controller
@RequestMapping(value = "admin/lichtrinh")
public class QuanLyLichTrinhController {

    @Autowired
    LichTrinhService lichTrinhService;
    @Autowired
    DiaDiemService diaDiemService;
    String tenLichTrinh;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    // index
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap mm, HttpServletRequest request) {
        String url = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + "/" + request.getContextPath() + "/admin/user/login";
        mm.put("url", url);
        setPages(mm, 0);
        return "admin/manager_lichtrinh";
    }
    // index phan trang

    @RequestMapping(value = "/indexp", method = RequestMethod.GET)
    public String index(ModelMap mm, @RequestParam int p) {
        setPages(mm, p);
        return "admin/manager_lichtrinh";
    }
//    insert

    // index chi tiet lich trinh
    @RequestMapping(value = "/indexdetail", method = RequestMethod.GET)
    public String indexDetail(ModelMap mm, HttpServletRequest request) {
        String url = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + "/" + request.getContextPath() + "/admin/user/login";
        mm.put("url", url);
        setPages(mm, 0);
        return "admin/manager_chitietlichtrinh";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert(ModelMap mm, HttpServletRequest request) {
        String url = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + "/" + request.getContextPath() + "/admin/user/login";
        mm.put("url", url);
        mm.put("listDiem", diaDiemService.getAll());
        return "admin/add_lichtrinh";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(ModelMap mm, @RequestParam String tenLichTrinh, @RequestParam double giaVe,
            @RequestParam int giamGia, @RequestParam long idDiemDi, @RequestParam long idDiemDen,
            @RequestParam String ngayKhoiHanh, @RequestParam String ngayKetThuc,
            @RequestParam String moTaNgan, @RequestParam String moTaChiTiet) throws ParseException {
        if (checkData(mm, tenLichTrinh, giaVe, giamGia, idDiemDi, idDiemDen, ngayKhoiHanh,
                ngayKetThuc, moTaNgan, moTaChiTiet)) {
            LichTrinh lt = new LichTrinh();
            lt.setTenLichTrinh(tenLichTrinh);
            lt.setNgayKhoiHanh(format.parse(ngayKhoiHanh));
            lt.setNgayKetThuc(format.parse(ngayKetThuc));
            lt.setMoTaNgan(moTaNgan);
            lt.setMoTaChiTiet(moTaChiTiet);
            lt.setGiamGia(giamGia);
            lt.setGiaVe(giaVe);
            lt.setDiemDi(new DiaDiem(idDiemDi));
            lt.setDiemDen(new DiaDiem(idDiemDen));
            lichTrinhService.addLichTrinh(lt);
            setPages(mm, 0);
            return "admin/manager_lichtrinh";
        } else {
            mm.put("listDiem", diaDiemService.getAll());
            return "admin/add_lichtrinh";
        }
    }
//    update

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(ModelMap mm, @RequestParam long id, HttpServletRequest request) {
        String url = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + "/" + request.getContextPath() + "/admin/user/login";
        mm.put("url", url);
        LichTrinh lt = lichTrinhService.findLichTrinh(id);
        mm.put("lichtrinh", lt);
        mm.put("listDiem", diaDiemService.getAll());
        return "admin/update_lichtrinh";
    }
    
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(ModelMap mm, @RequestParam String tenLichTrinh, @RequestParam double giaVe,
            @RequestParam int giamGia, @RequestParam long idDiemDi, @RequestParam long idDiemDen,
            @RequestParam String ngayKhoiHanh, @RequestParam String ngayKetThuc,
            @RequestParam String moTaNgan, @RequestParam String moTaChiTiet, @RequestParam long idLichTrinh) throws ParseException {
        if (checkData(mm, tenLichTrinh, giaVe, giamGia, idDiemDi, idDiemDen, ngayKhoiHanh,
                ngayKetThuc, moTaNgan, moTaChiTiet)) {
            LichTrinh lt = new LichTrinh();
            lt.setIdLichTrinh(idLichTrinh);
            lt.setTenLichTrinh(tenLichTrinh);
            lt.setNgayKhoiHanh(format.parse(ngayKhoiHanh));
            lt.setNgayKetThuc(format.parse(ngayKetThuc));
            lt.setMoTaNgan(moTaNgan);
            lt.setMoTaChiTiet(moTaChiTiet);
            lt.setGiamGia(giamGia);
            lt.setGiaVe(giaVe);
            lt.setDiemDi(new DiaDiem(idDiemDi));
            lt.setDiemDen(new DiaDiem(idDiemDen));
            lichTrinhService.updateLichTrinh(lt);
            setPages(mm, 0);
            return "admin/manager_lichtrinh";
        } else {
            mm.put("listDiem", diaDiemService.getAll());
            return "admin/add_lichtrinh";
        }
    }

    // phân trang
    private void setPages(ModelMap mm, int p) {
        int size = lichTrinhService.getAll().size();
        int maxResult = 5, pages = 0;
        if (size <= 5) {
            pages = 1;
            maxResult = size;
        } else {
            pages = (size / 5) + 1;
        }
        mm.put("listLichTrinh", lichTrinhService.getList(5 * p, maxResult));
        mm.put("size", pages);
    }

    private boolean checkData(ModelMap mm, @RequestParam String tenLichTrinh, @RequestParam double giaVe,
            @RequestParam int giamGia, @RequestParam long idDiemDi, @RequestParam long idDiemDen,
            @RequestParam String ngayKhoiHanh, @RequestParam String ngayKetThuc,
            @RequestParam String moTaNgan, @RequestParam String moTaChiTiet) throws ParseException {
        //        check ten lich trinh
        String err_tenlichtrinh = "";
        if (tenLichTrinh.equals("")) {
            err_tenlichtrinh = "Chưa nhập tên lịch trình";
            mm.put("err_tenlichtrinh", err_tenlichtrinh);
        }
        mm.put("tenlichtrinh", tenLichTrinh);
//       check gia ve 
        String err_GiaVe = "";
        if (giaVe == 0) {
            err_GiaVe = "Chưa nhập giá vé";
            mm.put("err_GiaVe", err_GiaVe);
        }
        mm.put("giaVe", giaVe);

//        check ngay khoi hanh va ngay ket thuc
        String err_NgayKhoiHanh = "";
        String err_NgayKetThuc = "";
        if (ngayKhoiHanh.equals("") && ngayKetThuc.equals("")) {
            err_NgayKhoiHanh = "Chưa chọn ngày khởi hành";
            err_NgayKetThuc = "Chưa chọn ngày kết thúc";

        } else {
            if (ngayKhoiHanh.equals("")) {
                err_NgayKhoiHanh = "Chưa chọn ngày khởi hành";
            }
            if (ngayKetThuc.equals("")) {
                err_NgayKetThuc = "Chưa chọn ngày kết thúc";
            }
            if (!ngayKhoiHanh.equals("") && !ngayKetThuc.equals("")) {
                Date date_now = format.parse(format.format(new Date()));
                Date date_end = format.parse(ngayKetThuc);
                Date date_star = format.parse(ngayKhoiHanh);
//            Ngày kết thúc nhở hơn ngày khởi hành
                if (date_end.compareTo(date_star) < 0) {
                    err_NgayKetThuc = "Ngày kết thúc nhở hơn ngày khởi hành";
                }
//            Ngày bắt đầu nhỏ hơn ngày hiện tại
                if (date_star.compareTo(date_now) < 0) {
                    err_NgayKhoiHanh = "Ngày khởi hành nhở hơn ngày hiện tại";
                }
            }
        }
        mm.put("err_NgayKhoiHanh", err_NgayKhoiHanh);
        mm.put("err_NgayKetThuc", err_NgayKetThuc);
        mm.put("ngayKhoiHanh", ngayKhoiHanh);
        mm.put("ngayKetThuc", ngayKetThuc);
//        check mota ngan
        String err_MoTaNgan = "";
        if (moTaNgan.equals("")) {
            err_MoTaNgan = "Chưa nhập mô tả";
            mm.put("err_MoTaNgan", err_MoTaNgan);
        }
        mm.put("moTaNgan", moTaNgan);

//check mo ta chi tiet
        String err_MoTaChiTiet = "";
        if (moTaChiTiet.equals("")) {
            err_MoTaChiTiet = "Chưa nhập mô tả chi tiết!";
            mm.put("err_MoTaChiTiet", err_MoTaChiTiet);
        }
        mm.put("moTaChiTiet", moTaChiTiet);

        if (err_tenlichtrinh.length() == 0 && err_GiaVe.length() == 0
                && err_NgayKhoiHanh.length() == 0 && err_NgayKetThuc.length() == 0
                && err_MoTaNgan.length() == 0 && err_MoTaChiTiet.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
