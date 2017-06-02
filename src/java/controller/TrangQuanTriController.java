/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ChiTietLichTrinhService;
import service.LichTrinhService;
import service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class TrangQuanTriController {
    
    @Autowired
    UserService userService;
    @Autowired
    ChiTietLichTrinhService chiTietLichTrinhService;
    @Autowired
    LichTrinhService lichTrinhService;  

    // trang chủ
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap mm, HttpServletRequest request) {
        String url = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + "/" + request.getContextPath() + "/admin/user/login";
        mm.put("url", url);
        mm.put("allUser", userService.allUser());
        mm.put("tonglichtrinh", chiTietLichTrinhService.tongChiTietLichTrinhCanDuyet());
        mm.put("allLichTrinh", lichTrinhService.getAll_LichTrinh());
        return "admin/index";
    }

}
