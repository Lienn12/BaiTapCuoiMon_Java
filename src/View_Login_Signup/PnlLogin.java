/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View_Login_Signup;

import View_Main.FrmTrangchu;
import Controllers.Admin_controller;
import View_Login_Signup.PnlSignup;
import View_Main.Frm_Login_Signup;
import Controllers.User_controller;
import Model.Admin_model;
import Model.User_model;
import java.awt.event.*;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author lienn
 */
public class PnlLogin extends javax.swing.JPanel {
    private Frm_Login_Signup frmLoginSignup;
    private User_controller userController;
    private FrmTrangchu frmTrangchu;
    private User_model userModel;
    private Admin_model adminModel;
    private Admin_controller adminController;
    public PnlLogin(Frm_Login_Signup frmLoginSignup) {
        this.frmLoginSignup = frmLoginSignup;
        initComponents();
        init();
        initEnterKeyListeners();
    }
    public void init(){
        userController = new User_controller();
        userModel=new User_model();
        frmTrangchu= new FrmTrangchu();
        adminController= new Admin_controller();
        adminModel = new Admin_model();
        lbshowPass.setVisible(false);
        lbhidePass.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbshowPass = new javax.swing.JLabel();
        lbhidePass = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        lbSignup = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        lberrorUsername = new javax.swing.JLabel();
        lberrorPass = new javax.swing.JLabel();
        lbForgot = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(16, 16));

        lbshowPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbshowPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/view.png"))); // NOI18N
        lbshowPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbhidePass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbhidePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hide.png"))); // NOI18N
        lbhidePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbhidePassMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbhidePassMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbhidePass)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbshowPass)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbhidePass)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbshowPass)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 153));
        jLabel1.setText("Welcome back");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 153));
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 153));
        jLabel3.setText("Password");

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtUsername.setBorder(null);

        btnLogin.setBackground(new java.awt.Color(51, 102, 153));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("LOGIN");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(51, 102, 153));

        jSeparator2.setForeground(new java.awt.Color(51, 102, 153));

        jLabel4.setForeground(new java.awt.Color(51, 102, 153));
        jLabel4.setText("Have not account yet?");

        lbSignup.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSignup.setForeground(new java.awt.Color(51, 102, 153));
        lbSignup.setText("Sign up");
        lbSignup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSignup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSignupMouseClicked(evt);
            }
        });

        txtPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPass.setBorder(null);

        lberrorUsername.setForeground(new java.awt.Color(255, 0, 0));
        lberrorUsername.setText("                 ");

        lberrorPass.setForeground(new java.awt.Color(255, 0, 0));
        lberrorPass.setText("                          ");

        lbForgot.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbForgot.setForeground(new java.awt.Color(51, 102, 153));
        lbForgot.setText("Forgot password?");
        lbForgot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbForgot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbForgotMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbForgot)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator2)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(jLabel1))
                        .addComponent(jSeparator1)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbSignup))
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtUsername)
                        .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lberrorUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lberrorPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lberrorUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lberrorPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbForgot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbSignup))
                .addContainerGap(52, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void initEnterKeyListeners(){
        txtUsername.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent evt){
                if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                    txtPass.requestFocus();
                }
            }
        });
        txtPass.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent evt){
                if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                    btnLogin.doClick();
                }
            }
        });
        
    }
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
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        try{
            String username = txtUsername.getText().trim();
            String password = passwordHash(txtPass.getText()).trim();
            
            adminModel.setUsername(username);
            userModel.setUsername(username);
            if(username.isEmpty() || password.isEmpty()){
                 lberrorUsername.setText(username.isEmpty() ? "Username không được để trống" : "");
                 lberrorPass.setText(password.isEmpty() ? "Password không được để trống" : "");
                 return;
            }else{
                if(userController.CheckLoginUser(userModel, password)){
                    JOptionPane.showMessageDialog(this,"Đăng nhập thành công");
                }else 
                    if(adminController.CheckLoginAdmin(adminModel, password)){
                     JOptionPane.showMessageDialog(this,"Đăng nhập thành công");
                     frmTrangchu.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(this,"Usernam hoặc password không chính xác!!");
                }
            }
            
        }catch(Exception ex){
            Logger.getLogger(PnlLogin.class.getName()).log(Level.SEVERE,"Loi"+ex.getMessage());
        }    
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lbSignupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSignupMouseClicked
        frmLoginSignup.showPanel("Signup");
    }//GEN-LAST:event_lbSignupMouseClicked

    private void lbhidePassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbhidePassMousePressed
        lbhidePass.setVisible(false);
        lbshowPass.setVisible(true);
        txtPass.setEchoChar((char)0);
    }//GEN-LAST:event_lbhidePassMousePressed

    private void lbhidePassMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbhidePassMouseReleased
        lbhidePass.setVisible(true);
        lbshowPass.setVisible(false);
        txtPass.setEchoChar('*');
    }//GEN-LAST:event_lbhidePassMouseReleased

    private void lbForgotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbForgotMouseClicked
        frmLoginSignup.showPanel("Forgot");
        
    }//GEN-LAST:event_lbForgotMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbForgot;
    private javax.swing.JLabel lbSignup;
    private javax.swing.JLabel lberrorPass;
    private javax.swing.JLabel lberrorUsername;
    private javax.swing.JLabel lbhidePass;
    private javax.swing.JLabel lbshowPass;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
