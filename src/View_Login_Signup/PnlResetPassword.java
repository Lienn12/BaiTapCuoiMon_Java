/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View_Login_Signup;

import Controllers.User_controller;
import Model.User_model;
import View_Main.Frm_Login_Signup;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lienn
 */
public class PnlResetPassword extends javax.swing.JPanel {
    private User_controller userController;
    private User_model userModel;
    private Frm_Login_Signup frmLoginSignup;
    public PnlForgotPassword pnlForgotPassword;
    public String email;
    public PnlResetPassword(Frm_Login_Signup frmLoginSignup) {
        this.frmLoginSignup = frmLoginSignup;
        userController = new User_controller(); 
        initComponents();
    }
    public void setUserModel(User_model userModel) {
        this.userModel = userModel; 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNew = new javax.swing.JPasswordField();
        txtConfirm = new javax.swing.JPasswordField();
        btnReset = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnBack = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lberrorNew = new javax.swing.JLabel();
        lberrorConfirm = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 153));
        jLabel1.setText("Reset password");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 153));
        jLabel2.setText("New password");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 153));
        jLabel3.setText("Confirm password");

        txtNew.setBorder(null);

        txtConfirm.setBorder(null);

        btnReset.setBackground(new java.awt.Color(51, 102, 153));
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("RESET");

        javax.swing.GroupLayout btnResetLayout = new javax.swing.GroupLayout(btnReset);
        btnReset.setLayout(btnResetLayout);
        btnResetLayout.setHorizontalGroup(
            btnResetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnResetLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        btnResetLayout.setVerticalGroup(
            btnResetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        btnBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bach48.png"))); // NOI18N
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(51, 102, 153));

        jSeparator2.setForeground(new java.awt.Color(51, 102, 153));

        lberrorNew.setForeground(new java.awt.Color(255, 51, 51));
        lberrorNew.setText("      ");

        lberrorConfirm.setForeground(new java.awt.Color(255, 51, 51));
        lberrorConfirm.setText("    ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 142, Short.MAX_VALUE)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator1)
                        .addComponent(txtConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                        .addComponent(jSeparator2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNew)
                        .addComponent(lberrorNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lberrorConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(jLabel1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btnBack)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(txtNew, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lberrorNew)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(txtConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lberrorConfirm)
                .addGap(18, 18, 18)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        frmLoginSignup.showPanel("Login");
    }//GEN-LAST:event_btnBackMouseClicked
     private static String passwordHash(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] rbt = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : rbt) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception ex) {
            Logger.getLogger(PnlLogin.class.getName()).log(Level.SEVERE, "Lỗi: " + ex.getMessage());
        }
        return null;
    }
    private boolean validateInputs(String password, String confirm){
        boolean valid=true;
        //ktr password
            if (password.trim().isEmpty()) {
                lberrorNew.setText("Vui lòng nhập mật khẩu mới.");
                valid = false;
            } else if (!userController.checkPassword(password)) {
                lberrorNew.setText("<html>Mật khẩu không hợp lệ.<br>Vui lòng nhập ít nhất 6 ký tự, bao gồm cả chữ, số và ký tự.</html>");
                valid = false;
            }
        //ktra confirm password
            if (confirm.trim().isEmpty()) {
                lberrorConfirm.setText("Xác nhận mật khẩu không được để trống.");
                valid = false;
            } else if (!userController.checkConfirmPassword(password, confirm)) {
                lberrorConfirm.setText("Xác nhận mật khẩu không khớp. Vui lòng nhập lại");
                valid = false;
            }
        return valid;
    }
    
    private void setNullError(){
        lberrorNew.setText("");
        lberrorConfirm.setText("");
    }
    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        try{
            String newPassword=passwordHash(txtNew.getText().trim());
            String confirm=passwordHash(txtConfirm.getText().trim());
            boolean valid=validateInputs(newPassword,confirm);
            if(valid){
                userController.ResetPassword(userModel.getEmail(), newPassword);
                JOptionPane.showMessageDialog(this, "Reset password thành công ");
                frmLoginSignup.showPanel("Login");
            }else{
                JOptionPane.showMessageDialog(this, "Reset password thất bại!!");
            }            
        }catch(Exception ex){
            Logger.getLogger(PnlVerifyCode.class.getName()).log(Level.SEVERE, "Lỗi: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnResetMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JPanel btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lberrorConfirm;
    private javax.swing.JLabel lberrorNew;
    private javax.swing.JPasswordField txtConfirm;
    private javax.swing.JPasswordField txtNew;
    // End of variables declaration//GEN-END:variables
}
