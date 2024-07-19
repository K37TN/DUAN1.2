/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import com.barcodelib.barcode.Linear;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.ChatLieu;
import models.ChiTietSP;
import models.DanhMucSP;
import models.KhuyenMai;
import models.KichCo;
import models.MauSac;
import models.NSX;
import models.ThuongHieu;
import org.bridj.cpp.com.OLEAutomationLibrary;
import services.IChatLieuServices;
import services.IChiTietSPServices;
import services.IDanhMucSPServices;
import services.IKhuyenmaiService;
import services.IKichCoServices;
import services.IMauSacServices;
import services.INSXServices;
import services.IThuongHieuServices;
import services.imp.ChatLieuServices;
import services.imp.ChiTietSPServices;
import services.imp.DanhMucSPServices;
import services.imp.KhuyenmaiService;
import services.imp.KichCoServices;
import services.imp.MauSacServices;
import services.imp.NSXServices;
import services.imp.ThuongHieuServices;
import viewmodels.ChiTietSPViewModel;
import viewmodels.KhuyenmaiViewmodel;
import viewmodels.SanPhamViewModel;

/**
 *
 * @author hungh
 */
public class frm_Sanpham extends javax.swing.JPanel {

    private IChiTietSPServices iChiTietSPServices;
    private INSXServices iNSXServices;
    private IMauSacServices iMauSacServices;
    private IDanhMucSPServices iDanhMucSPServices;
    private IKichCoServices iKichCoServices;
    private IChatLieuServices iChatLieuServices;
    private IThuongHieuServices iThuongHieuServices;
    private IKhuyenmaiService iKhuyenmaiService;
    DefaultTableModel defaultTableModel;
    private boolean hish = false;
    String sp = null;
    ChiTietSPViewModel _cSPViewModel;
    int _row = -1;

    public frm_Sanpham() {
        initComponents();

        innitTable();
//        listctsp = iChiTietSPServices.getAll();
        iChiTietSPServices = new ChiTietSPServices();
        iNSXServices = new NSXServices();
        iMauSacServices = new MauSacServices();
        iDanhMucSPServices = new DanhMucSPServices();
        iKichCoServices = new KichCoServices();
        iChatLieuServices = new ChatLieuServices();
        iThuongHieuServices = new ThuongHieuServices();
        iKhuyenmaiService = new KhuyenmaiService();
        _cSPViewModel = new ChiTietSPViewModel();
        loadData(iChiTietSPServices.getAll());
    }

    private String zenbarcode() {
        Random random = new Random();
        int ran = random.nextInt(999999);
        int dom = random.nextInt(999999);
        return ran + "" + dom;
    }

    private ChiTietSPViewModel getdadtafrom() {
        Pattern p = Pattern.compile("^[0-9]+$");
        if (txt_ma.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã sản phẩm!");
            return null;

        }
        if (txt_ma.getText().length() > 15) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm không quá 15 kí tự!");
            return null;
        }
//  tên sp
        if (txt_ten.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên sản phẩm!");
            return null;
        }

        if (p.matcher(txt_ten.getText()).find() == true) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm phải là chữ!");
            return null;
        }

        if (txt_ten.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm không quá 30 kí tự!");
            return null;
        }
// Số lượng tồn
        if (_cSPViewModel.getSoluongton() == Integer.MIN_VALUE) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập số lượng tồn!");
            return null;
        }

        try {
            Integer.valueOf(_cSPViewModel.getSoluongton());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng tồn phải là số!");
            return null;
        }

        if (Integer.valueOf(_cSPViewModel.getSoluongton()) <= 0) {
            JOptionPane.showMessageDialog(this, "Số lượng tồn phải lớn hơn 0!");
            return null;
        }
// giá nhập

        if (_cSPViewModel.getGianhap() == Integer.MIN_VALUE) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập giá nhập!");
            return null;
        }

        try {
            Double.valueOf(_cSPViewModel.getGianhap());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá nhập phải là số!");
            return null;
        }

        if (Double.valueOf(_cSPViewModel.getGianhap()) <= 0) {
            JOptionPane.showMessageDialog(this, "Giá nhập phải lớn hơn 0!");
            return null;
        }
