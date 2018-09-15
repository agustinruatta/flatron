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

import java.util.Date;

public class Compra {
    
    private Date fecha;
    private int numeroComprobante;
    private double totalCompra;

    public Compra(Date fecha, int numeroComprobante, double totalCompra) {
        this.fecha = fecha;
        this.numeroComprobante = numeroComprobante;
        this.totalCompra = totalCompra;
    }

}
