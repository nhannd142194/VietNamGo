/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.ChiTietLichTrinh;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ChiTietLichTrinhDAOImpl implements ChiTietLichTrinhDAO {

    @Override
    public void insertChiTietLichTrinh(ChiTietLichTrinh ctlt) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(ctlt);
        transaction.commit();
    }

    @Override
    public int tongChiTietLichTrinhCanDuyet() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("select COUNT(ct.idChiTietLichTrinh) from chitietlichtrinh ct WHERE tinhtrang = :tinhtrang");
        q.setBoolean("tinhtrang", false);
        int count = ((Number) q.uniqueResult()).intValue();
        transaction.commit();
        return count;
    }

    @Override
    public ArrayList<ChiTietLichTrinh> getListDonHang(long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("FROM chitietlichtrinh ct where idLichTrinh = :idLichTrinh ORDER BY ct.idChiTietLichTrinh DESC");
        q.setLong("idLichTrinh", id);
        ArrayList<ChiTietLichTrinh> list = (ArrayList<ChiTietLichTrinh>) q.list();
        transaction.commit();
        return list;
    }

    @Override
    public ArrayList<ChiTietLichTrinh> getList(int firstResult, int maxResult, long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM chitietlichtrinh ct where idLichTrinh = :idLichTrinh ORDER BY ct.idChiTietLichTrinh DESC");
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);
        query.setLong("idLichTrinh", id);
        ArrayList<ChiTietLichTrinh> list = (ArrayList<ChiTietLichTrinh>) query.list();
        transaction.commit();
        System.out.println("lllllllllllllllllllllllll  " + list.size());
        return list;
    }

    @Override
    public ChiTietLichTrinh findChiTietLichTrinh(long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("FROM chitietlichtrinh where idChiTietLichTrinh = :idChiTietLichTrinh");
        q.setLong("idChiTietLichTrinh", id);
        ChiTietLichTrinh chiTietLichTrinh = (ChiTietLichTrinh) q.uniqueResult();
        transaction.commit();
        return chiTietLichTrinh;
    }

    @Override
    public void update(long idChitiet, int kind) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createSQLQuery("UPDATE chitietlichtrinh SET tinhTrang = :tinhTrang where idChiTietLichTrinh = :idChiTietLichTrinh");
        q.setLong("idChiTietLichTrinh", idChitiet);
        q.setInteger("tinhTrang", kind);
        q.executeUpdate();
        transaction.commit();

    }
}
