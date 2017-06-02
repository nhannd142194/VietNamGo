/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.LoaiTinDAO;
import java.util.ArrayList;
import model.LoaiTin;
import org.springframework.beans.factory.annotation.Autowired;

public class LoaiTinServiceImpl implements LoaiTinService {

    @Autowired
    LoaiTinDAO loaiTinDAO;

    @Override
    public ArrayList<LoaiTin> getAll() {
        return loaiTinDAO.getAll();
    }

}
