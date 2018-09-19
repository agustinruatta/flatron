package com.flatron;

import com.flatron.vistas.VistaProducto;


/**
 *
 * @author Agustín Ruatta
 * @email agustinruatta@gmail.com
 */
public class Flatron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaProducto().setVisible(true);
            }
        });
    }
    
}
