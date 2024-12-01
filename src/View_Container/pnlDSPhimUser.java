
package View_Container;
import Controllers.Movie_controller;
import Model.Movie_model;
import Scrollbar.ScrollBarCustom;
import javax.swing.table.DefaultTableModel;
import View_Main.frmMain;
import View_Main.frmMainUser;
import cell.tableActUser_DSPhim;
import cell.tblActionCellEditorUser_DSPhim;
import cell.tblActionUser_DSPhim;
import java.awt.Color;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.TableRowSorter;


public final class pnlDSPhimUser extends javax.swing.JPanel {
    private final Movie_model movie= new Movie_model();
    private final Movie_controller movieController= new Movie_controller();
    private frmMainUser menu;
    private DefaultTableModel tableModel= new DefaultTableModel();
    private TableRowSorter<DefaultTableModel> sorter; 
    public pnlDSPhimUser(frmMainUser menu) {
        this.menu = menu;
        initComponents(); 
        init();
        String []colsName={"ID","Tên phim","Năm phát hành",""};
        tableModel.setColumnIdentifiers(colsName);
        table.setModel(tableModel);
        ShowData();
        sorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(sorter);
        spTable.setVerticalScrollBar(new ScrollBarCustom());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        JPanel p=new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER,p);
        spTable.getViewport().setBackground(Color.white);
        tblActionUser_DSPhim event = new tblActionUser_DSPhim() {
            @Override
            public void onView(int row) {
                int movieID = getSelectedMovieID();
                if (movieID != -1) {
                    showMovie(movieID);
                } else {
                    System.out.println("Không có phim nào được chọn!");
                }
            }
            @Override
            public void onRemove(int row) {
                int movieId= Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
                if(table.isEditing()){
                    table.getCellEditor().stopCellEditing();
                }
                if(JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn xóa phim này không??","Thong bao",2)==0){
                    try {
                        movieController.DeleteFilm(movieId);
                    } catch (SQLException ex) {
                        Logger.getLogger(pnlDSPhim.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    tableModel.removeRow(row);
                }
                
            }
        };
        table.getColumnModel().getColumn(3).setCellRenderer(new tableActUser_DSPhim());
        table.getColumnModel().getColumn(3).setCellEditor(new tblActionCellEditorUser_DSPhim(event));
       
    }

    public pnlDSPhimUser() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void init(){
//        txtSearch.addOption(new SearchOption("Name"));
    }
//    String fgetFieldName
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelBorder1 = new cell.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new Table.Table();

        setToolTipText("");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(5, 38, 89));
        jLabel1.setText("Danh sách Phim");

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        spTable.setBackground(new java.awt.Color(255, 255, 255));
        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Tên phim", "Năm phát hành", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(255, 255, 255));
        table.setSelectionBackground(new java.awt.Color(239, 244, 255));
        spTable.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(3).setMinWidth(50);
            table.getColumnModel().getColumn(3).setPreferredWidth(50);
            table.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTable)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
     
    public void ShowData() {
            try{
                List<Movie_model> dsMovie= movieController.getMovie(movie);
                try{
                    tableModel.setRowCount(0); 
                    for(int i=0; i<dsMovie.size();i++){
                        Object row[]={
                            dsMovie.get(i).getMovieID(),
                            dsMovie.get(i).getTitle(),
                            dsMovie.get(i).getReleaseYear()
                        };
                        tableModel.addRow(row); 
                    }
                    tableModel.fireTableDataChanged();
                    revalidate();   
                    repaint();  
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }catch(SQLException ex){
                Logger.getLogger(pnlDSPhimUser.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
     
    public void ClearData(){
        int n = tableModel.getRowCount()-1;
        for(int i=n;i>=0;i--)
            tableModel.removeRow(i);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private cell.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private Table.Table table;
    // End of variables declaration//GEN-END:variables
    public int getSelectedMovieID() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            return -1;
        }
        return (int) table.getValueAt(selectedRow, 0);
    }
    public void showMovie(int movieID) {
        try {
            System.out.println("showMovie: movieID: " + movieID);
            Movie_model movie = movieController.getMovieById(movieID);
            System.out.println("showMovie: movieID " + movie);
            if(movie != null) {
                System.out.println("Tên phim: " + movie.getTitle());
                System.out.println("Năm phim: " + movie.getReleaseYear());
                System.out.println("The loai: " + movie.getGenre());
                System.out.println("Mota: " + movie.getDescription());
                pnlChiTietFilmUser pnlCT = menu.getPanel();
                pnlCT.setMovieDetails(movie);
                menu.showPanel("chi tiet phim");
            } else {
                System.out.println("Khong tim thay ID phim !");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Loi truy van!");
        }
    }
}
