/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Star_rating;

/**
 *
 * @author lienn
 */
public class Stars extends javax.swing.JPanel {

    public Stars() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        star1 = new Star_rating.Star();
        star2 = new Star_rating.Star();
        star3 = new Star_rating.Star();
        star4 = new Star_rating.Star();
        star5 = new Star_rating.Star();

        setLayout(new java.awt.GridLayout(1, 5));
        add(star1);
        add(star2);

        star3.setToolTipText("");
        add(star3);
        add(star4);

        star5.setMinimumSize(new java.awt.Dimension(60, 7));
        add(star5);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Star_rating.Star star1;
    private Star_rating.Star star2;
    private Star_rating.Star star3;
    private Star_rating.Star star4;
    private Star_rating.Star star5;
    // End of variables declaration//GEN-END:variables
}
