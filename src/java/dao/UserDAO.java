/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigInteger;
import java.util.ArrayList;
import model.TaiKhoan;

public interface UserDAO {

    public void addUser(TaiKhoan user);

    public void deleteUser(TaiKhoan user);

    public void updateUser(TaiKhoan user);

    public ArrayList<TaiKhoan> getListUser();

    public TaiKhoan findUser(long id);

    public TaiKhoan login(String username, String pass);
    
    public ArrayList<TaiKhoan> filter(int role);
    
    public BigInteger report(String time);
    
    public TaiKhoan checkEmail(String email);
    
    public void resetPass(long id, String pass);
    public int allUser();
    public ArrayList<TaiKhoan> getList(int firstResult, int maxResult);

}
