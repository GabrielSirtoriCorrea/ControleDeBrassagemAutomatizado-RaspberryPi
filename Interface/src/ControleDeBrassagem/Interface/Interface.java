/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleDeBrassagem.Interface;

/**
 *
 * @author Gazebo
 */
public class Interface extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    public Interface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnTank2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnTank1 = new javax.swing.JButton();
        btnTank3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lblBomb = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnChangeMode = new javax.swing.JButton();
        btnNewBrew = new javax.swing.JButton();
        btnEmergency = new javax.swing.JButton();
        lblParameter2 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblParameter5 = new javax.swing.JLabel();
        lblParameter4 = new javax.swing.JLabel();
        lblResult1 = new javax.swing.JLabel();
        lblParameter3 = new javax.swing.JLabel();
        lblTankNumber = new javax.swing.JLabel();
        lblResult2 = new javax.swing.JLabel();
        lblResult3 = new javax.swing.JLabel();
        lblResult4 = new javax.swing.JLabel();
        lblResult5 = new javax.swing.JLabel();
        lblParameter10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel15.setText("jLabel15");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 22)); // NOI18N
        jLabel9.setText("TANQUE 2");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, -1, -1));

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 22)); // NOI18N
        jLabel7.setText("TANQUE 3");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 370, 130, 50));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 26)); // NOI18N
        jLabel3.setText("EMERGÊNCIA");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 190, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Ellipse 1.png"))); // NOI18N
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 200, 190));

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 22)); // NOI18N
        jLabel8.setText("TANQUE 1");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 130, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Group 1.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 140, 170));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Group 1.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Group 5.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 250, 230));

        btnTank2.setBackground(new java.awt.Color(51, 102, 255));
        btnTank2.setText("BOTAO TANQUE 2");
        btnTank2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTank2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnTank2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 100, 140));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Group 1.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Group 4.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, 990, 140));

        btnTank1.setBackground(new java.awt.Color(51, 102, 255));
        btnTank1.setText("BOTAO TANQUE 1");
        btnTank1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTank1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnTank1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 120, 130));

        btnTank3.setBackground(new java.awt.Color(51, 102, 255));
        btnTank3.setText("BOTAO TANQUE 2");
        btnTank3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTank3ActionPerformed(evt);
            }
        });
        getContentPane().add(btnTank3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 320, 110, 130));

        jLabel13.setFont(new java.awt.Font("Comic Sans MS", 1, 22)); // NOI18N
        jLabel13.setText("BOMBA:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 140, 40));

        lblBomb.setFont(new java.awt.Font("Comic Sans MS", 1, 22)); // NOI18N
        lblBomb.setText("DESLIGADA");
        getContentPane().add(lblBomb, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 170, 40));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Rectangle 10.png"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 260, 60));

        jLabel14.setFont(new java.awt.Font("Comic Sans MS", 1, 22)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("<html> <center> NOVA  BRASSAGEM <center></html>");
        jLabel14.setToolTipText("");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 150, 80));

        jLabel20.setFont(new java.awt.Font("Comic Sans MS", 1, 22)); // NOI18N
        jLabel20.setText("<html><center> ALTERAR MODO <center></html>");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 150, 80));

        btnChangeMode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Rectangle 16.png"))); // NOI18N
        btnChangeMode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(btnChangeMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 150, 80));

        btnNewBrew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Rectangle 16.png"))); // NOI18N
        btnNewBrew.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(btnNewBrew, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 150, 80));

        btnEmergency.setText("Emergencia");
        btnEmergency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmergencyActionPerformed(evt);
            }
        });
        getContentPane().add(btnEmergency, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 150, 90));

        lblParameter2.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblParameter2.setText("SetPoint:");
        getContentPane().add(lblParameter2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 100, 50));

        jLabel21.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        jLabel21.setText("MODO DE BRASSAGEM: AUTOMÁTICO");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 50));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Rectangle 9.png"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 440, 70));

        lblParameter5.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblParameter5.setText("Rampa Atual: ");
        getContentPane().add(lblParameter5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 150, 50));

        lblParameter4.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblParameter4.setText("Motor:");
        getContentPane().add(lblParameter4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 70, 50));

        lblResult1.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblResult1.setText("39 ºC");
        getContentPane().add(lblResult1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 70, 50));

        lblParameter3.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblParameter3.setText("Resistência: ");
        getContentPane().add(lblParameter3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 140, 30));

        lblTankNumber.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblTankNumber.setText("Tanque 1:");
        getContentPane().add(lblTankNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 120, 50));

        lblResult2.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblResult2.setText("41 ºC");
        getContentPane().add(lblResult2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 70, 30));

        lblResult3.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblResult3.setText("Desligada");
        getContentPane().add(lblResult3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 100, 30));

        lblResult4.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblResult4.setText("Desligada");
        getContentPane().add(lblResult4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 100, 30));

        lblResult5.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblResult5.setText("2");
        getContentPane().add(lblResult5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, 30, 30));

        lblParameter10.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblParameter10.setText("Temperatura: ");
        getContentPane().add(lblParameter10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 150, 50));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Rectangle 8.png"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 570, 200));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Wallpaper.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTank2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTank2ActionPerformed
        // TODO add your handling code here:
        System.out.println("Hello World");
    }//GEN-LAST:event_btnTank2ActionPerformed

    private void btnTank1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTank1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTank1ActionPerformed

    private void btnTank3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTank3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTank3ActionPerformed

    private void btnEmergencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmergencyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEmergencyActionPerformed

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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeMode;
    private javax.swing.JButton btnEmergency;
    private javax.swing.JButton btnNewBrew;
    private javax.swing.JButton btnTank1;
    private javax.swing.JButton btnTank2;
    private javax.swing.JButton btnTank3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblBomb;
    private javax.swing.JLabel lblParameter10;
    private javax.swing.JLabel lblParameter2;
    private javax.swing.JLabel lblParameter3;
    private javax.swing.JLabel lblParameter4;
    private javax.swing.JLabel lblParameter5;
    private javax.swing.JLabel lblResult1;
    private javax.swing.JLabel lblResult2;
    private javax.swing.JLabel lblResult3;
    private javax.swing.JLabel lblResult4;
    private javax.swing.JLabel lblResult5;
    private javax.swing.JLabel lblTankNumber;
    // End of variables declaration//GEN-END:variables
}
