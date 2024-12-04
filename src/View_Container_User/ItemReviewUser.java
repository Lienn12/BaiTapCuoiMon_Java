/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View_Container_User;

import Model.Movie_model;
import Model.Review_model;
import Model.User_model;
import Scrollbar.ScrollBarCustom;
import View_Container_Admin.pnlChiTietFilm;
import View_Main.frmMain;
import View_Main.frmMainUser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class ItemReviewUser extends javax.swing.JPanel {
    private frmMainUser main;
    private Movie_model movieModel;
    private User_model userModel;
    public Review_model getData(){
        return reviewModel;     
    }
    private Review_model reviewModel;
    public ItemReviewUser(Movie_model movieModel,Review_model reviewModel,frmMainUser main,User_model userModel) {
        this.reviewModel= reviewModel;
        this.movieModel=movieModel;
        this.userModel= userModel;
        this.main=main;
        initComponents();
        setOpaque(false);
        panel.setBackground(new Color(255,255,255,128));
        lbUser.setText(reviewModel.getUserModel().getUsername());
        lbstar.setText(String.valueOf(reviewModel.getRating()));
        txaCmt.setText(reviewModel.getComment());
        sp.setVerticalScrollBar(new ScrollBarCustom());
        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                showMovieDetail();
            }
            
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(255,255,255)); 
        g.fillRect(0, 0, getWidth(), getHeight());
    }
    private void showMovieDetail() {
        PnlChiTietFilmUser pnlCT = main.getPanel();
        pnlCT.showPanel("back phim trang chu");
        main.showMovieDetail(movieModel); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lbUser = new javax.swing.JLabel();
        lbstar = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        txaCmt = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setLayout(new java.awt.GridLayout(2, 1));

        lbUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbUser.setText("jLabel2");
        panel.add(lbUser);

        lbstar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/star16.png"))); // NOI18N
        lbstar.setText("jLabel3");
        panel.add(lbstar);

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txaCmt.setColumns(20);
        txaCmt.setLineWrap(true);
        txaCmt.setRows(5);
        txaCmt.setText("cmt");
        txaCmt.setBorder(null);
        sp.setViewportView(txaCmt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbUser;
    private javax.swing.JLabel lbstar;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTextArea txaCmt;
    // End of variables declaration//GEN-END:variables
}
