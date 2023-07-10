/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bar.view;

import com.bar.dao.TaiKhoanDAO;
import com.bar.model.TaiKhoan;
import com.bar.util.Auth;
import com.bar.util.MsgBox;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author PHUOCTAI
 */
public class ChangePass extends javax.swing.JFrame {

    boolean hideAndShow1 = true;
    boolean hideAndShow2 = true;
    boolean hideAndShow3 = true;
    List<TaiKhoan> listTK = new ArrayList<TaiKhoan>();
    TaiKhoanDAO tkDao = new TaiKhoanDAO();

    public ChangePass() {
        initComponents();
        txtTenDangNhap.setText(Auth.userName());
        txtTenDangNhap.setEditable(false);
        txtPassHienTai.setEchoChar('\u25cf');
        txtPassMoi.setEchoChar('\u25cf');
        txtConfirmPassMoi.setEchoChar('\u25cf');
        this.changeIcon();
    }
    ImageIcon icon;

    public void changeIcon() {
        icon = new ImageIcon(this.getClass().getResource("images/DEjavu_LoGo_App.png"));
        this.setIconImage(icon.getImage());
    }

    private void changePassword() {
        String user = txtTenDangNhap.getText();
        String passCurrent = String.valueOf(txtPassHienTai.getPassword());
        String passNew = String.valueOf(txtPassMoi.getPassword());
        String comfirmPass = String.valueOf(txtConfirmPassMoi.getPassword());

        if (!comfirmPass.equals(passNew)) {
            MsgBox.alert(this, "Vui lòng xác nhận lại mật khẩu ");
            return;
        }

        try {
            if (!user.equalsIgnoreCase(Auth.account.getTenTaiKhoan())) {
                MsgBox.alert(this, "Tên đăng nhập không đúng. Vui lòng kiểm tra lại ");
            } else if (!passCurrent.equalsIgnoreCase(Auth.account.getMatKhau())) {
                MsgBox.alert(this, "Mật khẩu không đúng. Vui lòng kiểm tra lại ");
            } else {
                Auth.account.setMatKhau(passNew);
                tkDao.update_Pass(Auth.account);
                MsgBox.alert(this, "Thay đổi mật khẩu thành công ");
                returnHome();
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Thay đổi mật khẩu thất bại. Vui lòng thử lại sau ");

        }

    }

    private boolean checkNull() {
        String user = txtTenDangNhap.getText();
        String passCurrent = String.valueOf(txtPassHienTai.getPassword());
        String passNew = String.valueOf(txtPassMoi.getPassword());
        String comfirmPass = String.valueOf(txtConfirmPassMoi.getPassword());
        StringBuilder sb = new StringBuilder();

        boolean isNotNull = true;
        if (user.equals("")) {
            sb.append("Vui lòng nhập tên đăng nhập\n");
        }
        if (passCurrent.equals("")) {
            sb.append("Vui lòng nhập mật khẩu hiện tại\n");
        }
        if (passNew.equals("")) {
            sb.append("Vui lòng nhập mật khẩu mới\n");

        }
        if (comfirmPass.equals("")) {
            sb.append("Vui lòng xác nhận mật khẩu");
        }

        if (sb.length() > 0) {
            MsgBox.alert(this, sb.toString());
            isNotNull = false;
        }
        return isNotNull;
    }

    private void returnHome() throws HeadlessException {
        String[] languages = {"Có, Trở về", "Không, Thoát"};
        int options = JOptionPane.showOptionDialog(this, "Bạn có muốn quay về Trang chủ ?", "Quán Bar Dejavu", 0, JOptionPane.QUESTION_MESSAGE, null, languages, "Có, Trở về");

        System.out.println(options);
        if (options == 0) {
            new MainDejavu().setVisible(true);
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            this.dispose();
        } else if (options == -1) {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        } else {
            this.dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnShowConfirm = new javax.swing.JButton();
        txtConfirmPassMoi = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        btnShowNew = new javax.swing.JButton();
        txtPassMoi = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        btnShowCurrent = new javax.swing.JButton();
        txtPassHienTai = new javax.swing.JPasswordField();
        pnlDoiMatKhau = new RoundedPanel(50);
        lblDoiMatKhau = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(6, 40, 61));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐỔI MẬT KHẨU");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 277, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên đăng nhập");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 180, 30));

        txtTenDangNhap.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTenDangNhap.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));
        txtTenDangNhap.setSelectedTextColor(new java.awt.Color(255, 0, 102));
        txtTenDangNhap.setSelectionColor(new java.awt.Color(255, 0, 102));
        jPanel1.add(txtTenDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 360, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mật khẩu hiện tại");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 200, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mật khẩu mới");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 170, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Xác nhận mật khẩu mới");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 250, 30));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.BorderLayout());

        btnShowConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bar/view/images/show.png"))); // NOI18N
        btnShowConfirm.setBorder(null);
        btnShowConfirm.setBorderPainted(false);
        btnShowConfirm.setContentAreaFilled(false);
        btnShowConfirm.setDefaultCapable(false);
        btnShowConfirm.setFocusPainted(false);
        btnShowConfirm.setPreferredSize(new java.awt.Dimension(50, 18));
        btnShowConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowConfirmActionPerformed(evt);
            }
        });
        jPanel6.add(btnShowConfirm, java.awt.BorderLayout.LINE_END);

        txtConfirmPassMoi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtConfirmPassMoi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));
        txtConfirmPassMoi.setFocusCycleRoot(true);
        txtConfirmPassMoi.setMargin(new java.awt.Insets(2, 5, 2, 2));
        jPanel6.add(txtConfirmPassMoi, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 365, 360, 40));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.BorderLayout());

        btnShowNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bar/view/images/show.png"))); // NOI18N
        btnShowNew.setBorder(null);
        btnShowNew.setBorderPainted(false);
        btnShowNew.setContentAreaFilled(false);
        btnShowNew.setDefaultCapable(false);
        btnShowNew.setFocusPainted(false);
        btnShowNew.setPreferredSize(new java.awt.Dimension(50, 18));
        btnShowNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowNewActionPerformed(evt);
            }
        });
        jPanel5.add(btnShowNew, java.awt.BorderLayout.LINE_END);

        txtPassMoi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPassMoi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));
        txtPassMoi.setFocusCycleRoot(true);
        txtPassMoi.setMargin(new java.awt.Insets(2, 5, 2, 2));
        jPanel5.add(txtPassMoi, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 285, 360, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());

        btnShowCurrent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bar/view/images/show.png"))); // NOI18N
        btnShowCurrent.setBorder(null);
        btnShowCurrent.setBorderPainted(false);
        btnShowCurrent.setContentAreaFilled(false);
        btnShowCurrent.setDefaultCapable(false);
        btnShowCurrent.setFocusPainted(false);
        btnShowCurrent.setPreferredSize(new java.awt.Dimension(50, 18));
        btnShowCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowCurrentActionPerformed(evt);
            }
        });
        jPanel4.add(btnShowCurrent, java.awt.BorderLayout.LINE_END);

        txtPassHienTai.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPassHienTai.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));
        txtPassHienTai.setFocusCycleRoot(true);
        txtPassHienTai.setMargin(new java.awt.Insets(2, 5, 2, 2));
        jPanel4.add(txtPassHienTai, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 205, 360, 40));

        pnlDoiMatKhau.setOpaque(false);
        pnlDoiMatKhau.setBackground(new java.awt.Color(191, 151, 66));
        pnlDoiMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        pnlDoiMatKhau.setLayout(new java.awt.BorderLayout());

        lblDoiMatKhau.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDoiMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        lblDoiMatKhau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoiMatKhau.setText("ĐỔI MẬT KHẨU");
        lblDoiMatKhau.setToolTipText("");
        lblDoiMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDoiMatKhauMouseClicked(evt);
            }
        });
        pnlDoiMatKhau.add(lblDoiMatKhau, java.awt.BorderLayout.CENTER);

        jPanel1.add(pnlDoiMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 220, 60));

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(40, 40, 40));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 600));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bar/view/images/DEjavu (2).png"))); // NOI18N
        jPanel2.add(jLabel4, java.awt.BorderLayout.CENTER);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bar/images/DEJAVU SHOP_1.png"))); // NOI18N
        jPanel2.add(jLabel5, java.awt.BorderLayout.PAGE_START);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("© 2022. All Rights Reserved. Dejavu     ");
        jLabel8.setPreferredSize(new java.awt.Dimension(229, 40));
        jPanel2.add(jLabel8, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowCurrentActionPerformed
        showAndHidePass(txtPassHienTai, btnShowCurrent);
    }//GEN-LAST:event_btnShowCurrentActionPerformed

    private void btnShowNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowNewActionPerformed
        showAndHidePass2(txtPassMoi, btnShowNew);
    }//GEN-LAST:event_btnShowNewActionPerformed

    private void btnShowConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowConfirmActionPerformed
        showAndHidePass3(txtConfirmPassMoi, btnShowConfirm);
    }//GEN-LAST:event_btnShowConfirmActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        returnHome();
    }//GEN-LAST:event_formWindowClosing

    private void lblDoiMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDoiMatKhauMouseClicked
        if (checkNull()) {
            changePassword();
        }
    }//GEN-LAST:event_lblDoiMatKhauMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnShowConfirm;
    private javax.swing.JButton btnShowCurrent;
    private javax.swing.JButton btnShowNew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblDoiMatKhau;
    private javax.swing.JPanel pnlDoiMatKhau;
    private javax.swing.JPasswordField txtConfirmPassMoi;
    private javax.swing.JPasswordField txtPassHienTai;
    private javax.swing.JPasswordField txtPassMoi;
    private javax.swing.JTextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables

    void showPass(JPasswordField pass, JButton btn) {
        btn.setIcon(new ImageIcon(this.getClass().getResource("images/dontshow.png")));
        pass.setEchoChar((char) 0);
    }

    void hidePass(JPasswordField pass, JButton btn) {
        btn.setIcon(new ImageIcon(this.getClass().getResource("images/show.png")));
        pass.setEchoChar('\u25cf');
    }

    void showAndHidePass(JPasswordField pass, JButton btn) {
        if (pass.getPassword().length <= 0) {
            return;
        } else {
            if (hideAndShow1) {
                showPass(pass, btn);
                hideAndShow1 = false;
            } else {
                hidePass(pass, btn);
                hideAndShow1 = true;
            }
        }
    }

    void showAndHidePass2(JPasswordField pass, JButton btn) {
        if (pass.getPassword().length <= 0) {
            return;
        } else {
            if (hideAndShow2) {
                showPass(pass, btn);
                hideAndShow2 = false;
            } else {
                hidePass(pass, btn);
                hideAndShow2 = true;
            }
        }
    }

    void showAndHidePass3(JPasswordField pass, JButton btn) {
        if (pass.getPassword().length <= 0) {
            return;
        } else {
            if (hideAndShow3) {
                showPass(pass, btn);
                hideAndShow3 = false;
            } else {
                hidePass(pass, btn);
                hideAndShow3 = true;
            }
        }
    }

}
