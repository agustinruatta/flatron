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

import com.flatron.modelos.Producto;
import com.flatron.modelos.Unidadmedida;
import com.flatron.repositorios.RepositorioProducto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Franco Morbidoni <fgmorbidoni@gmail.com>
 */
public class ServicioProducto {

    RepositorioProducto repositioProducto;

    public ServicioProducto() {
        this.repositioProducto = new RepositorioProducto();
    }

    public void guardarProducto(String nombre, String marca, Unidadmedida unidadMedida, String costo, String ganancias, String stock, String stockMinimo, String rubro) {
        
        Producto producto = new Producto(unidadMedida, ValidarMarca(marca), ValidarNombre(nombre), ValidarCosto(costo), ValidarGanancias(ganancias), ValidarStockActual(stock), ValidarStockMinimo(stockMinimo), ValidarRubro(rubro),null,null);
        this.repositioProducto.guardarProducto(producto);

    }

    //Verifica la viabilidad de los datos ingresados.      
    public String ValidarNombre(String nombre) {
        if (nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo nombre esta vacio.");
        }
        return nombre;
    }

    public String ValidarMarca(String marca) {
        if (marca.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo marca esta vacio.");
        }
        return marca;
    }

    public String ValidarUnidadMedida(String unidadMedida) {
        if (unidadMedida.trim().isEmpty()) {
            throw new IllegalArgumentException("No se selecciono unidad de medida esta vacio.");
        }
        return unidadMedida;
    }

    public double ValidarCosto(String costo) {
        try {
            double conversion = Double.valueOf(costo);
            if (conversion < 0) {
                throw new IllegalArgumentException("No puede ingresar numeros negativos.");
            }
            return conversion;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("No fue ingresado un numero en costo.");
        }
    }

    public double ValidarGanancias(String ganancias) {
        try {
            double conversion = Double.valueOf(ganancias);
            if (conversion < 0) {
                throw new IllegalArgumentException("No puede ingresar numeros negativos.");
            }
            return conversion;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("No fue ingresado un numero en ganancias.");
        }
    }

    public double ValidarStockActual(String stock) {
        try {
            double conversion = Double.valueOf(stock);
            if (conversion < 0) {
                throw new IllegalArgumentException("No puede ingresar numeros negativos.");
            }
            return conversion;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("No fue ingresado un numero en stock actual.");
        }

    }

    public double ValidarStockMinimo(String stockMinimo) {
        try {
            double conversion = Double.valueOf(stockMinimo);
            if (conversion < 0) {
                throw new IllegalArgumentException("No puede ingresar numeros negativos.");
            }
            return conversion;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("No fue ingresado un numero en stock minimo.");
        }
    }

    public String ValidarRubro(String rubro) {
        if (rubro.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo rubro esta vacio.");
        }
        return rubro;
    }

    public void eliminarProducto(Producto producto) {
        try {

            if (producto == null) {
                throw new IllegalArgumentException("No se ha escogido ningun producto a eliminar.");
            }
            this.repositioProducto.eliminarProducto(producto);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Problemas con el formato del codigo.");

        }

    }

    public ArrayList<Producto> obtenerTodosLosProductosRegistrados() {

        return this.repositioProducto.obtenerTodosLosProductos();

    }

    public ArrayList<Producto> buscarProductosPorNombre(String nombre) {
        if (nombre.equals("")) {
            throw new IllegalArgumentException("No se ingreso ningun dato para buscar.");
        }

        ArrayList<Producto> arrayADevolver = new ArrayList<>();

        arrayADevolver = this.repositioProducto.obtenerProductosSegunNombre(nombre);

        if (arrayADevolver.isEmpty()) {
            throw new IllegalArgumentException("No hay productos con ese nombre.");
        }

        return arrayADevolver;

    }

    public Producto buscarProductoPorCodigo(int codigo) {
        Producto producto = this.repositioProducto.obtenerUnicoProductoPorCodigo(codigo);

        if (producto == null) {
            throw new IllegalArgumentException("No existe el producto seleccionado");
        }

        return producto;
    }

    public void actualizarProducto(int codigo, String nombre, String marca, Unidadmedida unidadMedida, String costo, String ganancias, String stock, String stockMinimo, String rubro) {
        Producto productoModificado;
        
        productoModificado = new Producto(unidadMedida, ValidarMarca(marca), ValidarNombre(nombre), ValidarCosto(costo), ValidarGanancias(ganancias), ValidarStockActual(stock), ValidarStockMinimo(stockMinimo), ValidarRubro(rubro),null,null);
        productoModificado.setCodigo(codigo);

        this.repositioProducto.actualizarProducto(productoModificado);
    }

    //Metodo llamado cuando se necesita revisar si se alcanzo el stock minimo, y envia una respuesta por pantalla.
    public void revisarStock(int codigo) {
        boolean aux;
        aux = this.repositioProducto.verificarStock(codigo);

        if (aux) {
            JOptionPane.showMessageDialog(null, "Se alcanzo el stock minimo con el producto seleccionado.");
        }
    }
}
