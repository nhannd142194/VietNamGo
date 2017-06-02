/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.LichTrinh;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class LichTrinhDAOImpl implements LichTrinhDAO {

    @Override
    public void addLichTrinh(LichTrinh lichTrinh) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(lichTrinh);
        transaction.commit();
    }

    @Override
    public void deleteLichTrinh(LichTrinh lichTrinh) {
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(lichTrinh);
        transaction.commit();
    }

    @Override
    public void updateLichTrinh(LichTrinh lichTrinh) {
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(lichTrinh);
        transaction.commit();
    }

    @Override
    public ArrayList<LichTrinh> getAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql="from lichtrinh";        
        Query q = session.createQuery(hql);
        ArrayList<LichTrinh> list =(ArrayList<LichTrinh>) q.list();
        transaction.commit();
        return list;

    }

    @Override
    public LichTrinh findLichTrinh(long id) {
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql="from lichtrinh where idLichTrinh = :idLichTrinh";
        Query q = session.createQuery(hql);
        q.setLong("idLichTrinh", id);
        LichTrinh lichTrinh =(LichTrinh)q.uniqueResult();
        transaction.commit();
        return lichTrinh;
    }

    @Override
    public ArrayList<LichTrinh> getList(int firstResult, int maxResult) {
           Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from lichtrinh");
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);
        ArrayList<LichTrinh> list = (ArrayList<LichTrinh>) query.list();
        transaction.commit();
        return list;
    }
  @Override
    public ArrayList<LichTrinh> search(long noiDi, long noiDen, String ngayKhoiHanh, String gia) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from lichtrinh where idDiemDi = :idDiemDi and idDiemDen = :idDiemDen and ngayKhoiHanh = :ngayKhoiHanh and giaVe <= :giaVe");
        query.setLong("idDiemDi", noiDi);
        query.setLong("idDiemDen", noiDen);
        query.setString("ngayKhoiHanh", ngayKhoiHanh);
        query.setString("giaVe", gia);
        ArrayList<LichTrinh> list = (ArrayList<LichTrinh>) query.list();
        transaction.commit();
        return list;
    }

    @Override
    public int getAll_LichTrinh() {
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Query q = session.createQuery("select COUNT(lt.idLichTrinh) from lichtrinh lt");
        int count=((Number) q.uniqueResult()).intValue();
        transaction.commit();
        return count;
    }
 

}
