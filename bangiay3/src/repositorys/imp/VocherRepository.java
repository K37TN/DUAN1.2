/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Voucher;
import utilconnext.DBcontext;


/**
 *
 * @author FPTSHOP
 */
public class VocherRepository {
    public List<Voucher> getAll() {
        List<Voucher> list = new ArrayList<>();
        try {
            String sql = """
                        SELECT [MaVoucher]
                              ,[soLuongGiam]
                              ,[dieuKienGiam]
                              ,[trangThai]
                              ,[ngayBatDau]
                              ,[ngayKetThuc]
                          FROM [dbo].[Voucher]
                        """;
            Connection con = DBcontext.getConnection();
            PreparedStatement pr = con.prepareCall(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Voucher vc = new Voucher();
                vc.setMaVoucher(rs.getString(1));
                vc.setSoLuongGiam(rs.getInt(2));
                vc.setDieuKienGiam(rs.getBigDecimal(3));
                vc.setTrangThai(rs.getBoolean(4));
                vc.setNgayBatDau(rs.getDate(5));
                vc.setNgayKetThuc(rs.getDate(6));

                list.add(vc);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;

    }

    public boolean add(Voucher vc) {
        String sql = """
                    INSERT INTO [dbo].[Voucher]
                               ([MaVoucher]
                               ,[soLuongGiam]
                               ,[dieuKienGiam]
                               ,[trangThai]
                               ,[ngayBatDau]
                               ,[ngayKetThuc])
                         VALUES
                               (?,?,?,?,?,?)
                    """;
        int check = 0;
        Connection con = DBcontext.getConnection();

        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, vc.getMaVoucher());
            pr.setObject(2, vc.getSoLuongGiam());
            pr.setObject(3, vc.getDieuKienGiam());
            pr.setObject(4, vc.isTrangThai());
            pr.setObject(5, vc.getNgayBatDau());
            pr.setObject(6, vc.getNgayKetThuc());
            check = pr.executeUpdate();
        } catch (Exception e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean Update(String maVoucher, Voucher vc) {
        String sql = """
                   UPDATE [dbo].[Voucher]
                      SET [MaVoucher] = ?
                         ,[soLuongGiam] = ?
                         ,[dieuKienGiam] = ?
                         ,[trangThai] = ?
                         ,[ngayBatDau] = ?
                         ,[ngayKetThuc] = ?
                    WHERE [MaVoucher] = ?
                   """;
        int check = 0;
        Connection con = DBcontext.getConnection();

        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, vc.getMaVoucher());
            pr.setObject(2, vc.getSoLuongGiam());
            pr.setObject(3, vc.getDieuKienGiam());
            pr.setObject(4, vc.isTrangThai());
            pr.setObject(5, vc.getNgayBatDau());
            pr.setObject(6, vc.getNgayKetThuc());
            pr.setObject(7, maVoucher);

            check = pr.executeUpdate();
        } catch (Exception e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }
        return check > 0;
    }
}
