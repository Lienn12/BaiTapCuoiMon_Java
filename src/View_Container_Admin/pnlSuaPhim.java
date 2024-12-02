/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View_Container_Admin;

import Combobox.ComboboxSuggestion;
import Controllers.Country_controller;
import Controllers.Format_controller;
import Controllers.Genre_controller;
import Controllers.Movie_controller;
import Model.Countries;
import Model.Formats;
import Model.Genres;
import Model.Movie_model;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import View_Main.frmMain;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author ASUS
 */
public final class pnlSuaPhim extends javax.swing.JPanel {
    private final Genres genre = new Genres();
    private final Countries country = new Countries();
    private final Formats format = new Formats();
    private Movie_model movieModel;
    private Movie_controller control=new Movie_controller();
    private frmMain menu;
    private File selectedFile;
    private pnlDSPhim pnlDSPhim ;
    private int newMovieID;
     private final Movie_controller movie_controller=new Movie_controller();
    private final Country_controller countryController= new Country_controller();
    private final Genre_controller genreController= new Genre_controller();
    private final Format_controller formatController = new Format_controller();
    private DefaultComboBoxModel<Object> cbmodel;
     public pnlSuaPhim(frmMain menu,pnlDSPhim pnlDSPhim) {
        this.menu = menu;
        this.pnlDSPhim = pnlDSPhim;
        initComponents();
        txtMota.setLineWrap(true);
        txtMota.setWrapStyleWord(true);
        loadDataComboCountry();
        loadDataComboGenres();
        loadDataComboFormat();
    }
     public void setNull(){
        this.txtTen.setText("");
        this.txtNam.setText("");
        this.txtDaodien.setText("");
        this.txtDienVien.setText("");
        this.cbTheLoai.setSelectedIndex(-1);
        this.cbDinhDang.setSelectedIndex(-1);
        this.cbQuocGia.setSelectedIndex(-1);
        this.txtSoTap.setText("");
        this.txtMota.setText("");
        this.lblImage.setIcon(null);
    }
    private <T> void loadDataComboBox(ComboboxSuggestion<T> comboBox, List<T> dataList, String displayField) {
        try {
            DefaultComboBoxModel<T> cbModel = new DefaultComboBoxModel<>();
            comboBox.setModel(cbModel);
            cbModel.removeAllElements();

            if (dataList != null && !dataList.isEmpty()) {
                for (T item : dataList) {
                    if (item instanceof Genres) {
                        Genres genreItem = (Genres) item;
                        if (genreItem.getGenreId() == 1) {
                            continue;  // Loại bỏ phần tử có GenreId == 0
                        }
                    } else if (item instanceof Formats) {
                        Formats formatItem = (Formats) item;
                        if (formatItem.getFormatId() == 1) {
                            continue;  // Loại bỏ phần tử có FormatId == 0
                        }
                    } else if (item instanceof Countries) {
                        Countries countryItem = (Countries) item;
                        if (countryItem.getCountryId() == 1) {
                            continue;  // Loại bỏ phần tử có CountryId == 0
                        }
                    }
                    cbModel.addElement(item);
                }
            } else {
                System.out.println("Danh sách trống hoặc không hợp lệ");
            }
            comboBox.revalidate();
            comboBox.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadDataComboGenres() {
        try {
            List<Genres> dsGenre = genreController.getGenre(genre);
            loadDataComboBox(cbTheLoai, dsGenre, "genreName"); // "genreName" là tên của phương thức getter
        } catch (SQLException ex) {
            Logger.getLogger(pnlThemPhim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDataComboFormat() {
        try {
            List<Formats> dsFormat = formatController.getFormat(format);
            loadDataComboBox(cbDinhDang, dsFormat, "formatName"); // "formatName" là tên của phương thức getter
        } catch (SQLException ex) {
            Logger.getLogger(pnlThemPhim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDataComboCountry() {
        try {
            List<Countries> dsCountry = countryController.getCountry(country);
            loadDataComboBox(cbQuocGia, dsCountry, "countrysName"); // "countrysName" là tên của phương thức getter
        } catch (SQLException ex) {
            Logger.getLogger(pnlThemPhim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnUpload = new cell.PanelBorder();
        lbUpload = new javax.swing.JLabel();
        panelBorder2 = new cell.PanelBorder();
        lblImage = new javax.swing.JLabel();
        lbBack = new javax.swing.JLabel();
        panelBorder3 = new cell.PanelBorder();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNam = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDaodien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDienVien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMota = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtSoTap = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        cbTheLoai = new Combobox.ComboboxSuggestion<>();
        cbDinhDang = new Combobox.ComboboxSuggestion<>();
        cbQuocGia = new Combobox.ComboboxSuggestion<>();

        setBackground(new java.awt.Color(107, 153, 198));

        jLabel1.setBackground(new java.awt.Color(5, 38, 89));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(5, 38, 89));
        jLabel1.setText("Sửa phim");

        btnSave.setBackground(new java.awt.Color(5, 38, 89));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.setBorder(null);

        btnCancel.setBackground(new java.awt.Color(5, 38, 89));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.setBorder(null);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnUpload.setBackground(new java.awt.Color(125, 160, 202));
        btnUpload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUploadMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUploadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUploadMouseExited(evt);
            }
        });

        lbUpload.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbUpload.setForeground(new java.awt.Color(255, 255, 255));
        lbUpload.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/upload.png"))); // NOI18N
        lbUpload.setText("Upload");
        lbUpload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btnUploadLayout = new javax.swing.GroupLayout(btnUpload);
        btnUpload.setLayout(btnUploadLayout);
        btnUploadLayout.setHorizontalGroup(
            btnUploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbUpload, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
        );
        btnUploadLayout.setVerticalGroup(
            btnUploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbUpload, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        lblImage.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
        );

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

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(53, 102, 153));
        jLabel3.setText("Tên:");

        txtTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTen.setBorder(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(53, 102, 153));
        jLabel4.setText("Năm phát hành:");

        txtNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNam.setBorder(null);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(53, 102, 153));
        jLabel5.setText("Đạo diễn:");

        txtDaodien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDaodien.setBorder(null);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(53, 102, 153));
        jLabel6.setText("Diễn viên:");

        txtDienVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDienVien.setBorder(null);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(53, 102, 153));
        jLabel7.setText("Mô tả:");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtMota.setColumns(20);
        txtMota.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMota.setLineWrap(true);
        txtMota.setRows(5);
        txtMota.setBorder(null);
        jScrollPane1.setViewportView(txtMota);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(53, 102, 153));
        jLabel8.setText("Thể loại:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(53, 102, 153));
        jLabel10.setText("Quốc gia:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(53, 102, 153));
        jLabel11.setText("Số tập: ");

        txtSoTap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoTap.setBorder(null);

        jPanel5.setBackground(new java.awt.Color(52, 102, 153));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(52, 102, 153));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(52, 102, 153));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(52, 102, 153));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel13.setBackground(new java.awt.Color(52, 102, 153));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel15.setBackground(new java.awt.Color(52, 102, 153));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel16.setBackground(new java.awt.Color(52, 102, 153));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(53, 102, 153));
        jLabel12.setText("Định dạng");

