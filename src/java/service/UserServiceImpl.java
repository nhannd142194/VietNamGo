/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDAO;
import java.math.BigInteger;
import java.util.ArrayList;
import model.TaiKhoan;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public void addUser(TaiKhoan user) {
        userDAO.addUser(user);
    }

    @Override
    public void deleteUser(TaiKhoan user) {
        userDAO.deleteUser(user);
    }

    @Override
    public void updateUser(TaiKhoan user) {
        userDAO.updateUser(user);
    }

    @Override
    public ArrayList<TaiKhoan> getListUser() {
        return userDAO.getListUser();
    }

    @Override
    public TaiKhoan findUser(long id) {
        return userDAO.findUser(id);
    }

    @Override
    public TaiKhoan login(String username, String pass) {
        return userDAO.login(username, pass);
    }

    @Override
    public ArrayList<TaiKhoan> filter(int role) {
        return userDAO.filter(role);
    }

    @Override
    public BigInteger report(String time) {
        return userDAO.report(time);
    }

    @Override
    public TaiKhoan checkEmail(String email) {
        return userDAO.checkEmail(email);
    }

    @Override
    public void resetPass(long id, String pass) {
        userDAO.resetPass(id, pass);
    }

    @Override
    public int allUser() {
       return userDAO.allUser();
    }

    @Override
    public ArrayList<TaiKhoan> getList(int firstResult, int maxResult) {
        return userDAO.getList(firstResult, maxResult);
    }

}
