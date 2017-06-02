/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "chitietlichtrinh")
public class ChiTietLichTrinh {

    @Id
    @GeneratedValue
    private long idChiTietLichTrinh;
    private int soVe;
    @ManyToOne
    @JoinColumn(name = "idTaiKhoan")
    private TaiKhoan user;
    @ManyToOne
    @JoinColumn(name = "idLichTrinh")
    private LichTrinh lichTrinh;
    private int tinhTrang;

    public ChiTietLichTrinh() {
    }

    public long getIdChiTietLichTrinh() {
        return idChiTietLichTrinh;
    }

    public void setIdChiTietLichTrinh(long idChiTietLichTrinh) {
        this.idChiTietLichTrinh = idChiTietLichTrinh;
    }

    public TaiKhoan getUser() {
        return user;
    }

    public void setUser(TaiKhoan user) {
        this.user = user;
    }

    public LichTrinh getLichTrinh() {
        return lichTrinh;
    }

    public void setLichTrinh(LichTrinh lichTrinh) {
        this.lichTrinh = lichTrinh;
    }

    public int getSoVe() {
        return soVe;
    }

    public void setSoVe(int soVe) {
        this.soVe = soVe;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public ChiTietLichTrinh(long idChiTietLichTrinh, int tinhTrang) {
        this.idChiTietLichTrinh = idChiTietLichTrinh;
        this.tinhTrang = tinhTrang;
    }

  

}
