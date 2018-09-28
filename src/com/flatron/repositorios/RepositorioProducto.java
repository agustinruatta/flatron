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

import com.flatron.modelos.ModeloProducto;
import java.util.ArrayList;

/**
 *
 * @author Franco Morbidoni <fgmorbidoni@gmail.com>
 */
public class RepositorioProducto {
    private ArrayList<ModeloProducto> listadoProductos;

    public RepositorioProducto() {
        this.listadoProductos = new ArrayList<>();
    }
    
    //Los tres metodos siguientes realizan las tareas de ABM de los productos.
    public void guardarProducto(ModeloProducto producto){
        this.listadoProductos.add(producto);
    }
    
    public void eliminarProducto(int index){
        int contador=0, indice=0;
        
        for(ModeloProducto objeto : listadoProductos) {
            
            if (objeto.getCodigoProducto()==index) { 
               indice=contador;                                    
            }
            contador++;            
        }
        
        listadoProductos.remove(indice);           
    }
    
    public void actualizarProducto(int codigo, ModeloProducto producto){
        int contador=0, indice=0;
        
        for(ModeloProducto objeto : listadoProductos) {
            
            if (objeto.getCodigoProducto()==codigo) { 
               indice=contador;                                    
            }
            contador++;            
        }
        
        listadoProductos.remove(indice);   
        producto.setCodigoProducto(codigo);
        listadoProductos.add(indice, producto);
    }
    
    //Genera un array con todos los productos almacenados.
    public ArrayList<ModeloProducto> obtenerTodosLosProductos(){
        ArrayList<ModeloProducto> arrayADevolver = new ArrayList<>();
        
        arrayADevolver=listadoProductos;
        
        return arrayADevolver;
    }
    
    //Genera un array con todos los productos cuyo nombre se asemege al buscado.
    public ArrayList<ModeloProducto> obtenerProductosSegunNombre(String nombre){
        ArrayList<ModeloProducto> arrayADevolver = new ArrayList<>();
        ArrayList<ModeloProducto> arrayAuxiliar = new ArrayList<>();
        
        arrayAuxiliar=listadoProductos;
        
        for (ModeloProducto modeloProducto : arrayAuxiliar) {
            if (modeloProducto.getNombreProducto().toLowerCase().contains(nombre.toLowerCase())) {
                arrayADevolver.add(modeloProducto);
            }
        }
        return arrayADevolver;
    }
    
    //Obtiene el producto al cual le pertenece el codigo ingresado.
    public ModeloProducto obtenerUnicoProductoPorCodigo(int codigo){
        ModeloProducto productoADevolver = null;
        
        for (ModeloProducto producto : listadoProductos) {
            if (producto.getCodigoProducto()==codigo) {
                productoADevolver=producto;
            }
        }
        
        return productoADevolver;
    }
    
    public boolean verificarStock(int codigo){
        ModeloProducto productoElegido = null;
        boolean alcanzoStockMinimo = false; //true->se alcanzo el stock minimo, false-> no se alcanzo el stock minimo
        
        for (ModeloProducto producto : listadoProductos) {
            if (producto.getCodigoProducto()==codigo) {
                productoElegido=producto;
            }
        }
        
        if (productoElegido.getStockActualProducto()<=productoElegido.getStockMinimoProducto()){
            alcanzoStockMinimo=true;
        }
        
        return alcanzoStockMinimo;
    }
    
}