        jPanel18.setBackground(new java.awt.Color(52, 102, 153));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        cbTheLoai.setBorder(null);

        cbDinhDang.setBorder(null);

        cbQuocGia.setBorder(null);

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSoTap)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(cbQuocGia, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)))
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbTheLoai, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                    .addComponent(cbDinhDang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtDienVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                            .addComponent(txtDaodien, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNam, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDaodien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(2, 2, 2)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelBorder3Layout.createSequentialGroup()
                                        .addComponent(txtDienVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6))
                                .addGap(20, 20, 20)
                                .addComponent(cbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8))
                        .addGap(20, 20, 20)
                        .addComponent(cbDinhDang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12))
                .addGap(20, 20, 20)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addComponent(cbQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addComponent(txtSoTap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(46, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(btnUpload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnUpload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBackMouseClicked
        if (pnlDSPhim != null) {
            pnlDSPhim.ClearData();
            pnlDSPhim.ShowData();  
        }
        menu.showPanel("danh sach phim");
    }//GEN-LAST:event_lbBackMouseClicked
    
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        setNull();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnUploadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUploadMouseEntered
//        btnUpload.setOpaque(true);
        btnUpload.setBackground(new Color(84, 131, 179));
    }//GEN-LAST:event_btnUploadMouseEntered

    private void btnUploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUploadMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);// chỉ hiển thị file
        int returnValue = fileChooser.showOpenDialog(this);
        if(returnValue==JFileChooser.APPROVE_OPTION){
            selectedFile = fileChooser.getSelectedFile();
            //lấy đưuòng danx file để lưu vào 1 trường
            String pathFile = selectedFile.getAbsolutePath();
            //            String pathFl = fl.getAbsolutePath().replace("//", "--");
            BufferedImage img0;
            try{
                img0 = ImageIO.read(selectedFile);
                Image img = img0.getScaledInstance(lblImage.getWidth(),lblImage.getHeight(),Image.SCALE_SMOOTH);
                lblImage.setIcon(new ImageIcon(img));
            }catch(Exception e){

            }
            
        }
    }//GEN-LAST:event_btnUploadMouseClicked

    private void btnUploadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUploadMouseExited
