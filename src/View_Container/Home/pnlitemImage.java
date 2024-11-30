
package View_Container.Home;

import Model.Movie_model;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author lienn
 */
public class pnlitemImage extends javax.swing.JPanel {
    private Movie_model movieModel;
    private final Timer timer;
    private final Timer timerStopTimer;
    private final phimMoTa mota;
    private int y = 140;
    private int speed= 20;
    private boolean  showing = false;
    public pnlitemImage(Movie_model movieModel) {
        this.movieModel=movieModel;
        initComponents();
        init();
        mota= new phimMoTa(movieModel.getTitle(),movieModel.getRating(),movieModel.getDescription());
        System.out.println("Movie Title: " + movieModel.getTitle());
        System.out.println("Movie Rating: " + movieModel.getRating());
        System.out.println("Movie Description: " + movieModel.getDescription());
        mota.setLocation(0, y);
        mota.setSize(new Dimension(180,180));
        add(mota);
        revalidate();
        repaint();
        timer = new Timer(0,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(showing){
                    y -= speed;
                    if(y<=50){
                        y=50;
                        mota.setLocation(0, y);
                        timer.stop();
                    }else{
                        mota.setLocation(0, y);
                    }
                }else{
                    y+= speed;
                    if(y>=140){
                        y=140;
                        mota.setLocation(0, y);
                        timer.stop();
                    }else{
                        mota.setLocation(0, y);
                    }
                }
            } 
        });
        timerStopTimer=new Timer(1000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showing=false;
                timerStopTimer.stop();
                timer.start();
            }
        });
        
        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                showing=true;
                timerStopTimer.stop();
                timer.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                showing= false;
                timer.start();
            }
        });
    }

    public void init(){
        setOpaque(false);
        setPreferredSize(new Dimension(170,210));
        setMaximumSize(new Dimension(170,210));
        setMinimumSize(new Dimension(170,210));
//        pnlTitle.setBackground(new Color(0,0,0,128));
    }


    @Override
    public void paint(Graphics g) {
         super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, getHeight(),new Color(0,0,0,128),0,getHeight() - 50, new Color(0,0,0,0));
        g2.setPaint(gp);
        g2.fillRect(0,0,getWidth(),getHeight());
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  
        if (movieModel != null && movieModel.getImg() != null) {
            ImageIcon icon = new ImageIcon(movieModel.getImg()); 
            Image image = icon.getImage();  
            Rectangle size = getAutoSize(movieModel.getImg());
            g.drawImage(image, size.x, size.y, size.width, size.height, this);  
        }
    }

    private Rectangle getAutoSize(byte[] image) {
        ImageIcon icon = new ImageIcon(image);
        int w = getWidth();
        int h = getHeight();
        int iw = icon.getIconWidth();
        int ih = icon.getIconHeight();

        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.max(xScale, yScale);

        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        int x = (w - width) / 2;
        int y = (h - height) / 2;

        return new Rectangle(new Point(x, y), new Dimension(width, height));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
