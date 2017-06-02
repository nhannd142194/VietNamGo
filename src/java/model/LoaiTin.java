/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "loaitin")
public class LoaiTin {

    @Id
    @GeneratedValue
    private long idLoaiTen;
    private String tenLoai;

    public LoaiTin() {
    }

    public LoaiTin(long idLoaiTen) {
        this.idLoaiTen = idLoaiTen;
    }

    public LoaiTin(long idLoaiTen, String tenLoai) {
        this.idLoaiTen = idLoaiTen;
        this.tenLoai = tenLoai;
    }

    public long getIdLoaiTen() {
        return idLoaiTen;
    }

    public void setIdLoaiTen(long idLoaiTen) {
        this.idLoaiTen = idLoaiTen;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    @Override
    public String toString() {
        return "LoaiTin{" + "idLoaiTen=" + idLoaiTen + ", tenLoai=" + tenLoai + '}';
    }

}
