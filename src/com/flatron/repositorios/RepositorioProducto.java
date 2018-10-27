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
package com.flatron.repositorios;

import com.flatron.modelos.Producto;
import java.util.ArrayList;

/**
 *
 * @author Franco Morbidoni <fgmorbidoni@gmail.com>
 */
public class RepositorioProducto {
    private ArrayList<Producto> listadoProductos;

    public RepositorioProducto() {
        this.listadoProductos = new ArrayList<>();
    }
    
    //Los tres metodos siguientes realizan las tareas de ABM de los productos.
    public void guardarProducto(Producto producto){
        this.listadoProductos.add(producto);
    }
    
    public void eliminarProducto(int index){
        int contador=0, indice=0;
        
        for(Producto objeto : listadoProductos) {
            
            if (objeto.getId()==index) { 
               indice=contador;                                    
            }
            contador++;            
        }
        
        listadoProductos.remove(indice);           
    }
    
    public void actualizarProducto(Producto producto){
        int contador=0, indice=0;
        
        for(Producto objeto : listadoProductos) {
            
            if (objeto.getId()==producto.getId()) { 
               indice=contador;                                    
            }
            contador++;            
        }
        
        listadoProductos.remove(indice);
        listadoProductos.add(indice, producto);
    }
    
    //Genera un array con todos los productos almacenados.
    public ArrayList<Producto> obtenerTodosLosProductos(){
        return this.listadoProductos;
    }
    
    //Genera un array con todos los productos cuyo nombre se asemege al buscado.
    public ArrayList<Producto> obtenerProductosSegunNombre(String nombre){
        ArrayList<Producto> arrayADevolver = new ArrayList<>();
        ArrayList<Producto> arrayAuxiliar = new ArrayList<>();
        
        arrayAuxiliar=listadoProductos;
        
        for (Producto modeloProducto : arrayAuxiliar) {
            if (modeloProducto.getNombreProducto().toLowerCase().contains(nombre.toLowerCase())) {
                arrayADevolver.add(modeloProducto);
            }
        }
        return arrayADevolver;
    }
    
    //Obtiene el producto al cual le pertenece el codigo ingresado.
    public Producto obtenerUnicoProductoPorCodigo(int codigo){
        Producto productoADevolver = null;
        
        for (Producto producto : listadoProductos) {
            if (producto.getId()==codigo) {
                productoADevolver=producto;
            }
        }
        
        return productoADevolver;
    }
    
    /*
    *Metodo que luego de identificar un producto, consulta si su stock actual es menor o igual al stock minimo, 
    *devolviendo un booleano como respusta.
    */
    public boolean verificarStock(int codigo){
        Producto productoElegido = null;
        boolean alcanzoStockMinimo = false; //true->se alcanzo el stock minimo, false-> no se alcanzo el stock minimo
        
        for (Producto producto : listadoProductos) {
            if (producto.getId()==codigo) {
                productoElegido=producto;
            }
        }
        
        if (productoElegido.getStockActualProducto()<=productoElegido.getStockMinimoProducto()){
            alcanzoStockMinimo=true;
        }
        
        return alcanzoStockMinimo;
    }
    
}
