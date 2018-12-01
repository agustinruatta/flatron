/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flatron.presentadores;

import com.flatron.modelos.Compra;
import com.flatron.servicios.ServicioCompra;
import com.flatron.vistas.VistaCompra;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author santiago
 */
public class PresentadorCompra {
    private VistaCompra vista;
    private ServicioCompra servicio;
    private Compra compraSeleccionada;
    
    public PresentadorCompra(VistaCompra vista) {
        this.vista = vista;
        this.servicio = new ServicioCompra();
    }
    
    public void botonGuardarCompra(){
        
        int proveedor = Integer.parseInt(this.vista.getProveedorTextField().getText());
        String numeroComprobante = this.vista.getNumeroComprobanteTextField().getText();
        
        //convierto string a date
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(this.vista.getFechaTextField().getText());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        Date fecha = date1;
        //
        
        int total = Integer.parseInt(this.vista.getTotalTextField().getText());
        try {
            
            this.servicio.guardarCompra(proveedor, numeroComprobante, fecha, total);
        } catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
