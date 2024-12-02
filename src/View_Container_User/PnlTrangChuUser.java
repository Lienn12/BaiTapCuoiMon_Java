/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View_Container_User;

import Controllers.Country_controller;
import Controllers.Format_controller;
import Controllers.Genre_controller;
import Controllers.Movie_controller;
import Model.Countries;
import Model.Formats;
import Model.Genres;
import Model.Movie_model;
import View_Container_Admin.Home.PnlPhimLoai;
import View_Container_Admin.Home.PnlPhimTrangchu;
import View_Main.frmMain;
import View_Main.frmMainUser;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 *
 * @author lienn
 */
public class PnlTrangChuUser extends javax.swing.JPanel {
    private JPopupMenu countryMenu;
     private JPopupMenu genreMenu;  
    private CardLayout cardLayout;
    private PnlPhimTrangchuUser pnlPhimTrangchu;
    private PnlPhimLoaiUser pnlPhimLoai;
    private final Genres genre = new Genres();
    private final Countries country = new Countries();
    private final Formats format = new Formats();
    private frmMainUser main;
    private final Movie_model movieModel=new Movie_model();
    private final Movie_controller movieController = new Movie_controller();
    private final Country_controller countryController= new Country_controller();
    private final Genre_controller genreController= new Genre_controller();
    private final Format_controller formatController = new Format_controller();
    public PnlTrangChuUser(frmMainUser main) {
        this.main=main;
        initComponents();
        init();
        initComboGenre();
        initComboCountry();
        initPhim();
    }
    public void init(){
        cardLayout=new CardLayout();
        pnlPhim.setLayout(cardLayout);       
        pnlPhimLoai = new PnlPhimLoaiUser(this,movieModel);
        pnlPhimTrangchu = new PnlPhimTrangchuUser(this,main);
        pnlPhim.add(pnlPhimTrangchu,"phim trang chu");
        pnlPhim.add(pnlPhimLoai,"phim loai");
        showPanel("phim trang chu");
    }
    public void showPanel(String panelName){
        cardLayout.show(pnlPhim, panelName); 
    }    
    public void initComboGenre(){
        try {
            JPanel genrePanel = new JPanel();
            genrePanel.setLayout(new GridLayout(0, 3, 20, 15));
            genrePanel.setBackground(new Color(5,38,89));
            List<Genres> dsGenre= genreController.getGenre(genre);
            for(Genres genre: dsGenre){
                if(genre.getGenreId()==1){
                    continue;
                }
                JLabel lb= new JLabel(genre.getGenreName());
                lb.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                lb.setForeground(Color.WHITE);
                lb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                genrePanel.add(lb);
                lb.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        lb.setForeground(new Color(125,160,202));
                        openGenre(genre);
                        genreMenu.setVisible(false); 
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        lb.setForeground(new Color(125,160,202));
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        lb.setForeground(Color.WHITE);
                    } 
                });
            }
            genreMenu = new JPopupMenu();
            genreMenu.add(genrePanel); 
            genreMenu.setBorderPainted(false);
            lbTheLoai.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    lbTheLoai.setForeground(new Color(192, 232, 255));
                    genreMenu.show(lbTheLoai, 0, lbTheLoai.getHeight());
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    lbTheLoai.setForeground(Color.WHITE);
                }                
            });
        } catch (SQLException ex) {
            Logger.getLogger(PnlTrangChuUser.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    public void initComboCountry(){
        try {
            JPanel countryPanel = new JPanel();
            countryPanel.setLayout(new GridLayout(0, 3, 20, 15));
            countryPanel.setBackground(new Color(5,38,89));
            List<Countries> dsCountry= countryController.getCountry(country);
            for(Countries country: dsCountry){
                if(country.getCountryId()==1){
                    continue;
                }
                JLabel lb= new JLabel(country.getCountrysName());
                lb.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                lb.setForeground(Color.WHITE);
                lb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                countryPanel.add(lb);
                lb.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        lb.setForeground(new Color(125,160,202));
                        openCountry(country);
                        countryMenu.setVisible(false); 
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        lb.setForeground(new Color(125,160,202));
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        lb.setForeground(Color.WHITE);
                    }

                });
            }
            countryMenu = new JPopupMenu();
            countryMenu.add(countryPanel); 
            countryMenu.setBorderPainted(false);
            lbQuocGia.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    lbQuocGia.setForeground(new Color(192, 232, 255));
                    countryMenu.show(lbQuocGia, 0, lbQuocGia.getHeight());
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    lbQuocGia.setForeground(Color.WHITE);
                }                
            });
        } catch (SQLException ex) {
            Logger.getLogger(PnlTrangChuUser.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    public void initPhim(){
        lbPhimMoi.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                openPhimmoi(movieModel);
                genreMenu.setVisible(false); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                lbPhimMoi.setForeground(new Color(125,160,202));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lbPhimMoi.setForeground(Color.WHITE);
            }            
        });
        lbPhimBo.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                format.setFormatName("Phim Bộ");
                openFormat(format);
                genreMenu.setVisible(false); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                lbPhimBo.setForeground(new Color(125,160,202));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lbPhimBo.setForeground(Color.WHITE);
            }            
        });
        lbPhimLe.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                format.setFormatName("Phim Lẻ");
                openFormat(format);
                genreMenu.setVisible(false); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                lbPhimLe.setForeground(new Color(125,160,202));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lbPhimLe.setForeground(Color.WHITE);
            }            
        });
    }
    
    private void openGenre(Genres genre) {
        pnlPhimLoai.updateMoviesByGenre(genre);
        showPanel("phim loai");
    }
    private void openCountry(Countries country) {
        pnlPhimLoai.updateMoviesByCountry(country);
        showPanel("phim loai");
    }
    private void openPhimmoi(Movie_model movieModel){
        pnlPhimLoai.loadData();
        showPanel("phim loai");
    }
    private void openFormat(Formats format){
        pnlPhimLoai.updateMoviesByFormat(format);
        showPanel("phim loai");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbPhimMoi = new javax.swing.JLabel();
        lbTheLoai = new javax.swing.JLabel();
        lbQuocGia = new javax.swing.JLabel();
        lbPhimBo = new javax.swing.JLabel();
        lbPhimLe = new javax.swing.JLabel();
        pnlPhim = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(5, 38, 89));

        lbPhimMoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbPhimMoi.setForeground(new java.awt.Color(255, 255, 255));
        lbPhimMoi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPhimMoi.setText("PHIM MỚI");
        lbPhimMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbTheLoai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTheLoai.setForeground(new java.awt.Color(255, 255, 255));
        lbTheLoai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTheLoai.setText("THỂ LOẠI");
        lbTheLoai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbQuocGia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbQuocGia.setForeground(new java.awt.Color(255, 255, 255));
        lbQuocGia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQuocGia.setText("QUỐC GIA");
        lbQuocGia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbPhimBo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbPhimBo.setForeground(new java.awt.Color(255, 255, 255));
        lbPhimBo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPhimBo.setText("PHIM BỘ");
        lbPhimBo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbPhimLe.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbPhimLe.setForeground(new java.awt.Color(255, 255, 255));
        lbPhimLe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPhimLe.setText("PHIM LẺ");
        lbPhimLe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lbPhimMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPhimBo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbPhimLe, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPhimMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPhimBo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPhimLe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlPhimLayout = new javax.swing.GroupLayout(pnlPhim);
        pnlPhim.setLayout(pnlPhimLayout);
        pnlPhimLayout.setHorizontalGroup(
            pnlPhimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlPhimLayout.setVerticalGroup(
            pnlPhimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlPhim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbPhimBo;
    private javax.swing.JLabel lbPhimLe;
    private javax.swing.JLabel lbPhimMoi;
    private javax.swing.JLabel lbQuocGia;
    private javax.swing.JLabel lbTheLoai;
    private javax.swing.JPanel pnlPhim;
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
