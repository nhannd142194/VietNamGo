/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.UserDAO;
import java.math.BigInteger;
import java.util.ArrayList;
import model.TaiKhoan;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

    @Override
    public void addUser(TaiKhoan user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
    }

    @Override
    public void deleteUser(TaiKhoan user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
    }

    @Override
    public void updateUser(TaiKhoan user) {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (HibernateException h) {

        }
    }

    @Override
    public ArrayList<TaiKhoan> getListUser() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from taikhoan");
        ArrayList<TaiKhoan> listUser = (ArrayList<TaiKhoan>) query.list();
        transaction.commit();
        return listUser;
    }

    @Override
    public TaiKhoan findUser(long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from taikhoan where idTaiKhoan = :idTaiKhoan");
        query.setLong("idTaiKhoan", id);
        TaiKhoan user = (TaiKhoan) query.uniqueResult();
        transaction.commit();
        return user;
    }

    @Override
    public TaiKhoan login(String email, String pass) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from taikhoan where email = :email and matKhau = :matKhau");
        query.setString("email", email);
        query.setString("matKhau", pass);
        TaiKhoan user = (TaiKhoan) query.uniqueResult();
        transaction.commit();
        return user;
    }

    @Override
    public ArrayList<TaiKhoan> filter(int role) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from taikhoan where quyen = :quyen");
        query.setInteger("quyen", role);
        ArrayList<TaiKhoan> listUser = (ArrayList<TaiKhoan>) query.list();
        transaction.commit();
        return listUser;
    }

    @Override
    public BigInteger report(String time) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("SELECT count(*) from taikhoan where ngayTao = '" + time + "'");
        BigInteger listProduct = (BigInteger) query.uniqueResult();
        transaction.commit();
        return listProduct;
    }

    @Override
    public TaiKhoan checkEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from taikhoan where email = :email");
        query.setString("email", email);
        TaiKhoan user = (TaiKhoan) query.uniqueResult();
        transaction.commit();
        return user;
    }

    @Override
    public void resetPass(long id, String pass) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("update taikhoan set matKhau = :matKhau where idTaiKhoan = :idTaiKhoan");
        query.setString("matKhau", pass);
        query.setLong("idTaiKhoan", id);
        query.executeUpdate();
        transaction.commit();
    }

    @Override
    public int allUser() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("select COUNT(tk.idTaiKhoan) from taikhoan tk");
        int count = ((Number) q.uniqueResult()).intValue();
        transaction.commit();
        return count;
    }

  
   @Override
    public ArrayList<TaiKhoan> getList(int firstResult, int maxResult) {
           Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from taikhoan");
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);
        ArrayList<TaiKhoan> list = (ArrayList<TaiKhoan>) query.list();
        transaction.commit();
        return list;
    }
}
