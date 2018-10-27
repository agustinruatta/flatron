/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flatron.presentadores;

import com.flatron.vistas.VistaUnidadMedida;
import com.flatron.servicios.ServicioUnidadDeMedida;
import javax.swing.JOptionPane;

/**
 *
 * @author laboratorio
 */
public class PresentadorUnidadDeMedida {

    private VistaUnidadMedida vistaUnidadMedida;

    private ServicioUnidadDeMedida servicioUnidadDeMedida;

    public PresentadorUnidadDeMedida(VistaUnidadMedida vistaUnidadMedida) {
        this.vistaUnidadMedida = vistaUnidadMedida;

        this.servicioUnidadDeMedida = new ServicioUnidadDeMedida();
    }

    public void guardarUnidadDeMedida() {

        String nombre = this.vistaUnidadMedida.getNombreTextField().getText();
        String simbolo = this.vistaUnidadMedida.getSimboloTextField().getText();

        try {
            this.servicioUnidadDeMedida.guardarUnidadDeMedida(nombre, simbolo);

            this.vistaUnidadMedida.getNombreTextField().setText("");
            this.vistaUnidadMedida.getSimboloTextField().setText("");

            JOptionPane.showMessageDialog(null, "¡La unidad de medida fue guardada correctamente!");

        } catch (IllegalArgumentException excepcion) {

            JOptionPane.showMessageDialog(null, excepcion.getMessage());
        }

    }
    
    public void eliminarUnidadDeMedida(){
        
    }

}
