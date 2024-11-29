/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View_Container;

import Model.Movie_model;

/**
 *
 * @author lienn
 */
public class pnlPhim extends javax.swing.JLayeredPane {

    public pnlPhim() {
        initComponents();
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
            .addComponent(sp)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void addImage(Movie_model movieModel){
        pnlitemImage item= new pnlitemImage();
        item.setData(movieModel);
        panel.add(item);
        panel.repaint();
        panel.revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private Scrollbar.ScrollBarCustom scrollBarCustom1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
