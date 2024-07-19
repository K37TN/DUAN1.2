/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author long
 */
public class GioHangDTO {

    private String ma;

    private String ten;

    private int soLuong;

    private Double donGia;

    private String mauSac;

    private String chatLieu;

    private String kichThuoc;
    private Double giamGia;
    private String hinhThucGiamGia;

    public GioHangDTO() {
    }

    public GioHangDTO(String ma, String ten, int soLuong, Double donGia, String mauSac, String chatLieu, String kichThuoc, Double giamGia, String hinhThucGiamGia) {
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.kichThuoc = kichThuoc;
        this.giamGia = giamGia;
        this.hinhThucGiamGia = hinhThucGiamGia;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public Double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(Double giamGia) {
        this.giamGia = giamGia;
    }

    public String getHinhThucGiamGia() {
        return hinhThucGiamGia;
    }

    public void setHinhThucGiamGia(String hinhThucGiamGia) {
        this.hinhThucGiamGia = hinhThucGiamGia;
    }
    
    public double getThanhTien(){
        return donGia*soLuong;
    }

}