// giá bán
        if (_cSPViewModel.getGiaban() == Integer.MIN_VALUE) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập giá bán!");
            return null;
        }

        try {
            Double.valueOf(_cSPViewModel.getGiaban());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá bán phải là số!");
            return null;
        }

        if (Double.valueOf(_cSPViewModel.getGiaban()) <= 0) {
            JOptionPane.showMessageDialog(this, "Giá bán phải lớn hơn 0!");
            return null;
        }
///////////////
        String mota = _cSPViewModel.getMota();
        if (_cSPViewModel.getMota().equals("")) {
            mota = "không có";
        }
        NSX nsx = (NSX) _cSPViewModel.getNsx();
        DanhMucSP danhmuc = (DanhMucSP) _cSPViewModel.getDanhmuc();
        MauSac mausac = (MauSac) _cSPViewModel.getMausac();
        ChatLieu chatlieu = (ChatLieu) _cSPViewModel.getChatlieu();
        ThuongHieu thuonghieu = (ThuongHieu) _cSPViewModel.getThuonghieu();
        KichCo kichco = (KichCo) _cSPViewModel.getKichco();
        double gianhap;
        double giaban;
        int soluong;
        try {
            gianhap = Double.parseDouble(_cSPViewModel.getGianhap().toString());
            giaban = Double.parseDouble(_cSPViewModel.getGiaban().toString());
            soluong = _cSPViewModel.getSoluongton();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "lỗi");
        }
        gianhap = Double.parseDouble(_cSPViewModel.getGianhap().toString());
        giaban = Double.parseDouble(_cSPViewModel.getGiaban().toString());
        soluong = _cSPViewModel.getSoluongton();
        ChiTietSPViewModel ctsp = new ChiTietSPViewModel(txt_ma.getText(), txt_ten.getText(), nsx, mausac, danhmuc, kichco, chatlieu, thuonghieu, null, soluong, gianhap, giaban, mota);
        return ctsp;
    }

    private ChiTietSPViewModel getdataTB(int row) {
        String ma = tbl_sp.getValueAt(row, 0).toString();
        String ten = tbl_sp.getValueAt(row, 1).toString();
        NSX nsx = (NSX) tbl_sp.getValueAt(row, 2);
        MauSac ms = (MauSac) tbl_sp.getValueAt(row, 3);
        DanhMucSP dmsp = (DanhMucSP) tbl_sp.getValueAt(row, 4);
        KichCo kc = (KichCo) tbl_sp.getValueAt(row, 5);
        ChatLieu cl = (ChatLieu) tbl_sp.getValueAt(row, 6);
        ThuongHieu th = (ThuongHieu) tbl_sp.getValueAt(row, 7);
        KhuyenMai km = (KhuyenMai) tbl_sp.getValueAt(row, 8);
        int soluong = (int) tbl_sp.getValueAt(row, 9);
        double gianhap = (double) tbl_sp.getValueAt(row, 10);
        double giaban = (double) tbl_sp.getValueAt(row, 11);
        String mota = tbl_sp.getValueAt(row, 12).toString();

        return new ChiTietSPViewModel(ma, ten, nsx, ms, dmsp, kc, cl, th, km, soluong, gianhap, giaban, mota);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradiente1 = new swing.PanelGradiente();
        panelBorder1 = new swing.PanelBorder();
        txt_ma = new swing.MyTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_ten = new swing.MyTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_capnhat = new swing.MyButton();
        btn_lammoi = new swing.MyButton();
        btn_them = new swing.MyButton();
        hideshow = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        panelBorder3 = new swing.PanelBorder();
        searchText = new swing.SearchText();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sp = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1010, 640));

        panelGradiente1.setColorPrimario(new java.awt.Color(242, 242, 242));
        panelGradiente1.setColorSecundario(new java.awt.Color(242, 242, 242));

        panelBorder1.setBackground(new java.awt.Color(242, 242, 242));
        panelBorder1.add(txt_ma);
        txt_ma.setBounds(30, 30, 210, 40);

        jLabel1.setText("Mã sản phẩm");
        panelBorder1.add(jLabel1);
        jLabel1.setBounds(30, 10, 210, 20);
        panelBorder1.add(txt_ten);
        txt_ten.setBounds(290, 30, 210, 40);

        jLabel2.setText("Tên sản phẩm");
        panelBorder1.add(jLabel2);
        jLabel2.setBounds(290, 10, 210, 20);

        btn_capnhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/floppy-disk.png"))); // NOI18N
        btn_capnhat.setText("Cập nhật");
        btn_capnhat.setColor(new java.awt.Color(255, 255, 255));
        btn_capnhat.setColorOver(new java.awt.Color(204, 204, 204));
        btn_capnhat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatActionPerformed(evt);
            }
        });
        panelBorder1.add(btn_capnhat);
        btn_capnhat.setBounds(810, 120, 140, 40);

        btn_lammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btn_lammoi.setText("Làm mới");
        btn_lammoi.setColor(new java.awt.Color(255, 255, 255));
        btn_lammoi.setColorOver(new java.awt.Color(204, 204, 204));
        btn_lammoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lammoiActionPerformed(evt);
            }
        });
        panelBorder1.add(btn_lammoi);
        btn_lammoi.setBounds(810, 20, 140, 40);

        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.setColor(new java.awt.Color(255, 255, 255));
        btn_them.setColorOver(new java.awt.Color(204, 204, 204));
        btn_them.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        panelBorder1.add(btn_them);
        btn_them.setBounds(810, 70, 140, 40);

        panelGradiente1.add(panelBorder1);
        panelBorder1.setBounds(0, 0, 990, 220);

        hideshow.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        hideshow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hide.png"))); // NOI18N
        hideshow.setText("  Hiện sản phẩm hết");
        hideshow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hideshowMouseClicked(evt);
            }
        });
        panelGradiente1.add(hideshow);
        hideshow.setBounds(50, 240, 180, 40);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-page.png"))); // NOI18N
        jLabel15.setText("Thêm/Sửa thuộc tính");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        panelGradiente1.add(jLabel15);
        jLabel15.setBounds(270, 240, 180, 40);

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));

        searchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextKeyReleased(evt);
            }
        });
        panelBorder3.add(searchText);
        searchText.setBounds(10, 0, 250, 40);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_24px.png"))); // NOI18N
        panelBorder3.add(jLabel14);
        jLabel14.setBounds(270, 0, 24, 40);

        panelGradiente1.add(panelBorder3);
        panelBorder3.setBounds(670, 240, 310, 40);

        tbl_sp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_sp.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_sp.setRowHeight(25);
        tbl_sp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_spMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sp);

        panelGradiente1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 300, 1010, 240);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 94, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
        loadData(iChiTietSPServices.getAll());
        clearForm();
    }//GEN-LAST:event_btn_lammoiActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        ChiTietSPViewModel x = getdadtafrom();
        if (x == null) {
            return;
        }
        int chon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm sản phẩm ?", "Thêm sản phẩm mới", JOptionPane.YES_NO_OPTION);
        if (chon == JOptionPane.YES_OPTION) {
            boolean kq = iChiTietSPServices.Add(x);
            if (kq == true) {
                loadData(iChiTietSPServices.getAll());
//            xuatbarcode(x);
//                String data = x.getQrcode();
                String path = "D:\\QRcode\\Qr" + x.getTen() + ".png";
                Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
                hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
//                generateQRcode(data, path, hashMap, 200, 200);
//                System.out.println("QR Code created successfully.");
            }
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatActionPerformed
        int row = tbl_sp.getSelectedRow();
        if (txt_ma.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, " Bạn cần chọn 1 dòng để cập nhật");
            return;
        }
        String ma = (String) tbl_sp.getValueAt(_row, 0);
        ChiTietSPViewModel x = getdadtafrom();
        if (x == null) {
            return;
        }
        int chon = JOptionPane.showConfirmDialog(this, "Bạn Có chắc muốn cập nhật lại sản phẩm ?", "Update", JOptionPane.YES_NO_OPTION);
        if (chon == JOptionPane.YES_OPTION) {
            boolean kq = iChiTietSPServices.Update(ma, x);
            if (kq == true) {
                loadData(iChiTietSPServices.getAll());
                JOptionPane.showMessageDialog(this, "Thành công", "Update", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Thất bại", "Update", JOptionPane.INFORMATION_MESSAGE);
            }

        }

    }//GEN-LAST:event_btn_capnhatActionPerformed

    private void tbl_spMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_spMouseClicked
        int row = tbl_sp.getSelectedRow();
        _row = row;
        if (row == -1) {
            return;
        }
        ChiTietSPViewModel x = getdataTB(row);
        _cSPViewModel = x;
        txt_ma.setText(x.getMa());
        txt_ten.setText(x.getTen());

    }//GEN-LAST:event_tbl_spMouseClicked

    private void hideshowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideshowMouseClicked

        if (hish == false) {
            hish = true;
            hideshow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/show.png")));
            loadData(iChiTietSPServices.getSPhet());
            hideshow.setText("Ẩn sản phẩm hết");
        } else {
            hish = false;
            hideshow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hide.png")));
            hideshow.setText("Hiện sản phẩm hết");
            loadData(iChiTietSPServices.getAll());
        }

    }//GEN-LAST:event_hideshowMouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
