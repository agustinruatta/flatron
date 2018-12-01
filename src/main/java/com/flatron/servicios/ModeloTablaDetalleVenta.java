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

import com.flatron.modelos.Detalleventa;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Franco Morbidoni <fgmorbidoni@gmail.com>
 */
public class ModeloTablaDetalleVenta extends AbstractTableModel{
    private static final int CANTIDAD_COLUMNAS = 4;
    private static final int COLUMNA_PRODUCTO = 0;
    private static final int COLUMNA_PRECIO= 1;
    private static final int COLUMNA_CANTIDAD = 2;
    private static final int COLUMNA_IMPORTE = 3;
    private ArrayList<Detalleventa> detallesVentas;

    public ModeloTablaDetalleVenta(ArrayList<Detalleventa> detalles) {
        this.detallesVentas = detalles;
    }

    @Override
    public String getColumnName(int columna) {
        switch(columna){
            case COLUMNA_PRODUCTO: return "Producto";
            case COLUMNA_PRECIO: return "Precio";
            case COLUMNA_CANTIDAD : return "Cantidad";
            case COLUMNA_IMPORTE: return "Importe";
            default: throw new IllegalArgumentException("Error");
        }    }
    
    @Override
    public int getRowCount() {
        return this.detallesVentas.size();
    }

    @Override
    public int getColumnCount() {
     return CANTIDAD_COLUMNAS;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
     switch(columna){
            case COLUMNA_PRODUCTO: return this.detallesVentas.get(fila).getProducto().getNombre();
            case COLUMNA_PRECIO: return this.detallesVentas.get(fila).getProducto().getPrecio();
            case COLUMNA_CANTIDAD : return this.detallesVentas.get(fila).getCantidad();
            case COLUMNA_IMPORTE: return this.detallesVentas.get(fila).getImporte();
            default: throw new IllegalArgumentException("Error");
        }    }
    
}
