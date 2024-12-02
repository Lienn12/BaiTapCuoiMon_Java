/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View_Container_User;
import Model.Movie_model;
import Model.Review_model;
import View_Container_Admin.Home.ItemReview;
import View_Main.frmMainUser;
import java.awt.*;
import javax.swing.*;
public class ListReviewUser<E extends Object> extends JList<E>{
    private final DefaultListModel listModel;
    private frmMainUser main;
    private Movie_model movieModel;
    public ListReviewUser(){
        listModel=new DefaultListModel();
        setModel(listModel);
        setOpaque(false);
        setBackground(Color.WHITE);
    }
    
    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Review_model reviewModel;
                if(value instanceof Review_model){
                    reviewModel=(Review_model) value;
                }else{
                    reviewModel= new Review_model("no",0,"no",0);
                }
                ItemReviewUser item= new ItemReviewUser(movieModel,reviewModel,main);
                return item;
            }
        };
    }
    
    public void addItem(Review_model reviewModel){
        listModel.addElement(reviewModel);
    }
    public void clearItems() {
        listModel.removeAllElements(); 
    }
}
