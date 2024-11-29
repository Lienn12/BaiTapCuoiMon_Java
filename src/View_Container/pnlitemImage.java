
package View_Container;

import Model.Movie_model;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author lienn
 */
public class pnlitemImage extends javax.swing.JPanel {

    /**
     * Creates new form pnlitemImage
     */
    public pnlitemImage() {
        initComponents();
        init();
        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                setSize(getWidth()+10,getHeight()+10);
                setBackground(new Color(255,255,255,100));
                pnlTitle.setSize(getWidth()+10,getHeight()+10);
                repaint();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setSize(getWidth()-10,getHeight()-10);
                setBackground(new Color(255,255,255,0));
                pnlTitle.setSize(getWidth(),getHeight());
                repaint();
            }
        });
    }

    public void init(){
        setOpaque(false);
        setPreferredSize(new Dimension(170,210));
        setMaximumSize(new Dimension(170,210));
        setMinimumSize(new Dimension(170,210));
        pnlTitle.setBackground(new Color(0,0,0,128));
    }
    private Movie_model movieModel;
    public void setData(Movie_model movieModel) {
        this.movieModel = movieModel;
        lbTitle.setText(movieModel.getTitle());
        repaint();  
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

        pnlTitle = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Title");

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 162, Short.MAX_VALUE)
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel pnlTitle;
    // End of variables declaration//GEN-END:variables
}
