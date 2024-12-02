/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View_Container_Admin.Home;
import Model.Movie_model;
import java.awt.*;
import javax.swing.*;
public class ListReview<E extends Object> extends JList<E>{
    private final DefaultListModel listModel;
    public ListReview(){
        listModel=new DefaultListModel();
        setModel(listModel);
        setOpaque(false);
    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Movie_model movieModel;
                if(value instanceof Movie_model){
                    movieModel=(Movie_model) value;
                }else{
                    movieModel= new Movie_model(0,"no",0,new byte[0]);
                }
                ItemReview item= new ItemReview(movieModel);
                return item;
            }
        };
    }
    public void addItem(Movie_model movieModel){
        listModel.addElement(movieModel);
    }
    
}
