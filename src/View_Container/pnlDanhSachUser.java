package View_Container;

import Controllers.User_controller;
import Model.User_model;
import View_Main.frmMain;
import cell.tableActUser;
import cell.tblActionCellEditorUser;
import cell.tblActionUser;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public final class pnlDanhSachUser extends javax.swing.JPanel {
    private User_model userMode;
    private User_controller userController= new User_controller();
    private  frmMain menu;
    private DefaultTableModel tableModel= new DefaultTableModel();
    public pnlDanhSachUser(frmMain menu) {
        this.menu=menu;
        initComponents();  
        String []colsName={"ID","Tài khoản","Giới tính","Ngày sinh","Emai",""};
        tableModel.setColumnIdentifiers(colsName);
        table.setModel(tableModel);
        ShowData();
        tblActionUser event = new tblActionUser() {
            @Override
            public void onDelete(int row) {
                int userId= Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
                if(table.isEditing()){
                    table.getCellEditor().stopCellEditing();
                }
                if(JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn xóa tài khoản này không??","Thong bao",2)==0){
                    try {
                        userController.DeleteData(userId);
                    } catch (Exception ex) {
                        java.util.logging.Logger.getLogger(pnlDanhgia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                    tableModel.removeRow(row);
                }
            }
        };
        table.getColumnModel().getColumn(5).setCellRenderer(new tableActUser());
        table.getColumnModel().getColumn(5).setCellEditor(new tblActionCellEditorUser(event));
    }
    public void ShowData() {
        try{
            List<User_model> dsUser= userController.getUser();
            try{
                for(int i=0; i<dsUser.size();i++){
                    Object row[]={
                        dsUser.get(i).getUserID(),
                        dsUser.get(i).getUsername(),
                        dsUser.get(i).getGender(),
                        dsUser.get(i).getBirth(),
                        dsUser.get(i).getEmail()
                    };
                    tableModel.addRow(row);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }catch(Exception ex){
           java.util.logging.Logger.getLogger(pnlDanhSachUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelBorder1 = new cell.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new cell.Table();

        setBackground(new java.awt.Color(106, 153, 198));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(5, 38, 89));
        jLabel1.setText("Danh sách người dùng");

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tài khoản ", "Giới tính ", "Ngày sinh", "Email", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(35);
            table.getColumnModel().getColumn(0).setPreferredWidth(35);
            table.getColumnModel().getColumn(0).setMaxWidth(35);
            table.getColumnModel().getColumn(5).setMinWidth(35);
            table.getColumnModel().getColumn(5).setPreferredWidth(35);
            table.getColumnModel().getColumn(5).setMaxWidth(35);
        }

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private cell.PanelBorder panelBorder1;
    private cell.Table table;
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
          g2.fillRoundRect(0, 0, width, height, 15, 15);
          g2.fillRect(0, 0, width - 20, height);
      }
}
