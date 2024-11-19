
package View_Container;
import Controllers.Movie_controller;
import Model.Movie_model;
import javax.swing.table.DefaultTableModel;
import cell.tableAction;
import cell.tblActionCellEditor;
import cell.tblActionEvent;
import View_Main.frmMenu;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;


public final class pnlDSPhim extends javax.swing.JPanel {
    private final Movie_model movie= new Movie_model();
    private final Movie_controller movieController= new Movie_controller();
    private frmMenu menu;
    private DefaultTableModel tableModel= new DefaultTableModel();
    private Movie_controller controller;
    public pnlDSPhim(frmMenu menu) {
        this.menu = menu;
        initComponents(); 
        init();
        String []colsName={"ID","Tên phim","Năm phát hành",""};
        tableModel.setColumnIdentifiers(colsName);
        table.setModel(tableModel);
        controller = new Movie_controller();
        ShowData();
        tblActionEvent event = new tblActionEvent() {
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
            public void onEdit(int row) {
                int movieID = getSelectedMovieID();
                if (movieID != -1) {
                    editMovie(movieID);
                } else {
                    System.out.println("Không có phim nào được chọn!");
                }
            }

            @Override
            public void onDelete(int row) {
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
                    DefaultTableModel tbl = (DefaultTableModel) table.getModel();
                    tbl.removeRow(row);
                }
                
            }
        };
        table.getColumnModel().getColumn(3).setCellRenderer(new tableAction());
        table.getColumnModel().getColumn(3).setCellEditor(new tblActionCellEditor(event));
    }
    public void init(){
//        txtSearch.addOption(new SearchOption("Name"));
    }
//    String fgetFieldName
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(107, 153, 198));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Danh sách Phim");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tìm kiếm:");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/plus.png"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 153), 2));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        table.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Tên phim", "Năm phát hành", "Chức năng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table.setGridColor(new java.awt.Color(153, 153, 153));
        table.setRowHeight(40);
        table.setSelectionBackground(new java.awt.Color(204, 204, 204));
        table.setShowGrid(true);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(50);
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
            table.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(347, 347, 347)
                            .addComponent(jLabel3))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(146, 146, 146)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
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
                Logger.getLogger(pnlDSPhim.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void ClearData(){
        int n = tableModel.getRowCount()-1;
        for(int i=n;i>=0;i--)
            tableModel.removeRow(i);
    }
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        menu.showPanel("them phim");
    }//GEN-LAST:event_jLabel3MouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String query = txtSearch.getText().toLowerCase(); // Lấy giá trị nhập vào ô tìm kiếm
           TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
           table.setRowSorter(sorter);

           if (query.length() == 0) {
               sorter.setRowFilter(null); // Nếu không có gì được nhập, hiển thị tất cả các dòng
           } else {
               sorter.setRowFilter(RowFilter.regexFilter(query)); // Lọc kết quả dựa trên nội dung ô tìm kiếm
           }
    }//GEN-LAST:event_txtSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
    public int getSelectedMovieID() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            // Không có dòng nào được chọn
            return -1;
        }
        // Lấy giá trị từ cột ID (cột 0)
        return (int) table.getValueAt(selectedRow, 0);
    }
    public void showMovie(int movieID) {
        try {
            Movie_model movie = controller.getMovieById(movieID);
            if(movie != null) {
                System.out.println("Tên phim: " + movie.getTitle());
                System.out.println("Năm ph: " + movie.getReleaseYear());
                System.out.println("The loai: " + movie.getGenre());
                System.out.println("Mota: " + movie.getDescription());
                pnlChiTietFilm pnlCT = menu.getPanel();
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
    public void editMovie(int movieID) {
        try {
            Movie_model movie = controller.getMovieById(movieID);
            if(movie != null) {
                System.out.println("ID:" + movie.getMovieID());
                System.out.println("Tên phim: " + movie.getTitle());
                System.out.println("Năm ph: " + movie.getReleaseYear());
                System.out.println("The loai: " + movie.getGenre());
                System.out.println("Mota: " + movie.getDescription());
                pnlSuaPhim pnlSua = menu.getPanelSua();
                pnlSua.setMovieDetails(movie);
                menu.showPanel("sua phim");
            } else {
                System.out.println("Khong tim thay ID phim !");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Loi truy van!");
        }
    }
}
