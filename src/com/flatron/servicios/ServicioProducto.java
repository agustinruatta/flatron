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
import javax.swing.JOptionPane;

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

    //Verifica la viabilidad de los datos ingresados.
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
                if (costoProducto<0) {
                    throw new IllegalArgumentException("No puede ingresar numeros negativos.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("No fue ingresado un numero en costo.");
            }
        }

        if (ganancias.equals("")) {
            throw new IllegalArgumentException("El campo ganancias esta vacio.");
        } else {
            try {
                this.gananciasProducto = Float.valueOf(ganancias);
                if (gananciasProducto<0) {
                    throw new IllegalArgumentException("No puede ingresar numeros negativos.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("No fue ingresado un numero en ganancias.");
            }
        }

        if (stock.equals("")) {
            throw new IllegalArgumentException("El campo stock actual esta vacio.");
        } else {
            try {
                this.stockActualProducto = Float.valueOf(stock);
                if (stockActualProducto<0) {
                    throw new IllegalArgumentException("No puede ingresar numeros negativos.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("No fue ingresado un numero en stock actual.");
            }
        }

        if (stockMinimo.equals("")) {
            throw new IllegalArgumentException("El campo stock minimo esta vacio.");
        } else {
            try {
                this.stockMinimoProducto = Float.valueOf(stockMinimo);
                if (stockMinimoProducto<0) {
                    throw new IllegalArgumentException("No puede ingresar numeros negativos.");
                }
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
    
    public void eliminarProducto(String codigo){
        try {
            
            if (codigo==null) {
                throw new IllegalArgumentException("No se ha escogido ningun producto a eliminar.");
            }
            
            int codigoProducto = Integer.valueOf(codigo.split(" ")[2]);
            this.repositioProducto.eliminarProducto(codigoProducto); 
        } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Problemas con el formato del codigo.");
            
        }
               
    }

    public ArrayList<ModeloProducto> obtenerTodosLosProductosRegistrados() {
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
    
    public ModeloProducto buscarProductoPorCodigo(int codigo){
        ModeloProducto producto;
        producto=this.repositioProducto.obtenerUnicoProductoPorCodigo(codigo);
        
        if (producto==null) {
            throw new IllegalArgumentException("No existe el producto seleccionado");
        }
        
        return producto;
    }
    
    public void actualizarProducto(int codigo, String nombre, String marca, String unidadMedida, String costo, String ganancias, String stock, String stockMinimo, String rubro){
        ModeloProducto productoModificado;
        
        validarDatos(nombre, marca, unidadMedida, costo, ganancias, stock, stockMinimo, rubro);
        
        productoModificado = new ModeloProducto(nombreProducto, marcaProducto, unidadMedidaProducto, costoProducto, gananciasProducto, stockActualProducto, stockMinimoProducto, rubroProducto);
        
        this.repositioProducto.actualizarProducto(codigo, productoModificado);
    }
    
    //Metodo llamado cuando se necesita revisar si se alcanzo el stock minimo, y envia una respuesta por pantalla.
    public void revisarStock(int codigo){
        boolean aux;
        aux=this.repositioProducto.verificarStock(codigo);
        
        if (aux) {
            JOptionPane.showMessageDialog(null, "Se alcanzo el stock minimo con el producto seleccionado.");
        }
    }
}
