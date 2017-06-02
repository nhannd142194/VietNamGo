/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.DiaDiem;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class DiaDiemDAOImpl implements DiaDiemDAO {

    @Override
    public ArrayList<DiaDiem> search(String tenDiaDiem) {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from diadiem where tenDiaDiem like :tenDiaDiem");
            query.setString("tenDiaDiem", "%" + tenDiaDiem + "%");
            ArrayList<DiaDiem> list = (ArrayList<DiaDiem>) query.list();
            transaction.commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long searchID(String tenDiaDiem) {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from diadiem where tenDiaDiem = :tenDiaDiem");
            query.setString("tenDiaDiem", tenDiaDiem);
            DiaDiem dd = (DiaDiem) query.uniqueResult();
            transaction.commit();
            return dd.getIdDiaDiem();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void addDiaDiem(DiaDiem diaDiem) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(diaDiem);
        transaction.commit();
    }

    @Override
    public void deleteDiaDiem(DiaDiem diaDiem) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(diaDiem);
        transaction.commit();
    }

    @Override
    public void updateDiaDiem(DiaDiem diaDiem) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(diaDiem);
        transaction.commit();
    }

    @Override
    public ArrayList<DiaDiem> getAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from diadiem");
        ArrayList<DiaDiem> list = (ArrayList<DiaDiem>) query.list();
        transaction.commit();
        return list;
    }

    @Override
    public ArrayList<DiaDiem> getList(int firstResult, int maxResult) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from diadiem");
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);
        ArrayList<DiaDiem> list = (ArrayList<DiaDiem>) query.list();
        transaction.commit();
        return list;
    }

    @Override
    public DiaDiem findDiaDiem(long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from diadiem where idDiaDiem = :idDiaDiem");
        query.setLong("idDiaDiem", id);
        DiaDiem dd = (DiaDiem) query.uniqueResult();
        transaction.commit();
        return dd;
    }

    @Override
    public boolean checkName(long id, String tenDiaDiem) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from diadiem where tenDiaDiem = :tenDiaDiem and idDiaDiem != :idDiaDiem");
        query.setLong("idDiaDiem", id);
        query.setString("tenDiaDiem", tenDiaDiem);
        DiaDiem dd = (DiaDiem) query.uniqueResult();
        transaction.commit();
        return dd != null;
    }

}
