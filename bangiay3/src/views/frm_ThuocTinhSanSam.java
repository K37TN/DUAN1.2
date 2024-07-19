/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.ChatLieu;
import models.DanhMucSP;
import models.KhuyenMai;
import models.KichCo;
import models.MauSac;
import models.NSX;
import models.ThuongHieu;
import models.Voucher;
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

/**
 *
 * @author long
 */
public class frm_ThuocTinhSanSam extends javax.swing.JFrame {

    /**
     * Creates new form frm_ThuocTinhSanSam
     */
    private ChiTietSPViewModel chiTietSPViewModel = new ChiTietSPViewModel();

    public void setChiTietSPViewModel(ChiTietSPViewModel chiTietSPViewModel) {
        this.chiTietSPViewModel = chiTietSPViewModel;
    }

    public ChiTietSPViewModel getChiTietSPViewModel() {
        return chiTietSPViewModel;
    }

    private IChiTietSPServices iChiTietSPServices;
    private INSXServices iNSXServices;
    private IMauSacServices iMauSacServices;
    private IDanhMucSPServices iDanhMucSPServices;
    private IKichCoServices iKichCoServices;
    private IChatLieuServices iChatLieuServices;
    private IThuongHieuServices iThuongHieuServices;
    private IKhuyenmaiService iKhuyenmaiService;

    private String _maSp;
    private String _tenSp;

    public frm_ThuocTinhSanSam(ChiTietSPViewModel chiTietSPViewModel) {
        initComponents();
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        iChiTietSPServices = new ChiTietSPServices();
        iNSXServices = new NSXServices();
        iMauSacServices = new MauSacServices();
        iDanhMucSPServices = new DanhMucSPServices();
        iKichCoServices = new KichCoServices();
        iChatLieuServices = new ChatLieuServices();
        iThuongHieuServices = new ThuongHieuServices();
        iKhuyenmaiService = new KhuyenmaiService();
        _maSp = chiTietSPViewModel.getMa();
        _tenSp = chiTietSPViewModel.getTen();
        chiTietSPViewModel.setMa(chiTietSPViewModel.getMa());
        chiTietSPViewModel.setTen(chiTietSPViewModel.getTen());
        initcbo();
//        cbo_nsx.setSelectedIndex(getindexnsx(chiTietSPViewModel));
//        cbo_chatlieu.setSelectedIndex(getindexchatlieu(chiTietSPViewModel));
//        cbo_danhmuc.setSelectedIndex(getindexdanhmuc(chiTietSPViewModel));
//        cbo_mausac.setSelectedIndex(getindexmausac(chiTietSPViewModel));
//        cbo_size.setSelectedIndex(getindexsize(chiTietSPViewModel));
//        cbo_thuonghieu1.setSelectedIndex(getindexthuonghieu(chiTietSPViewModel));
//        txt_giaban.setText(chiTietSPViewModel.getGiaban().toString());
//        txt_gianhap.setText(chiTietSPViewModel.getGiaban().toString());
//        txt_mota.setText(chiTietSPViewModel.getMota());
//        txt_soluongton.setText(String.valueOf(chiTietSPViewModel.getSoluongton()));
        cbSetData(chiTietSPViewModel);
    }

    private void cbSetData(ChiTietSPViewModel ctspvm) {
        if (ctspvm.getChatlieu() == null) {
            cbo_nsx.setSelectedIndex(1);
            cbo_chatlieu.setSelectedIndex(1);
            cbo_danhmuc.setSelectedIndex(1);
            cbo_mausac.setSelectedIndex(1);
            cbo_size.setSelectedIndex(1);
            cbo_thuonghieu1.setSelectedIndex(1);
            txt_giaban.setText("");
            txt_gianhap.setText("");
            txt_mota.setText("");
            txt_soluongton.setText("");
        } else {
            cbo_nsx.setSelectedIndex(getindexnsx(ctspvm));
            cbo_chatlieu.setSelectedIndex(getindexchatlieu(ctspvm));
            cbo_danhmuc.setSelectedIndex(getindexdanhmuc(ctspvm));
            cbo_mausac.setSelectedIndex(getindexmausac(ctspvm));
            cbo_size.setSelectedIndex(getindexsize(ctspvm));
            cbo_thuonghieu1.setSelectedIndex(getindexthuonghieu(ctspvm));
            txt_giaban.setText(ctspvm.getGiaban().toString());
            txt_gianhap.setText(ctspvm.getGiaban().toString());
            txt_mota.setText(ctspvm.getMota());
            txt_soluongton.setText(String.valueOf(ctspvm.getSoluongton()));
        }
    }

