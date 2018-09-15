/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flatron.vistas;

import javax.swing.ImageIcon;

/**
 *
 * @author laboratorio
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        salirjButton = new javax.swing.JButton();
        fondojLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salirjButton.setBackground(new java.awt.Color(255, 0, 0));
        salirjButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        salirjButton.setForeground(new java.awt.Color(255, 255, 255));
        salirjButton.setText("Salir ");
        salirjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirjButtonActionPerformed(evt);
            }
        });
        getContentPane().add(salirjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 70, 30));

        fondojLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/flatron/vistas/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(fondojLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 421));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirjButtonActionPerformed
      System.exit(0);
    }//GEN-LAST:event_salirjButtonActionPerformed

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
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondojLabel;
    private javax.swing.JButton salirjButton;
    // End of variables declaration//GEN-END:variables
}
