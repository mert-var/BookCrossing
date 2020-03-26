/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookcrossing;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

/**
 *
 * @author MERT
 */
public class AnaEkran extends javax.swing.JFrame {

    /**
     * Creates new form AnaEkran
     */

    List <String> listbookisbn = new ArrayList<>();
    List <String> listimage = new ArrayList<>();
    List <String> populerlistisbn = new ArrayList<>();
    List <String> resimlist = new ArrayList<>();
    List <String> populerlistimage = new ArrayList<>();
    List <String> eniyilistisbn = new ArrayList<>();
    List <String> eniyilistimage = new ArrayList<>();
    int userid;
    
    
    String path;
    URL url;
    BufferedImage image;
    String path1;
    URL url1;
    BufferedImage image1;
    String path2;
    URL url2;
    BufferedImage image2;
    String path3;
    URL url3;
    BufferedImage image3;
    String path4;
    URL url4;
    BufferedImage image4;
    String path5;
    URL url5;
    BufferedImage image5;
    String path6;
    URL url6;
    BufferedImage image6;
    String path7;
    URL url7;
    BufferedImage image7;
    String path8;
    URL url8;
    BufferedImage image8;
    String path9;
    URL url9;
    BufferedImage image9;
    
    int dongu=0;
    int boyut;
    Integer sayfano=1;
    Integer sayfasayisi=0;
    Integer kitapno;
    javax.swing.border.Border blackBorder = BorderFactory.createLineBorder(Color.BLACK, 2, true);
    
    
    public AnaEkran() throws SQLException {
        initComponents();
        
        
        String sorgu ="Select ISBN,[Image-URL-M] FROM [kitaplar].[dbo].[BX-Books]";
        ResultSet rs = new Baglan().Listele(sorgu);
        
        while(rs.next()){
            
            listbookisbn.add(rs.getString("ISBN"));
            listimage.add(rs.getString("Image-URL-M"));
   
        }
        
        rs.close();
        
        /////////////////////////////////////////////////////////
        //POPÜLER KİTAP LİSTESİ
        
        String sorgu2="Select TOP 11 ISBN, count(ISBN) AS sayi from kitaplar.dbo.[BX-Book-Ratings] group by ISBN order by count(*) desc";
        ResultSet rs2 = new Baglan().Listele(sorgu2);   

            while(rs2.next()){
                
                populerlistisbn.add(rs2.getString("ISBN"));
            }     
                     
            rs2.close();
        

        //////////////////////////////////////////////////////////////////////////
        // POPULER KİTAPLARIN RESİMLERİ
        
         String sorgu3 ="SELECT DISTINCT ISBN, [Image-URL-M] AS link FROM [kitaplar].[dbo].[BX-Books] where ISBN = '"
                    +populerlistisbn.get(0)+"'"+ "or ISBN ='"+populerlistisbn.get(1)+"'"+ 
                    "or ISBN ='"+populerlistisbn.get(2)+"'"+ "or ISBN ='"+populerlistisbn.get(3)+"'"+ 
                    "or ISBN ='"+populerlistisbn.get(4)+"'"+ "or ISBN ='"+populerlistisbn.get(5)+"'"+ 
                    "or ISBN ='"+populerlistisbn.get(6)+"'"+ "or ISBN ='"+populerlistisbn.get(7)+"'"+ 
                    "or ISBN ='"+populerlistisbn.get(8)+"'"+ "or ISBN ='"+populerlistisbn.get(9)+"'"+ "or ISBN ='"+populerlistisbn.get(10)+"'";
        
         ResultSet rs3= new Baglan().Listele(sorgu3);

            while(rs3.next()){
                populerlistimage.add(rs3.getString("link"));
            }

            rs3.close();

        ///////////////////////////////////////////////
        //EN İYİ KİTAP LİSTESİ
        
            String sorgu4="SELECT TOP(11) ISBN, AVG(Rating) AS rating FROM [kitaplar].[dbo].[BX-Book-Ratings] group by ISBN order by rating desc";
            ResultSet rs4=new Baglan().Listele(sorgu4);

            while(rs4.next()){
                
                eniyilistisbn.add(rs4.getString("ISBN"));
        
            }

            rs4.close();

        //////////////////////////////////////////////////////////////////////////
        //EN İYİ KİTAPLARIN RESİMLERİ
 
            String sorgu5="SELECT ISBN, [Image-URL-M] AS link FROM [kitaplar].[dbo].[BX-Books] where "
                    + "ISBN = '"+eniyilistisbn.get(0)+"'"+ "or ISBN ='"+eniyilistisbn.get(1)+"'"+ 
                    "or ISBN ='"+eniyilistisbn.get(2)+"'"+ "or ISBN ='"+eniyilistisbn.get(3)+"'"+ 
                    "or ISBN ='"+eniyilistisbn.get(4)+"'"+ "or ISBN ='"+eniyilistisbn.get(5)+"'"+ 
                    "or ISBN ='"+eniyilistisbn.get(6)+"'"+ "or ISBN ='"+eniyilistisbn.get(7)+"'"+ 
                    "or ISBN ='"+eniyilistisbn.get(8)+"'"+ "or ISBN ='"+eniyilistisbn.get(9)+"'"+ "or ISBN ='"+eniyilistisbn.get(10)+"'";
            
            ResultSet rs5 = new Baglan().Listele(sorgu5);

            while(rs5.next()){
                eniyilistimage.add(rs5.getString("link"));
            }

            rs5.close();
   

     resimEkleme(listimage);
     jTextField1.setText(sayfano.toString());
                           
    }
    
    
    public void resimEkleme(List <String> a){
            
                    resimlist= a;
                   
                try {
                    
                    
                    path = resimlist.get(dongu);
                    url = new URL(path);
                    image = ImageIO.read(url);
  
                    
                    path1 = resimlist.get(dongu+1);
                    url1 = new URL(path1);
                    image1 = ImageIO.read(url1);
       
                    
                    path2 = resimlist.get(dongu+2);
                    url2 = new URL(path2);
                    image2 = ImageIO.read(url2);
        
                    
                    path3 = resimlist.get(dongu+3);
                    url3 = new URL(path3);
                    image3 = ImageIO.read(url3);
       
                    
                    path4 = resimlist.get(dongu+4);
                    url4 = new URL(path4);
                    image4 = ImageIO.read(url4);
      
                    
                    path5 = resimlist.get(dongu+5);
                    url5 = new URL(path5);
                    image5 = ImageIO.read(url5);
    
                    
                    path6 = resimlist.get(dongu+6);
                    url6 = new URL(path6);
                    image6 = ImageIO.read(url6);
     
                    
                    path7 = resimlist.get(dongu+7);
                    url7 = new URL(path7);
                    image7 = ImageIO.read(url7);

                    
                    path8 = resimlist.get(dongu+8);
                    url8 = new URL(path8);
                    image8 = ImageIO.read(url8);

                    
                    path9 = resimlist.get(dongu+9);
                    url9 = new URL(path9);
                    image9 = ImageIO.read(url9);
                    

                  jLabel1.setIcon(new ImageIcon(image.getScaledInstance(140, 200, Image.SCALE_SMOOTH)));
                  jLabel2.setIcon(new ImageIcon(image1.getScaledInstance(140, 200, Image.SCALE_SMOOTH)));
                  jLabel3.setIcon(new ImageIcon(image2.getScaledInstance(140, 200, Image.SCALE_SMOOTH)));
                  jLabel4.setIcon(new ImageIcon(image3.getScaledInstance(140, 200, Image.SCALE_SMOOTH)));
                  jLabel5.setIcon(new ImageIcon(image4.getScaledInstance(140, 200, Image.SCALE_SMOOTH)));
                  jLabel6.setIcon(new ImageIcon(image5.getScaledInstance(140, 200, Image.SCALE_SMOOTH)));
                  jLabel7.setIcon(new ImageIcon(image6.getScaledInstance(140, 200, Image.SCALE_SMOOTH)));
                  jLabel8.setIcon(new ImageIcon(image7.getScaledInstance(140, 200, Image.SCALE_SMOOTH)));
                  jLabel9.setIcon(new ImageIcon(image8.getScaledInstance(140, 200, Image.SCALE_SMOOTH)));
                  jLabel10.setIcon(new ImageIcon(image9.getScaledInstance(140, 200, Image.SCALE_SMOOTH)));
                  
                  jLabel1.setBorder(blackBorder);
                  jLabel2.setBorder(blackBorder);
                  jLabel3.setBorder(blackBorder);
                  jLabel4.setBorder(blackBorder);
                  jLabel5.setBorder(blackBorder);
                  jLabel6.setBorder(blackBorder);
                  jLabel7.setBorder(blackBorder);
                  jLabel8.setBorder(blackBorder);
                  jLabel9.setBorder(blackBorder);
                  jLabel10.setBorder(blackBorder);

                  
                } catch (HeadlessException | IOException exp) {
                }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 200));

        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setPreferredSize(new java.awt.Dimension(240, 480));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Sonraki Sayfa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton2.setText("Önceki Sayfa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setPreferredSize(new java.awt.Dimension(240, 480));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setPreferredSize(new java.awt.Dimension(240, 480));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setPreferredSize(new java.awt.Dimension(240, 480));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setPreferredSize(new java.awt.Dimension(240, 480));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setPreferredSize(new java.awt.Dimension(240, 480));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setPreferredSize(new java.awt.Dimension(240, 480));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel8.setPreferredSize(new java.awt.Dimension(240, 480));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel9.setPreferredSize(new java.awt.Dimension(240, 480));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel10.setPreferredSize(new java.awt.Dimension(240, 480));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton3.setText("İlk Sayfa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton4.setText("Son Sayfa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setText("Sayfa Numarası :");

        jTextField1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jTextField1.setEnabled(false);

        jButton5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton5.setText("Yeni Kitaplar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton6.setText("Kitap Listesi");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton7.setText("Popüler Kitaplar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton8.setText("En İyi Kitaplar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton9.setText("Kitap Oylama");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton10.setText("ÇIKIŞ");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(240, 240, 240)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1)
                                    .addComponent(jButton4))))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(206, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Sonraki Sayfa
        
  
        //sondaki sayfaya ulaştıysa hiçbirşey yapmayıp son sayfada kalması sağlanıyor
        if(dongu==listimage.size()-10){
            
        }
        else{
            dongu=dongu+10;
            sayfasayisi++;
            sayfano++;
            jTextField1.setText(sayfano.toString());
            resimEkleme(listimage);
        }
            
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Önceki Sayfa
        
        //ilk sayfadayken önceki butona tıklanması halinde hiçbirşey yapmayıp ilk sayfada bekliyor
        if(dongu==0){

        }
        else
        {
            dongu=dongu-10;
            sayfasayisi--;
            sayfano--;
            jTextField1.setText(sayfano.toString());
            resimEkleme(listimage);
        }
        

        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // label1 mouse ile seçilmesi
        
        kitapno=((sayfasayisi)*10) + 1;
        
        //String pdf = "pdf\\" + listbookisbn.get(kitapno-1) + ".pdf";
        String pdf="pdf\\1.pdf";
        new KitapOkuma(pdf);

        
        
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // Jlabel2 mouse ile seçilmesi
        
        kitapno=((sayfasayisi)*10) + 2;
        
       // String pdf = "pdf\\" + listbookisbn.get(kitapno-1) + ".pdf";
       String pdf="pdf\\2.pdf";
        new KitapOkuma(pdf);
        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        
        kitapno=((sayfasayisi)*10) + 3;
        
        //String pdf = "pdf\\" + listbookisbn.get(kitapno-1) + ".pdf";
        String pdf="pdf\\3.pdf";
        new KitapOkuma(pdf);
        
        
        
    }//GEN-LAST:event_jLabel3MouseClicked


    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        
        kitapno=((sayfasayisi)*10) + 5;
        
        //String pdf = "pdf\\" + listbookisbn.get(kitapno-1) + ".pdf";
        String pdf="pdf\\4.pdf";
        new KitapOkuma(pdf);
        
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
  
        kitapno=((sayfasayisi)*10) + 4;
       
        //String pdf = "pdf\\" + listbookisbn.get(kitapno-1) + ".pdf";
        String pdf="pdf\\5.pdf";
        new KitapOkuma(pdf);
        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        
        
        kitapno=((sayfasayisi)*10) + 6;
        
       // String pdf = "pdf\\" + listbookisbn.get(kitapno-1) + ".pdf";
       String pdf="pdf\\6.pdf";
        new KitapOkuma(pdf);
        
        
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        
        
        kitapno=((sayfasayisi)*10) + 7;
        
        //String pdf = "pdf\\" + listbookisbn.get(kitapno-1) + ".pdf";
        String pdf="pdf\\7.pdf";
        new KitapOkuma(pdf);
        
        
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        
        
        kitapno=((sayfasayisi)*10) + 8;
       
        //String pdf = "pdf\\" + listbookisbn.get(kitapno-1) + ".pdf";
        String pdf="pdf\\8.pdf";
        new KitapOkuma(pdf);
        
        
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        
      
        kitapno=((sayfasayisi)*10) + 9;
        
        //String pdf = "pdf\\" + listbookisbn.get(kitapno-1) + ".pdf";
        String pdf="pdf\\9.pdf";
        new KitapOkuma(pdf);
        
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        

        kitapno=((sayfasayisi)*10) + 10;
        
        //String pdf = "pdf\\" + listbookisbn.get(kitapno-1) + ".pdf";
        String pdf="pdf\\10.pdf";
        new KitapOkuma(pdf);
        
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // ilk sayfaya dönmek için

        dongu =0;
        sayfasayisi=0;
        sayfano=1;
        jTextField1.setText(sayfano.toString());
        resimEkleme(listimage);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Son sayfaya gitmek için
        
        
        dongu =listimage.size()-10;
        sayfasayisi=listimage.size()/10;
        sayfano=listimage.size()/10 + 1;
        System.out.println(sayfano);
        jTextField1.setText(sayfano.toString());
        resimEkleme(listimage);
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Yeni Kitaplar

        dongu=listimage.size()-10;
        jTextField1.setVisible(false);
        jLabel11.setVisible(false);
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jButton4.setVisible(false);
        resimEkleme(listimage);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Kitap Listesi
        
        jTextField1.setVisible(true);
        jLabel11.setVisible(true);
        jButton1.setVisible(true);
        jButton2.setVisible(true);
        jButton3.setVisible(true);
        jButton4.setVisible(true);
        dongu=0;
        resimEkleme(listimage);
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // Populer Kitaplar

        jTextField1.setVisible(false);
        jLabel11.setVisible(false);
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jButton4.setVisible(false);
        dongu=0;
        resimEkleme(populerlistimage);
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // En iyi Kitaplar
        
        jTextField1.setVisible(false);
        jLabel11.setVisible(false);
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jButton4.setVisible(false);
        dongu=0;
        resimEkleme(eniyilistimage);
        
        
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
 
            // Kitap Oylama
          
         try {   
            Oylama o2 = new Oylama();
            o2.userid=userid;
            o2.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // ÇIKIŞ
        
        System.exit(0);
    }//GEN-LAST:event_jButton10ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AnaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AnaEkran().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
                }
        
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
