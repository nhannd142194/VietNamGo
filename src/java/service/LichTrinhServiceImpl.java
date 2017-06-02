/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.LichTrinhDAO;
import java.util.ArrayList;
import model.LichTrinh;

import org.springframework.beans.factory.annotation.Autowired;

public class LichTrinhServiceImpl implements LichTrinhService {

    @Autowired
    LichTrinhDAO lichTrinhDAO;

    @Override
    public void addLichTrinh(LichTrinh lichTrinh) {
        lichTrinhDAO.addLichTrinh(lichTrinh);
    }

    @Override
    public void deleteLichTrinh(LichTrinh lichTrinh) {
        lichTrinhDAO.deleteLichTrinh(lichTrinh);
    }

    @Override
    public void updateLichTrinh(LichTrinh lichTrinh) {
        lichTrinhDAO.updateLichTrinh(lichTrinh);
    }

    @Override
    public ArrayList<LichTrinh> getAll() {
        return lichTrinhDAO.getAll();
    }

    @Override
    public LichTrinh findLichTrinh(long id) {
        return lichTrinhDAO.findLichTrinh(id);
    }

    @Override
    public ArrayList<LichTrinh> getList(int firstResult, int maxResult) {
        return lichTrinhDAO.getList(firstResult, maxResult);
    }

    @Override
    public ArrayList<LichTrinh> search(long noiDi, long noiDen, String ngayKhoiHanh, String gia) {
        return lichTrinhDAO.search(noiDi, noiDen, ngayKhoiHanh, gia);
    }

    @Override
    public int getAll_LichTrinh() {
        return lichTrinhDAO.getAll_LichTrinh();
    }

 

  

}
