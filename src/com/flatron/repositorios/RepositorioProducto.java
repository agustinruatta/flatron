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
    
    public void guardarProducto(ModeloProducto producto){
        this.listadoProductos.add(producto);
    }
    
    public void eliminarProducto(int index){
        this.listadoProductos.remove(index);
    }
    
    public ModeloProducto[] obtenerTodosLosProductos(){
        ModeloProducto[] arrayADevolver = new ModeloProducto[this.listadoProductos.size()];
        
        return this.listadoProductos.toArray(arrayADevolver);
    }
    
}