//        new frm_themthuoctinh(new javax.swing.JFrame(), true).setVisible(true);
        int row = tbl_sp.getSelectedRow();
        if (txt_ma.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã!");
            return;
        }
        if (txt_ten.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên!");
            return;
        }
//        defaultTableModel.addColumn("Mã");
//        defaultTableModel.addColumn("Tên");
//        defaultTableModel.addColumn("NSX");
//        defaultTableModel.addColumn("Màu sắc");
//        defaultTableModel.addColumn("Danh mục");
//        defaultTableModel.addColumn("Size");
//        defaultTableModel.addColumn("Chất liệu");
//        defaultTableModel.addColumn("Thương hiệu");
//        defaultTableModel.addColumn("Khuyến mãi");
//        defaultTableModel.addColumn("Số lượng tồn");
//        defaultTableModel.addColumn("Giá nhập");
//        defaultTableModel.addColumn("Giá bán");
//        defaultTableModel.addColumn("Mô tả");
        frm_ThuocTinhSanSam fSam = new frm_ThuocTinhSanSam(_cSPViewModel);
        fSam.setVisible(true);
        fSam.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Truy cập đối tượng ChiTietSPViewModel từ ChildFrame sau khi nó đóng
                _cSPViewModel = fSam.getChiTietSPViewModel();
                loadData(iChiTietSPServices.getAll());
                // Xử lý dữ liệu ở đây
            }
        });
    }//GEN-LAST:event_jLabel15MouseClicked

    private void searchTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextKeyReleased
        loadData(iChiTietSPServices.getlistbyTen("%" + searchText.getText() + "%"));
    }//GEN-LAST:event_searchTextKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton btn_capnhat;
    private swing.MyButton btn_lammoi;
    private swing.MyButton btn_them;
    private javax.swing.JLabel hideshow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.PanelBorder panelBorder1;
    private swing.PanelBorder panelBorder3;
    private swing.PanelGradiente panelGradiente1;
    private swing.SearchText searchText;
    private javax.swing.JTable tbl_sp;
    private swing.MyTextField txt_ma;
    private swing.MyTextField txt_ten;
    // End of variables declaration//GEN-END:variables

    private void innitTable() {
        defaultTableModel = (DefaultTableModel) tbl_sp.getModel();
        defaultTableModel.setColumnCount(0);
        defaultTableModel.addColumn("Mã");
        defaultTableModel.addColumn("Tên");
        defaultTableModel.addColumn("NSX");
        defaultTableModel.addColumn("Màu sắc");
        defaultTableModel.addColumn("Danh mục");
        defaultTableModel.addColumn("Size");
        defaultTableModel.addColumn("Chất liệu");
        defaultTableModel.addColumn("Thương hiệu");
        defaultTableModel.addColumn("Khuyến mãi");
        defaultTableModel.addColumn("Số lượng tồn");
        defaultTableModel.addColumn("Giá nhập");
        defaultTableModel.addColumn("Giá bán");
        defaultTableModel.addColumn("Mô tả");

    }

    private void loadData(List<ChiTietSPViewModel> lst) {
        defaultTableModel = (DefaultTableModel) tbl_sp.getModel();
        defaultTableModel.setRowCount(0);
        for (ChiTietSPViewModel x : lst) {
            defaultTableModel.addRow(new Object[]{
                x.getMa(),
                x.getTen(),
                x.getNsx(),
                x.getMausac(),
                x.getDanhmuc(),
                x.getKichco(),
                x.getChatlieu(),
                x.getThuonghieu(),
                x.getKhuyenmai(),
                x.getSoluongton(),
                x.getGianhap(),
                x.getGiaban(),
                x.getMota(),});
        }
    }

