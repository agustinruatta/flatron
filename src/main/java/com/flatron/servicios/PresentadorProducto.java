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
import com.flatron.modelos.Unidadmedida;
import com.flatron.servicios.ServicioProducto;
import com.flatron.vistas.VistaProducto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Franco Morbidoni <fgmorbidoni@gmail.com>
 */
public class PresentadorProducto {

    private final VistaProducto vista;
    private final ServicioProducto servicio;
    private Producto productoSeleccionado;

    public PresentadorProducto(VistaProducto vista) {
        this.vista = vista;
        this.servicio = new ServicioProducto();
    }

    /**
    *Realiza el guardado de los datos ingresados.
    */
    public void botonGuardarProducto() {
        
        String nombre = this.vista.getNombreProductoTextField().getText();
        String marca = this.vista.getMarcaProductoTextField().getText();
        Unidadmedida unidadMedida = null; //TODO cambiar cuando se obtega el repositorio de unidades de medidas.
        String costo = this.vista.getCostoProductoTextField().getText();
        String precio = this.vista.getPrecioProductoTextField().getText();
        String stock = this.vista.getStockActualProductoTextField().getText();
        String stockMinimo = this.vista.getStockMinimoProductoTextField().getText();
        String rubro = this.vista.getRubroProductoTextField().getText();

        try {

            this.servicio.guardarProducto(nombre, marca, unidadMedida, costo, precio, stock, stockMinimo, rubro);

            this.limpiarVista();

            this.actualizarTabla(this.servicio.obtenerTodosLosProductosRegistrados());
            JOptionPane.showMessageDialog(null, "Datos guardados.");

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    
    /**
    *Elimina un producto seleccionado de la tabla.
    */
    public void botonEliminarProducto(){
        try {
           this.servicio.eliminarProducto(productoSeleccionado);
           this.actualizarTabla(this.servicio.obtenerTodosLosProductosRegistrados());
        } catch (IllegalArgumentException e) {            
            JOptionPane.showMessageDialog(null, e.getMessage());
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

  /**
    *Llena la tabla con los atributos de los productos, ya sea la lista completa
    *o los obtenidos por la operacion buscar.
    */
    private void actualizarTabla(ArrayList<Producto> array) {        
        
        this.vista.getProductosTable().setModel(new ModeloTablaProducto(array));
    
    }
    
    /**
    *Se escogio buscar los productos que se acerquen al nombre ingresado, como
    *caracteristica elegida para centrar la busqueda.
    */ 
    public void botonBuscarProducto() {
        try {
            String nombreBuscado = this.vista.getBuscarProductoTextField().getText();
            ArrayList<Producto> array = new ArrayList<>();
            array = this.servicio.buscarProductosPorNombre(nombreBuscado);
            this.actualizarTabla(array);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
    *Restaura la tabla a mostrar todos los valores, luego de una busqueda.
    */
    public void botonMostrarTodosLosProductos() {
        this.actualizarTabla(this.servicio.obtenerTodosLosProductosRegistrados());
    }
    
    /**
    *Llena los campos de la vista con los valores de la linea seleccionada en 
    *la tabla.
    */
    public void cargarDatosProducto(Producto producto) {
        try {
            this.productoSeleccionado=producto;
            this.vista.getNombreProductoTextField().setText(producto.getNombre());
            this.vista.getMarcaProductoTextField().setText(producto.getMarca());
            this.vista.getUnidadesMedidaProductoComboBox().setSelectedItem(producto.getUnidadmedida().getNombre());
            this.vista.getCostoProductoTextField().setText("" + producto.getCosto());
            this.vista.getPrecioProductoTextField().setText("" + producto.getPrecio());
            this.vista.getStockActualProductoTextField().setText("" + producto.getStock());
            this.vista.getStockMinimoProductoTextField().setText("" + producto.getStockMinimo());
            this.vista.getRubroProductoTextField().setText(producto.getRubro());

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /*
    *Toma los datos presentes en los campos de la vista y actualiza el registro
    *del producto seleccionado en la tabla.
    */
    public void botonModificarProducto() {
        try {
            if (productoSeleccionado==null) {
                throw new NullPointerException("Producto no seleccionado");
            }
            
            //Se utiliza el laber para no perder el codigo respectivo del producto elegido.
            String nombre = this.vista.getNombreProductoTextField().getText();
            String marca = this.vista.getMarcaProductoTextField().getText();
            Unidadmedida unidadMedida = null; //TODO esperar al repositorio de unidad de medidas
            String costo = this.vista.getCostoProductoTextField().getText();
            String precio = this.vista.getPrecioProductoTextField().getText();
            String stock = this.vista.getStockActualProductoTextField().getText();
            String stockMinimo = this.vista.getStockMinimoProductoTextField().getText();
            String rubro = this.vista.getRubroProductoTextField().getText();

            this.servicio.actualizarProducto(productoSeleccionado.getCodigo(),nombre, marca, unidadMedida, costo, precio, stock, stockMinimo, rubro);
            limpiarVista();
            this.actualizarTabla(this.servicio.obtenerTodosLosProductosRegistrados());
            JOptionPane.showMessageDialog(null, "Datos actualizados.");
            
        } catch (IllegalArgumentException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
    *Vacia los campos de la vista luego de agregar o modificar un producto.
    */
    private void limpiarVista() {
        this.vista.getNombreProductoTextField().setText("");
        this.vista.getMarcaProductoTextField().setText("");
        this.vista.getUnidadesMedidaProductoComboBox().setSelectedIndex(0);
        this.vista.getCostoProductoTextField().setText("");
        this.vista.getPrecioProductoTextField().setText("");
        this.vista.getStockActualProductoTextField().setText("");
        this.vista.getStockMinimoProductoTextField().setText("");
        this.vista.getRubroProductoTextField().setText("");
    }
    
    /**
    *Crea una tabla vacia cuando se abre la vista de la gestion de productos.
    */
    public void crearTablaInicial(){
        ArrayList<Producto> arrayVacio = new ArrayList<>();
        this.actualizarTabla(arrayVacio);
    }

}
