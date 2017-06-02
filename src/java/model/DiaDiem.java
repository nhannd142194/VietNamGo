/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "diadiem")
public class DiaDiem {

    @Id
    @GeneratedValue
    private long idDiaDiem;
    private String tenDiaDiem;

    public DiaDiem(long idDiaDiem, String tenDiaDiem) {
        this.idDiaDiem = idDiaDiem;
        this.tenDiaDiem = tenDiaDiem;
    }

    public DiaDiem() {
    }

    public DiaDiem(long idDiaDiem) {
        this.idDiaDiem = idDiaDiem;
    }

    public long getIdDiaDiem() {
        return idDiaDiem;
    }

    public void setIdDiaDiem(long idDiaDiem) {
        this.idDiaDiem = idDiaDiem;
    }

    public String getTenDiaDiem() {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(String tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }

    @Override
    public String toString() {
        return "DiaDiem{" + "idDiaDiem=" + idDiaDiem + ", tenDiaDiem=" + tenDiaDiem + '}';
    }

}
