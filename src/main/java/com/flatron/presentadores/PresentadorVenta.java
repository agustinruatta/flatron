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
import com.flatron.modelos.Producto;
import com.flatron.modelos.Venta;
import com.flatron.repositorios.RepositorioProducto;
import com.flatron.servicios.ServicioVenta;
import com.flatron.vistas.VistaVenta;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;

/**
 *
 * @author Franco Morbidoni <fgmorbidoni@gmail.com>
 */
public class PresentadorVenta {
    private final VistaVenta vista;
    private final ServicioVenta servicio;
    private ArrayList<Producto> productos;
    private ArrayList<Detalleventa> listaDetalles;
    private RepositorioProducto repositorioProducto;

    public PresentadorVenta(VistaVenta vista) {
        this.vista = vista;
        this.servicio=new ServicioVenta();
        this.repositorioProducto= new RepositorioProducto();
        productos = new ArrayList<>();
        listaDetalles = new ArrayList<>();
    }
    
    public String[] obtenerListadoDeProductos(){
        return servicio.obtenerProductos();
    }
    
    public void generarImporte(){
        if (this.vista.getCantidadVentaTextField().getText().toString().equals("")==false) {           
        
        String producto = this.vista.getProductoVentaComboBox().getSelectedItem().toString();
        String cantidad = this.vista.getCantidadVentaTextField().getText().toString();
        double importe = this.servicio.calcularImporte(producto,cantidad);
        this.vista.getImporteDetalleVentaLabel().setText(importe+"");
        }
    }
    
    public void calcularTotal(){
        if (this.vista.getDescuentoVentaTextField().getText().toString().equals("")==false) {         
        
        double total=0;
        for (Detalleventa detalle : listaDetalles) {
            total+=detalle.getImporte();
        }
        double descuento= generarDoubleDescuento();
        if (descuento!=0) {
            total=total-(total*descuento);
        }
        this.vista.getTotalVentaLabel().setText(total+"");
        }
    }
    
    public void agregarProductoAlDetalle(){
       Venta venta = new Venta();
       int codigo = Integer.valueOf(this.vista.getProductoVentaComboBox().getSelectedItem().toString().split(" - ")[0]); 
       Producto producto = this.servicio.obtenerProductoEnParticular(codigo);
       productos.add(producto);
       Detalleventa detalle = new Detalleventa(producto, venta, Double.valueOf(this.vista.getCantidadVentaTextField().getText().toString()), Double.valueOf(this.vista.getImporteDetalleVentaLabel().getText().toString()));
       listaDetalles.add(detalle);
       this.actualizarTabla(listaDetalles);
       this.calcularTotal();
    }
    
    public void registrarVenta(){
        servicio.guardarVenta(null, this.vista.getNumeroComprobanteVentaTextField().getText().toString(), this.vista.getFechaVentaFormattedTextField().getText().toString(), this.vista.getImporteDetalleVentaLabel().getText().toString(), this.vista.getDescuentoVentaTextField().getText().toString(),listaDetalles);
        for (Detalleventa detalle : listaDetalles) {
            servicio.guardarDetalleVenta(detalle.getProducto(), detalle.getCantidad()+"", detalle.getImporte()+"");
        }
    }
    
    /**
    *Llena la tabla con los atributos de los productos, ya sea la lista completa
    *o los obtenidos por la operacion buscar.
    */
    private void actualizarTabla(ArrayList<Detalleventa> array) {        
        
        this.vista.getDetalleVentaTable().setModel(new ModeloTablaDetalleVenta(array));
    
    }
    
    /**
    *Crea una tabla vacia cuando se abre la vista de la gestion de productos.
    */
    public void crearTablaInicial(){
        ArrayList<Detalleventa> arrayVacio = new ArrayList<>();
        this.actualizarTabla(arrayVacio);
    }
    
    private double generarDoubleDescuento(){
        String descuentoString = this.vista.getDescuentoVentaTextField().getText().toString();
        double descuentoReal = Double.valueOf(descuentoString);
        descuentoReal=descuentoReal/100;
        return descuentoReal;
    }
    
    

    
}
