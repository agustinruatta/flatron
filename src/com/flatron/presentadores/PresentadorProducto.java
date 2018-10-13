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

import com.flatron.modelos.ModeloProducto;
import com.flatron.servicios.ServicioProducto;
import com.flatron.vistas.VistaProducto;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Franco Morbidoni <fgmorbidoni@gmail.com>
 */
public class PresentadorProducto {

    private final VistaProducto vista;
    private final ServicioProducto servicio;

    public PresentadorProducto(VistaProducto vista) {
        this.vista = vista;
        this.servicio = new ServicioProducto();
    }

    //Realiza el guardado de los datos ingresados.
    public void botonGuardarProducto() {
        
        String nombre = this.vista.getNombreProductoTextField().getText();
        String marca = this.vista.getMarcaProductoTextField().getText();
        String unidadMedida = this.vista.getUnidadesMedidaProductoComboBox().getSelectedItem().toString();
        String costo = this.vista.getCostoProductoTextField().getText();
        String ganancia = this.vista.getGananciaProductoTextField().getText();
        String stock = this.vista.getStockActualProductoTextField().getText();
        String stockMinimo = this.vista.getStockMinimoProductoTextField().getText();
        String rubro = this.vista.getRubroProductoTextField().getText();

        try {

            this.servicio.guardarProducto(nombre, marca, unidadMedida, costo, ganancia, stock, stockMinimo, rubro);

            limpiarVista();

            this.actualizarTabla(this.servicio.obtenerTodosLosProductosRegistrados());
            JOptionPane.showMessageDialog(null, "Datos guardados.");

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    
    //Elimina un producto seleccionado de la tabla.
    public void botonEliminarProducto(){
        String auxiliar;
        auxiliar = this.vista.getProductoElegidoLabel().getText();
        try {
           this.servicio.eliminarProducto(auxiliar);
           this.actualizarTabla(this.servicio.obtenerTodosLosProductosRegistrados());
        } catch (IllegalArgumentException e) {            
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //Llena la tabla con los atributos de los productos, ya sea la lista completa
    //o los obtenidos por la operacion buscar.
    private void actualizarTabla(ArrayList<ModeloProducto> array) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("Codigo");
        tableHeaders.add("Nombre");
        tableHeaders.add("Marca");
        tableHeaders.add("Unidad de Medida");
        tableHeaders.add("Costo");
        tableHeaders.add("Ganancias");
        tableHeaders.add("Stock Actual");
        tableHeaders.add("Stock Minimo");
        tableHeaders.add("Rubro");

        for (ModeloProducto o : array) {
            ModeloProducto modelo = o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(modelo.getCodigoProducto());
            oneRow.add(modelo.getNombreProducto());
            oneRow.add(modelo.getMarcaProducto());
            oneRow.add(modelo.getUnidadMedidaProducto());
            oneRow.add(modelo.getCostoProducto());
            oneRow.add(modelo.getGananciasProducto());
            oneRow.add(modelo.getStockActualProducto());
            oneRow.add(modelo.getStockMinimoProducto());
            oneRow.add(modelo.getRubroProducto());
            tableData.add(oneRow);
        }

        this.vista.getProductosTable().setModel(new DefaultTableModel(tableData, tableHeaders));
    }

    //Se escogio buscar los productos que se acerquen al nombre ingresado, como
    //caracteristica elegida para centrar la busqueda.
    public void botonBuscarProducto() {
        try {
            String nombreBuscado = this.vista.getBuscarProductoTextField().getText();
            ArrayList<ModeloProducto> array = new ArrayList<>();
            array = this.servicio.buscarProductosPorNombre(nombreBuscado);
            this.actualizarTabla(array);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //Restaura la tabla a mostrar todos los valores, luego de una busqueda.
    public void botonMostrarTodosLosProductos() {
        this.actualizarTabla(this.servicio.obtenerTodosLosProductosRegistrados());
    }
    
    //Llena los campos de la vista con los valores de la linea seleccionada en 
    //la tabla.
    public void cargarDatosProducto(int codigoProducto) {
        try {
            ModeloProducto producto;
            producto = this.servicio.buscarProductoPorCodigo(codigoProducto);

            this.vista.getNombreProductoTextField().setText(producto.getNombreProducto());
            this.vista.getMarcaProductoTextField().setText(producto.getMarcaProducto());
            this.vista.getUnidadesMedidaProductoComboBox().setSelectedItem(producto.getUnidadMedidaProducto());
            this.vista.getCostoProductoTextField().setText("" + producto.getCostoProducto());
            this.vista.getGananciaProductoTextField().setText("" + producto.getGananciasProducto());
            this.vista.getStockActualProductoTextField().setText("" + producto.getStockActualProducto());
            this.vista.getStockMinimoProductoTextField().setText("" + producto.getStockMinimoProducto());
            this.vista.getRubroProductoTextField().setText(producto.getRubroProducto());

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //Toma los datos presentes en los campos de la vista y actualiza el registro
    //del producto seleccionado en la tabla.
    public void botonModificarProducto() {
        try {
            //Se utiliza el laber para no perder el codigo respectivo del producto elegido.
            int codigoProducto = Integer.valueOf(this.vista.getProductoElegidoLabel().getText().split(" ")[2]);

            String nombre = this.vista.getNombreProductoTextField().getText();
            String marca = this.vista.getMarcaProductoTextField().getText();
            String unidadMedida = this.vista.getUnidadesMedidaProductoComboBox().getSelectedItem().toString();
            String costo = this.vista.getCostoProductoTextField().getText();
            String ganancia = this.vista.getGananciaProductoTextField().getText();
            String stock = this.vista.getStockActualProductoTextField().getText();
            String stockMinimo = this.vista.getStockMinimoProductoTextField().getText();
            String rubro = this.vista.getRubroProductoTextField().getText();

            this.servicio.actualizarProducto(codigoProducto,nombre, marca, unidadMedida, costo, ganancia, stock, stockMinimo, rubro);
            limpiarVista();
            this.actualizarTabla(this.servicio.obtenerTodosLosProductosRegistrados());
            JOptionPane.showMessageDialog(null, "Datos actualizados.");
            
        } catch (IllegalArgumentException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //Vacia los campos de la vista luego de agregar o modificar un producto.
    private void limpiarVista() {
        this.vista.getNombreProductoTextField().setText("");
        this.vista.getMarcaProductoTextField().setText("");
        this.vista.getUnidadesMedidaProductoComboBox().setSelectedIndex(0);
        this.vista.getCostoProductoTextField().setText("");
        this.vista.getGananciaProductoTextField().setText("");
        this.vista.getStockActualProductoTextField().setText("");
        this.vista.getStockMinimoProductoTextField().setText("");
        this.vista.getRubroProductoTextField().setText("");
        this.vista.getProductoElegidoLabel().setText("");

    }
    
    //Crea una tabla vacia cuando se abre la vista de la gestion de productos.
    public void crearTablaInicial(){
        ArrayList<ModeloProducto> arrayVacio = new ArrayList<>();
        this.actualizarTabla(arrayVacio);
    }

}
