/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Scrollbar;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class ModernScrollBarUI extends BasicScrollBarUI{
    
    private  final int THUMB_SIZE=40;
    

    @Override
    public Dimension getMaximumSize(JComponent c) {
        if(scrollbar.getOrientation()==JScrollBar.VERTICAL){
            return new Dimension(0,40);
        }else{
            return new Dimension(THUMB_SIZE,0);
        }
    }

    @Override
    protected Dimension getMinimumThumbSize() {
        if(scrollbar.getOrientation()==JScrollBar.VERTICAL){
            return new Dimension(0,THUMB_SIZE);
        }else{
            return new Dimension(THUMB_SIZE,0);
        }
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new ScrollBarButton();
    }
    
    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new ScrollBarButton();
    }
    
   @Override
   protected void paintTrack(Graphics g, JComponent jc,Rectangle rc){
       Graphics2D g2= (Graphics2D) g;
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
       int orientation = scrollbar.getOrientation();
       int size ;
       int x;
       int y;
       int width;
       int height;
       if(orientation==JScrollBar.VERTICAL){
           size=rc.width/2;
           x=rc.x + ((rc.width - size)/2);
           y=rc.y;
           width=size;
           height=rc.height;
       }else{
           size=rc.height/2;
           y=rc.y + ((rc.height-size)/2);
           x=0;
           width=rc.width;
           height=size;
       }
       g2.setColor(Color.WHITE);
       g2.fillRect(x, y, width, height);
   }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle rc) {
        Graphics2D g2= (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        int x = rc.x;
        int y = rc.y;
        int width = rc.width;
        int height= rc.height;
        if(scrollbar.getOrientation()==JScrollBar.VERTICAL){
            y+=8;
            height-=16;
        }else{
            x+=8;
            width-=16;
        }
        g2.setColor(scrollbar.getForeground());
        g2.fillRect(x, y, width, height);
    }   
    private class ScrollBarButton extends JButton{
        public ScrollBarButton(){
            setBorder(BorderFactory.createEmptyBorder());
        }

        @Override
        public void paint(Graphics g) {
            
        }
        
        
    }
}
