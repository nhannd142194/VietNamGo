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
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "lichtrinh")
public class LichTrinh {

    @Id
    @GeneratedValue
    private long idLichTrinh;
    private String tenLichTrinh;
    private String moTaNgan;
    private String moTaChiTiet;
    private double giaVe;
    @Temporal(TemporalType.DATE)
    private Date ngayKhoiHanh;
    @Temporal(TemporalType.DATE)
    private Date ngayKetThuc;
    private int giamGia;
    @ManyToOne
    @JoinColumn(name = "idDiemDi")
    private DiaDiem diemDi;
    @ManyToOne
    @JoinColumn(name = "idDiemDen")
    private DiaDiem diemDen;

    public LichTrinh() {
    }

    public LichTrinh(long idLichTrinh) {
        this.idLichTrinh = idLichTrinh;
    }

    public long getIdLichTrinh() {
        return idLichTrinh;
    }

    public void setIdLichTrinh(long idLichTrinh) {
        this.idLichTrinh = idLichTrinh;
    }

    public String getTenLichTrinh() {
        return tenLichTrinh;
    }

    public void setTenLichTrinh(String tenLichTrinh) {
        this.tenLichTrinh = tenLichTrinh;
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

    public double getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(double giaVe) {
        this.giaVe = giaVe;
    }

    public Date getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(Date ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    public DiaDiem getDiemDi() {
        return diemDi;
    }

    public void setDiemDi(DiaDiem diemDi) {
        this.diemDi = diemDi;
    }

    public DiaDiem getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(DiaDiem diemDen) {
        this.diemDen = diemDen;
    }

}
