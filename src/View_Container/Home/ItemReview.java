/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View_Container.Home;

import Model.Movie_model;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author lienn
 */
public class ItemReview extends javax.swing.JPanel {
    public Movie_model getData(){
        return movieModel;     
    }
    private final Movie_model movieModel;
    public ItemReview(Movie_model movieModel) {
        this.movieModel= movieModel;
        initComponents();
        setOpaque(false);
        panel.setBackground(new Color(255,255,255,0));
        lbTitle.setText(movieModel.getTitle());
        lbstar.setText(String.valueOf(movieModel.getRating()));
        lbImg.setPreferredSize(new Dimension(80, 90));
        loadImage();
    }
     private void loadImage() {
        if (movieModel.getImg() != null && movieModel.getImg().length > 0) {
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(movieModel.getImg());
                BufferedImage bufferedImage = ImageIO.read(bis);
                if (bufferedImage != null) {
                    int width = lbImg.getPreferredSize().width;
                    int height = lbImg.getPreferredSize().height;
                    Image scaledImg = bufferedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                    lbImg.setIcon(new ImageIcon(scaledImg));
                } else {
                    lbImg.setText("Invalid image");
                }
            } catch (Exception e) {
                e.printStackTrace();
                lbImg.setText("Error loading image");
            }
        } else {
            lbImg.setText("No Image");
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(255,255,255,128)); 
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        lbstar = new javax.swing.JLabel();
        lbImg = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setLayout(new java.awt.GridLayout(2, 1, 5, 5));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setText("jLabel2");
        panel.add(lbTitle);

        lbstar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/star16.png"))); // NOI18N
        lbstar.setText("jLabel3");
        panel.add(lbstar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lbImg, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbImg;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbstar;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
