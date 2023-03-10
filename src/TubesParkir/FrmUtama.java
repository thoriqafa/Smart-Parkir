/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TubesParkir;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author thor
 */
public class FrmUtama extends javax.swing.JFrame {

    Connection con= conn.getKoneksi();
    String hakakses;
    
    public FrmUtama() {
        initComponents();
        jDialog2.setPreferredSize(new Dimension (200, 400));
        jDialog2.setMinimumSize(new Dimension (500, 300));
        jDialog2.setMaximumSize(new Dimension (500, 300));
        MnFile.setEnabled(true);
        MnData.setEnabled(false);
        MnHelp.setEnabled(false);
        MnProses.setEnabled(false);
        MnLaporan.setEnabled(false);
        ItLogout.setEnabled(false);
    }
    
    public void btl(){
        txtUsername.setText("");
        txtPass.setText("");
        }
    public void login(){
        try{
            String password;
            password = new String(txtPass.getText());
            Statement st = con.createStatement();
            String sql = "select Posisi from TblStaff where Username ='"+txtUsername.getText()+"' and Password='"+password+"'";
            ResultSet rs = st.executeQuery(sql);
            
            String sql1="update TblStaff set Status = 1 where Username = '"+txtUsername.getText()+"'";
            Statement st2 = con.createStatement();
            java.sql.PreparedStatement pst=con.prepareStatement(sql1);
            pst.execute();
            
            if(rs.next()){
                hakakses = rs.getString("Posisi").replaceAll(" ", "");
            }
            if(hakakses.equals("")){
                JOptionPane.showMessageDialog(this, "Masukan User dan Password","Error",
                JOptionPane.ERROR_MESSAGE);
            }
            else{
                jDialog2.setVisible(false);
                if(hakakses.equals("admin")){
                    JOptionPane.showMessageDialog(null, "Anda Masuk Sebagai Admin");
                    MnFile.setEnabled(true);
                    MnData.setEnabled(true);
                    MnHelp.setEnabled(true);
                    MnProses.setEnabled(true);
                    MnLaporan.setEnabled(true);
                    ItLogout.setEnabled(true);
                    ItLogin.setEnabled(true);
                    }
                else if(hakakses.equals("pegawai")){
                    JOptionPane.showMessageDialog(null, "Anda Masuk Sebagai Pegawai");
                    MnFile.setEnabled(true);
                    MnData.setEnabled(false);
                    MnHelp.setEnabled(false);
                    MnProses.setEnabled(true);
                    MnLaporan.setEnabled(false);
                    ItLogout.setEnabled(true);
                    ItLogin.setEnabled(true);
                }
                
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Periksa Nama dan Password Anda !","Information",
            JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e.getMessage());
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

        jDialog2 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btnMasuk = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        txtUserLog = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        MnFile = new javax.swing.JMenu();
        ItLogin = new javax.swing.JMenuItem();
        ItLogout = new javax.swing.JMenuItem();
        MnData = new javax.swing.JMenu();
        MnDataKendaraan = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        MnLaporan = new javax.swing.JMenu();
        ItLaporan = new javax.swing.JMenuItem();
        MnProses = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        MnHelp = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("LOGIN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        btnMasuk.setText("Masuk");
        btnMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasukActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(57, 57, 57)
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnMasuk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMasuk)
                    .addComponent(btnBatal))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txtUserLog.setEditable(false);
        txtUserLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserLogActionPerformed(evt);
            }
        });

        MnFile.setText("File");

        ItLogin.setText("Login");
        ItLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItLoginActionPerformed(evt);
            }
        });
        MnFile.add(ItLogin);

        ItLogout.setText("Logout");
        ItLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItLogoutActionPerformed(evt);
            }
        });
        MnFile.add(ItLogout);

        jMenuBar1.add(MnFile);

        MnData.setText("Data");

        MnDataKendaraan.setText("Data Kendaraan");
        MnDataKendaraan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnDataKendaraanActionPerformed(evt);
            }
        });
        MnData.add(MnDataKendaraan);

        jMenuItem2.setText("Data Lokasi");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        MnData.add(jMenuItem2);

        jMenuItem3.setText("Data Staff");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        MnData.add(jMenuItem3);

        jMenuBar1.add(MnData);

        MnLaporan.setText("Laporan");

        ItLaporan.setText("Laporan");
        ItLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItLaporanActionPerformed(evt);
            }
        });
        MnLaporan.add(ItLaporan);

        jMenuBar1.add(MnLaporan);

        MnProses.setText("Proses");

        jMenuItem7.setText("Parkir Masuk");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        MnProses.add(jMenuItem7);

        jMenuItem8.setText("Parkir Keluar");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        MnProses.add(jMenuItem8);

        jMenuBar1.add(MnProses);

        MnHelp.setText("Help");

        jMenuItem4.setText("About Us");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        MnHelp.add(jMenuItem4);

        jMenuBar1.add(MnHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 298, Short.MAX_VALUE)
                .addComponent(txtUserLog, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtUserLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 263, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(416, 343));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasukActionPerformed
        if (txtUsername.getText().equals("") && txtPass.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Masukkan Username dan Password");
        } else {
            login();
            txtUserLog.setText(txtUsername.getText());
        }
        
        txtUsername.setText("");
        txtPass.setText("");
        
    }//GEN-LAST:event_btnMasukActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        jDialog2.setVisible(false);
        btl();
        txtUsername.setText("");
        txtPass.setText("");
    }//GEN-LAST:event_btnBatalActionPerformed

    private void ItLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItLoginActionPerformed
         jDialog2.setSize(200,200);
         jDialog2.setLocationRelativeTo(null);
         jDialog2.setVisible(true);
    }//GEN-LAST:event_ItLoginActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        new ParkirMasuk().setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new DataStaff().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void MnDataKendaraanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnDataKendaraanActionPerformed
        new DataKendaraan().setVisible(true);
    }//GEN-LAST:event_MnDataKendaraanActionPerformed

    private void ItLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItLogoutActionPerformed
        try {
            String sql1="update TblStaff set Status = 0 where status = 1";
            Statement st2 = con.createStatement();
            java.sql.PreparedStatement pst=con.prepareStatement(sql1);
            pst.execute();
            txtUserLog.setText("");
        } catch (Exception e) {
        }
        
        
        
        MnFile.setEnabled(true);
        MnData.setEnabled(false);
        MnHelp.setEnabled(false);
        MnProses.setEnabled(false);
        MnLaporan.setEnabled(false);
        ItLogout.setEnabled(false);
    }//GEN-LAST:event_ItLogoutActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setExtendedState(FrmUtama.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        new ParkirKeluar().setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new DataLokasi().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtUserLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserLogActionPerformed
        
    }//GEN-LAST:event_txtUserLogActionPerformed

    private void ItLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItLaporanActionPerformed
        new FrmLaporan().setVisible(true);
    }//GEN-LAST:event_ItLaporanActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
         JOptionPane.showMessageDialog(null, "KELOMPOK 8 SBD \nAPLIKASI SMART PARKIR(V 1.0.0) \nWIRA, AHNAF, THORIQ");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUtama().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ItLaporan;
    private javax.swing.JMenuItem ItLogin;
    private javax.swing.JMenuItem ItLogout;
    private javax.swing.JMenu MnData;
    private javax.swing.JMenuItem MnDataKendaraan;
    private javax.swing.JMenu MnFile;
    private javax.swing.JMenu MnHelp;
    private javax.swing.JMenu MnLaporan;
    private javax.swing.JMenu MnProses;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnMasuk;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUserLog;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
