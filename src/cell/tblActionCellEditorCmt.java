package cell;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class tblActionCellEditorCmt extends DefaultCellEditor {
    private tblActionCmt event;
    
    public tblActionCellEditorCmt (tblActionCmt event) {
        super(new JCheckBox());
        this.event = event;
    }
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        pnlActionCmt action = new pnlActionCmt();
        action.initEvent(event, row);
        action.setBackground(table.getSelectionBackground());
        return action;
    }
}
