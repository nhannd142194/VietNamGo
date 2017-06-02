/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.TinTucDAO;
import java.util.ArrayList;
import model.TinTuc;
import org.springframework.beans.factory.annotation.Autowired;

public class TinTucServiceImpl implements TinTucService {

    @Autowired
    TinTucDAO tinTucDAO;

    @Override
    public void addTinTuc(TinTuc tinTuc) {
        tinTucDAO.addTinTuc(tinTuc);
    }

    @Override
    public void deleteTinTuc(TinTuc tinTuc) {
        tinTucDAO.deleteTinTuc(tinTuc);
    }

    @Override
    public void updateTinTuc(TinTuc tinTuc) {
        tinTucDAO.updateTinTuc(tinTuc);
    }

    @Override
    public ArrayList<TinTuc> getAll() {
        return tinTucDAO.getAll();

    }

    @Override
    public TinTuc findTinTuc(long id) {
        return tinTucDAO.findTinTuc(id);
    }

    @Override
    public ArrayList<TinTuc> getList(int firstResult, int maxResult) {
        return tinTucDAO.getList(firstResult, maxResult);
    }

    @Override
    public void updateDoNotImg(TinTuc tinTuc) {
        tinTucDAO.updateDoNotImg(tinTuc);
    }

    @Override
    public ArrayList<TinTuc> getListByKind(long kind, int firstResult, int maxResult) {
        return tinTucDAO.getListByKind(kind, firstResult, maxResult);
    }

    @Override
    public ArrayList<TinTuc> getListByKind(long kind) {
        return tinTucDAO.getListByKind(kind);
    }

    @Override
    public ArrayList<TinTuc> getListByRandom(int num) {
        return tinTucDAO.getListByRandom(num);
    }
}
