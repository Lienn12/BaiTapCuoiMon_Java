/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View_Login_Signup;

import Controllers.Email_controller;
import View_Main.Frm_Login_Signup;
import View_Main.frmMain;
import java.awt.*;
import Controllers.User_controller;
import Model.Message_model;
import Model.User_model;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class PnlVerifyCode extends javax.swing.JPanel {
    private User_controller userController;
    private User_model userModel;
    private PnlSignup pnlSignup;
    private Frm_Login_Signup frmMain;
    public PnlVerifyCode() {
        initComponents(); 
        userController= new User_controller();
        userModel= new User_model();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(50,50,50,50)); // Màu xanh dương với độ trong suốt 50%
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public void setUserModel(User_model userModel) {
        this.userModel = userModel;
    }
    public void setPnlSignup(PnlSignup pnlSignup) {
        this.pnlSignup = pnlSignup;
    }
    @Override
    public void setVisible(boolean bln){
        super.setVisible(bln);
        if(bln){
            txtCode.grabFocus();
            txtCode.setText("");
        }
    }
    public String getInputCode(){
        return txtCode.getText().trim();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlVerify = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();

        setBackground(new java.awt.Color(50, 50, 50));
        setOpaque(false);

        pnlVerify.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 153));
        jLabel1.setText("Verify Code");

        jLabel2.setForeground(new java.awt.Color(51, 102, 153));
        jLabel2.setText("Check your email to get verify code");

        txtCode.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCode.setForeground(new java.awt.Color(51, 102, 153));
        txtCode.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnCancel.setForeground(new java.awt.Color(51, 102, 153));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnOK.setBackground(new java.awt.Color(51, 102, 153));
        btnOK.setForeground(new java.awt.Color(255, 255, 255));
        btnOK.setText("Ok");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVerifyLayout = new javax.swing.GroupLayout(pnlVerify);
        pnlVerify.setLayout(pnlVerifyLayout);
        pnlVerifyLayout.setHorizontalGroup(
            pnlVerifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVerifyLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(pnlVerifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlVerifyLayout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOK))
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVerifyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(81, 81, 81))
        );
        pnlVerifyLayout.setVerticalGroup(
            pnlVerifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVerifyLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(pnlVerifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnOK))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addComponent(pnlVerify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(pnlVerify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        try {
            userModel = pnlSignup.getUser();
            if(userController.verifyCodeWithUser(userModel.getUserID(),getInputCode())){
                userController.doneVerify(userModel.getUserID());
                JOptionPane.showMessageDialog(this, "Verify chính xác");
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(this, "Verify không chính xác");
            }
        } catch (Exception ex) {
            Logger.getLogger(PnlVerifyCode.class.getName()).log(Level.SEVERE, "loi"+ex.getMessage());
        }
    }//GEN-LAST:event_btnOKActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pnlVerify;
    private javax.swing.JTextField txtCode;
    // End of variables declaration//GEN-END:variables
}
