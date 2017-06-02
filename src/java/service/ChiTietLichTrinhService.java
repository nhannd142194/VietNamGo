/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.ChiTietLichTrinh;

public interface ChiTietLichTrinhService {

    public void insertChiTietLichTrinh(ChiTietLichTrinh ctlt);

    public int tongChiTietLichTrinhCanDuyet();

    public ArrayList<ChiTietLichTrinh> getListDonHang(long id);

    public ArrayList<ChiTietLichTrinh> getList(int firstResult, int maxResult, long id);

    public ChiTietLichTrinh findChiTietLichTrinh(long id);

    public void update(long idChitiet, int kind);
}
