/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Voucher;
import repositorys.imp.VocherRepository;

/**
 *
 * @author FPTSHOP
 */
public class voucherQLY extends javax.swing.JPanel {
    
Voucher vc = new Voucher();
    private final VocherRepository dao = new VocherRepository();
    DefaultTableModel model = new DefaultTableModel(); 
    private List<Voucher> pggs = new ArrayList<>();
    Date date = new Date();
    public voucherQLY() {
        initComponents();
        init();
        pggs = dao.getAll();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtGiaTri = new javax.swing.JTextField();
        dateNgayBD = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        rdTien = new javax.swing.JRadioButton();
        rdPhanTram = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dateNgayKT = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtdieuKienGiam = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVoucher = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_capnhat = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        jLabel1.setText("Mã voucher");

        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        jTextField3.setText("Seach");

        jLabel7.setText("Ngày bắt đầu");

        dateNgayBD.setDateFormatString("yyyy-MM-dd");

        jLabel8.setText("Hình thức giảm");

        rdTien.setText("Tiền");

        rdPhanTram.setText("%");

        jLabel2.setText("Giá trị giảm");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Ngày bắt đầu");

        dateNgayKT.setDateFormatString("yyyy-MM-dd");

        jLabel5.setText("Điều kiện giảm");

        txtdieuKienGiam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdieuKienGiamActionPerformed(evt);
            }
        });

        jLabel3.setText("Ngày kết thúc");

        tblVoucher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Voucher", "Giá trị giảm", "Điều kiện giảm", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái"
            }
        ));
        tblVoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVoucherMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVoucher);

        jLabel6.setText("Ngày kết thúc");

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_capnhat.setText("Cập nhật");
        btn_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(113, 113, 113))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dateNgayKT, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addComponent(jLabel5)
                            .addComponent(txtdieuKienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(dateNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdTien)
                                .addGap(37, 37, 37)
                                .addComponent(rdPhanTram))
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextField2))))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_them)
                            .addComponent(btn_capnhat)
                            .addComponent(btnClear))
                        .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_them)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_capnhat))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdTien)
                            .addComponent(rdPhanTram)
                            .addComponent(btnClear))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdieuKienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void txtdieuKienGiamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdieuKienGiamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdieuKienGiamActionPerformed

    private void tblVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVoucherMouseClicked
        // TODO add your handling code here:
        int row = tblVoucher.getSelectedRow();
        showDetail(row);
    }//GEN-LAST:event_tblVoucherMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
          dateNgayKT.setDate(date);
        dateNgayBD.setDate(date);
        txtMa.setText("");
        txtGiaTri.setText("");
        txtdieuKienGiam.setText("");
        rdPhanTram.setSelected(true);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btn_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatActionPerformed
         int row = tblVoucher.getSelectedRow();
        String maVoucher = pggs.get(row).getMaVoucher();
        dao.Update(maVoucher, getForm());
        pggs = dao.getAll();
        loadTable();
    }//GEN-LAST:event_btn_capnhatActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
         dao.add(getForm());
        pggs = dao.getAll();
        loadTable();
    }//GEN-LAST:event_btn_themActionPerformed
private void init() {
  
        model = (DefaultTableModel) tblVoucher.getModel();
        loadTable();
//        if (tblVoucher.getRowCount() >= 0) {
//            tblVoucher.setRowSelectionInterval(0, 0);
//           showDetail();
//        }
    }

    private void showDetail(int viTri) {
        Voucher vc = pggs.get(viTri);
        txtMa.setText(vc.getMaVoucher());
        txtGiaTri.setText(String.valueOf(vc.getSoLuongGiam()));
        dateNgayBD.setDate(new Date(vc.getNgayBatDau().getTime()));
        dateNgayKT.setDate(new Date(vc.getNgayKetThuc().getTime()));
        txtdieuKienGiam.setText(String.valueOf(vc.getDieuKienGiam()));
        boolean trangThai = vc.isTrangThai();
        if (trangThai == true) {
            rdPhanTram.setSelected(true);
        }else{
            rdTien.setSelected(true);
        }
    }
    
    
    private void loadTable() {

        model.setRowCount(0);
        List<Voucher> list = dao.getAll();
        for (Voucher voucher : list) {
            model.addRow(new Object[]{
                voucher.getMaVoucher(),
                voucher.getSoLuongGiam(),
                voucher.getDieuKienGiam(),
                voucher.getNgayBatDau(),
                voucher.getNgayKetThuc(),
                voucher.isTrangThai()? "Phần trăm" :"Tiền"
            });
        }
    }
    
    public boolean validates() {
        return true;
    }
    
    

    private Voucher getForm() {
        Voucher cd = new Voucher();
        String maVocher = txtMa.getText();
        Date ngayBD = dateNgayBD.getDate();
        Date ngatKT = dateNgayKT.getDate();
        String giaTrigiam = txtGiaTri.getText();
        boolean trangThai = rdPhanTram.isSelected();
        String dieuKienGiam = txtdieuKienGiam.getText();
        try {
            BigDecimal DieuKienBigDecimal = new BigDecimal(dieuKienGiam);
            cd.setDieuKienGiam(DieuKienBigDecimal);
        } catch (Exception e) {
            e.printStackTrace();
        }   
        cd.setMaVoucher(maVocher);
        cd.setNgayBatDau(new java.sql.Date(ngayBD.getTime()));
        cd.setNgayKetThuc(new java.sql.Date(ngatKT.getTime()));
        cd.setSoLuongGiam(Integer.valueOf(giaTrigiam));
        cd.setTrangThai(trangThai);
        
        return cd;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btn_capnhat;
    private javax.swing.JButton btn_them;
    private com.toedter.calendar.JDateChooser dateNgayBD;
    private com.toedter.calendar.JDateChooser dateNgayKT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JRadioButton rdPhanTram;
    private javax.swing.JRadioButton rdTien;
    private javax.swing.JTable tblVoucher;
    private javax.swing.JTextField txtGiaTri;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtdieuKienGiam;
    // End of variables declaration//GEN-END:variables
}
