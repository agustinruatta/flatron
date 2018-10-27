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
package com.flatron.modelos;

/**
 *
 * @author Franco Morbidoni <fgmorbidoni@gmail.com>
 */
public class Producto {
    static int contador=0; //Variable temporal a remplazar una vez en funcionamiento la base de datos.
    int id;
    String nombreProducto;
    String marcaProducto;
    String unidadMedidaProducto; //TODO Cambiarlo por un objeto de la clase Unidad de Medida.
    float costoProducto;
    float gananciasProducto;
    float stockActualProducto;
    float stockMinimoProducto;
    String rubroProducto;

    public Producto(String nombreProducto, String marcaProducto, String unidadMedidaProducto, float costoProducto, float gananciasProducto, float stockActualProducto, float stockMinimoProducto, String rubroProducto) {
        contador++;
        this.id=contador;
        this.nombreProducto = nombreProducto;
        this.marcaProducto = marcaProducto;
        this.unidadMedidaProducto = unidadMedidaProducto;
        this.costoProducto = costoProducto;
        this.gananciasProducto = gananciasProducto;
        this.stockActualProducto = stockActualProducto;
        this.stockMinimoProducto = stockMinimoProducto;
        this.rubroProducto = rubroProducto;
    }

    public int getId() {
        return id;
    }   

    public void setId(int id) {
        this.id = id;
    }    

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public String getUnidadMedidaProducto() {
        return unidadMedidaProducto;
    }

    public float getCostoProducto() {
        return costoProducto;
    }

    public float getGananciasProducto() {
        return gananciasProducto;
    }

    public float getStockActualProducto() {
        return stockActualProducto;
    }

    public float getStockMinimoProducto() {
        return stockMinimoProducto;
    }

    public String getRubroProducto() {
        return rubroProducto;
    }
    
    public void validarStock(){
        
    }
    
    public void calcularPrecioVenta(){
        
    }
    
}
