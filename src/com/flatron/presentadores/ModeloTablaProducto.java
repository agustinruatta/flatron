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

import com.flatron.modelos.Producto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Franco Morbidoni <fgmorbidoni@gmail.com>
 */
public class ModeloTablaProducto extends AbstractTableModel{
    private static final int CANTIDAD_COLUMNAS = 9;
    private static final int COLUMNA_CODIGO = 0;
    private static final int COLUMNA_NOMBRE = 1;
    private static final int COLUMNA_MARCA= 2;
    private static final int COLUMNA_UNIDADMEDIDA = 3;
    private static final int COLUMNA_COSTO = 4;
    private static final int COLUMNA_GANANCIA = 5;
    private static final int COLUMNA_STOCK = 6;
    private static final int COLUMNA_STOCKMINIMO = 7;
    private static final int COLUMNA_RUBRO = 8;
    private ArrayList<Producto> productos;

    public ModeloTablaProducto(ArrayList<Producto> productos) {
        this.productos = productos;
    } 

    @Override
    public String getColumnName(int columna) {
        switch(columna){
            case COLUMNA_CODIGO: return "Codigo";
            case COLUMNA_NOMBRE: return "Nombre";
            case COLUMNA_MARCA: return "Marca";
            case COLUMNA_UNIDADMEDIDA : return "Unidad de medida";
            case COLUMNA_COSTO: return "Costo";
            case COLUMNA_GANANCIA: return "Ganancia";
            case COLUMNA_STOCK: return "Stock actual";
            case COLUMNA_STOCKMINIMO: return "Stock minimo";
            case COLUMNA_RUBRO: return "rubro";
            default: throw new IllegalArgumentException("Error");
        }        
    }   

    @Override
    public int getRowCount() {
        return this.productos.size();
    }

    @Override
    public int getColumnCount() {
     return CANTIDAD_COLUMNAS;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        switch(columna){
            case COLUMNA_CODIGO: return this.productos.get(fila).getCodigo();
            case COLUMNA_NOMBRE: return this.productos.get(fila).getNombre();
            case COLUMNA_MARCA: return this.productos.get(fila).getMarca();
            case COLUMNA_UNIDADMEDIDA : return this.productos.get(fila).getUnidadmedida().getNombre();
            case COLUMNA_COSTO: return this.productos.get(fila).getCosto();
            case COLUMNA_GANANCIA: return this.productos.get(fila).getGanancia();
            case COLUMNA_STOCK: return this.productos.get(fila).getStock();
            case COLUMNA_STOCKMINIMO: return this.productos.get(fila).getStockMinimo();
            case COLUMNA_RUBRO: return this.productos.get(fila).getRubro();
            default: throw new IllegalArgumentException("Error");
        }    
    }
    
    public Producto ObtenerProducto(int fila){
        return this.productos.get(fila);
    }
    
    
    
}
