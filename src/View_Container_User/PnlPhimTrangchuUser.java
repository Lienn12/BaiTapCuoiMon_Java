/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View_Container_User;

import View_Container_Admin.PnlTrangChu;
import Controllers.Movie_controller;
import Model.Movie_model;
import View_Container_Admin.pnlChiTietFilm;
import View_Main.frmMain;
import View_Main.frmMainUser;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lienn
 */
public class PnlPhimTrangchuUser extends javax.swing.JPanel {
    private frmMainUser main;
    private PnlTrangChuUser pnlTrangChu;
    private final Movie_model movieModel=new Movie_model();
    private final Movie_controller movieController = new Movie_controller();
   
    public PnlPhimTrangchuUser(PnlTrangChuUser pnlTrangChu,frmMainUser main) {
        this.pnlTrangChu=pnlTrangChu;
        this.main=main;
        initComponents();
        loadDataPhimdx();
        loadDataPhimbo();
        loadDataPhimle();
    }
    private void loadDataForPanel(pnlPhimUser panel, List<Movie_model> movies) {
        if (movies != null && !movies.isEmpty()) {
            panel.removeAll();
            for (Movie_model movie : movies) {
                panel.addImage(movie);  
            }
            panel.revalidate();
            panel.repaint();
        } else {
            System.out.println("Không có phim để hiển thị!");
        }
    }
    public void loadDataPhimdx() {
        try {
            List<Movie_model> dsmoviedx = movieController.getImage();
            loadDataForPanel(pnlPhimdexuat, dsmoviedx);  
        } catch (SQLException ex) {
            Logger.getLogger(PnlTrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDataPhimbo() {
        try {
            List<Movie_model> dsmoviebo = movieController.getphimbo();
            loadDataForPanel(pnlPhimbo, dsmoviebo);
        } catch (SQLException ex) {
            Logger.getLogger(PnlTrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    public void loadDataPhimle() {
        try {
            List<Movie_model> dsmoviedx = movieController.getphimle();
            loadDataForPanel(pnlPhimle, dsmoviedx);  
        } catch (SQLException ex) {
            Logger.getLogger(PnlTrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pnlPhimdexuat = new View_Container_User.pnlPhimUser(main);
        pnlPhimbo = new View_Container_User.pnlPhimUser(main);
        pnlPhimle = new View_Container_User.pnlPhimUser(main);
        reviewUser1 = new View_Container_User.ReviewUser();

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(5, 38, 89));
        jLabel6.setText("Phim đề xuất");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(5, 38, 89));
        jLabel8.setText("Phim bộ mới cập nhật");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(5, 38, 89));
        jLabel7.setText("Phim lẻ mới cập nhật");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(5, 38, 89));
        jLabel9.setText("Bảng đánh giá");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(reviewUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPhimle, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPhimbo, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPhimdexuat, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(pnlPhimdexuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel8)
                .addGap(20, 20, 20)
                .addComponent(pnlPhimbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel7)
                .addGap(20, 20, 20)
                .addComponent(pnlPhimle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(reviewUser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private View_Container_User.pnlPhimUser pnlPhimbo;
    private View_Container_User.pnlPhimUser pnlPhimdexuat;
    private View_Container_User.pnlPhimUser pnlPhimle;
    private View_Container_User.ReviewUser reviewUser1;
    // End of variables declaration//GEN-END:variables
    @Override
      protected void paintComponent(Graphics g) { 
          super.paintComponent(g); 
          Graphics2D g2 = (Graphics2D) g;
          g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

          int width = getWidth();
          int height = getHeight();
          GradientPaint gp = new GradientPaint(0,0, Color.decode("#ffffff"), 0, getHeight(), Color.decode("#6B99C6"));
            g2.setPaint(gp);
          g2.fillRect(0, 0, width, height);
      }
}
