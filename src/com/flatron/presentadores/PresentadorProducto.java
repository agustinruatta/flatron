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

import com.flatron.modelos.ModeloProducto;
import com.flatron.servicios.ServicioProducto;
import com.flatron.vistas.VistaProducto;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
            this.actualizarTabla(this.servicio.ObtenerProductosRegistrados());
        
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
               
    
    }
    
    private void actualizarTabla(ArrayList<ModeloProducto> array){
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("Nombre");
        tableHeaders.add("Marca");
        tableHeaders.add("Unidad de Medida");
        tableHeaders.add("Costo");
        tableHeaders.add("Ganancias");
        tableHeaders.add("Stock Actual");
        tableHeaders.add("Stock Minimo");
        tableHeaders.add("Rubro");
        
        for (ModeloProducto o : array) {
            ModeloProducto modelo = o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(modelo.getNombreProducto());
            oneRow.add(modelo.getMarcaProducto());
            oneRow.add(modelo.getUnidadMedidaProducto());
            oneRow.add(modelo.getCostoProducto());
            oneRow.add(modelo.getGananciasProducto());
            oneRow.add(modelo.getStockActualProducto());
            oneRow.add(modelo.getStockMinimoProducto());
            oneRow.add(modelo.getRubroProducto());
            tableData.add(oneRow);
        }
        
        this.vista.getProductosTable().setModel(new DefaultTableModel(tableData, tableHeaders));
    };
    
}
