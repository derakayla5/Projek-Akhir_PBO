/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;
import Database.database;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        usernametxt = new javax.swing.JTextField();
        passwordtxt = new javax.swing.JPasswordField();
        buttonlogin = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(850, 430));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 0, -1, -1));

        usernametxt.setBackground(new java.awt.Color(208, 175, 111));
        usernametxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(usernametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 170, -1));

        passwordtxt.setBackground(new java.awt.Color(208, 175, 111));
        passwordtxt.setBorder(null);
        getContentPane().add(passwordtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 170, -1));

        buttonlogin.setBackground(new java.awt.Color(208, 175, 111));
        buttonlogin.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        buttonlogin.setText("login");
        buttonlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonloginActionPerformed(evt);
            }
        });
        getContentPane().add(buttonlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));

        jButton1.setBackground(new java.awt.Color(208, 175, 111));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        jLabel1.setText("WELCOME");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 100, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Username (1) (1).png"))); // NOI18N
        jLabel2.setText("PLEASE LOGIN");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Registrasi rgs = new Registrasi();
        rgs.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonloginActionPerformed
        try {
            String username = usernametxt.getText();
            String password = passwordtxt.getText();
            String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";

            Connection conn = database.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");

                if ("admin".equals(role)) {
                    // Jika peran adalah admin, tampilkan pesan dan buka menu admin
                    JOptionPane.showMessageDialog(null, "Selamat datang, Admin!");
                    this.setVisible(false);
                    new adminMenu().setVisible(true);
                } else if ("pegawai".equals(role)) {
                    // Jika peran adalah pegawai, tampilkan pesan dan buka menu pegawai
                    JOptionPane.showMessageDialog(null, "Selamat datang, Pegawai!");
                    this.setVisible(false);
                    new CrudPenumpang().setVisible(true);
                } else {
                    // Jika peran tidak dikenali
                    JOptionPane.showMessageDialog(null, "Login gagal: Peran tidak valid.");
                }
            } else {
                // Jika tidak ada hasil dari database
                JOptionPane.showMessageDialog(null, "Login gagal: Username atau password salah.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

//        try {
//            String sql = "SELECT * FROM admin where username ='" + usernametxt.getText() + "'AND password ='" + passwordtxt.getText()+"'";
//            java.sql.Connection conn = (Connection) database.configDB();
//            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
//            java.sql.ResultSet rs = pst.executeQuery(sql);
//            if (rs.next()) {
//                if (usernametxt.getText().equals(rs.getString("username"))
//                        && passwordtxt.getText().equals(rs.getString("password"))) {
//                        JOptionPane.showMessageDialog(null, "Login berhasil");
//                        this.setVisible(false);
//                        new Menu().setVisible(true);
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Login gagal");
//            }
//        } catch (Exception e){
//            JOptionPane.showMessageDialog(this, e.getMessage());
//        }
    }//GEN-LAST:event_buttonloginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonlogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordtxt;
    private javax.swing.JTextField usernametxt;
    // End of variables declaration//GEN-END:variables
}
