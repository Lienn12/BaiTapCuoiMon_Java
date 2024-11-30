/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View_Container.Home;

import View_Container.PnlTrangChu;
import Controllers.Movie_controller;
import Model.Movie_model;
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
public class PnlPhimTrangchu extends javax.swing.JPanel {
    private PnlTrangChu pnlTrangChu;
    private final Movie_model movieModel=new Movie_model();
    private final Movie_controller movieController = new Movie_controller();
    public PnlPhimTrangchu(PnlTrangChu pnlTrangChu) {
        this.pnlTrangChu=pnlTrangChu;
        initComponents();
        loadDataPhimdx();
        loadDataPhimbo();
        loadDataPhimle();
    }

    private void loadDataForPanel(View_Container.pnlPhim panel, List<Movie_model> movies) {
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

    // Sử dụng phương thức chung trong các phương thức loadData
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

        reviews2 = new View_Container.Home.Reviews();
        jLabel6 = new javax.swing.JLabel();
        pnlPhimdexuat = new View_Container.pnlPhim();
        jLabel8 = new javax.swing.JLabel();
        pnlPhimle = new View_Container.pnlPhim();
        jLabel7 = new javax.swing.JLabel();
        pnlPhimbo = new View_Container.pnlPhim();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        reviews2.setBackground(new java.awt.Color(125, 160, 202));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(5, 38, 89));
        jLabel6.setText("Phim đề xuất");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(5, 38, 89));
        jLabel8.setText("Phim lẻ mới cập nhật");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(5, 38, 89));
        jLabel7.setText("Phim bộ mới cập nhật");

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
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel9)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6)
                        .addComponent(pnlPhimdexuat, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addComponent(pnlPhimle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlPhimbo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reviews2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addGap(20, 20, 20)
                .addComponent(pnlPhimdexuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel8)
                .addGap(20, 20, 20)
                .addComponent(pnlPhimle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel7)
                .addGap(20, 20, 20)
                .addComponent(pnlPhimbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel9)
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(reviews2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private View_Container.pnlPhim pnlPhimbo;
    private View_Container.pnlPhim pnlPhimdexuat;
    private View_Container.pnlPhim pnlPhimle;
    private View_Container.Home.Reviews reviews2;
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
