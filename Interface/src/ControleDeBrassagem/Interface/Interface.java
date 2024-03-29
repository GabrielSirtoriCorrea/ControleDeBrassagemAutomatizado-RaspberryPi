/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleDeBrassagem.Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Gazebo
 */
public class Interface extends javax.swing.JFrame {
    StatusController status;
    int tankControled = 1;
    boolean brewStarted;
    /**
     * Creates new form Interface
     */
    public Interface() {
        this.setExtendedState(Interface.MAXIMIZED_BOTH); 
        this.setUndecorated(true);
        toFront();
        initComponents();
        brewStarted  = false;
        status = new StatusController();
        status.writeStatus(null, "BrewMode", "Automatic");
        System.out.println(status.readStatus().get("BrewMode"));
        status.writeStatus(null, "BrewStatus", "Pausado");
        Timer timer = new Timer(1000, new TankController());
        timer.start();
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
        jLabel20 = new javax.swing.JLabel();
        btnChangeMode = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnEmergency = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        lblParameter2 = new javax.swing.JLabel();
        lblParameter5 = new javax.swing.JLabel();
        lblParameter4 = new javax.swing.JLabel();
        lblResult1 = new javax.swing.JLabel();
        lblParameter3 = new javax.swing.JLabel();
        lblTankNumber = new javax.swing.JLabel();
        lblStartStop = new javax.swing.JLabel();
        lblResult2 = new javax.swing.JLabel();
        lblResult3 = new javax.swing.JLabel();
        lblResult4 = new javax.swing.JLabel();
        lblResult5 = new javax.swing.JLabel();
        lblParameter1 = new javax.swing.JLabel();
        lblBrewStatus = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btnNewBrew = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnStartBrew = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel15.setText("jLabel15");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 22)); // NOI18N
        jLabel9.setText("TANQUE 2");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 480, -1, -1));

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 22)); // NOI18N
        jLabel7.setText("TANQUE 3");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 480, 130, 40));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel3.setText("EMERGÊNCIA");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 230, 50));

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 22)); // NOI18N
        jLabel8.setText("TANQUE 1");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 480, 130, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Group 1.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 410, 140, 170));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Group 1.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Group 5.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, 250, 230));

        btnTank2.setBackground(new java.awt.Color(51, 102, 255));
        btnTank2.setText("BOTAO TANQUE 2");
        btnTank2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTank2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnTank2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, 100, 140));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Group 1.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Group 4.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 520, 990, 140));

        btnTank1.setBackground(new java.awt.Color(51, 102, 255));
        btnTank1.setText("BOTAO TANQUE 1");
        btnTank1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTank1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnTank1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 120, 130));

        btnTank3.setBackground(new java.awt.Color(51, 102, 255));
        btnTank3.setText("BOTAO TANQUE 2");
        btnTank3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTank3ActionPerformed(evt);
            }
        });
        getContentPane().add(btnTank3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 420, 110, 130));

        jLabel13.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        jLabel13.setText("BOMBA:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 20, 140, 40));

        lblBomb.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        lblBomb.setText("DESLIGADA");
        getContentPane().add(lblBomb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 20, 170, 40));

        jLabel20.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        jLabel20.setText("<html><center> ALTERAR MODO <center></html>");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 150, 80));

        btnChangeMode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Rectangle 16.png"))); // NOI18N
        btnChangeMode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnChangeMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeModeActionPerformed(evt);
            }
        });
        getContentPane().add(btnChangeMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 150, 80));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Ellipse 1.png"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        btnEmergency.setText("Emergencia");
        btnEmergency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmergencyActionPerformed(evt);
            }
        });
        getContentPane().add(btnEmergency, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 150, 90));

        jLabel21.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        jLabel21.setText("BRASSAGEM:");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 160, 50));

        lblParameter2.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblParameter2.setText("SetPoint:");
        getContentPane().add(lblParameter2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 130, 50));

        lblParameter5.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblParameter5.setText("Rampa Atual: ");
        getContentPane().add(lblParameter5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 170, 50));

        lblParameter4.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblParameter4.setText("Motor:");
        getContentPane().add(lblParameter4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 100, 50));

        lblResult1.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblResult1.setText("39 ºC");
        getContentPane().add(lblResult1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 310, 50));

        lblParameter3.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblParameter3.setText("Resistência: ");
        getContentPane().add(lblParameter3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 160, 30));

        lblTankNumber.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblTankNumber.setText("Tanque 1:");
        getContentPane().add(lblTankNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 120, 50));

        lblStartStop.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        lblStartStop.setText("<html><center> INICIAR BRASSAGEM <center></html>");
        getContentPane().add(lblStartStop, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 150, 80));

        lblResult2.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblResult2.setText("41 ºC");
        getContentPane().add(lblResult2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 70, 30));

        lblResult3.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblResult3.setText("Desligada");
        getContentPane().add(lblResult3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 240, 30));

        lblResult4.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblResult4.setText("Desligado");
        getContentPane().add(lblResult4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, 170, 30));

        lblResult5.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblResult5.setText("2");
        getContentPane().add(lblResult5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 230, 80, 30));

        lblParameter1.setFont(new java.awt.Font("Comic Sans MS", 1, 21)); // NOI18N
        lblParameter1.setText("Temperatura: ");
        getContentPane().add(lblParameter1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 170, 50));

        lblBrewStatus.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        lblBrewStatus.setText("PAUSADO");
        getContentPane().add(lblBrewStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 490, 50));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Rectangle 9.png"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 440, 70));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Rectangle 8.png"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 570, 200));

        jLabel22.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        jLabel22.setText("<html><center>NOVA BRASSAGEM<center></html>");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 150, 80));

        btnNewBrew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Rectangle 16.png"))); // NOI18N
        btnNewBrew.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnNewBrew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewBrewActionPerformed(evt);
            }
        });
        getContentPane().add(btnNewBrew, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 150, 80));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Rectangle 10.png"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 260, 60));

        btnStartBrew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Rectangle 16.png"))); // NOI18N
        btnStartBrew.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnStartBrew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartBrewActionPerformed(evt);
            }
        });
        getContentPane().add(btnStartBrew, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 150, 80));

        jLabel23.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        jLabel23.setText("MODO DE BRASSAGEM: AUTOMÁTICO");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 410, 50));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Rectangle 9.png"))); // NOI18N
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 440, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ControleDeBrassagem/Images/Wallpaper.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTank2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTank2ActionPerformed
        // TODO add your handling code here:
        tankControled = 2;
    }//GEN-LAST:event_btnTank2ActionPerformed

    private void btnTank1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTank1ActionPerformed
        // TODO add your handling code here
         tankControled = 1;
        
    }//GEN-LAST:event_btnTank1ActionPerformed

    private void btnTank3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTank3ActionPerformed
        // TODO add your handling code here:
        tankControled = 3;
    }//GEN-LAST:event_btnTank3ActionPerformed

    private void btnEmergencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmergencyActionPerformed
        // TODO add your handling code here:
        new StatusController().resetStatus();
    }//GEN-LAST:event_btnEmergencyActionPerformed

    private void btnChangeModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeModeActionPerformed
        new StatusController().resetStatus();
        new TelaBrassagemManual().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnChangeModeActionPerformed

    private void btnNewBrewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewBrewActionPerformed
        // TODO add your handling code here:
        new TelaNovaBrassagem().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnNewBrewActionPerformed

    private void btnStartBrewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartBrewActionPerformed
        // TODO add your handling code here:
        status = new StatusController();
        
        if(brewStarted){
         status.writeStatus(null, "BrewStatus", "Pausado");
         lblBrewStatus.setText("PAUSADO");
         lblStartStop.setText("<html><center> INICIAR BRASSAGEM <center></html>");
        }else{
         status.writeStatus(null, "BrewStatus", "Em andamento");
         lblBrewStatus.setText("EM ANDAMENTO");
         lblStartStop.setText("<html><center> PAUSAR BRASSAGEM <center></html>");
        }
        
        brewStarted = !brewStarted;
    }//GEN-LAST:event_btnStartBrewActionPerformed

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
    private javax.swing.JButton btnStartBrew;
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
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblBomb;
    private javax.swing.JLabel lblBrewStatus;
    private javax.swing.JLabel lblParameter1;
    private javax.swing.JLabel lblParameter2;
    private javax.swing.JLabel lblParameter3;
    private javax.swing.JLabel lblParameter4;
    private javax.swing.JLabel lblParameter5;
    private javax.swing.JLabel lblResult1;
    private javax.swing.JLabel lblResult2;
    private javax.swing.JLabel lblResult3;
    private javax.swing.JLabel lblResult4;
    private javax.swing.JLabel lblResult5;
    private javax.swing.JLabel lblStartStop;
    private javax.swing.JLabel lblTankNumber;
    // End of variables declaration//GEN-END:variables


    class TankController implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Thread.currentThread().sleep(1000);
                status = new StatusController();
                lblBomb.setText(booleanStatus(status.readStatus().getBoolean("Bomb")));
                if(status.readStatus().getJSONObject("Tank1").getBoolean("MaltAlert")){
                    JOptionPane.showMessageDialog(null, "ADICIONE O MALTE NA PANELA DE MOSTURAÇÃO!!!", "ATENÇÃO!!!", JOptionPane.WARNING_MESSAGE);
                }
                if(status.readStatus().getJSONObject("Tank3").getBoolean("HopAlert")){
                    JOptionPane.showMessageDialog(null, "ADICIONE O LÚPULO NA PANELA DE FERVURA!!!", "ATENÇÃO!!!", JOptionPane.WARNING_MESSAGE);
                }
                if(status.readStatus().getJSONObject("Tank1").getBoolean("NextProcess")){
                    JOptionPane.showMessageDialog(null, "ACIONE AS VÁVULAS PARA O PROCESSO DE CLARIFICAÇÃO!!!", "ATENÇÃO!!!", JOptionPane.WARNING_MESSAGE);
                }
                if(status.readStatus().getJSONObject("Tank2").getBoolean("NextProcess")){
                    JOptionPane.showMessageDialog(null, "ACIONE AS VÁVULAS PARA O PROCESSO DE FERVURA!!!", "ATENÇÃO!!!", JOptionPane.WARNING_MESSAGE);
                }
                if(status.readStatus().getJSONObject("Tank3").getBoolean("NextProcess")){
                    JOptionPane.showMessageDialog(null, "ACIONE AS VÁVULAS PARA O PROCESSO DE FERMENTAÇÃO!!!", "ATENÇÃO!!!", JOptionPane.WARNING_MESSAGE);
                }

              switch(tankControled){
                 case 1:
                     lblTankNumber.setText("Tanque 1");

                     lblParameter1.setText("Temperatura:");
                     lblParameter2.setText("SetPoint:");
                     lblParameter3.setText("Resistência:");
                     lblParameter4.setText("Motor:");
                     lblParameter5.setText("Rampa atual:");

                     lblResult1.setText(Integer.toString(status.readStatus().getJSONObject("Tank1").getInt("Temperature")) + "ºC");
                     lblResult2.setText(Integer.toString(status.readStatus().getJSONObject("Tank1").getInt("SetPoint")) + "ºC");
                     lblResult3.setText(booleanStatus(status.readStatus().getJSONObject("Tank1").getBoolean("Resistence")));
                     lblResult4.setText(booleanStatus(status.readStatus().getJSONObject("Tank1").getBoolean("Motor")));
                     lblResult5.setText(Integer.toString(status.readStatus().getJSONObject("Tank1").getInt("ActualRamp")));
                     break;
                 case 2:
                     lblTankNumber.setText("Tanque 2");

                     lblParameter1.setText("Motor:");
                     lblParameter2.setText("");
                     lblParameter3.setText("");
                     lblParameter4.setText("");
                     lblParameter5.setText("");

                     lblResult1.setText(booleanStatus(status.readStatus().getJSONObject("Tank2").getBoolean("Motor")));
                     lblResult2.setText("");
                     lblResult3.setText("");
                     lblResult4.setText("");
                     lblResult5.setText("");
                     break;
                 case 3:
                     lblTankNumber.setText("Tanque 3");

                     lblParameter1.setText("Temperatura:");
                     lblParameter2.setText("SetPoint");
                     lblParameter3.setText("Resistência:");
                     lblParameter4.setText("");
                     lblParameter5.setText("");
                     lblResult1.setText(Integer.toString(status.readStatus().getJSONObject("Tank3").getInt("Temperature")) + "ºC");
                     lblResult2.setText(Integer.toString(status.readStatus().getJSONObject("Tank3").getInt("SetPoint")) + "ºC");
                     lblResult3.setText(booleanStatus(status.readStatus().getJSONObject("Tank3").getBoolean("Resistence")));
                     lblResult4.setText("");
                     lblResult5.setText("");
                     break;
                }
             } catch (InterruptedException ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
             
         }
            
        
        private String booleanStatus(boolean status){
            if(status) return "LIGADO";
            else return "DESLIGADO";
        }
        
    }
}