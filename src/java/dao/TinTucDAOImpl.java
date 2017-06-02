/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.TinTuc;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class TinTucDAOImpl implements TinTucDAO {

    @Override
    public void addTinTuc(TinTuc tinTuc) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(tinTuc);
        transaction.commit();
    }

    @Override
    public void deleteTinTuc(TinTuc tinTuc) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(tinTuc);
        transaction.commit();
    }

    @Override
    public void updateTinTuc(TinTuc tinTuc) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(tinTuc);
        transaction.commit();
    }

    @Override
    public ArrayList<TinTuc> getAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from tintuc");
        ArrayList<TinTuc> list = (ArrayList<TinTuc>) query.list();
        transaction.commit();
        return list;
    }

    @Override
    public TinTuc findTinTuc(long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from tintuc where idTinTuc = :idTinTuc");
        query.setLong("idTinTuc", id);
        TinTuc tintuc = (TinTuc) query.uniqueResult();
        transaction.commit();
        return tintuc;
    }

    @Override
    public ArrayList<TinTuc> getList(int firstResult, int maxResult) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from tintuc ORDER BY idLoaiTin DESC");
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);
        ArrayList<TinTuc> list = (ArrayList<TinTuc>) query.list();
        transaction.commit();
        return list;
    }

    @Override
    public void updateDoNotImg(TinTuc tinTuc) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("update tintuc set idLoaiTin = :idLoaiTin, tenTinTuc = :tenTinTuc, moTaNgan = :moTaNgan, moTaChiTiet = :moTaChiTiet where idTinTuc = :idTinTuc");
        query.setLong("idTinTuc", tinTuc.getIdTinTuc());
        query.setLong("idLoaiTin", tinTuc.getLoaiTin().getIdLoaiTen());
        query.setString("tenTinTuc", tinTuc.getTenTinTuc());
        query.setString("moTaNgan", tinTuc.getMoTaNgan());
        query.setString("moTaChiTiet", tinTuc.getMoTaChiTiet());
        query.executeUpdate();
        transaction.commit();
    }

    @Override
    public ArrayList<TinTuc> getListByKind(long kind, int firstResult, int maxResult) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from tintuc where idLoaiTin = :idLoaiTin ORDER BY idLoaiTin DESC");
        query.setLong("idLoaiTin", kind);
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);
        ArrayList<TinTuc> list = (ArrayList<TinTuc>) query.list();
        transaction.commit();
        return list;
    }

    @Override
    public ArrayList<TinTuc> getListByKind(long kind) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from tintuc where idLoaiTin = :idLoaiTin ORDER BY idLoaiTin DESC");
        query.setLong("idLoaiTin", kind);
        ArrayList<TinTuc> list = (ArrayList<TinTuc>) query.list();
        transaction.commit();
        return list;
    }

    @Override
    public ArrayList<TinTuc> getListByRandom(int num) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from tintuc ORDER BY rand()");
        query.setMaxResults(num);
        ArrayList<TinTuc> listProduct = (ArrayList<TinTuc>) query.list();
        transaction.commit();
        return listProduct;
    }

}
