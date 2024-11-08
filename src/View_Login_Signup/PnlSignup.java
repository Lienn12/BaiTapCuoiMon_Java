
package View_Login_Signup;

import Controllers.Admin_controller;
import Controllers.Email_controller;
import View_Main.Frm_Login_Signup;
import Controllers.User_controller;
import Model.Admin_model;
import Model.Message_model;
import Model.User_model;
import View_Login_Signup.PnlVerifyCode;
import java.awt.*;
import java.awt.event.*;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class PnlSignup extends javax.swing.JPanel {
    private Frm_Login_Signup frmMain;
    private PnlVerifyCode pnlVerifyCode;
    private User_controller userController;
    private User_model userModel;
    private Admin_model adminModel;
    private Admin_controller adminController;
    public PnlSignup(Frm_Login_Signup frmMain) {
        this.frmMain = frmMain;
        initComponents();
        init();
        initEnterKeyListeners();
    } 
    public User_model getUser(){
        return userModel;
    }
    private void init() {
        pnlVerifyCode = new PnlVerifyCode();
        userController = new User_controller();
        userModel = new User_model();
        adminController= new Admin_controller();
        adminModel = new Admin_model();
        initEnterKeyListeners();
        setupPasswordVisibility(lbhidePass, lbshowPass, txtPass);
        setupPasswordVisibility(lbhideConfPass, lbshowConfPass, txtConfirmPass);
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
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setVerifyInputWhenFocusTarget(false);

        ShowHidePass.setBackground(new java.awt.Color(255, 255, 255));
        ShowHidePass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ShowHidePass.setPreferredSize(new java.awt.Dimension(20, 20));
        ShowHidePass.setLayout(new java.awt.CardLayout());

        lbshowPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbshowPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/view.png"))); // NOI18N
        lbshowPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ShowHidePass.add(lbshowPass, "card2");

        lbhidePass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbhidePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hide.png"))); // NOI18N
        ShowHidePass.add(lbhidePass, "card3");

        ShowHideConfPass.setBackground(new java.awt.Color(255, 255, 255));
        ShowHideConfPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ShowHideConfPass.setPreferredSize(new java.awt.Dimension(20, 20));
        ShowHideConfPass.setLayout(new java.awt.CardLayout());

        lbshowConfPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbshowConfPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/view.png"))); // NOI18N
        lbshowConfPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ShowHideConfPass.add(lbshowConfPass, "card2");

        lbhideConfPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbhideConfPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hide.png"))); // NOI18N
        ShowHideConfPass.add(lbhideConfPass, "card3");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 153));
        jLabel1.setText("Creat an account ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 153));
        jLabel2.setText("Username");

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsername.setBorder(null);

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
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtUsername)
                        .addComponent(lberrorPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(txtConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(ShowHideConfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private void initEnterKeyListeners() {
        JTextField[] fields = {txtUsername, txtEmail, txtPass, txtConfirmPass};
        for (int i = 0; i < fields.length; i++) {
            int nextIndex = (i + 1) % fields.length;
            fields[i].addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent evt) {
                    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                        if (nextIndex == 0) {
                            btnSignup.doClick(); 
                        } else {
                            fields[nextIndex].requestFocus();
                        }
                    }
                }
            });
        }
    }
    
    private static String passwordHash(String password){
        try{
            MessageDigest md= MessageDigest.getInstance("SHA");
            md.update(password.getBytes());
            byte[] rbt= md.digest();
            StringBuilder sb= new StringBuilder();
            for(byte b: rbt){
                sb.append(String.format("%02x",b));
            }
            return sb.toString();
        }catch(Exception ex){
            Logger.getLogger(PnlLogin.class.getName()).log(Level.SEVERE,"Loi"+ex.getMessage());
        }
        return null;
    }
    
    private void setupPasswordVisibility(JLabel lbhide, JLabel lbshow, JPasswordField txtPass){  
        lbhide.addMouseListener(new MouseAdapter(){
            //hien mat khau 
            public void mousePressed(MouseEvent evt){
                lbshow.setVisible(true);
                lbhide.setVisible(false);
                txtPass.setEchoChar((char)0);
            }
            //an mat khau
            public void mouseReleased(MouseEvent evt){
                lbshow.setVisible(false);
                lbhide.setVisible(true);
                txtPass.setEchoChar('*');
            }
        });
        lbhide.setVisible(true);
        lbshow.setVisible(false);
    }
    
    private boolean validateInputs(User_model userModel, String password, String confirmPass) throws SQLException{
        boolean valid= true;
        //ktr Username
        if(userModel.getUsername().trim().isEmpty()){
            lberrorUser.setText("Username không được để trống.");
            valid=false;
        }else if(userController.checkDuplicateUser(userModel.getUsername())){
            lberrorUser.setText("Username đã tồn tại");
            valid = false;
        }
        
        //ktr email
        if(userModel.getEmail().trim().isEmpty()){
            lberrorEmail.setText("Email không được để trống.");
            valid=false;
        }else if(userController.checkDuplicateEmail(userModel.getEmail())){
            lberrorEmail.setText("Email đã tồn tại.");
            valid=false;
        }else if(!userController.checkEmail(userModel)){
             lberrorEmail.setText("Email không hợp lệ");
             valid = false;
        }
        //ktr password
            if (password.trim().isEmpty()) {
                lberrorPass.setText("Password không được để trống.");
                valid = false;
            } else if (!userController.checkPassword(password)) {
                lberrorPass.setText("<html>Mật khẩu không hợp lệ.<br>Vui lòng nhập ít nhất 6 ký tự, bao gồm cả chữ và số.</html>");
                valid = false;
            }
        //ktra confirm password
            if (confirmPass.trim().isEmpty()) {
                lberrorConfirm.setText("Xác nhận mật khẩu không được để trống.");
                valid = false;
            } else if (!userController.checkComfirmPassword(password, confirmPass)) {
                lberrorConfirm.setText("Xác nhận mật khẩu không khớp. Vui lòng nhập lại");
                valid = false;
            }
        return valid;
    }

    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        try{
            String username=txtUsername.getText().trim();
            String email=txtEmail.getText().trim();
            String password=passwordHash(txtPass.getText().trim());
            String confirmpass=passwordHash(txtConfirmPass.getText().trim());
            userModel = new User_model(0,username,email,password);
            lberrorUser.setText("");
            lberrorEmail.setText("");
            lberrorPass.setText("");
            lberrorConfirm.setText("");
            pnlVerifyCode.setUserModel(userModel);
            boolean valid=validateInputs(userModel,password,confirmpass);
            if(valid){
                userController.CheckSignup(userModel, password);
                userController.sendVerificationCode(userModel);
                frmMain.showVerifyCode();
            }else{
                JOptionPane.showMessageDialog(this, "Đăng ký thất bại!!");
            } 
        }catch(Exception ex){
            Logger.getLogger(PnlLogin.class.getName()).log(Level.SEVERE,"Loi"+ex.getMessage());
        } 
    }//GEN-LAST:event_btnSignupActionPerformed

    private void lbLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLoginMouseClicked
        frmMain.showPanel("Login");
    }//GEN-LAST:event_lbLoginMouseClicked

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