//    public ChiTietSP getData() {
//        String ma = txt_ma.getText();
//        String ten = txt_ten.getText();
//        NSX nsx =(NSX) cbo_nsx.getSelectedItem();
//        MauSac ms = (MauSac) cbo_mausac.getSelectedItem();
//        DanhMucSP dmsp = (DanhMucSP) cbo_danhmuc.getSelectedItem();
//        KichCo kc = (KichCo) cbo_size.getSelectedItem();
//        ChatLieu cl = (ChatLieu) cbo_chatlieu.getSelectedItem();
//        ThuongHieu th = (ThuongHieu) cbo_thuonghieu1.getSelectedItem();
//        KhuyenmaiViewmodel km = (KhuyenmaiViewmodel) cbo_khuyenmai.getSelectedItem();
//        int slt = Integer.parseInt(txt_soluongton.getText());
//        double gianhap = Double.parseDouble(_cSPViewModel.getGianhap());
//        double giaban = Double.parseDouble(_cSPViewModel.getGiaban());
//        String mota = _cSPViewModel.getMota();
//        String qrcode = "";
//
//        return new ChiTietSP(ma, ten, nsx.getTen(), ms.getTen(), dmsp.getTen(), kc.getTen(), cl.getTen(), th.getTen(), km.getTenKM(), slt, gianhap, giaban, mota, qrcode);
//    }
    public void clearForm() {
        txt_ma.setText("");
        txt_ten.setText("");
    }

//    public boolean check() {
//        if (txt_ma.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Bạn không đc để trống");
//            return false;
//        }
//        if (txt_ten.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Bạn không đc để trống");
//            return false;
//        }
//        
//        if (txt_soluongton.getText() == null) {
//            JOptionPane.showMessageDialog(this, "Bạn không đc để trống");
//            return false;
//        }
//        if (_cSPViewModel.getGianhap().equals("")) {
//            JOptionPane.showMessageDialog(this, "Bạn không đc để trống");
//            return false;
//        }
//        if (_cSPViewModel.getGiaban().equals("")) {
//            JOptionPane.showMessageDialog(this, "Bạn không đc để trống");
//            return false;
//        }
//        if (_cSPViewModel.getMota().equals("")) {
//            JOptionPane.showMessageDialog(this, "Bạn không đc để trống");
//            return false;
//        }
//        return true;
//    }
//
//    public int getId() {
//        Integer row = tbl_sp.getSelectedRow();
//        int id = (int) tbl_sp.getValueAt(row, 0);
//        return id;
//
//    }
}
