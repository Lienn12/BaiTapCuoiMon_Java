/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View_Container_Admin.Home;

import Controllers.Movie_controller;
import Model.Movie_model;
import Scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reviews extends javax.swing.JPanel {

    private Movie_controller movieController;
    public Reviews() {
        initComponents();
        movieController = new Movie_controller();
        init();
        sp.setVerticalScrollBar(new ScrollBarCustom());
        sp.setBackground(Color.white);
        setBackground(new Color(255,255,255,128));
    }
    private void init(){
        try {
            List<Movie_model> movies = movieController.getReview();
            for (Movie_model movie : movies) {
                list.addItem(movie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reviews.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();

        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        list = new View_Container_Admin.Home.ListReview<>();

        setBackground(new java.awt.Color(255, 255, 255));

        sp.setBorder(null);

        list.setBorder(null);
        sp.setViewportView(list);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View_Container_Admin.Home.ListReview<String> list;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
