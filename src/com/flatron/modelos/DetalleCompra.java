/*
 * Copyright (C) 2018 Nicolas Santillan <nicoar_23@hotmail.com>
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

public class DetalleCompra {
    
    private String nombreProveedor;
    private String nombreProducto;
    private String marcaProducto;
    private String cantidadProducto;
    private double totalProducto;

    public DetalleCompra(String nombreProveedor, String nombreProducto, String marcaProducto, String cantidadProducto, double totalProducto) {
        this.nombreProveedor = nombreProveedor;
        this.nombreProducto = nombreProducto;
        this.marcaProducto = marcaProducto;
        this.cantidadProducto = cantidadProducto;
        this.totalProducto = totalProducto;
    }
 
}
