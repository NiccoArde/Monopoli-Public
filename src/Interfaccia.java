
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Niccolo'
 */
public class Interfaccia extends javax.swing.JFrame {

    /**
     * Creates new form Interfaccia
     */
    
    
    public Interfaccia() {
        initComponents();
        Setting.setVisible(false);
        Line.setVisible(true);
        
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    setVisible(false);
                    Tabellone v = new Tabellone();
                    v.setVisible(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        setSize(978, 620);
    }

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Setting = new javax.swing.JPanel();
        Musica = new javax.swing.JButton();
        Line = new javax.swing.JLabel();
        Info = new javax.swing.JButton();
        X = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Start = new javax.swing.JButton();
        Set = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(960, 606));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Setting.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Musica.setBorderPainted(false);
        Musica.setContentAreaFilled(false);
        Musica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Musica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MusicaActionPerformed(evt);
            }
        });
        Setting.add(Musica, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 110, 110));

        Line.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Line 11.png"))); // NOI18N
        Setting.add(Line, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 110, 100));

        Info.setBorderPainted(false);
        Info.setContentAreaFilled(false);
        Info.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoActionPerformed(evt);
            }
        });
        Setting.add(Info, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 110, 110));

        X.setIcon(new javax.swing.ImageIcon(getClass().getResource("/X.png"))); // NOI18N
        X.setBorderPainted(false);
        X.setContentAreaFilled(false);
        X.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        X.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XActionPerformed(evt);
            }
        });
        Setting.add(X, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 30, 30));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Setting (2).png"))); // NOI18N
        Setting.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 400));

        getContentPane().add(Setting, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 500, -1));

        jPanel2.setMaximumSize(new java.awt.Dimension(970, 607));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Start.setBorderPainted(false);
        Start.setContentAreaFilled(false);
        Start.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });
        jPanel2.add(Start, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 260, 200));

        Set.setBorderPainted(false);
        Set.setContentAreaFilled(false);
        Set.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Set.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetActionPerformed(evt);
            }
        });
        jPanel2.add(Set, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 520, 90, 80));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 620));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 1010, 646));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Tabellone v = new Tabellone();
        v.setVisible(true);
    }//GEN-LAST:event_StartActionPerformed

    private void SetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetActionPerformed
        // TODO add your handling code here:
        Setting.setVisible(true);
       
    }//GEN-LAST:event_SetActionPerformed

    private void XActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XActionPerformed
        // TODO add your handling code here:
        Setting.setVisible(false);
    }//GEN-LAST:event_XActionPerformed

    private void MusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MusicaActionPerformed
        // TODO add your handling code here:
        Tabellone v = new Tabellone();
        if(!Line.isVisible()){
            v.stopSong();
            Line.setVisible(true);
        }else{
            v.canzonebase();
            Line.setVisible(false);
        }
    }//GEN-LAST:event_MusicaActionPerformed

    private void InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoActionPerformed
        // TODO add your handling code here:
        try {
            File file = new File("ManualeUtente.pdf"); // Sostituisci "percorso/al/tuo/file.pdf" con il percorso del tuo file PDF
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("Il file non esiste.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_InfoActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaccia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaccia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaccia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaccia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaccia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Info;
    private javax.swing.JLabel Line;
    private javax.swing.JButton Musica;
    private javax.swing.JButton Set;
    private javax.swing.JPanel Setting;
    private javax.swing.JButton Start;
    private javax.swing.JButton X;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
