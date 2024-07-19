/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author FPTSHOP
 */
public class Voucher {
   private String MaVoucher;
   private Date ngayBatDau;
   private Date ngayKetThuc;
   private int soLuongGiam;
   private boolean trangThai;
   private BigDecimal dieuKienGiam;

    public Voucher() {
    }

    public String getMaVoucher() {
        return MaVoucher;
    }

    public void setMaVoucher(String MaVoucher) {
        this.MaVoucher = MaVoucher;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getSoLuongGiam() {
        return soLuongGiam;
    }

    public void setSoLuongGiam(int soLuongGiam) {
        this.soLuongGiam = soLuongGiam;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public BigDecimal getDieuKienGiam() {
        return dieuKienGiam;
    }

    public void setDieuKienGiam(BigDecimal dieuKienGiam) {
        this.dieuKienGiam = dieuKienGiam;
    }

    @Override
    public String toString() {
        return "Voucher{" + "MaVoucher=" + MaVoucher + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", soLuongGiam=" + soLuongGiam + ", trangThai=" + trangThai + ", dieuKienGiam=" + dieuKienGiam + '}';
    }
 
}
