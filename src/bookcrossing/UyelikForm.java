package bookcrossing;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MERT
 */
public class UyelikForm extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame2
     * @throws java.sql.SQLException
     */
    
    
    public UyelikForm() throws SQLException {
        initComponents();
        

        String sorgu="select * FROM [kitaplar].[dbo].[user]";
        ResultSet rs = new Baglan().Listele(sorgu);
        
           while(rs.next()){
               
               deneme=rs.getInt("userid");
               list.add(rs.getString("username"));
               
           }
           deneme++;
           id.setText(deneme.toString());

    }
    
    
    boolean dogrumu = true;
     List<String> list = new ArrayList<>();
     int userid;
     Integer deneme=0;
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 200));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("ÜYELİK FORMU");

        id.setEnabled(false);
        id.setMinimumSize(new java.awt.Dimension(6, 30));
        id.setPreferredSize(new java.awt.Dimension(6, 30));
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText(" USER ID :");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("KULLANICI ADI :");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("ŞİFRE :");

        jPasswordField1.setPreferredSize(new java.awt.Dimension(6, 30));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setText("ŞİFRE(TEKRAR) :");

        jPasswordField2.setPreferredSize(new java.awt.Dimension(6, 30));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("ÜYE OL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField4.setPreferredSize(new java.awt.Dimension(6, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Üye ol Butonu
        
            userid = Integer.parseInt(id.getText());
            String username=jTextField4.getText();
            String password=jPasswordField1.getText();
            
            int i=0;

            //Username Kontrol(farklı olma durumu)
 
        while(i<list.size()){
            
            if(username.equalsIgnoreCase(list.get(i))){
                dogrumu=false;
                break;
            }
            else{
                dogrumu=true;
                i++;
                
            }
            
        }  
        if(id.getText().equals("") || username.equals("") || password.equals("") || jPasswordField2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Lütfen tüm alanları eksiksiz doldurun..","UYARI",2);
        }
        else if(!dogrumu){
            
            JOptionPane.showMessageDialog(null,"Girmiş olduğunuz username daha önce alınmış.\n Lütfen farklı bir username deneyiniz..","UYARI",2);
            
        }
        else if(password.equals(jPasswordField2.getText())){
            
        try {
            
            //başarılı giriş
     
            dispose();

            // Kullanıcı Bilgilerini Dosyaya Yazma
            

            String sorgu2 ="SELECT Location, Age FROM [kitaplar].[dbo].[BX-Users] where [User-ID]="+userid;
            ResultSet rs2=new Baglan().Listele(sorgu2);
            rs2.next();
            String location=rs2.getString("Location");
            String age=rs2.getString("Age");
            
            
           ///////////////////////////////////////////////////////////

            String sorgu3 ="INSERT INTO [kitaplar].[dbo].[user]( username, password, location, age) VALUES ("+"'"+username+"', '"+password+"', '"+location+"', '"+age+"')";
            new Baglan().Guncelle(sorgu3);
            
            
            // Ratings tablosunu okuma ve oy verme sayısının 10 olma durumunu kontrol etme
            
            int sayac;
            
            String sorgu4 ="SELECT Count(*) AS Sayac FROM [kitaplar].[dbo].[BX-Book-Ratings] where userid ="+userid;
            ResultSet rs3= new Baglan().Listele(sorgu4);
            rs3.next();
            sayac = Integer.parseInt(rs3.getString("Sayac"));
            
  
            if(sayac<10)
            {
                JOptionPane.showMessageDialog(null,"En az 10 adet kitaba oy vermeniz gerekmektedir.","UYARI",2);
                Oylama o1 = null;
                try {
                    o1 = new Oylama();
                } catch (SQLException ex) {
                    Logger.getLogger(UyelikForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                o1.oysayac=sayac;
                o1.userid=userid;
                o1.setVisible(true);
            }
            else
            {
                try {
                    AnaEkran a1 = new AnaEkran();
                    a1.userid = userid;
                    a1.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(UyelikForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UyelikForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        }
        else {
            //Şifrelerin uymama durumu
            
            JOptionPane.showMessageDialog(null,"Lütfen şifrelerin aynı olduğundan emin olun..","UYARI",2);
   
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped
        // TODO add your handling code here:
       
    }//GEN-LAST:event_idKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new UyelikForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(UyelikForm.class.getName()).log(Level.SEVERE, null, ex);
                }
          
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
