/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.DiaDiemDAO;
import java.util.ArrayList;
import model.DiaDiem;
import org.springframework.beans.factory.annotation.Autowired;

public class DiaDiemServiceImpl implements DiaDiemService {

    @Autowired
    DiaDiemDAO diaDiemDAO;

    @Override
    public ArrayList<DiaDiem> search(String tenDiaDiem) {
        return diaDiemDAO.search(tenDiaDiem);
    }

    @Override
    public long searchID(String tenDiaDiem) {
        return diaDiemDAO.searchID(tenDiaDiem);
    }

    @Override
    public void addDiaDiem(DiaDiem diaDiem) {
        diaDiemDAO.addDiaDiem(diaDiem);
    }

    @Override
    public void deleteDiaDiem(DiaDiem diaDiem) {
        diaDiemDAO.deleteDiaDiem(diaDiem);
    }

    @Override
    public void updateDiaDiem(DiaDiem diaDiem) {
        diaDiemDAO.updateDiaDiem(diaDiem);
    }

    @Override
    public ArrayList<DiaDiem> getAll() {
        return diaDiemDAO.getAll();
    }

    @Override
    public ArrayList<DiaDiem> getList(int firstResult, int maxResult) {
        return diaDiemDAO.getList(firstResult, maxResult);
    }

    @Override
    public DiaDiem findDiaDiem(long id) {
        return diaDiemDAO.findDiaDiem(id);
    }

    @Override
    public boolean checkName(long id, String tenDiaDiem) {
        return diaDiemDAO.checkName(id, tenDiaDiem);
    }

}
