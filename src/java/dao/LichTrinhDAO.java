/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.LichTrinh;

public interface LichTrinhDAO {

    public void addLichTrinh(LichTrinh lichTrinh);

    public void deleteLichTrinh(LichTrinh lichTrinh);

    public void updateLichTrinh(LichTrinh lichTrinh);

    public ArrayList<LichTrinh> getAll();

    public LichTrinh findLichTrinh(long id);
    
    public ArrayList<LichTrinh> getList(int firstResult, int maxResult);
    // tìm kiếm
    public ArrayList<LichTrinh> search(long noiDi, long noiDen, String ngayKhoiHanh, String gia);
    public int getAll_LichTrinh();

}