//        btnUpload.setOpaque(false);
        btnUpload.setBackground(new Color(51, 102, 153));
    }//GEN-LAST:event_btnUploadMouseExited
                                      
    public Movie_model getMovieDetails() {
        Movie_model movie = new Movie_model();
        movie.setTitle(txtTen.getText()); // Lấy tên phim
        movie.setReleaseYear(Integer.parseInt(txtNam.getText())); // Lấy năm phát hành
        movie.setDirector(txtDaodien.getText());
        movie.setCast(txtDienVien.getText());
        movie.setGenre(((Genres) cbTheLoai.getSelectedItem()));
        movie.setFormat(((Formats) cbDinhDang.getSelectedItem()));
        movie.setCountry((Countries) cbQuocGia.getSelectedItem());
        movie.setEpisodes(Integer.parseInt(txtSoTap.getText()));
        movie.setDescription(txtMota.getText()); // Lấy mô tả
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        // Chuyển đổi ảnh từ JLabel sang byte[]
        byte[] imageBytes = null;
        if (lblImage.getIcon() != null) {
            ImageIcon icon = (ImageIcon) lblImage.getIcon();
            Image image = icon.getImage();
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = bufferedImage.createGraphics();
                g2d.drawImage(image, 0, 0, null);
                g2d.dispose();
                ImageIO.write(bufferedImage, "jpg", baos);
                imageBytes = baos.toByteArray();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        movie.setImg(imageBytes); // Lấy ảnh
        return movie;
    }

    public void setMovieDetails(Movie_model movie) {
        newMovieID= movie.getMovieID();
        txtNam.setText(String.valueOf(movie.getReleaseYear())); 
        txtTen.setText(movie.getTitle()); 
        txtDaodien.setText(movie.getDirector());
        txtDienVien.setText(movie.getCast());
        cbTheLoai.setSelectedItem(movie.getGenre());
        cbDinhDang.setSelectedItem(movie.getFormat());
        cbQuocGia.setSelectedItem(movie.getCountry());
        txtSoTap.setText(String.valueOf(movie.getEpisodes()));
        txtMota.setText(movie.getDescription()); 
        if(movie.getImg() !=null && movie.getImg().length >0){
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(movie.getImg());
                Image img = ImageIO.read(bis);
                if (img != null) {
                    ImageIcon icon = new ImageIcon(img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
                    lblImage.setIcon(icon);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        btnSave.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Movie_model movie = getMovieDetails(); 
                    movie.setMovieID(newMovieID);
                    if(control.updateMovie(movie)){
                        JOptionPane.showMessageDialog(menu, "Đã sửa thành công");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(menu, "Lỗi: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }  
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private cell.PanelBorder btnUpload;
    private Combobox.ComboboxSuggestion<Formats> cbDinhDang;
    private Combobox.ComboboxSuggestion<Countries> cbQuocGia;
    private Combobox.ComboboxSuggestion<Genres> cbTheLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBack;
    private javax.swing.JLabel lbUpload;
    private javax.swing.JLabel lblImage;
    private cell.PanelBorder panelBorder2;
    private cell.PanelBorder panelBorder3;
    private javax.swing.JTextField txtDaodien;
    private javax.swing.JTextField txtDienVien;
    private javax.swing.JTextArea txtMota;
    private javax.swing.JTextField txtNam;
    private javax.swing.JTextField txtSoTap;
    private javax.swing.JTextField txtTen;
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
            g2.fillRect(0, 0, width , height);
      }
}
