/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Star_rating;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

/**
 *
 * @author lienn
 */
public class Star extends JButton{

    public Star(){
        setContentAreaFilled(false);
//        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBackground(new Color(200,200,200));
//        setForeground(Color.yellow);
    }
     public void setColor(Color color) {
        // Thay đổi màu nền của sao
        setForeground(color);
    }
    @Override
    public void paint(Graphics grph) {
        super.paint(grph);
        Graphics2D g2= (Graphics2D)grph.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        int width= getWidth();
        int heigh= getHeight();
        int size= Math.min(width,heigh)/2;
        int x= width/2;
        int y = heigh/2;
        Star2D s= new Star2D(x,y,size/2,size,5);
        g2.setColor(getBackground());
        if(isSelected()){
            g2.setColor(getForeground());
            g2.fill(s);
        }
        g2.fill(s);
        g2.dispose();
    }
}
