/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View_Container_Admin;

import Controllers.Review_controller;
import Model.Review_model;
import Scrollbar.ScrollBarCustom;
import View_Main.frmMain;
import cell.tableActCmt;
import cell.tblActionCellEditorCmt;
import cell.tblActionCmt;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ASUS
 */
public class pnlDanhgia extends javax.swing.JPanel {
    private Review_model reviewModel;
    private final Review_controller reviewController= new Review_controller();
    private frmMain menu;
    private pnlReplyCmt pnlReplyCmt;
    private DefaultTableModel tableModel= new DefaultTableModel();
    private TableRowSorter<DefaultTableModel> sorter; 
    public pnlDanhgia(frmMain menu)  {
        this.menu=menu;
        initComponents();
        String []colsName={"ID","Tài khoản","Phim","Rating","Date",""};
        tableModel.setColumnIdentifiers(colsName);
        table.setModel(tableModel);
        spTable.setVerticalScrollBar(new ScrollBarCustom());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        JPanel p=new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER,p);
        spTable.getViewport().setBackground(Color.white);
        ShowData();
        sorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(sorter);
        tblActionCmt event = new tblActionCmt() {
            @Override
            public void onReply(int row) {
                 int reviewId = getSelectedMovieID();
                showDanhgia(reviewId);
            }
            
            @Override
            public void onDelete(int row) {
                int reviewId= Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
                if(table.isEditing()){
                    table.getCellEditor().stopCellEditing();
                }
                if(JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn xóa phim này không??","Thong bao",2)==0){
                    try {
                        reviewController.DeleteReview(reviewId);
                    } catch (Exception ex) {
                        Logger.getLogger(pnlDanhgia.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    tableModel.removeRow(row);
                }
            }
        };
        table.getColumnModel().getColumn(5).setCellRenderer(new tableActCmt());
        table.getColumnModel().getColumn(5).setCellEditor(new tblActionCellEditorCmt(event));
    }
    public void ShowData() {
        try{
            List<Review_model> dsReview= reviewController.getReview();
            
            try{
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                for(int i=0; i<dsReview.size();i++){
                    String formattedDate = dateFormat.format(dsReview.get(i).getReviewDate());
                    Object row[]={
                        dsReview.get(i).getReviewID(),
                        dsReview.get(i).getUserModel().getUsername(),
                        dsReview.get(i).getMovieModel().getTitle(),
                        dsReview.get(i).getRating(),
                        formattedDate
                    };
                    tableModel.addRow(row);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }catch(SQLException ex){
            Logger.getLogger(pnlDanhgia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int getSelectedMovieID() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            // Không có dòng nào được chọn
            return -1;
        }
        // Lấy giá trị từ cột ID (cột 0)
        return (int) table.getValueAt(selectedRow, 0);
    }
    
    private void showDanhgia(int reviewId){
        try {
            reviewModel = reviewController.getReply(reviewId);
            if(reviewModel !=null){
                pnlReplyCmt pnlReplyCmt = menu.getReply();
                pnlReplyCmt.setData(reviewModel);
                menu.showPanel("reply");
            }else{
                JOptionPane.showMessageDialog(this, "No user found with ID: " + reviewId);
                pnlReplyCmt.clearData(); 
            }
            
        } catch (Exception ex) {
             Logger.getLogger(pnlDanhgia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelBorder1 = new cell.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new Table.Table();

        setBackground(new java.awt.Color(244, 244, 244));

        jLabel1.setBackground(new java.awt.Color(5, 38, 89));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(5, 38, 89));
        jLabel1.setText("Đánh giá");

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        spTable.setBackground(new java.awt.Color(255, 255, 255));
        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tài khoản", "Phim", "Rating", "Date", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        spTable.setViewportView(table);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private cell.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private Table.Table table;
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
