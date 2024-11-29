
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View_Main;

import Scrollbar.ScrollBarCustom;
import View_Container.PnlTrangChu;
import View_Container.pnlDanhSachUser;
import View_Container.pnlChiTietFilm;
import View_Container.pnlDSPhim;
import View_Container.pnlDanhSachUser;
import View_Container.pnlDanhgia;
import View_Container.pnlReplyCmt;
import View_Container.pnlSuaPhim;
import View_Container.pnlThemPhim;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.Border;
/**
 *
 * @author ASUS
 */
public final class frmMain extends javax.swing.JFrame {
    private CardLayout cardLayout;
    private JScrollPane spTrangChu;
    private JScrollPane spThem;
     private JScrollPane spSua;
    private PnlTrangChu pnlTrangchu;
    private pnlDSPhim pnldsPhim; 
    private pnlSuaPhim pnlSua;
    private pnlThemPhim pnlThem;
    private pnlChiTietFilm pnlChiTiet;
    private pnlDanhSachUser pnlUser;
    private pnlDanhgia pnlDanhgia;
    private pnlReplyCmt pnlReplycmt;
    public frmMain()  {
        initComponents();
        setLocationRelativeTo(null);
        init1();
        init();
        addMenuListeners();
    }
    public void init1(){
        setLayout(new BorderLayout());
        add(pnlMenu, BorderLayout.WEST);
        add(pnlMain, BorderLayout.CENTER);
        pnlMain.setLayout(new BorderLayout());
        pnlMain.add(pnlContainer, BorderLayout.CENTER);
        pnlMain.add(pnlHeader, BorderLayout.NORTH);
        Dimension frameSize = getSize();
        int width = (int)(frameSize.width * 0.25); // 20% của chiều rộng frame
        int height = frameSize.height; // giữ nguyên chiều cao của frame
        pnlMenu.setPreferredSize(new Dimension(width, height));
        setSize(1040, 670);
    }
        public void init() {
            cardLayout=new CardLayout();
            pnlContainer.setLayout(cardLayout);
            
            pnlTrangchu = new PnlTrangChu(this);
            pnldsPhim= new pnlDSPhim(this);
            pnlChiTiet= new pnlChiTietFilm (this);
            pnlSua=new pnlSuaPhim(this);
            pnlThem= new pnlThemPhim(this,pnldsPhim);
            pnlUser= new pnlDanhSachUser(this);
            pnlDanhgia= new pnlDanhgia(this);
            pnlReplycmt= new pnlReplyCmt(this);
            
            spTrangChu = createScrollPane(pnlTrangchu);
            spThem = createScrollPane(pnlThem);
            spSua = createScrollPane(pnlSua);
            
            pnlContainer.add(spTrangChu,"trang chu");
            pnlContainer.add(pnldsPhim,"danh sach phim");
            pnlContainer.add(pnlChiTiet,"chi tiet phim");
            pnlContainer.add(spSua,"sua phim");
            pnlContainer.add(spThem,"them phim");
            pnlContainer.add(pnlUser,"danh sach user");
            pnlContainer.add(pnlDanhgia,"danh gia");
            pnlContainer.add(pnlReplycmt, "reply");


            cardLayout.show(pnlContainer, "trang chu");
            setColor(btnTrangChu);

        }
    
    private JScrollPane createScrollPane(JPanel panel) {
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBar(new ScrollBarCustom());
        scrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
        return scrollPane;
    }
    public  pnlChiTietFilm getPanel(){
        return pnlChiTiet;
    }
    
    public pnlReplyCmt getReply(){
        return pnlReplycmt;
    }
    
