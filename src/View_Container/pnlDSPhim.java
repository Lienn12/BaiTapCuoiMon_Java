
package View_Container;
import Controllers.Movie_controller;
import Model.Movie_model;
import javax.swing.table.DefaultTableModel;
import cell.tableAction;
import cell.tblActionCellEditor;
import cell.tblActionEvent;
import View_Main.frmMain;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
    private frmMain menu;
    private DefaultTableModel tableModel= new DefaultTableModel();
    private Movie_controller controller;
    public pnlDSPhim(frmMain menu) {
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
                menu.showPanel("sua phim");
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
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        panelBorder1 = new cell.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new cell.Table();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelBorder2 = new cell.PanelBorder();
        txtSearch = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setToolTipText("");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(5, 38, 89));
        jLabel1.setText("Danh sách Phim");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/plusXanh.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/seacrhxanh.png"))); // NOI18N

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

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
        jScrollPane1.setViewportView(table);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(5, 38, 89));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TỔNG: ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("     ");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.setBorder(null);

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(5, 38, 89));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tìm kiếm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 72, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        menu.showPanel("them phim");
    }//GEN-LAST:event_jLabel3MouseClicked
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private cell.PanelBorder panelBorder1;
    private cell.PanelBorder panelBorder2;
    private cell.Table table;
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
    @Override
      protected void paintComponent(Graphics g) { 
          super.paintComponent(g); 
          Graphics2D g2 = (Graphics2D) g;
          g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

          int width = getWidth();
          int height = getHeight();
          GradientPaint gp = new GradientPaint(0,0, Color.decode("#ffffff"), 0, getHeight(), Color.decode("#6B99C6"));
            g2.setPaint(gp);
//          g2.setColor(Color.decode("#FFFFFF"));
          g2.fillRoundRect(0, 0, width, height, 15, 15);
          g2.fillRect(0, 0, width - 20, height);
      }
}
