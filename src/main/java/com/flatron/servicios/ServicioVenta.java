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

import com.flatron.modelos.Cliente;
import com.flatron.modelos.Detalleventa;
import com.flatron.modelos.Producto;
import com.flatron.modelos.Venta;
import com.flatron.repositorios.RepositorioProducto;
import com.flatron.repositorios.RepositorioVenta;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.mapping.Collection;

/**
 *
 * @author Franco Morbidoni <fgmorbidoni@gmail.com>
 */
public class ServicioVenta {
    RepositorioVenta repositorioVenta;
    RepositorioProducto repositorioProducto;

    public ServicioVenta() {
        this.repositorioVenta=new RepositorioVenta();
        this.repositorioProducto=new RepositorioProducto();
    }
    
    public void guardarVenta(Cliente cliente, String comprobante, String fecha,  String total, String descuento, ArrayList<Detalleventa> detallesDeVenta){
        //TODO el cliente creado es una medida temporal, hasta que se cree el repositorio de clientes.
        cliente=new Cliente("Juan", "Perez","124155352" ,"juan@hotmail","15667889","Italia 333", "Devoto", "Cordoba",null);
        cliente.setCodigo(1);
        Venta venta = new Venta(cliente, validarComprobante(comprobante), validarFecha(fecha), validarTotal(total), validarDescuento(descuento));
        this.repositorioVenta.guardarVenta(venta);
        
        for (Detalleventa detalle : detallesDeVenta) {
            detalle.setVenta(venta);
            venta.agregarDetalleVenta(detalle);
            
            this.repositorioVenta.guardarDetalleVenta(detalle);
            this.repositorioVenta.guardarVenta(venta);
        }
    }
    
    public void guardarDetalleVenta(Producto producto, String cantidad, String importe){
        Detalleventa detalle = new Detalleventa(producto, null, validarCantidad(cantidad), validarImporte(importe));
        
    }
    
    public double calcularImporte(String productoElegido, String cantidadIngresada){
        String codigoProducto = productoElegido.split(" - ")[0];
        Producto producto = repositorioProducto.obtenerUnicoProductoPorCodigo(Integer.valueOf(codigoProducto));
        double resultado = producto.getPrecio()*validarCantidad(cantidadIngresada);
        return resultado;
    }
    
    public String[] obtenerProductos(){
        ArrayList<Producto> productos = repositorioProducto.obtenerTodosLosProductos();
        String[] listado = new String[productos.size()]; 
        for (int i = 0; i < productos.size(); i++) {
            listado[i]= productos.get(i).getCodigo() + " - " + productos.get(i).getNombre();
        }
        return listado;
    }    
    
    public boolean stockMinimoAlcanzado(){
        boolean stockAlcanzado=false;
    
        return stockAlcanzado;
    }
    
    private String validarComprobante(String comprobante){
        if (comprobante.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo numero del comprobante esta vacio.");
        }
        return comprobante;
    }
    
    private Date validarFecha(String fecha){
        Date fechaValidada = new Date();
        if (fecha.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo fecha esta vacio.");
        }else{
            try {
                fechaValidada = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
            } catch (ParseException e) {
                throw new IllegalArgumentException("El formato de la fecha ingresada, es incorrecto.");
            }            
         }
        return fechaValidada;
    }
    
    private double validarDescuento(String descuento){
        double descuentoValidado=0;
        if (descuento.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo descuento esta vacio.");
        }else{
            try {
                descuentoValidado = Double.valueOf(descuento);
                if (descuentoValidado<0) {
                    throw new IllegalArgumentException("El descuento no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("No fue ingresado un numero en el campo descuento.");
            }            
         }
        return descuentoValidado;
    }
    
    private double validarCantidad(String cantidad){
        double cantidadValidada=0;
        if (cantidad.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo cantidad esta vacio.");
        }else{
            try {
                cantidadValidada = Double.valueOf(cantidad);
                if (cantidadValidada<0) {
                    throw new IllegalArgumentException("La cantidad no puede ser negativa.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("No fue ingresado un numero en el campo cantidad.");
            }            
         }
        return cantidadValidada;
    }
    
    private double validarTotal(String total){
        double totalValidado=0;
        if (total.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo total no ha sido calculado.");
        }else{
            totalValidado = Double.valueOf(total);           
         }
        return totalValidado;
    }
    
    private double validarImporte(String importe){
        double importeValidado=0;
        if (importe.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo importe no ha sido calculado.");
        }else{
            try {
                importeValidado = Double.valueOf(importe);
                if (importeValidado<0) {
                    throw new IllegalArgumentException("La cantidad no puede ser negativa."); //El importe sera negativo solo si la cantidad lo es.
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("No fue ingresado un numero en el campo cantidad.");//Solo se puede modificar el campo cantidad.
            }            
         }
        return importeValidado;
    }
    
    public Producto obtenerProductoEnParticular(int codigo){
        return this.repositorioProducto.obtenerUnicoProductoPorCodigo(codigo);        
    }
}
