/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.LoaiTin;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class LoaiTinDAOImpl implements LoaiTinDAO {

    @Override
    public ArrayList<LoaiTin> getAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from loaitin");
        ArrayList<LoaiTin> list = (ArrayList<LoaiTin>) query.list();
        transaction.commit();
        return list;
    }

}
