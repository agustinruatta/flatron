/*
 * Copyright (C) 2018 Franco Morbidoni <fgmorbidoni@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.flatron.presentadores;

import com.flatron.servicios.ServicioProducto;
import com.flatron.vistas.VistaProducto;
import javax.swing.JOptionPane;

/**
 *
 * @author Franco Morbidoni <fgmorbidoni@gmail.com>
 */
public class PresentadorProducto {
    private final VistaProducto vista;
    private final ServicioProducto servicio;

    public PresentadorProducto(VistaProducto vista) {
        this.vista = vista;
        this.servicio = new ServicioProducto();
    }
    
    public void botonGuardarProducto(){
        String nombre = this.vista.getNombreProductoTextField().getText();
        String marca = this.vista.getMarcaProductoTextField().getText();
        String unidadMedida = this.vista.getUnidadesMedidaProductoComboBox().getSelectedItem().toString();
        String costo = this.vista.getCostoProductoTextField().getText();
        String ganancia = this.vista.getGananciaProductoTextField().getText();
        String stock = this.vista.getStockActualProductoTextField().getText();
        String stockMinimo = this.vista.getStockMinimoProductoTextField().getText();
        String rubro = this.vista.getRubroProductoTextField().getText();
        
        try {
        
            this.servicio.guardarProducto(nombre, marca, unidadMedida, costo, ganancia, stock, stockMinimo, rubro);
        
            this.vista.getNombreProductoTextField().setText("");
            this.vista.getMarcaProductoTextField().setText("");
            this.vista.getUnidadesMedidaProductoComboBox().setSelectedIndex(0);
            this.vista.getCostoProductoTextField().setText("");
            this.vista.getGananciaProductoTextField().setText("");
            this.vista.getStockActualProductoTextField().setText("");
            this.vista.getStockMinimoProductoTextField().setText("");
            this.vista.getRubroProductoTextField().setText("");
            
            JOptionPane.showMessageDialog(null, "Datos guardados.");
        
        } catch (IllegalArgumentException e) {
        }
        
        
    
    }
    
}
