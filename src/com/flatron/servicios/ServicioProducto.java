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
package com.flatron.servicios;

import com.flatron.modelos.ModeloProducto;
import com.flatron.repositorios.RepositorioProducto;
import java.util.ArrayList;

/**
 *
 * @author Franco Morbidoni <fgmorbidoni@gmail.com>
 */
public class ServicioProducto {

    String nombreProducto;
    String marcaProducto;
    String unidadMedidaProducto; //TODO Cambiarlo por un objeto de la clase Unidad de Medida.
    float costoProducto;
    float gananciasProducto;
    float stockActualProducto;
    float stockMinimoProducto;
    String rubroProducto;
    RepositorioProducto repositioProducto;

    public ServicioProducto() {
        this.repositioProducto = new RepositorioProducto();
    }

    public void guardarProducto(String nombre, String marca, String unidadMedida, String costo, String ganancias, String stock, String stockMinimo, String rubro) {
        this.validarDatos(nombre, marca, unidadMedida, costo, ganancias, stock, stockMinimo, rubro);

        ModeloProducto producto = new ModeloProducto(nombreProducto, marcaProducto, unidadMedidaProducto, costoProducto, gananciasProducto, stockActualProducto, stockMinimoProducto, rubroProducto);
        this.repositioProducto.guardarProducto(producto);

    }

    private void validarDatos(String nombre, String marca, String unidadMedida, String costo, String ganancias, String stock, String stockMinimo, String rubro) {

        if (nombre.equals("")) {
            throw new IllegalArgumentException("El campo nombre esta vacio.");
        } else {
            this.nombreProducto = nombre;
        }

        if (marca.equals("")) {
            throw new IllegalArgumentException("El campo marca esta vacio.");
        } else {
            this.marcaProducto = marca;
        }

        if (unidadMedida.equals("")) {
            throw new IllegalArgumentException("No se selecciono unidad de medida esta vacio.");
        } else {
            this.unidadMedidaProducto = unidadMedida;
        }

        if (costo.equals("")) {
            throw new IllegalArgumentException("El campo costo esta vacio.");
        } else {
            try {
                this.costoProducto = Float.valueOf(costo);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("No fue ingresado un numero en costo.");
            }
        }

        if (ganancias.equals("")) {
            throw new IllegalArgumentException("El campo ganancias esta vacio.");
        } else {
            try {
                this.gananciasProducto = Float.valueOf(ganancias);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("No fue ingresado un numero en ganancias.");
            }
        }

        if (stock.equals("")) {
            throw new IllegalArgumentException("El campo stock actual esta vacio.");
        } else {
            try {
                this.stockActualProducto = Float.valueOf(stock);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("No fue ingresado un numero en stock actual.");
            }
        }

        if (stockMinimo.equals("")) {
            throw new IllegalArgumentException("El campo stock minimo esta vacio.");
        } else {
            try {
                this.stockMinimoProducto = Float.valueOf(stockMinimo);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("No fue ingresado un numero en stock minimo.");
            }
        }

        if (rubro.equals("")) {
            throw new IllegalArgumentException("El campo rubro esta vacio.");
        } else {
            this.rubroProducto = rubro;
        }

    }

    public ArrayList<ModeloProducto> obtenerProductosRegistrados() {
        ArrayList<ModeloProducto> arrayADevolver = new ArrayList<>();

        arrayADevolver = this.repositioProducto.obtenerTodosLosProductos();

        return arrayADevolver;
    }

    public ArrayList<ModeloProducto> buscarProductosPorNombre(String nombre) {
        if (nombre.equals("")) {
            throw new IllegalArgumentException("No se ingreso ningun dato para buscar.");
        } else {

            ArrayList<ModeloProducto> arrayADevolver = new ArrayList<>();

            arrayADevolver = this.repositioProducto.obtenerProductosSegunNombre(nombre);
            
            if (arrayADevolver.isEmpty()) {
                 throw new IllegalArgumentException("No hay productos con ese nombre.");
            }

            return arrayADevolver;
        }
    }
}
