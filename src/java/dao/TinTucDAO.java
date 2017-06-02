/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.TinTuc;

public interface TinTucDAO {

    public void addTinTuc(TinTuc tinTuc);

    public void deleteTinTuc(TinTuc tinTuc);

    public void updateTinTuc(TinTuc tinTuc);

    public void updateDoNotImg(TinTuc tinTuc);

    public ArrayList<TinTuc> getAll();

    public TinTuc findTinTuc(long id);

    public ArrayList<TinTuc> getList(int firstResult, int maxResult);
    
    // hiển thị tin tức theo chuyên mục
    public ArrayList<TinTuc> getListByKind(long kind, int firstResult, int maxResult);
    
    public ArrayList<TinTuc> getListByKind(long kind);
    
    public ArrayList<TinTuc> getListByRandom(int num);

}
