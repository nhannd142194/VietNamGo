/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.DiaDiem;

public interface DiaDiemDAO {

    public void addDiaDiem(DiaDiem diaDiem);

    public void deleteDiaDiem(DiaDiem diaDiem);

    public void updateDiaDiem(DiaDiem diaDiem);

    public ArrayList<DiaDiem> getAll();

    public ArrayList<DiaDiem> search(String tenDiaDiem);

    public ArrayList<DiaDiem> getList(int firstResult, int maxResult);

    public long searchID(String tenDiaDiem);

    public DiaDiem findDiaDiem(long id);
    
    public boolean checkName(long id, String tenDiaDiem);

}
