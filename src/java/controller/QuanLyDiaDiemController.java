/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import model.DiaDiem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.DiaDiemService;


@Controller
@RequestMapping(value = "admin/diadiem")
public class QuanLyDiaDiemController {

    @Autowired
    DiaDiemService diaDiemService;

    // index
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap mm, HttpServletRequest request) {
        String url = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + "/" + request.getContextPath() + "/admin/user/login";
        mm.put("url", url);
        setPages(mm, 0);
        return "admin/manager_diadiem";
    }

    // index
    @RequestMapping(value = "/indexd", method = RequestMethod.GET)
    public String index(ModelMap mm, @RequestParam int d, HttpServletRequest request) {
        setPages(mm, d);
        return "admin/manager_diadiem";
    }

    // insert
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert(ModelMap mm, HttpServletRequest request) {
        String url = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + "/" + request.getContextPath() + "/admin/user/login";
        mm.put("url", url);
        return "admin/add_diadiem";
    }

    //insert
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(ModelMap mm, @ModelAttribute(value = "diaDiem") DiaDiem diaDiem) {
        if (checkData(mm, diaDiem)) {
            diaDiemService.addDiaDiem(diaDiem);
            setPages(mm, 0);
            return "admin/manager_diadiem";
        }
        return "admin/add_diadiem";
    }

    //    update khi chuyen trang
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(ModelMap mm, @RequestParam long id) {
        DiaDiem dd = diaDiemService.findDiaDiem(id);
        mm.put("dd", dd);
        return "admin/update_diadiem";
    }

    //update diadiem
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(ModelMap mm, @ModelAttribute(value = "diaDiem") DiaDiem diaDiem) {
        if (checkData(mm, diaDiem)) {
            diaDiemService.updateDiaDiem(diaDiem);
            setPages(mm, 0);
            return "admin/manager_diadiem";
        }
        return "admin/add_diadiem";
    }
    
    // xóa
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(ModelMap mm, @RequestParam long id) {
        DiaDiem dd = new DiaDiem();
        dd.setIdDiaDiem(id);
        diaDiemService.deleteDiaDiem(dd);
        setPages(mm, 0);
        return "admin/manager_diadiem";
    }

    // phân trang
    private void setPages(ModelMap mm, int p) {
        int size = diaDiemService.getAll().size();
        int maxResult = 5, pages = 0;
        if (size <= 5) {
            pages = 1;
            maxResult = size;
        } else {
            pages = (size / 5) + 1;
        }
        mm.put("listDiaDiem", diaDiemService.getList(5 * p, maxResult));
        mm.put("size", pages);
    }

    // kiểm tra
    private boolean checkData(ModelMap mm, DiaDiem diaDiem) {
        if (diaDiem.getTenDiaDiem().equals("")) {
            mm.put("s", "Chưa Nhập tên địa điểm!");
            return false;
        } else if (diaDiemService.checkName(diaDiem.getIdDiaDiem(), diaDiem.getTenDiaDiem())) {
            mm.put("s", "Tên địa điểm đã tồn tại!");
            return false;
        }
        return true;
    }

}
