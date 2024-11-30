/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Combobox;
import javax.swing.JComboBox;
/**
 *
 * @author lienn
 */
public class ComboBoxUI<E> extends JComboBox<Object> {
    public ComboBoxUI(){
        setUI(new ComboBox());
    }
}


