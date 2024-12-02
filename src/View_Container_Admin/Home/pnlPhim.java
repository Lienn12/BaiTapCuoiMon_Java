/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View_Container_Admin.Home;

import Model.Movie_model;
import View_Container_Admin.Home.PnlitemImage;
import View_Container_User.PnlitemImageUser;
import View_Main.frmMain;
import View_Main.frmMainUser;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author lienn
 */
public class pnlPhim extends javax.swing.JLayeredPane {
     private  frmMain main;
    public pnlPhim(frmMain main) {
        this.main=main;
        initComponents();
        sp.setBackground(new Color(255,255,255,128));
        panel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 0)); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        scrollBarCustom1 = new Scrollbar.ScrollBarCustom();

        sp.setBackground(new java.awt.Color(255, 255, 255));
        sp.setBorder(null);
        sp.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        sp.setHorizontalScrollBar(scrollBarCustom1);

        panel.setBackground(new java.awt.Color(255, 255, 255));
        sp.setViewportView(panel);

        scrollBarCustom1.setOrientation(javax.swing.JScrollBar.HORIZONTAL);

        setLayer(sp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(scrollBarCustom1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
            .addComponent(sp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void addImage(Movie_model movieModel){
        PnlitemImage item= new PnlitemImage(movieModel,main);
        panel.add(item);
        panel.repaint();
        panel.revalidate();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(255,255,255,128)); // Màu xanh dương với độ trong suốt 50%
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private Scrollbar.ScrollBarCustom scrollBarCustom1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