    public pnlSuaPhim getPanelSua(){
        return pnlSua;
    }
    private void addMenuListeners() {
        btnTrangChu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showPanel("trang chu");
                setColor(btnTrangChu);
            }
        });
        btnDSphim.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Chuyển sang panel danh sách phim
                showPanel("danh sach phim");
                setColor(btnDSphim);
            }
        });

        btnDSNguoiDung.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Chuyển sang panel danh sách người dùng
                showPanel("danh sach user");
            }
        });
        
        btnDanhGia.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showPanel("danh gia");
                setColor(btnDanhGia);
            }
        });
        
        btnLogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Frm_Login_Signup frmLoginSignup= new Frm_Login_Signup();
                frmLoginSignup.setVisible(true);
                dispose();
            }
        });
    }
    void setColor(JPanel panel){
        panel.setOpaque(true);
        panel.setBackground(new Color(84, 131, 179));
        panel.setForeground(new Color(5,38,89));
    }
    void resetColor(JPanel panel){
        panel.setOpaque(false);
        panel.setBackground(new Color(51, 102, 153));
    }
    
    public void showPanel(String panelName){
        cardLayout.show(pnlContainer, panelName); 
    }
    public void setPanel(JPanel panel) {
        this.getContentPane().removeAll();
        this.getContentPane().add(panel);
        this.revalidate();
        this.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenu = new View_Main.PnlMenu();
        jLabel1 = new javax.swing.JLabel();
        btnTrangChu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnDSphim = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnDSNguoiDung = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnDanhGia = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pnlMain = new View_Main.PnlContainer();
        pnlHeader = new View_Main.PnlHeader();
        pnlContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1000, 650));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N

        btnTrangChu.setBackground(new java.awt.Color(51, 102, 153));
        btnTrangChu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrangChu.setOpaque(false);
        btnTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTrangChuMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Trang chủ");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N

        javax.swing.GroupLayout btnTrangChuLayout = new javax.swing.GroupLayout(btnTrangChu);
        btnTrangChu.setLayout(btnTrangChuLayout);
        btnTrangChuLayout.setHorizontalGroup(
            btnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTrangChuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        btnTrangChuLayout.setVerticalGroup(
            btnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnDSphim.setBackground(new java.awt.Color(51, 102, 153));
        btnDSphim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDSphim.setOpaque(false);
        btnDSphim.setPreferredSize(new java.awt.Dimension(209, 44));
        btnDSphim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDSphimMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Danh sách Phim");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/filmlist32.png"))); // NOI18N

        javax.swing.GroupLayout btnDSphimLayout = new javax.swing.GroupLayout(btnDSphim);
        btnDSphim.setLayout(btnDSphimLayout);
        btnDSphimLayout.setHorizontalGroup(
            btnDSphimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnDSphimLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel8)
                .addGap(30, 30, 30)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnDSphimLayout.setVerticalGroup(
            btnDSphimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnDSNguoiDung.setBackground(new java.awt.Color(51, 102, 153));
        btnDSNguoiDung.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDSNguoiDung.setOpaque(false);
        btnDSNguoiDung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDSNguoiDungMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DS người dùng");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/userlist32.png"))); // NOI18N

        javax.swing.GroupLayout btnDSNguoiDungLayout = new javax.swing.GroupLayout(btnDSNguoiDung);
        btnDSNguoiDung.setLayout(btnDSNguoiDungLayout);
        btnDSNguoiDungLayout.setHorizontalGroup(
            btnDSNguoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnDSNguoiDungLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel9)
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnDSNguoiDungLayout.setVerticalGroup(
            btnDSNguoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        btnDanhGia.setBackground(new java.awt.Color(51, 102, 153));
        btnDanhGia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDanhGia.setOpaque(false);
        btnDanhGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDanhGiaMousePressed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(102, 153, 204));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Đánh giá");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/comment32.png"))); // NOI18N

        javax.swing.GroupLayout btnDanhGiaLayout = new javax.swing.GroupLayout(btnDanhGia);
        btnDanhGia.setLayout(btnDanhGiaLayout);
        btnDanhGiaLayout.setHorizontalGroup(
            btnDanhGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnDanhGiaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel10)
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnDanhGiaLayout.setVerticalGroup(
            btnDanhGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        btnLogout.setBackground(new java.awt.Color(51, 102, 153));
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.setOpaque(false);
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLogoutMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Log out");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout32.png"))); // NOI18N

        javax.swing.GroupLayout btnLogoutLayout = new javax.swing.GroupLayout(btnLogout);
        btnLogout.setLayout(btnLogoutLayout);
        btnLogoutLayout.setHorizontalGroup(
            btnLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnLogoutLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel11)
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnLogoutLayout.setVerticalGroup(
            btnLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDSphim, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
            .addComponent(btnDSNguoiDung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDanhGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel1)
                .addGap(77, 77, 77)
                .addComponent(btnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDSphim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnDSNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnDanhGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlContainer.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrangChuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMousePressed
        setColor(btnTrangChu);
        resetColor(btnDSphim);
        resetColor(btnDSNguoiDung);
        resetColor(btnDanhGia);
        resetColor(btnLogout);
    }//GEN-LAST:event_btnTrangChuMousePressed

    private void btnDSphimMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDSphimMousePressed
        resetColor(btnTrangChu);
        setColor(btnDSphim);
        resetColor(btnDSNguoiDung);
        resetColor(btnDanhGia);
        resetColor(btnLogout);
    }//GEN-LAST:event_btnDSphimMousePressed

    private void btnDSNguoiDungMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDSNguoiDungMousePressed
        resetColor(btnTrangChu);
        resetColor(btnDSphim);
        setColor(btnDSNguoiDung);
        resetColor(btnDanhGia);
        resetColor(btnLogout);
    }//GEN-LAST:event_btnDSNguoiDungMousePressed

    private void btnDanhGiaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDanhGiaMousePressed
        resetColor(btnTrangChu);
        resetColor(btnDSphim);
        resetColor(btnDSNguoiDung);
        setColor(btnDanhGia);
        resetColor(btnLogout);
    }//GEN-LAST:event_btnDanhGiaMousePressed

    private void btnLogoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMousePressed
        resetColor(btnTrangChu);
        resetColor(btnDSphim);
        resetColor(btnDSNguoiDung);
        resetColor(btnDanhGia);
        setColor(btnLogout);
    }//GEN-LAST:event_btnLogoutMousePressed

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
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnDSNguoiDung;
    private javax.swing.JPanel btnDSphim;
    private javax.swing.JPanel btnDanhGia;
    private javax.swing.JPanel btnLogout;
    private javax.swing.JPanel btnTrangChu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel pnlContainer;
    private View_Main.PnlHeader pnlHeader;
    private View_Main.PnlContainer pnlMain;
    private View_Main.PnlMenu pnlMenu;
    // End of variables declaration//GEN-END:variables

}
