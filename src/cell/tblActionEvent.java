/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cell;

/**
 *
 * @author ASUS
 */
public interface tblActionEvent {
    public void onView(int row);
    public void onEdit(int row);
    public void onDelete(int row);
}