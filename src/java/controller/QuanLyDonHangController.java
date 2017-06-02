/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import model.ChiTietLichTrinh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.ChiTietLichTrinhService;


@Controller
@RequestMapping(value = "admin/quanlydonhang")
public class QuanLyDonHangController {

    @Autowired
    ChiTietLichTrinhService chiTietLichTrinhService;
    // index chi tiet lich trinh

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexDetail(ModelMap mm, HttpServletRequest request, @RequestParam long id) {
        String url = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + "/" + request.getContextPath() + "/admin/user/login";
        mm.put("url", url);
        setPages(mm, 0, id);
        return "admin/manager_chitietlichtrinh";
    }
    // index phan trang

    @RequestMapping(value = "/indexp", method = RequestMethod.GET)
    public String index(ModelMap mm, @RequestParam int p, @RequestParam long id) {
        setPages(mm, p, id);
        return "admin/manager_chitietlichtrinh";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(ModelMap mm, HttpServletRequest request, @RequestParam long id, @RequestParam int kind) {
        String url = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + "/" + request.getContextPath() + "/admin/user/login";
        mm.put("url", url);
        chiTietLichTrinhService.update(id, kind);
        setPages(mm, 0, id);
        return "admin/manager_chitietlichtrinh";
    }

    // phân trang
    private void setPages(ModelMap mm, int p, long id) {
        int size = chiTietLichTrinhService.getListDonHang(id).size();
        int maxResult = 5, pages = 0;
        if (size <= 5) {
            pages = 1;
            maxResult = size;
        } else {
            pages = (size / 5) + 1;
        }
        mm.put("listChiTiet", chiTietLichTrinhService.getList(5 * p, maxResult, id));
        mm.put("size", pages);
    }
}
