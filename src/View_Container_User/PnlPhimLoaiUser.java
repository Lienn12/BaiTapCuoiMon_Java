/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View_Container_User;


import View_Container_Admin.Home.PnlitemImage;
import Combobox.ComboBoxUI;
import Controllers.Country_controller;
import Controllers.Format_controller;
import Controllers.Genre_controller;
import View_Container_Admin.PnlTrangChu;
import Controllers.Movie_controller;
import Model.Countries;
import Model.Formats;
import Model.Genres;
import Model.Movie_model;
import Scrollbar.ScrollBarCustom;
import View_Container_Admin.Home.WrapLayout;
import View_Container_Admin.pnlThemPhim;
import View_Main.frmMainUser;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author lienn
 */
public class PnlPhimLoaiUser extends javax.swing.JPanel {
    private frmMainUser main;
    private Movie_model movieModel;
    private PnlTrangChuUser pnlTrangChu;
    private final Genres genre = new Genres();
    private final Countries country = new Countries();
    private final Formats format = new Formats();
    private final Movie_controller movieController= new Movie_controller();
    private final Country_controller countryController= new Country_controller();
    private final Genre_controller genreController= new Genre_controller();
    private final Format_controller formatController = new Format_controller();
     private DefaultComboBoxModel<Object> cbmodel;
    public PnlPhimLoaiUser(PnlTrangChuUser pnlTrangChu,Movie_model movieModel) {
        this.pnlTrangChu=pnlTrangChu;
        this.movieModel=movieModel;
        initComponents();
        loadData();
        panel.setLayout(new WrapLayout(WrapLayout.LEADING));
        sp.setVerticalScrollBar(new ScrollBarCustom());
        loadDataComboCountry();
        loadDataComboGenres();
        loadDataComboFormat();
        SortComboBox();
    }
    public void updateMoviesByGenre(Genres genre) {
        try {
            List<Movie_model> dsmovie = movieController.getMoviesByGenreID(genre.getGenreId());
            for (int i = 0; i < cbTheLoai.getItemCount(); i++) {
                String genreName = cbTheLoai.getItemAt(i).toString(); 
                if (genreName.equals(genre.getGenreName())) {
                    cbTheLoai.setSelectedIndex(i);  
                    break;
                }
            }
             init(dsmovie) ;
        } catch (SQLException ex) {
            Logger.getLogger(PnlPhimLoaiUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateMoviesByCountry(Countries country) {
        try {
            List<Movie_model> dsmovie = movieController.getMoviesByCountryID(country.getCountryId());
            for (int i = 0; i < cbQuocGia.getItemCount(); i++) {
                String countryName = cbQuocGia.getItemAt(i).toString(); 
                if (countryName.equals(country.getCountrysName())) { 
                    cbQuocGia.setSelectedIndex(i);  
                    break;
                }
                else{
                    System.out.println("sau if countryName "+countryName);
                }
            }
             init(dsmovie) ;
        } catch (SQLException ex) {
            Logger.getLogger(PnlPhimLoaiUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateMoviesByFormat(Formats format) {
        try {
            if (format == null || format.getFormatName() == null) {
                throw new IllegalArgumentException("Format hoặc format name không được null");
            }
            List<Movie_model> dsmoviebo = movieController.getphimbo();
            List<Movie_model> dsmoviele = movieController.getphimle();
            if (format.getFormatName().equalsIgnoreCase("Phim Bộ")) {
                init(dsmoviebo) ;
            } else if (format.getFormatName().equalsIgnoreCase("Phim Lẻ")) {
                init(dsmoviele) ;
            }
            for (int i = 0; i < cbDinhDang.getItemCount(); i++) {
                String formatName = cbDinhDang.getItemAt(i).toString();
                if (formatName.equalsIgnoreCase(format.getFormatName())) {
                    cbDinhDang.setSelectedIndex(i); 
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PnlPhimLoaiUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void init(List<Movie_model> dsmovie) {
        try {
            if (dsmovie != null && !dsmovie.isEmpty()) {
                panel.removeAll();  
                for (Movie_model movie : dsmovie) {
                    if (movie != null) {
                        PnlitemImageUser item = new PnlitemImageUser(movie,main);  
                        panel.add(item);  
                    } else {
                        System.out.println("Movie_model là null.");
                    }
                }
                panel.revalidate(); 
                panel.repaint();  
            } else {
                panel.removeAll();
                JLabel noMoviesLabel = new JLabel("Không có phim phù hợp!");
                panel.add(noMoviesLabel);
                panel.revalidate();
                panel.repaint();
                System.out.println("Không có phim để hiển thị!");
            }
        } catch (NullPointerException npe) {
            System.out.println("Lỗi NullPointerException: " + npe.getMessage());
            npe.printStackTrace();
        }
    }
    public void loadData() {
        try {
            List<Movie_model> dsmovie = movieController.getImage();
            init(dsmovie);
        } catch (SQLException ex) {
            Logger.getLogger(PnlPhimLoaiUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private <T> void loadDataComboBox(ComboBoxUI<T> comboBox, List<T> dataList, String displayField) {
        try {
            DefaultComboBoxModel<T> cbModel = new DefaultComboBoxModel<>();
            comboBox.setModel(cbModel);
            cbModel.removeAllElements();

            if (dataList != null && !dataList.isEmpty()) {
                for (T item : dataList) {
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
            loadDataComboBox(cbTheLoai, dsGenre, "genreName");
            cbTheLoai.setSelectedIndex(0);
        } catch (SQLException ex) {
            Logger.getLogger(pnlThemPhim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDataComboFormat() {
        try {  
            List<Formats> dsFormat = formatController.getFormat(format);
            loadDataComboBox(cbDinhDang, dsFormat, "formatName"); 
            cbDinhDang.setSelectedIndex(0);
        } catch (SQLException ex) {
            Logger.getLogger(pnlThemPhim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDataComboCountry() {
        try {
            cbQuocGia.addItem(new Countries(0, "Quốc gia"));
            List<Countries> dsCountry = countryController.getCountry(country);
            loadDataComboBox(cbQuocGia, dsCountry, "countrysName"); 
            cbQuocGia.setSelectedIndex(0);
        } catch (SQLException ex) {
            Logger.getLogger(pnlThemPhim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void SortComboBox(){
        String item[]={"Sắp xếp","Tên phim (A-Z)", "Năm phát hành", "Đánh giá"};
        cbSapXep.removeAllItems();
        for (String s : item) { 
            cbSapXep.addItem(s);
        } 
        cbSapXep.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        cbTheLoai = new Combobox.ComboBoxUI<>();
        cbQuocGia = new Combobox.ComboBoxUI<>();
        cbDinhDang = new Combobox.ComboBoxUI<>();
        cbSapXep = new Combobox.ComboBoxUI<>();
        panelBorder1 = new cell.PanelBorder();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        sp.setBackground(new java.awt.Color(242, 242, 242));
        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        panel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 763, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        panelBorder1.setBackground(new java.awt.Color(5, 38, 89));
        panelBorder1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBorder1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelBorder1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelBorder1MouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tìm kiếm");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbDinhDang, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbDinhDang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void panelBorder1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBorder1MouseClicked
        try {
            String selectedGenreName = cbTheLoai.getSelectedItem().toString();
            String selectedCountryName = cbQuocGia.getSelectedItem().toString();
            String selectedFormatName = cbDinhDang.getSelectedItem().toString();
            int selectedSort = cbSapXep.getSelectedIndex();
            int selectedGenreId = getGenreIdFromModel(selectedGenreName);  
            int selectedCountryId = getCountryIdFromModel(selectedCountryName);  
            int selectedFormatId = getFormatIdFromModel(selectedFormatName);  
            List<Movie_model> dsmovie = movieController.searchMovies(selectedGenreId, selectedCountryId, selectedFormatId, selectedSort);
            init(dsmovie);
        }  catch (SQLException ex) {
            Logger.getLogger(PnlPhimLoaiUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_panelBorder1MouseClicked

    private int getGenreIdFromModel(String genreName) {
        try {
            List<Genres> dsGenre = genreController.getGenre(genre);
            for (Genres genre : dsGenre) {
                if (genre.getGenreName().equals(genreName)) {
                    return genre.getGenreId();
                }
            }
            return 0; 
        } catch (SQLException ex) {
            Logger.getLogger(PnlPhimLoaiUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    private int getCountryIdFromModel(String countryName) {
        try {
            List<Countries> dsCountry = countryController.getCountry(country);
            for (Countries country: dsCountry) {
                if (country.getCountrysName().equals(countryName)) {
                    return country.getCountryId();
                }
            }
            return 0; 
        } catch (SQLException ex) {
            Logger.getLogger(PnlPhimLoaiUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    private int getFormatIdFromModel(String formatName) {
        try {
            List<Formats> dsFormat = formatController.getFormat(format);
            for (Formats format : dsFormat) {
                if (format.getFormatName().equals(formatName)) {
                    return format.getFormatId();
                }
            }
            return 0; 
        } catch (SQLException ex) {
            Logger.getLogger(PnlPhimLoaiUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    private void panelBorder1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBorder1MouseEntered
        
    }//GEN-LAST:event_panelBorder1MouseEntered

    private void panelBorder1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBorder1MouseExited
        
    }//GEN-LAST:event_panelBorder1MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Combobox.ComboBoxUI<Formats> cbDinhDang;
    private Combobox.ComboBoxUI<Countries> cbQuocGia;
    private Combobox.ComboBoxUI<String> cbSapXep;
    private Combobox.ComboBoxUI<Genres> cbTheLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panel;
    private cell.PanelBorder panelBorder1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
