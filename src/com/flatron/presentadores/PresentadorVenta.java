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

import com.flatron.servicios.ServicioVenta;
import com.flatron.vistas.VistaVenta;
import java.sql.DatabaseMetaData;

/**
 *
 * @author Franco Morbidoni <fgmorbidoni@gmail.com>
 */
public class PresentadorVenta {
    private final VistaVenta vista;
    private final ServicioVenta servicio;

    public PresentadorVenta(VistaVenta vista) {
        this.vista = vista;
        this.servicio=new ServicioVenta();
    }
    
    public String[] obtenerListadoDeProductos(){
        return servicio.obtenerProductos();
    }
    
    public void generarImporte(){
        String producto = this.vista.getProductoVentaComboBox().getSelectedItem().toString();
        String cantidad = this.vista.getCantidadVentaTextField().getText().toString();
        double importe = this.servicio.calcularImporte(producto,cantidad);
        this.vista.getImporteDetalleVentaLabel().setText(importe+"");
    }
    
    
}
