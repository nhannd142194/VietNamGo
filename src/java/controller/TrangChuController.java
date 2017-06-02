/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.DiaDiem;
import model.LichTrinh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DiaDiemService;
import service.LichTrinhService;
import service.TinTucService;

@Controller
@RequestMapping(value = "/home")
public class TrangChuController {

    @Autowired
    DiaDiemService diaDiemService;
    @Autowired
    LichTrinhService lichTrinhService;
    @Autowired
    TinTucService tinTucService;

    // index
    @RequestMapping(value = "/index")
    public String index() {
        return "pages/index";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "pages/login";
    }

    // quên mật khẩu
    @RequestMapping(value = "/forgetpass", method = RequestMethod.GET)
    public String forgetpass() {
        return "pages/forgetpass";
    }

    @RequestMapping(value = "/register")
    public String register() {
        return "pages/register";
    }

    // travels
    @RequestMapping(value = "/travels")
    public String travels() {
        return "pages/travels";
    }

    // about
    @RequestMapping(value = "/about")
    public String about() {
        return "pages/about";
    }

    // contact
    @RequestMapping(value = "/contact")
    public String contact() {
        return "pages/contact";
    }

    // tourist_spots
    @RequestMapping(value = "/checkout")
    public String checkout(ModelMap mm, @RequestParam String id) {
        mm.put("idLichTrinh", id);
        return "pages/checkout";
    }

    // tìm kiếm dựa vào tên địa điểm
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public @ResponseBody
    List<DiaDiem> searchDiaDiem(@RequestParam String tagName) {
        return diaDiemService.search(tagName);
    }

    // tìm kiếm lịch trình
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchLichTrinh(ModelMap mm, @RequestParam String diemDi, @RequestParam String diemDen,
            @RequestParam String ngayKhoiHanh, @RequestParam String giaVe) {
        ArrayList<LichTrinh> list = lichTrinhService.search(diaDiemService.searchID(diemDi),
                diaDiemService.searchID(diemDen), ngayKhoiHanh, giaVe);
        mm.put("listTravels", list);
        return "pages/travels";
    }

    // get tin tức theo thể loại
    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String getListByKind(ModelMap mm, @RequestParam long kind, @RequestParam int p) {
        setPagesByKind(mm, kind, p);
        return "pages/news";
    }

    // phân trang
    private void setPagesByKind(ModelMap mm, long kind, int p) {
        int size = tinTucService.getListByKind(kind).size();
        int maxResult = 5, pages = 0;
        if (size <= 5) {
            pages = 1;
            maxResult = size;
        } else {
            pages = (size / 5) + 1;
        }
        mm.put("listNews", tinTucService.getListByKind(kind, 5 * p, maxResult));
        mm.put("size", pages);
        mm.put("kind", kind);
    }

    // chi tiết tin tức
    @RequestMapping(value = "/detailnews", method = RequestMethod.GET)
    public String detailNews(ModelMap mm, @RequestParam long id) {
        mm.put("tinTuc", tinTucService.findTinTuc(id));
        mm.put("listNews", tinTucService.getListByRandom(5));
        return "pages/detailnews";
    }

}
