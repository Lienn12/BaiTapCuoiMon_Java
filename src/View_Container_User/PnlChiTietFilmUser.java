package View_Container_User;
import Controllers.Favorite_controllor;
import Controllers.Movie_controller;
import Controllers.Review_controller;
import Model.Favorites;
import Model.Movie_model;
import Model.Review_model;
import Scrollbar.ScrollBarCustom;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import View_Main.frmMainUser;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;
import java.sql.Timestamp;        
import java.util.Date; 

public class PnlChiTietFilmUser extends javax.swing.JPanel {
    private CardLayout cardLayout;
    private  frmMainUser main;
    private final Favorites favorite= new Favorites();
    private PnlTrangChuUser pnlTrangChu;
    private final Favorite_controllor favoriteControll= new Favorite_controllor();
    private final Review_controller reviewController= new Review_controller();
    private final Movie_controller movieController= new Movie_controller();
    private  String filmName , vidPath;
    public PnlChiTietFilmUser(frmMainUser main,PnlTrangChuUser pnlTrangChu) {
        this.main = main;
        this.pnlTrangChu= pnlTrangChu;
        initComponents();
        this.setMovieDetails(new Movie_model());
        setbtnBack();
        setHide(true);
        pnlDg.setVisible(false);
        pnlThongtin.setOpaque(true);
        pnlThongtin.setBackground(new Color(255, 255, 255, 128));
        sp.setVerticalScrollBar(new ScrollBarCustom());
        sp.setBackground(Color.WHITE);
        pnlPlay.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                pnlPlay.setBackground(new Color(84,131,179));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                pnlPlay.setBackground(new Color(5,38,89));
            }       
        });
        btnFavorite.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                btnFavorite.setBackground(new Color(84,131,179));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnFavorite.setBackground(new Color(5,38,89));
            }       
        });       
    }
    
    public void setbtnBack(){
          cardLayout= new CardLayout();
          back.setLayout(cardLayout);
          back.add(lbBackfavorite,"back favorite");
          back.add(lbBacktrangchu,"back phim trang chu");
          cardLayout.show(back, "back favorite"); 
      }
    public void showPanel(String lbName){
        cardLayout.show(back, lbName); 
    }
    public void setNull(){
        starRating.clearStars();
        txaComment.setText("");
    }
    public void setHide(boolean a){
         btnFavorite.setVisible(!a);
    }
    public void insertReview(int movieID, int userID){
        btnthem.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                   pnlDg.setVisible(true);
            }           
        });
        btnluu.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    int rating = starRating.getStar();
                    String comment= txaComment.getText().trim();
                    Timestamp time = new Timestamp(new Date().getTime());
                    reviewController.InsertReview(movieID,userID,rating,comment,time);
                } catch (SQLException ex) {
                    Logger.getLogger(PnlChiTietFilmUser.class.getName()).log(Level.SEVERE, null, ex);
                }   
                setNull();
                setHide(true);
                pnlDg.setVisible(false);
                showData(movieID,userID);
            }
        });
    }
    public void InsertFavorite(int movieId,int userId){
        btnFavorite.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if(!favoriteControll.checkMovie(movieId,userId)){
                        if(favoriteControll.insertFavorite(movieId,userId)){
                            JOptionPane.showMessageDialog(main,"Phim đã được thêm vào danh sách");
                        } else {
                            
                           JOptionPane.showMessageDialog(main,"Không thể thêm phim vào danh sách yêu thích");
                        }
                    } else{
                        JOptionPane.showMessageDialog(main,"Phim đã được thêm vào danh sách trước đó");
                    }                       
                } catch (SQLException ex) {
                    Logger.getLogger(PnlChiTietFilmUser.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }
        });
    }
    public void setReviews(int movieId){
        try {
            list.clearItems();
            List<Review_model> reviews = reviewController.getReviewUser(movieId);
                for (Review_model review : reviews) {
                    list.addItem(review);                    
                }
                list.revalidate(); 
                list.repaint();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }         
    }
    public void showData(int movieID,int userId) {
        try {
            Movie_model movie = movieController.getMovieById(movieID);
            if(movie != null) {
                setMovieDetails(movie);
                setReviews(movieID);               
                main.showPanel("chi tiet phim");      
            } else {
                System.out.println("Khong tim thay ID phim !");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Loi truy van!");
        }
    }
    public void showMovie(int movieID,int userId) {
        try {
            Movie_model movie = movieController.getMovieById(movieID);
            if(movie != null) {
                setMovieDetails(movie);
                setReviews(movieID);
                InsertFavorite(movieID,userId);
                insertReview(movieID,userId);
                main.showPanel("chi tiet phim");    
                setHide(false);
            } else {
                System.out.println("Khong tim thay ID phim !");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Loi truy van!");
        }
    }
    
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
        System.setProperty("jna.library.path", "C:/Program Files/VideoLAN/VLC");

        JFrame frame = new JFrame(filmName);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        frame.add(mediaPlayerComponent, BorderLayout.CENTER);

        JButton playButton = new JButton("PLAY");
        JButton pauseButton = new JButton("PAUSE");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(playButton);
        buttonPanel.add(pauseButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
        MediaPlayer mediaPlayer = mediaPlayerComponent.mediaPlayer();
        
        playButton.addActionListener(e -> {
            mediaPlayer.media().play(videoPath); 
        });
        pauseButton.addActionListener(e -> {
            mediaPlayer.controls().pause(); 
        });
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
        jLabel2 = new javax.swing.JLabel();
        btnFavorite = new cell.PanelBorder();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        sp = new javax.swing.JScrollPane();
        list = new View_Container_User.ListReviewUser<>();
        jLabel7 = new javax.swing.JLabel();
        pnlDg = new javax.swing.JPanel();
        starRating = new Star_rating.StarRating();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaComment = new javax.swing.JTextArea();
        btnluu = new javax.swing.JLabel();
        btnthem = new javax.swing.JLabel();
        back = new javax.swing.JPanel();
        lbBackfavorite = new javax.swing.JLabel();
        lbBacktrangchu = new javax.swing.JLabel();

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

        pnlPlay.setBackground(new java.awt.Color(5, 38, 89));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Trailer");

        javax.swing.GroupLayout pnlPlayLayout = new javax.swing.GroupLayout(pnlPlay);
        pnlPlay.setLayout(pnlPlayLayout);
        pnlPlayLayout.setHorizontalGroup(
            pnlPlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        pnlPlayLayout.setVerticalGroup(
            pnlPlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        btnFavorite.setBackground(new java.awt.Color(125, 160, 202));
        btnFavorite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFavoriteMouseClicked(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/heart.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btnFavoriteLayout = new javax.swing.GroupLayout(btnFavorite);
        btnFavorite.setLayout(btnFavoriteLayout);
        btnFavoriteLayout.setHorizontalGroup(
            btnFavoriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnFavoriteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(79, 79, 79))
        );
        btnFavoriteLayout.setVerticalGroup(
            btnFavoriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlThongtinLayout = new javax.swing.GroupLayout(pnlThongtin);
        pnlThongtin.setLayout(pnlThongtinLayout);
        pnlThongtinLayout.setHorizontalGroup(
            pnlThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongtinLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
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
                .addGroup(pnlThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlThongtinLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(pnlPlay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(btnFavorite, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlThongtinLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGroup(pnlThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMota, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlThongtinLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(pnlThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFavorite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlPlay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
        );

        jPanel2.getAccessibleContext().setAccessibleDescription("");
        jPanel3.getAccessibleContext().setAccessibleDescription("");
        jPanel5.getAccessibleContext().setAccessibleDescription("");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(5, 38, 89));
        jLabel3.setText("Bình luận ");

        panel.setBackground(new java.awt.Color(255, 255, 255));

        sp.setBackground(new java.awt.Color(255, 255, 255));
        sp.setBorder(null);
        sp.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        list.setBorder(null);
        sp.setViewportView(list);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(5, 38, 89));
        jLabel7.setText("Đánh giá");

        pnlDg.setBackground(new java.awt.Color(255, 255, 255));

        txaComment.setColumns(20);
        txaComment.setRows(5);
        jScrollPane1.setViewportView(txaComment);

        btnluu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnluu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reply.png"))); // NOI18N

        javax.swing.GroupLayout pnlDgLayout = new javax.swing.GroupLayout(pnlDg);
        pnlDg.setLayout(pnlDgLayout);
        pnlDgLayout.setHorizontalGroup(
            pnlDgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDgLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnluu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDgLayout.createSequentialGroup()
                        .addGroup(pnlDgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(starRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDgLayout.setVerticalGroup(
            pnlDgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(starRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnluu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        btnthem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N

        lbBackfavorite.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBackfavorite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/backxanh.png"))); // NOI18N
        lbBackfavorite.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbBackfavorite.setMaximumSize(new java.awt.Dimension(32, 48));
        lbBackfavorite.setPreferredSize(new java.awt.Dimension(50, 48));
        lbBackfavorite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBackfavoriteMouseClicked(evt);
            }
        });

        lbBacktrangchu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBacktrangchu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/backxanh.png"))); // NOI18N
        lbBacktrangchu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbBacktrangchu.setMaximumSize(new java.awt.Dimension(32, 48));
        lbBacktrangchu.setPreferredSize(new java.awt.Dimension(50, 48));
        lbBacktrangchu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBacktrangchuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout backLayout = new javax.swing.GroupLayout(back);
        back.setLayout(backLayout);
        backLayout.setHorizontalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbBacktrangchu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lbBackfavorite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        backLayout.setVerticalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbBacktrangchu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lbBackfavorite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(296, 296, 296)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlThongtin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(93, 93, 93)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(33, 33, 33)
                                    .addComponent(btnthem))
                                .addComponent(pnlDg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(pnlThongtin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnthem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbBacktrangchuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBacktrangchuMouseClicked
        main.showPanel("trang chu");
    }//GEN-LAST:event_lbBacktrangchuMouseClicked

    private void btnFavoriteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFavoriteMouseClicked
           
    }//GEN-LAST:event_btnFavoriteMouseClicked

    private void lbBackfavoriteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBackfavoriteMouseClicked
        main.showPanel("danh sach yeu thich");
    }//GEN-LAST:event_lbBackfavoriteMouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel back;
    private cell.PanelBorder btnFavorite;
    private javax.swing.JLabel btnluu;
    private javax.swing.JLabel btnthem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBackfavorite;
    private javax.swing.JLabel lbBacktrangchu;
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
    private View_Container_User.ListReviewUser<String> list;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel pnlDg;
    private cell.PanelBorder pnlPlay;
    private cell.PanelBorder pnlThongtin;
    private javax.swing.JScrollPane sp;
    private Star_rating.StarRating starRating;
    private javax.swing.JTextArea txaComment;
    // End of variables declaration//GEN-END:variables
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
}
