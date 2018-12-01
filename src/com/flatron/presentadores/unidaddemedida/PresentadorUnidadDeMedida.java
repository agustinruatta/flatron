/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flatron.presentadores.unidaddemedida;

import com.flatron.modelos.UnidadDeMedida;
import com.flatron.repositorios.unidaddemedida.RepositorioUnidadDeMedida;
import com.flatron.vistas.unidaddemedida.VistaUnidadMedida;
import com.flatron.servicios.unidaddemedida.ServicioUnidadDeMedida;
import com.flatron.vistas.unidaddemedida.TablaUnidadDeMedidaTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author laboratorio
 */
public class PresentadorUnidadDeMedida {

    private VistaUnidadMedida vistaUnidadMedida;

    private ServicioUnidadDeMedida servicioUnidadDeMedida;

    private RepositorioUnidadDeMedida repositorioUnidadDeMedida;
    
    private TablaUnidadDeMedidaTableModel modeloTabla;

    public PresentadorUnidadDeMedida(VistaUnidadMedida vistaUnidadMedida) {
        this.vistaUnidadMedida = vistaUnidadMedida;

        this.servicioUnidadDeMedida = new ServicioUnidadDeMedida();

        this.repositorioUnidadDeMedida = new RepositorioUnidadDeMedida();
        this.inicializarTabla();
    }

    private void inicializarTabla() {
        ArrayList<UnidadDeMedida> unidadesDeMedida = this.repositorioUnidadDeMedida.obtenerTodos();

        modeloTabla = new TablaUnidadDeMedidaTableModel(unidadesDeMedida);
        this.vistaUnidadMedida.getUnidadDeMedidaTable().setModel(modeloTabla);

    }

    public void guardarUnidadDeMedida() {

        String nombre = this.vistaUnidadMedida.getNombreTextField().getText();
        String simbolo = this.vistaUnidadMedida.getSimboloTextField().getText();

        try {
            this.servicioUnidadDeMedida.guardarUnidadDeMedida(nombre, simbolo);

            this.vistaUnidadMedida.getNombreTextField().setText("");
            this.vistaUnidadMedida.getSimboloTextField().setText("");

            ArrayList<UnidadDeMedida> unidadesDeMedida = this.repositorioUnidadDeMedida.obtenerTodos();

            modeloTabla = new TablaUnidadDeMedidaTableModel(unidadesDeMedida);
            this.vistaUnidadMedida.getUnidadDeMedidaTable().setModel(modeloTabla);
            this.vistaUnidadMedida.getUnidadDeMedidaTable().repaint();
            

            JOptionPane.showMessageDialog(null, "¡La unidad de medida fue guardada correctamente!");

        } catch (IllegalArgumentException excepcion) {

            JOptionPane.showMessageDialog(null, excepcion.getMessage());
        }

    }

    public void eliminarUnidadDeMedida(int filaSeleccionada) {
        UnidadDeMedida medida = this.modeloTabla.getUnidadDeMedidaSeleccionada(filaSeleccionada);
        
        this.servicioUnidadDeMedida.remove(medida);
    }

}