    public void initcbo() {
        List<NSX> listnsx = iNSXServices.getAll();
        cbo_nsx.setModel(new DefaultComboBoxModel(listnsx.toArray()));

        List<MauSac> listms = iMauSacServices.getAll();
        cbo_mausac.setModel(new DefaultComboBoxModel(listms.toArray()));

        List<DanhMucSP> listdmsp = iDanhMucSPServices.getAll();
        cbo_danhmuc.setModel(new DefaultComboBoxModel(listdmsp.toArray()));

        List<KichCo> listkc = iKichCoServices.getAll();
        cbo_size.setModel(new DefaultComboBoxModel(listkc.toArray()));

        List<ChatLieu> listcl = iChatLieuServices.getAll();
        cbo_chatlieu.setModel(new DefaultComboBoxModel(listcl.toArray()));

        List<ThuongHieu> listth = iThuongHieuServices.getAll();
        cbo_thuonghieu1.setModel(new DefaultComboBoxModel(listth.toArray()));

    }

    private int getindexmausac(ChiTietSPViewModel x) {
        List<MauSac> lst = iMauSacServices.getAll();
        int index = -1;
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).getId() == x.getMausac().getId()) {
                index = i;
            }
        }
        return index;
    }

//    private void xuatbarcode(ChiTietSPViewModel x) {
//        System.out.println(x.toString());
//        try {
//            Linear barcode = new Linear();
//            barcode.setType(Linear.CODE128B);
//            barcode.setData(x.getQrcode());
//            barcode.setI(11.0f);
//            barcode.renderBarcode("D:\\QRcode\\" + x.getTen() + ".png");
//            System.out.println("xuất thành công");
//        } catch (Exception e) {
//            System.out.println("xuất thất bại");
//        }
//    }
//    public static void generateQRcode(String data, String path, Map map, int h, int w) {
//        try {
//            BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes("UTF-8"), "UTF-8"), BarcodeFormat.QR_CODE, w, h);
//            MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));
//        } catch (Exception ex) {
//            Logger.getLogger(frm_Sanpham.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
    private int getindexnsx(ChiTietSPViewModel x) {
        List<NSX> lst = iNSXServices.getAll();
        int index = -1;
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).getId() == x.getNsx().getId()) {
                index = i;
            }
        }
        return index;
    }

    private int getindexdanhmuc(ChiTietSPViewModel x) {
        List<DanhMucSP> lst = iDanhMucSPServices.getAll();
        int index = -1;
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).getId() == x.getDanhmuc().getId()) {
                index = i;
            }
        }
        return index;
    }

    private int getindexsize(ChiTietSPViewModel x) {
        List<KichCo> lst = iKichCoServices.getAll();
        int index = -1;
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).getId() == x.getKichco().getId()) {
                index = i;
            }
        }
        return index;
    }

    private int getindexthuonghieu(ChiTietSPViewModel x) {
        List<ThuongHieu> lst = iThuongHieuServices.getAll();
        int index = -1;
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).getId() == x.getThuonghieu().getId()) {
                index = i;
            }
        }
        return index;
    }

    private int getindexchatlieu(ChiTietSPViewModel x) {
        List<ChatLieu> lst = iChatLieuServices.getAll();
        int index = -1;
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).getId() == x.getChatlieu().getId()) {
                index = i;
            }
        }
        return index;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new swing.PanelBorder();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_soluongton = new swing.MyTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_gianhap = new swing.MyTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_giaban = new swing.MyTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_mota = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        cbo_nsx = new javax.swing.JComboBox<>();
        cbo_mausac = new javax.swing.JComboBox<>();
        cbo_danhmuc = new javax.swing.JComboBox<>();
        cbo_size = new javax.swing.JComboBox<>();
        cbo_chatlieu = new javax.swing.JComboBox<>();
        cbo_thuonghieu1 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        btn_capnhat = new swing.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(780, 372));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        panelBorder1.setBackground(new java.awt.Color(242, 242, 242));

        jLabel3.setText("Nhà sản xuất");
        panelBorder1.add(jLabel3);
        jLabel3.setBounds(30, 10, 210, 20);

        jLabel4.setText("Màu sắc");
        panelBorder1.add(jLabel4);
        jLabel4.setBounds(30, 90, 210, 20);

        jLabel5.setText("Danh mục");
        panelBorder1.add(jLabel5);
        jLabel5.setBounds(30, 170, 210, 20);

        jLabel6.setText("Size");
        panelBorder1.add(jLabel6);
        jLabel6.setBounds(30, 250, 210, 20);

        jLabel7.setText("Chất liệu");
        panelBorder1.add(jLabel7);
        jLabel7.setBounds(270, 10, 210, 20);

        jLabel8.setText("Thương hiệu");
        panelBorder1.add(jLabel8);
        jLabel8.setBounds(270, 90, 210, 20);
        panelBorder1.add(txt_soluongton);
        txt_soluongton.setBounds(270, 190, 210, 40);

        jLabel10.setText("Số lượng tồn");
        panelBorder1.add(jLabel10);
        jLabel10.setBounds(270, 170, 210, 20);
        panelBorder1.add(txt_gianhap);
        txt_gianhap.setBounds(270, 270, 210, 40);

        jLabel11.setText("Giá nhập");
        panelBorder1.add(jLabel11);
        jLabel11.setBounds(270, 250, 210, 20);
        panelBorder1.add(txt_giaban);
        txt_giaban.setBounds(520, 70, 210, 40);

        jLabel12.setText("Mô tả");
        panelBorder1.add(jLabel12);
        jLabel12.setBounds(520, 140, 220, 20);

        txt_mota.setColumns(20);
        txt_mota.setRows(2);
        txt_mota.setTabSize(0);
        txt_mota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jScrollPane4.setViewportView(txt_mota);

        panelBorder1.add(jScrollPane4);
        jScrollPane4.setBounds(520, 160, 220, 70);

        jLabel13.setText("Giá bán");
        panelBorder1.add(jLabel13);
        jLabel13.setBounds(520, 50, 210, 20);

        cbo_nsx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_nsx.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        panelBorder1.add(cbo_nsx);
        cbo_nsx.setBounds(30, 30, 210, 40);

        cbo_mausac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_mausac.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        panelBorder1.add(cbo_mausac);
        cbo_mausac.setBounds(30, 110, 210, 40);

        cbo_danhmuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_danhmuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        panelBorder1.add(cbo_danhmuc);
        cbo_danhmuc.setBounds(30, 190, 210, 40);

        cbo_size.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_size.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        panelBorder1.add(cbo_size);
        cbo_size.setBounds(30, 270, 210, 40);

        cbo_chatlieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_chatlieu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        panelBorder1.add(cbo_chatlieu);
        cbo_chatlieu.setBounds(270, 30, 210, 40);

        cbo_thuonghieu1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_thuonghieu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        panelBorder1.add(cbo_thuonghieu1);
        cbo_thuonghieu1.setBounds(270, 110, 210, 40);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-page.png"))); // NOI18N
        jLabel15.setText("Thêm Mới Thuộc Tính");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        panelBorder1.add(jLabel15);
        jLabel15.setBounds(580, 10, 170, 30);

        btn_capnhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/floppy-disk.png"))); // NOI18N
        btn_capnhat.setText("Hoàn Tất");
        btn_capnhat.setColor(new java.awt.Color(255, 255, 255));
        btn_capnhat.setColorOver(new java.awt.Color(204, 204, 204));
        btn_capnhat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(590, Short.MAX_VALUE)
                .addComponent(btn_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(225, 225, 225)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(275, Short.MAX_VALUE)
                .addComponent(btn_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private ChiTietSPViewModel getdadtafrom() {
        Pattern p = Pattern.compile("^[0-9]+$");
// Số lượng tồn
        if (txt_soluongton.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập số lượng tồn!");
            return null;
        }

        try {
            Integer.valueOf(txt_soluongton.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng tồn phải là số!");
            return null;
        }

        if (Integer.valueOf(txt_soluongton.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Số lượng tồn phải lớn hơn 0!");
            return null;
        }
// giá nhập

        if (txt_gianhap.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập giá nhập!");
            return null;
        }

        try {
            Double.valueOf(txt_gianhap.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá nhập phải là số!");
            return null;
        }

        if (Double.valueOf(txt_gianhap.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Giá nhập phải lớn hơn 0!");
            return null;
        }
// giá bán
        if (txt_giaban.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập giá bán!");
            return null;
        }

        try {
            Double.valueOf(txt_giaban.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá bán phải là số!");
            return null;
        }

        if (Double.valueOf(txt_giaban.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Giá bán phải lớn hơn 0!");
            return null;
        }
///////////////
        String mota = txt_mota.getText();
        if (txt_mota.getText().equals("")) {
            mota = "không có";
        }
        NSX nsx = (NSX) cbo_nsx.getSelectedItem();
        DanhMucSP danhmuc = (DanhMucSP) cbo_danhmuc.getSelectedItem();
        MauSac mausac = (MauSac) cbo_mausac.getSelectedItem();
        ChatLieu chatlieu = (ChatLieu) cbo_chatlieu.getSelectedItem();
        ThuongHieu thuonghieu = (ThuongHieu) cbo_thuonghieu1.getSelectedItem();
        KichCo kichco = (KichCo) cbo_size.getSelectedItem();
        double gianhap;
        double giaban;
        int soluong;
        try {
            gianhap = Double.parseDouble(txt_gianhap.getText());
            giaban = Double.parseDouble(txt_giaban.getText());
            soluong = Integer.parseInt(txt_soluongton.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "lỗi");
        }
        gianhap = Double.parseDouble(txt_gianhap.getText());
        giaban = Double.parseDouble(txt_giaban.getText());
        soluong = Integer.parseInt(txt_soluongton.getText());
        ChiTietSPViewModel ctsp = new ChiTietSPViewModel(_maSp, _tenSp, nsx, mausac, danhmuc, kichco, chatlieu, thuonghieu, null, soluong, gianhap, giaban, mota);
        return ctsp;
    }

    private void btn_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatActionPerformed

        ChiTietSPViewModel x = getdadtafrom();
        if (x == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thuộc tính sản phẩm!");
            return;
        }
        chiTietSPViewModel.setChatlieu(x.getChatlieu());
        chiTietSPViewModel.setDanhmuc(x.getDanhmuc());
        chiTietSPViewModel.setGiaban(x.getGiaban());
        chiTietSPViewModel.setGianhap(x.getGianhap());
        chiTietSPViewModel.setKhuyenmai(x.getKhuyenmai());
        chiTietSPViewModel.setKichco(x.getKichco());
        chiTietSPViewModel.setMausac(x.getMausac());
        chiTietSPViewModel.setMota(x.getMota());
        chiTietSPViewModel.setNsx(x.getNsx());
        chiTietSPViewModel.setSoluongton(x.getSoluongton());
        chiTietSPViewModel.setThuonghieu(x.getThuonghieu());
//        int chon = JOptionPane.showConfirmDialog(this, "Bạn Có chắc muốn cập nhật lại sản phẩm ?", "Update", JOptionPane.YES_NO_OPTION);
//        if (chon == JOptionPane.YES_OPTION) {
//            boolean kq = iChiTietSPServices.Update(_maSp, x);
//            if (kq == true) {
//                JOptionPane.showMessageDialog(this, "Thành công", "Update", JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                JOptionPane.showMessageDialog(this, "Thất bại", "Update", JOptionPane.INFORMATION_MESSAGE);
//            }
//
//        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Đóng form
        dispose();
    }//GEN-LAST:event_btn_capnhatActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        frm_themthuoctinh fttt = new frm_themthuoctinh(new javax.swing.JFrame(), true);
        fttt.setVisible(true);
        fttt.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Truy cập đối tượng ChiTietSPViewModel từ ChildFrame sau khi nó đóng
                initcbo();
                // Xử lý dữ liệu ở đây
            }
        });
    }//GEN-LAST:event_jLabel15MouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(frm_ThuocTinhSanSam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frm_ThuocTinhSanSam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frm_ThuocTinhSanSam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frm_ThuocTinhSanSam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frm_ThuocTinhSanSam().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton btn_capnhat;
    private javax.swing.JComboBox<String> cbo_chatlieu;
    private javax.swing.JComboBox<String> cbo_danhmuc;
    private javax.swing.JComboBox<String> cbo_mausac;
    private javax.swing.JComboBox<String> cbo_nsx;
    private javax.swing.JComboBox<String> cbo_size;
    private javax.swing.JComboBox<String> cbo_thuonghieu1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane4;
    private swing.PanelBorder panelBorder1;
    private swing.MyTextField txt_giaban;
    private swing.MyTextField txt_gianhap;
    private javax.swing.JTextArea txt_mota;
    private swing.MyTextField txt_soluongton;
    // End of variables declaration//GEN-END:variables

}
