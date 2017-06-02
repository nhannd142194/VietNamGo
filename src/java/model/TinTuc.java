/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "tintuc")
public class TinTuc {

    @Id
    @GeneratedValue
    private long idTinTuc;
    private String tenTinTuc;
    @Lob
    private byte[] hinhAnh;
    @ManyToOne
    @JoinColumn(name = "idLoaiTin")
    private LoaiTin loaiTin;
    private String moTaNgan;
    private String moTaChiTiet;
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayDang;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private TaiKhoan user;

    public TinTuc() {
    }

    public long getIdTinTuc() {
        return idTinTuc;
    }

    public void setIdTinTuc(long idTinTuc) {
        this.idTinTuc = idTinTuc;
    }

    public String getTenTinTuc() {
        return tenTinTuc;
    }

    public void setTenTinTuc(String tenTinTuc) {
        this.tenTinTuc = tenTinTuc;
    }

    public LoaiTin getLoaiTin() {
        return loaiTin;
    }

    public void setLoaiTin(LoaiTin loaiTin) {
        this.loaiTin = loaiTin;
    }

    public String getMoTaNgan() {
        return moTaNgan;
    }

    public void setMoTaNgan(String moTaNgan) {
        this.moTaNgan = moTaNgan;
    }

    public String getMoTaChiTiet() {
        return moTaChiTiet;
    }

    public void setMoTaChiTiet(String moTaChiTiet) {
        this.moTaChiTiet = moTaChiTiet;
    }

    public Date getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(Date ngayDang) {
        this.ngayDang = ngayDang;
    }

    public TaiKhoan getUser() {
        return user;
    }

    public void setUser(TaiKhoan user) {
        this.user = user;
    }

    public byte[] getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

}
