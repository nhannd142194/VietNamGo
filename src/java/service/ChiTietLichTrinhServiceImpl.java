/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ChiTietLichTrinhDAO;
import java.util.ArrayList;
import model.ChiTietLichTrinh;
import org.springframework.beans.factory.annotation.Autowired;

public class ChiTietLichTrinhServiceImpl implements ChiTietLichTrinhService {
    
    @Autowired
    ChiTietLichTrinhDAO chiTietLichTrinhDAO;
    
    @Override
    public void insertChiTietLichTrinh(ChiTietLichTrinh ctlt) {
        chiTietLichTrinhDAO.insertChiTietLichTrinh(ctlt);
    }

    @Override
    public int tongChiTietLichTrinhCanDuyet() {
        return chiTietLichTrinhDAO.tongChiTietLichTrinhCanDuyet();
    }

    @Override
    public ArrayList<ChiTietLichTrinh> getListDonHang(long id) {
        return chiTietLichTrinhDAO.getListDonHang(id);
    }

    @Override
    public ArrayList<ChiTietLichTrinh> getList(int firstResult, int maxResult, long id) {
        return chiTietLichTrinhDAO.getList(firstResult, maxResult, id);
    }

    @Override
    public ChiTietLichTrinh findChiTietLichTrinh(long id) {
        return chiTietLichTrinhDAO.findChiTietLichTrinh(id);
    }

    @Override
    public void update(long idChitiet, int kind) {
         chiTietLichTrinhDAO.update(idChitiet, kind);
    }

   
    
}
