package View_Login_Signup;

import Controllers.Email_controller;
import Controllers.User_controller;
import Model.Message_model;
import Model.User_model;
import View_Main.Frm_Login_Signup;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PnlForgotPassword extends javax.swing.JPanel {
    private final Frm_Login_Signup frmLoginSignup;
    private User_model userModel;
    private final User_controller userController;
    private PnlResetPassword pnlResetPassword;

    public PnlForgotPassword(Frm_Login_Signup frmLoginSignup) {
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
        btnSend = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnVerifycode = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lberrorEmail = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        lberrorCode = new javax.swing.JLabel();
        btnBack = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 153));
        jLabel1.setText("Forgot password");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 153));
        jLabel2.setText("Email");

        btnSend.setBackground(new java.awt.Color(51, 102, 153));
        btnSend.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSendMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Send code");

        javax.swing.GroupLayout btnSendLayout = new javax.swing.GroupLayout(btnSend);
        btnSend.setLayout(btnSendLayout);
        btnSendLayout.setHorizontalGroup(
            btnSendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );
        btnSendLayout.setVerticalGroup(
            btnSendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnVerifycode.setBackground(new java.awt.Color(51, 102, 153));
        btnVerifycode.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerifycode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVerifycodeMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Verifycode");

        javax.swing.GroupLayout btnVerifycodeLayout = new javax.swing.GroupLayout(btnVerifycode);
        btnVerifycode.setLayout(btnVerifycodeLayout);
        btnVerifycodeLayout.setHorizontalGroup(
            btnVerifycodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
        );
        btnVerifycodeLayout.setVerticalGroup(
            btnVerifycodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setBorder(null);

        jSeparator1.setBackground(new java.awt.Color(51, 102, 153));
        jSeparator1.setForeground(new java.awt.Color(51, 102, 153));

        lberrorEmail.setForeground(new java.awt.Color(255, 51, 51));
        lberrorEmail.setText("   ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 102, 153));
        jLabel5.setText("Verify code");

        txtCode.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCode.setForeground(new java.awt.Color(51, 102, 153));
        txtCode.setBorder(null);

        jSeparator2.setBackground(new java.awt.Color(102, 153, 204));
        jSeparator2.setForeground(new java.awt.Color(51, 102, 153));

        lberrorCode.setForeground(new java.awt.Color(255, 51, 51));
        lberrorCode.setText("   ");

        btnBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bach48.png"))); // NOI18N
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lberrorEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lberrorCode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCode, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnVerifycode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBack))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnBack)
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lberrorEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCode)
                    .addComponent(btnVerifycode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lberrorCode)
                .addContainerGap(73, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSendMouseClicked
        try {
            String email = txtEmail.getText().trim();
            lberrorEmail.setText("");
            userModel.setEmail(email); 

            if (email.isEmpty()) {
                lberrorEmail.setText("Email không được để trống");
            } else if (!userController.checkDuplicateEmail(email)) {
                lberrorEmail.setText("Email không tồn tại");
            } else {
                userController.ForgotPassword(userModel);
                userController.sendPassCode(userModel); 
            }
        } catch (Exception ex) {
            Logger.getLogger(PnlForgotPassword.class.getName()).log(Level.SEVERE, "Lỗi: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnSendMouseClicked

    private void btnVerifycodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerifycodeMouseClicked
        String email = txtEmail.getText().trim();
        String code = txtCode.getText().trim();
        userModel.setEmail(email);
        userModel.setVerifyCode(code);
        if (code.isEmpty()) {
            lberrorEmail.setText("Vui lòng nhập verify code");
        } else {
            try {
                if (userController.checkDuplicateEmail(email) && userModel.getVerifyCode().equals(code)) {
                    userController.doneVerify(userModel.getUserID());
                    JOptionPane.showMessageDialog(frmLoginSignup, "Verify chính xác");
                    frmLoginSignup.showPanel("Reset");
                    this.disable();
                } else {
                    lberrorEmail.setText("Verify không chính xác");
                }
            } catch (Exception ex) {
                Logger.getLogger(PnlVerifyCode.class.getName()).log(Level.SEVERE, "Lỗi: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnVerifycodeMouseClicked

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        frmLoginSignup.showPanel("Login");
    }//GEN-LAST:event_btnBackMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JPanel btnSend;
    private javax.swing.JPanel btnVerifycode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lberrorCode;
    private javax.swing.JLabel lberrorEmail;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
