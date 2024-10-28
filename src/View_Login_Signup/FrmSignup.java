
package View_Login_Signup;

import View_Main.Frm_Login_Signup;
import Controllers.User_controller;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class FrmSignup extends javax.swing.JPanel {
    private User_controller userController;

    public FrmSignup() {
        initComponents();
        init();
    } 
    private void init() {
        // Initialize the User_controller instance
        userController = new User_controller();

        lbhidePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbhidePassMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbhidePassMouseReleased(evt);
            }
        });
        
        lbshowPass.setVisible(false);
        lbhidePass.setVisible(true);
        
        lbhideConfPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbhideConfPassMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbhideConfPassMouseReleased(evt);
            }
        });
        
        lbshowConfPass.setVisible(false);
        lbhideConfPass.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ShowHidePass = new javax.swing.JPanel();
        lbshowPass = new javax.swing.JLabel();
        lbhidePass = new javax.swing.JLabel();
        ShowHideConfPass = new javax.swing.JPanel();
        lbshowConfPass = new javax.swing.JLabel();
        lbhideConfPass = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        txtConfirmPass = new javax.swing.JPasswordField();
        btnSignup = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lbLogin = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        lberrorUser = new javax.swing.JLabel();
        lberrorEmail = new javax.swing.JLabel();
        lberrorPass = new javax.swing.JLabel();
        lberrorConfirm = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(51, 102, 153));
        setVerifyInputWhenFocusTarget(false);

        ShowHidePass.setBackground(new java.awt.Color(255, 255, 255));
        ShowHidePass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ShowHidePass.setPreferredSize(new java.awt.Dimension(20, 20));
        ShowHidePass.setLayout(new java.awt.CardLayout());

        lbshowPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbshowPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/view.png"))); // NOI18N
        ShowHidePass.add(lbshowPass, "card2");

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
        ShowHidePass.add(lbhidePass, "card3");

        ShowHideConfPass.setBackground(new java.awt.Color(255, 255, 255));
        ShowHideConfPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ShowHideConfPass.setPreferredSize(new java.awt.Dimension(20, 20));
        ShowHideConfPass.setLayout(new java.awt.CardLayout());

        lbshowConfPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbshowConfPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/view.png"))); // NOI18N
        ShowHideConfPass.add(lbshowConfPass, "card2");

        lbhideConfPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbhideConfPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hide.png"))); // NOI18N
        lbhideConfPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbhideConfPassMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbhideConfPassMouseReleased(evt);
            }
        });
        ShowHideConfPass.add(lbhideConfPass, "card3");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 153));
        jLabel1.setText("Creat an account ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 153));
        jLabel2.setText("Username");

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsername.setBorder(null);
        txtUsername.setPreferredSize(new java.awt.Dimension(64, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 153));
        jLabel3.setText("Email");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setBorder(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 102, 153));
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 102, 153));
        jLabel5.setText("Confirm password");

        txtPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPass.setBorder(null);

        txtConfirmPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtConfirmPass.setBorder(null);

        btnSignup.setBackground(new java.awt.Color(51, 102, 153));
        btnSignup.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        btnSignup.setForeground(new java.awt.Color(255, 255, 255));
        btnSignup.setText("SIGNUP");
        btnSignup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(51, 102, 153));
        jLabel6.setText("Already have an acount?");

        lbLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbLogin.setForeground(new java.awt.Color(51, 102, 153));
        lbLogin.setText("Log in");
        lbLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLoginMouseClicked(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(51, 102, 153));

        jSeparator2.setForeground(new java.awt.Color(51, 102, 153));

        jSeparator3.setForeground(new java.awt.Color(51, 102, 153));

        jSeparator4.setForeground(new java.awt.Color(51, 102, 153));

        lberrorUser.setForeground(new java.awt.Color(255, 0, 0));
        lberrorUser.setText("                       ");

        lberrorEmail.setForeground(new java.awt.Color(255, 0, 0));
        lberrorEmail.setText("                       ");

        lberrorPass.setForeground(new java.awt.Color(255, 0, 0));
        lberrorPass.setText("                       ");

        lberrorConfirm.setForeground(new java.awt.Color(255, 0, 0));
        lberrorConfirm.setText("                       ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lberrorPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ShowHideConfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lberrorUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbLogin)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnSignup, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lberrorConfirm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ShowHidePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lberrorEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 29, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lberrorUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lberrorEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShowHidePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(lberrorPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lberrorConfirm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btnSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lbLogin))
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ShowHideConfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        try{
            String username=txtUsername.getText();
            String email=txtEmail.getText();
            String password=txtPass.getText();
            String confirmpass=txtConfirmPass.getText();
            
            lberrorUser.setText("");
            lberrorEmail.setText("");
            lberrorPass.setText("");
            lberrorConfirm.setText("");
            
            boolean valid = true;
            
            if (username.trim().isEmpty()) {
                lberrorUser.setText("Username không được để trống.");
                valid = false;
            } else if (!userController.checkUsername(username)){
                lberrorUser.setText("Username đã tồn tại.");
                valid = false;
            }
            
            // Kiểm tra trường email
            if (email.trim().isEmpty()) {
                lberrorEmail.setText("Email không được để trống.");
                valid = false;
            } else if (!userController.checkEmail(email)) {
                lberrorEmail.setText("Email không hợp lệ");
                valid = false;  
            }

            // Kiểm tra trường password
            if (password.trim().isEmpty()) {
                lberrorPass.setText("Password không được để trống.");
                valid = false;
            } else if (!userController.checkPassword(password)) {
                lberrorPass.setText("<html>Mật khẩu không hợp lệ.<br>Vui lòng nhập ít nhất 8 ký tự, bao gồm cả chữ và số.</html>");
                valid = false;
            }

            // Kiểm tra trường confirm password
            if (confirmpass.trim().isEmpty()) {
                lberrorConfirm.setText("Xác nhận mật khẩu không được để trống.");
                valid = false;
            } else if (!userController.checkComfirmPassword(password, confirmpass)) {
                lberrorConfirm.setText("Xác nhận mật khẩu không khớp. Vui lòng nhập lại");
                valid = false;
            }

            // Nếu tất cả thông tin hợp lệ, thực hiện đăng ký
            if (valid && userController.CheckSignup(username, email, password, confirmpass)) {
                JOptionPane.showMessageDialog(this, "Đăng ký thành công");
            } else if (!valid) {
                JOptionPane.showMessageDialog(this, "Đăng ký thất bại do thông tin không hợp lệ");
            }
        }catch(Exception ex){
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE,"Loi"+ex.getMessage());
        }
        
    }//GEN-LAST:event_btnSignupActionPerformed

    private void lbLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLoginMouseClicked
        Frm_Login_Signup parentFrame = (Frm_Login_Signup) this.getTopLevelAncestor();
        parentFrame.switchToLogin();
    }//GEN-LAST:event_lbLoginMouseClicked

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

    private void lbhideConfPassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbhideConfPassMousePressed
        lbhideConfPass.setVisible(false);
        lbshowConfPass.setVisible(true);
        txtConfirmPass.setEchoChar((char)0);
    }//GEN-LAST:event_lbhideConfPassMousePressed

    private void lbhideConfPassMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbhideConfPassMouseReleased
        lbhideConfPass.setVisible(true);
        lbshowConfPass.setVisible(false);
        txtConfirmPass.setEchoChar('*');       
    }//GEN-LAST:event_lbhideConfPassMouseReleased
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ShowHideConfPass;
    private javax.swing.JPanel ShowHidePass;
    private javax.swing.JButton btnSignup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lberrorConfirm;
    private javax.swing.JLabel lberrorEmail;
    private javax.swing.JLabel lberrorPass;
    private javax.swing.JLabel lberrorUser;
    private javax.swing.JLabel lbhideConfPass;
    private javax.swing.JLabel lbhidePass;
    private javax.swing.JLabel lbshowConfPass;
    private javax.swing.JLabel lbshowPass;
    private javax.swing.JPasswordField txtConfirmPass;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
