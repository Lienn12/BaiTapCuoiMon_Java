/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View_Main;

import View_Main.frmMain;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PnlHeader extends javax.swing.JPanel {
    public PnlHeader() {
        initComponents();
        setOpaque(false);
        
        btnExit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(PnlHeader.this);
                    topFrame.dispose();            
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnExit.setBackground(Color.decode("#f0f0f0")); // Màu nền khi chuột đi vào
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnExit.setBackground(Color.WHITE); // Màu nền khi chuột rời khỏi
            }
        });
        
        btnMinimize.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(PnlHeader.this);
                    topFrame.setState(JFrame.ICONIFIED); 
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnMinimize.setBackground(Color.decode("#f0f0f0")); // Màu nền khi di chuột
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnMinimize.setBackground(Color.WHITE); // Màu nền trở lại khi chuột ra
            }

        });
    }
    @Override
    protected void paintComponent(Graphics g) { 
        super.paintComponent(g); 
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        g2.setColor(Color.decode("#FFFFFF"));
        g2.fillRoundRect(0, 0, width, height, 15, 15);
        g2.fillRect(0, 0, 25, getHeight());
        g2.fillRect(getWidth()-25,getHeight()-25, getWidth(),getHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        searchtxt1 = new cell.Searchtxt();
        btnExit = new javax.swing.JPanel();
        lbExit = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JPanel();
        lbMinimize = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/seacrhxanh.png"))); // NOI18N

        searchtxt1.setBorder(null);

        btnExit.setBackground(new java.awt.Color(255, 255, 255));

        lbExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit..png"))); // NOI18N

        javax.swing.GroupLayout btnExitLayout = new javax.swing.GroupLayout(btnExit);
        btnExit.setLayout(btnExitLayout);
        btnExitLayout.setHorizontalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnExitLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbExit)
                .addContainerGap())
        );
        btnExitLayout.setVerticalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnExitLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnMinimize.setBackground(new java.awt.Color(255, 255, 255));

        lbMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/minimize.png"))); // NOI18N

        javax.swing.GroupLayout btnMinimizeLayout = new javax.swing.GroupLayout(btnMinimize);
        btnMinimize.setLayout(btnMinimizeLayout);
        btnMinimizeLayout.setHorizontalGroup(
            btnMinimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnMinimizeLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbMinimize)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        btnMinimizeLayout.setVerticalGroup(
            btnMinimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnMinimizeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchtxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchtxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnExit;
    private javax.swing.JPanel btnMinimize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbExit;
    private javax.swing.JLabel lbMinimize;
    private cell.Searchtxt searchtxt1;
    // End of variables declaration//GEN-END:variables
}
