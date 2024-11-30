/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cell;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author ASUS
 */
public class tblActionCellEditorUser_DSPhim extends DefaultCellEditor {

    private tblActionUser_DSPhim event;
    
    public tblActionCellEditorUser_DSPhim(tblActionUser_DSPhim event) {
        super(new JCheckBox());
        this.event = event;
    }
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        pnlActUser_DSPhim action = new pnlActUser_DSPhim();
        action.initEvent(event, row);
        action.setBackground(table.getSelectionBackground());
        return action;
    }
}