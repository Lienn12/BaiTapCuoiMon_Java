/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View_Container_Admin;

import Controllers.Review_controller;
import Model.Review_model;
import Scrollbar.ScrollBarCustom;
import Star_rating.EventStarRating;
import View_Main.frmMain;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ASUS
 */
public class pnlReplyCmt extends javax.swing.JPanel {
    private final Review_controller reviewController= new Review_controller();
    private  frmMain main;
    private Icon emptyStar;
    private Icon fullStar;
    public pnlReplyCmt(frmMain main) {
        this.main=main;
        initComponents();
        loadIcons();
        setHide(false);
    }
    
    public void setHide(boolean a){
        txtReply.setVisible(a);
        btnReply.setVisible(a);
    }
    
    private void loadIcons() {
        ImageIcon originalEmptyIcon = new ImageIcon(getClass().getResource("/icon/star_Ray.png"));
        Image scaledEmptyImage = originalEmptyIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        emptyStar = new ImageIcon(scaledEmptyImage);

        ImageIcon originalFullIcon = new ImageIcon(getClass().getResource("/icon/star_Yellow.png"));
        Image scaledFullImage = originalFullIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        fullStar = new ImageIcon(scaledFullImage);
    }
    public void setRating(int rating) {
        star1.setIcon(rating >= 1 ? fullStar : emptyStar);
        star2.setIcon(rating >= 2 ? fullStar : emptyStar);
        star3.setIcon(rating >= 3 ? fullStar : emptyStar);
        star4.setIcon(rating >= 4 ? fullStar : emptyStar);
        star5.setIcon(rating >= 5 ? fullStar : emptyStar);
    }
    public void setData(Review_model reviewModel){
        lbUsername.setText(reviewModel.getUserModel().getUsername());
        String formattedDate = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(reviewModel.getReviewDate());
        lbTime.setText(formattedDate); 
        txtCmt.setText(reviewModel.getComment());
        txtshowReply.setText(reviewModel.getReply());
        String title = reviewModel.getMovieModel().getTitle();
        title = "<html>" + title.replace("\n", "<br>") + "</html>";
        lbTitle.setText(title);
        lbTitle.setPreferredSize(new Dimension(236, 150)); 
         if (reviewModel.getMovieModel().getImg() != null && reviewModel.getMovieModel().getImg().length > 0) {
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(reviewModel.getMovieModel().getImg());
                Image img = ImageIO.read(bis);
                if (img != null) {
                    ImageIcon icon = new ImageIcon(img.getScaledInstance(lbImg.getWidth(), lbImg.getHeight(), Image.SCALE_SMOOTH));
                    lbImg.setIcon(icon);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        setRating(reviewModel.getRating());
        actions(reviewModel);
    }
    public void actions(Review_model reviewModel) {
        for (MouseListener listener : btnPlus.getMouseListeners()) {
            btnPlus.removeMouseListener(listener);
        }
        btnPlus.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                setHide(true);
            }           
        });
        for (MouseListener listener : btnReply.getMouseListeners()) {
            btnReply.removeMouseListener(listener);
        }
        btnReply.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String reply = txtReply.getText().trim();
                    if (reply.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập phản hồi");
                        return;
                    }                    
                    boolean isAdded = reviewController.setReply(reviewModel.getReviewID(), reply);
                    if (isAdded) {
                        txtshowReply.setText(reply);
                        txtReply.setText("");
                        setHide(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Thêm phản hồi thất bại!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi thêm phản hồi.");
                }
            }
        });
        for (MouseListener listener : btnDelete.getMouseListeners()) {
            btnDelete.removeMouseListener(listener);
        }
        btnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                     int result = JOptionPane.showConfirmDialog(
                        main,
                        "Bạn có chắc chắn muốn xóa không?",
                        "Xác nhận", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.QUESTION_MESSAGE 
                    );
                    if (result == JOptionPane.YES_OPTION) {
                            reviewController.deleteReply(reviewModel.getReviewID());
                            txtshowReply.setText("");
                    }                   
                } catch (SQLException ex) {
                    Logger.getLogger(pnlReplyCmt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void clearData(){
        lbUsername.setText("");
        lbTime.setText("");
        txtCmt.setText("");
        lbTitle.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        panelBorder1 = new cell.PanelBorder();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbUsername = new javax.swing.JLabel();
        lbTime = new javax.swing.JLabel();
        star1 = new javax.swing.JLabel();
        star3 = new javax.swing.JLabel();
        star2 = new javax.swing.JLabel();
        star4 = new javax.swing.JLabel();
        star5 = new javax.swing.JLabel();
        txtshowReply = new javax.swing.JTextArea();
        btnReply = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        btnPlus = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        txtCmt = new javax.swing.JTextArea();
        txtReply = new javax.swing.JTextArea();
        lbImg = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        lbBack = new javax.swing.JLabel();

        jSeparator2.setBackground(new java.awt.Color(53, 102, 153));
        jSeparator2.setForeground(new java.awt.Color(53, 102, 153));

        setBackground(new java.awt.Color(107, 153, 198));

        jLabel1.setBackground(new java.awt.Color(5, 38, 89));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(5, 38, 89));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Phản hồi đánh giá");

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(53, 102, 153));
        jLabel11.setText("Phản hồi");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(53, 102, 153));
        jLabel4.setText("Ngày đánh giá");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(53, 102, 153));
        jLabel7.setText("Bình luận");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(53, 102, 153));
        jLabel8.setText("Đánh giá");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(53, 102, 153));
        jLabel3.setText("Username");

        lbUsername.setBackground(new java.awt.Color(255, 255, 255));
        lbUsername.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbUsername.setText("   ");

        lbTime.setBackground(new java.awt.Color(255, 255, 255));
        lbTime.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbTime.setText("   ");

        star1.setForeground(new java.awt.Color(255, 255, 255));
        star1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        star1.setText("      ");

        star3.setForeground(new java.awt.Color(255, 255, 255));
        star3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        star3.setText("      ");
        star3.setToolTipText("");

        star2.setForeground(new java.awt.Color(255, 255, 255));
        star2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        star2.setText("      ");

        star4.setForeground(new java.awt.Color(255, 255, 255));
        star4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        star4.setText("      ");

        star5.setForeground(new java.awt.Color(255, 255, 255));
        star5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        star5.setText("      ");

        txtshowReply.setEditable(false);
        txtshowReply.setColumns(20);
        txtshowReply.setLineWrap(true);
        txtshowReply.setRows(5);
        txtshowReply.setWrapStyleWord(true);
        txtshowReply.setBorder(null);

        btnReply.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reply.png"))); // NOI18N
        btnReply.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnDelete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sub.png"))); // NOI18N

        btnPlus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPlus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(53, 102, 153));
        jSeparator1.setForeground(new java.awt.Color(53, 102, 153));

        jSeparator3.setBackground(new java.awt.Color(53, 102, 153));
        jSeparator3.setForeground(new java.awt.Color(53, 102, 153));

        txtCmt.setEditable(false);
        txtCmt.setColumns(20);
        txtCmt.setLineWrap(true);
        txtCmt.setRows(5);
        txtCmt.setWrapStyleWord(true);
        txtCmt.setBorder(null);

        txtReply.setColumns(20);
        txtReply.setLineWrap(true);
        txtReply.setRows(5);
        txtReply.setWrapStyleWord(true);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11))
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtshowReply)
                            .addComponent(txtReply))
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnPlus))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnReply))))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCmt, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelBorder1Layout.createSequentialGroup()
                                    .addComponent(star1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(star3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(star2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(star4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(star5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(12, 12, 12))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(star1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(star3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(star2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(star4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(star5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(25, 25, 25)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(btnPlus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete))
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtshowReply, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnReply))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtReply, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        lbImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("   ");
        lbTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/backxanh.png"))); // NOI18N
        lbBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbBack.setMaximumSize(new java.awt.Dimension(32, 48));
        lbBack.setPreferredSize(new java.awt.Dimension(50, 48));
        lbBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 415, Short.MAX_VALUE)
                        .addComponent(lbBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbImg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbBack, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(76, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBackMouseClicked
        main.showPanel("danh gia");
    }//GEN-LAST:event_lbBackMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnPlus;
    private javax.swing.JLabel btnReply;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbBack;
    private javax.swing.JLabel lbImg;
    private javax.swing.JLabel lbTime;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUsername;
    private cell.PanelBorder panelBorder1;
    private javax.swing.JLabel star1;
    private javax.swing.JLabel star2;
    private javax.swing.JLabel star3;
    private javax.swing.JLabel star4;
    private javax.swing.JLabel star5;
    private javax.swing.JTextArea txtCmt;
    private javax.swing.JTextArea txtReply;
    private javax.swing.JTextArea txtshowReply;
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
