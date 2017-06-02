/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.DiaDiemDAO;
import dao.DiaDiemDAOImpl;
import dao.LichTrinhDAOImpl;
import java.security.SecureRandom;
import java.util.ArrayList;
import model.DiaDiem;
import model.LichTrinh;
import model.TaiKhoan;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Main {
    
    public static void main(String[] args) {
        
        DiaDiemDAOImpl dao = new DiaDiemDAOImpl();
        System.out.println(dao.checkName(2, "TPHCM"));
        DiaDiem dd = new DiaDiem(5, "sadas");
        dao.addDiaDiem(dd);
        
    }
}
