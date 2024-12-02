package View_Container_Admin;
import Model.Movie_model;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import View_Main.frmMain;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

public class pnlChiTietFilm extends javax.swing.JPanel {
    private CardLayout cardLayout;
    private  frmMain menu;
    private  String filmName , vidPath;
    public pnlChiTietFilm(frmMain menu) {
        this.menu = menu;
        initComponents();
        this.setMovieDetails(new Movie_model());
        setbtnBack();
        pnlThongtin.setOpaque(true);
        pnlThongtin.setBackground(new Color(255, 255, 255, 128));
        pnlPlay.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                pnlPlay.setBackground(new Color(84,131,179));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                pnlPlay.setBackground(new Color(125,160,202));
            }
            
        });
    }
    @Override
      protected void paintComponent(Graphics g) { 
          super.paintComponent(g); 
          Graphics2D g2 = (Graphics2D) g;
          g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

          int width = getWidth();
          int height = getHeight();
          GradientPaint gp = new GradientPaint(0,0, Color.decode("#ffffff"), 0, getHeight(), Color.decode("#6B99C6"));
            g2.setPaint(gp);
           g2.fillRect(0, 0, width, height);
      }
      public void setbtnBack(){
          cardLayout= new CardLayout();
          back.setLayout(cardLayout);
          back.add(lbBackdsPhim,"back danh sach phim");
          back.add(lbBackTrangchu,"back phim trang chu");
           cardLayout.show(back, "favorite"); 
      }
      public void showPanel(String lbName){
        cardLayout.show(back, lbName); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlThongtin = new cell.PanelBorder();
        lblImg = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblRating = new javax.swing.JLabel();
        lblYear = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        lblTap = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblDaodien = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblCast = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblTheLoai = new javax.swing.JLabel();
        lblMota = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        pnlPlay = new cell.PanelBorder();
        btnTrailer = new javax.swing.JLabel();
        back = new javax.swing.JPanel();
        lbBackdsPhim = new javax.swing.JLabel();
        lbBackTrangchu = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(5, 38, 89));
        jLabel1.setText("Thông tin chi tiết");

        pnlThongtin.setBackground(new java.awt.Color(255, 255, 255));

        lblImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblName.setForeground(new java.awt.Color(52, 102, 153));
        lblName.setText("Tên");

        lblRating.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRating.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRating.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/star16.png"))); // NOI18N
        lblRating.setText("rating");

        lblYear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblYear.setText("năm");

        lblCountry.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCountry.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCountry.setText("Trung quốc");

        lblTap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTap.setText("số tập");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(52, 102, 153));
        jLabel9.setText("Đạo diễn:");

        lblDaodien.setText("tên đạo diễn");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(52, 102, 153));
        jLabel11.setText("Diễn viên:");

        lblCast.setText("các diễn viên");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(52, 102, 153));
        jLabel13.setText("Mô tả");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(52, 102, 153));
        jLabel15.setText("Thể loại:");

        lblTheLoai.setText("các thể loại");

        lblMota.setText("mô tả");

        jPanel2.setBackground(new java.awt.Color(52, 102, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(52, 102, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(52, 102, 153));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pnlPlay.setBackground(new java.awt.Color(125, 160, 202));

        btnTrailer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTrailer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/play.png"))); // NOI18N
        btnTrailer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrailer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrailerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlPlayLayout = new javax.swing.GroupLayout(pnlPlay);
        pnlPlay.setLayout(pnlPlayLayout);
        pnlPlayLayout.setHorizontalGroup(
            pnlPlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPlayLayout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(btnTrailer, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
        pnlPlayLayout.setVerticalGroup(
            pnlPlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPlayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTrailer, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlThongtinLayout = new javax.swing.GroupLayout(pnlThongtin);
        pnlThongtin.setLayout(pnlThongtinLayout);
        pnlThongtinLayout.setHorizontalGroup(
            pnlThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongtinLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(pnlThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlThongtinLayout.createSequentialGroup()
                        .addComponent(lblRating, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(lblYear)
                        .addGap(24, 24, 24)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(lblCountry)
                        .addGap(8, 8, 8)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(lblTap))
                    .addComponent(jLabel13)
                    .addGroup(pnlThongtinLayout.createSequentialGroup()
                        .addGroup(pnlThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel11))
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDaodien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCast, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblMota, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(pnlThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPlay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        pnlThongtinLayout.setVerticalGroup(
            pnlThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongtinLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlThongtinLayout.createSequentialGroup()
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblRating, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCountry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblYear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblDaodien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(pnlThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCast, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(22, 22, 22)
                        .addGroup(pnlThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(lblTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel13))
                    .addComponent(lblImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPlay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        jPanel2.getAccessibleContext().setAccessibleDescription("");
        jPanel3.getAccessibleContext().setAccessibleDescription("");
        jPanel5.getAccessibleContext().setAccessibleDescription("");

        lbBackdsPhim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBackdsPhim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/backxanh.png"))); // NOI18N
        lbBackdsPhim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbBackdsPhim.setMaximumSize(new java.awt.Dimension(32, 48));
        lbBackdsPhim.setPreferredSize(new java.awt.Dimension(50, 48));
        lbBackdsPhim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBackdsPhimMouseClicked(evt);
            }
        });

        lbBackTrangchu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBackTrangchu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/backxanh.png"))); // NOI18N
        lbBackTrangchu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbBackTrangchu.setMaximumSize(new java.awt.Dimension(32, 48));
        lbBackTrangchu.setPreferredSize(new java.awt.Dimension(50, 48));
        lbBackTrangchu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBackTrangchuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout backLayout = new javax.swing.GroupLayout(back);
        back.setLayout(backLayout);
        backLayout.setHorizontalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbBackdsPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lbBackTrangchu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        backLayout.setVerticalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbBackdsPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lbBackTrangchu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlThongtin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addComponent(pnlThongtin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbBackdsPhimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBackdsPhimMouseClicked
        menu.showPanel("trang chu");
    }//GEN-LAST:event_lbBackdsPhimMouseClicked

    private void btnTrailerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrailerMouseClicked
        String videoPath = vidPath;
        if (videoPath == null || videoPath.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy đường dẫn video!");
            return;
        }
        playVideoWithVLC(videoPath); 
    }//GEN-LAST:event_btnTrailerMouseClicked

    private void lbBackTrangchuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBackTrangchuMouseClicked
        menu.showPanel("danh sach phim");
    }//GEN-LAST:event_lbBackTrangchuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel back;
    private javax.swing.JLabel btnTrailer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbBackTrangchu;
    private javax.swing.JLabel lbBackdsPhim;
    private javax.swing.JLabel lblCast;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblDaodien;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblMota;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRating;
    private javax.swing.JLabel lblTap;
    private javax.swing.JLabel lblTheLoai;
    private javax.swing.JLabel lblYear;
    private cell.PanelBorder pnlPlay;
    private cell.PanelBorder pnlThongtin;
    // End of variables declaration//GEN-END:variables
    public void setMovieDetails(Movie_model movie) {
        if (movie == null) { 
            System.out.println("Lỗi truy vấn");
        } else {
            lblYear.setText(String.valueOf(movie.getReleaseYear())); 
            lblName.setText(movie.getTitle()); 
            if (movie.getGenre() != null) {
            lblTheLoai.setText(movie.getGenre().getGenreName());
        } else {
            lblTheLoai.setText("Không có thể loại");
        }
            lblMota.setText(movie.getDescription());
            lblCast.setText(movie.getCast());
            if (movie.getCountry() != null) {
            lblCountry.setText(movie.getCountry().getCountrysName());
        } else {
            lblCountry.setText("Không có quốc gia");
        }
            lblDaodien.setText(movie.getDirector());
            lblRating.setText(String.valueOf(movie.getRating()));
            lblTap.setText(String.valueOf(movie.getEpisodes())); 
            if(movie.getImg() !=null && movie.getImg().length >0){
                try {
                    ByteArrayInputStream bis = new ByteArrayInputStream(movie.getImg());
                    Image img = ImageIO.read(bis);
                    if (img != null) {
                        ImageIcon icon = new ImageIcon(img.getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
                        lblImg.setIcon(icon);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            vidPath = movie.getVidpath();
            filmName = movie.getTitle();
        }
    }

    public void playVideoWithVLC(String videoPath) {
        // Kiểm tra nếu thư viện VLC đã được cài đặt
        System.setProperty("jna.library.path", "C:/Program Files/VideoLAN/VLC"); // Đảm bảo đúng đường dẫn tới thư viện VLC
        // Tạo JFrame cho giao diện
        JFrame frame = new JFrame(filmName);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        // Tạo thành phần phát video VLCJ
        EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        frame.add(mediaPlayerComponent, BorderLayout.CENTER);
        // Tạo JButton để phát video
        JButton playButton = new JButton("PLAY");
        // Tạo JButton để tạm dừng video
        JButton pauseButton = new JButton("PAUSE");
        // Tạo JPanel để chứa các nút
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(playButton);
        buttonPanel.add(pauseButton);
        // Thêm JPanel chứa các nút vào JFrame
        frame.add(buttonPanel, BorderLayout.SOUTH);
        // Hiển thị JFrame
        frame.setVisible(true);
        MediaPlayer mediaPlayer = mediaPlayerComponent.mediaPlayer();
        
        playButton.addActionListener(e -> {
            mediaPlayer.media().play(videoPath); // Phát video khi nút Play được click
        });
        // Thêm ActionListener cho Pause button
        pauseButton.addActionListener(e -> {
            mediaPlayer.controls().pause(); // Tạm dừng video khi nút Pause được click
        });
    }
}
