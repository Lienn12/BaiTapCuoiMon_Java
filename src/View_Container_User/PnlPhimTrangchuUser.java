/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View_Container_User;


import Controllers.Movie_controller;
import Model.Movie_model;
import Model.User_model;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import View_Main.frmMainUser;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
/**
 *
 * @author lienn
 */
public class PnlPhimTrangchuUser extends javax.swing.JPanel {
    private frmMainUser main;
    private PnlTrangChuUser pnlTrangChu;
    private User_model userModel;
    private final Movie_model movieModel=new Movie_model();
    private final Movie_controller movieController = new Movie_controller();
   
    public PnlPhimTrangchuUser(PnlTrangChuUser pnlTrangChu,frmMainUser main,User_model userModel) {
        this.pnlTrangChu=pnlTrangChu;
        this.main=main;
        this.userModel=userModel;
        initComponents();
        loadData();
        init();
    }
    public void init() {
        setupPanel(spdx, phimDx, pnlPhimdx);
        setupPanel(spbo, phimbo, pnlPhimbo);
        setupPanel(sple, phimle, pnlPhimle);
    }

    private void setupPanel(JScrollPane scrollPane, JPanel panel, JPanel pnlContainer) {
        scrollPane.setBackground(Color.WHITE);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        pnlContainer.setBackground(new Color(255, 255, 255, 128));
    }

    public void loadData() {
        loadDataPhim(phimDx, "dx");
        loadDataPhim(phimbo, "bo");
        loadDataPhim(phimle, "le");
    }

    private void loadDataPhim(JPanel panel, String type) {
        try {
            List<Movie_model> movies = null;
            switch (type) {
                case "dx":
                    movies = movieController.getImage();
                    break;
                case "bo":
                    movies = movieController.getphimbo();
                    break;
                case "le":
                    movies = movieController.getphimle();
                    break;
            }
            if (movies != null) {
                panel.removeAll();
                for (Movie_model movie : movies) {
                    PnlitemImageUser item = new PnlitemImageUser(movie, main,userModel);
                    panel.add(item);
                }
                panel.repaint();
                panel.revalidate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PnlTrangChuUser.class.getName()).log(Level.SEVERE, null, ex);
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
        pnlPhimdx = new javax.swing.JPanel();
        spdx = new javax.swing.JScrollPane();
        phimDx = new javax.swing.JPanel();
        scrollBarCustom1 = new Scrollbar.ScrollBarCustom();
        reviews1 = new View_Container_Admin.Home.Reviews();
        pnlPhimbo = new javax.swing.JPanel();
        spbo = new javax.swing.JScrollPane();
        phimbo = new javax.swing.JPanel();
        scrollBarCustom2 = new Scrollbar.ScrollBarCustom();
        pnlPhimle = new javax.swing.JPanel();
        sple = new javax.swing.JScrollPane();
        phimle = new javax.swing.JPanel();
        scrollBarCustom3 = new Scrollbar.ScrollBarCustom();

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

        pnlPhimdx.setBackground(new java.awt.Color(255, 255, 255));

        spdx.setBorder(null);
        spdx.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        spdx.setHorizontalScrollBar(scrollBarCustom1);

        phimDx.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout phimDxLayout = new javax.swing.GroupLayout(phimDx);
        phimDx.setLayout(phimDxLayout);
        phimDxLayout.setHorizontalGroup(
            phimDxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 683, Short.MAX_VALUE)
        );
        phimDxLayout.setVerticalGroup(
            phimDxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 221, Short.MAX_VALUE)
        );

        spdx.setViewportView(phimDx);

        scrollBarCustom1.setOrientation(javax.swing.JScrollBar.HORIZONTAL);

        javax.swing.GroupLayout pnlPhimdxLayout = new javax.swing.GroupLayout(pnlPhimdx);
        pnlPhimdx.setLayout(pnlPhimdxLayout);
        pnlPhimdxLayout.setHorizontalGroup(
            pnlPhimdxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhimdxLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlPhimdxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPhimdxLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(spdx, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        pnlPhimdxLayout.setVerticalGroup(
            pnlPhimdxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhimdxLayout.createSequentialGroup()
                .addComponent(spdx, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPhimbo.setBackground(new java.awt.Color(255, 255, 255));

        spbo.setBorder(null);
        spbo.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        spbo.setHorizontalScrollBar(scrollBarCustom2);

        phimbo.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout phimboLayout = new javax.swing.GroupLayout(phimbo);
        phimbo.setLayout(phimboLayout);
        phimboLayout.setHorizontalGroup(
            phimboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 683, Short.MAX_VALUE)
        );
        phimboLayout.setVerticalGroup(
            phimboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 221, Short.MAX_VALUE)
        );

        spbo.setViewportView(phimbo);

        scrollBarCustom2.setOrientation(javax.swing.JScrollBar.HORIZONTAL);

        javax.swing.GroupLayout pnlPhimboLayout = new javax.swing.GroupLayout(pnlPhimbo);
        pnlPhimbo.setLayout(pnlPhimboLayout);
        pnlPhimboLayout.setHorizontalGroup(
            pnlPhimboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhimboLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPhimboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPhimboLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(scrollBarCustom2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(spbo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        pnlPhimboLayout.setVerticalGroup(
            pnlPhimboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhimboLayout.createSequentialGroup()
                .addComponent(spbo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBarCustom2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPhimle.setBackground(new java.awt.Color(255, 255, 255));

        sple.setBorder(null);
        sple.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        sple.setHorizontalScrollBar(scrollBarCustom3);

        phimle.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout phimleLayout = new javax.swing.GroupLayout(phimle);
        phimle.setLayout(phimleLayout);
        phimleLayout.setHorizontalGroup(
            phimleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 683, Short.MAX_VALUE)
        );
        phimleLayout.setVerticalGroup(
            phimleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 221, Short.MAX_VALUE)
        );

        sple.setViewportView(phimle);

        scrollBarCustom3.setOrientation(javax.swing.JScrollBar.HORIZONTAL);

        javax.swing.GroupLayout pnlPhimleLayout = new javax.swing.GroupLayout(pnlPhimle);
        pnlPhimle.setLayout(pnlPhimleLayout);
        pnlPhimleLayout.setHorizontalGroup(
            pnlPhimleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhimleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollBarCustom3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlPhimleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sple, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlPhimleLayout.setVerticalGroup(
            pnlPhimleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhimleLayout.createSequentialGroup()
                .addComponent(sple, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBarCustom3, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(reviews1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPhimdx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPhimbo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPhimle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel6)
                .addGap(20, 20, 20)
                .addComponent(pnlPhimdx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel7)
                .addGap(20, 20, 20)
                .addComponent(pnlPhimbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel8)
                .addGap(20, 20, 20)
                .addComponent(pnlPhimle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reviews1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel phimDx;
    private javax.swing.JPanel phimbo;
    private javax.swing.JPanel phimle;
    private javax.swing.JPanel pnlPhimbo;
    private javax.swing.JPanel pnlPhimdx;
    private javax.swing.JPanel pnlPhimle;
    private View_Container_Admin.Home.Reviews reviews1;
    private Scrollbar.ScrollBarCustom scrollBarCustom1;
    private Scrollbar.ScrollBarCustom scrollBarCustom2;
    private Scrollbar.ScrollBarCustom scrollBarCustom3;
    private javax.swing.JScrollPane spbo;
    private javax.swing.JScrollPane spdx;
    private javax.swing.JScrollPane sple;
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
