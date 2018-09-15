/*
 * Copyright (C) 2018 Mateo Cignetti <mateocig18@gmail.com>
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

import com.flatron.excepciones.ProveedorNoEncontradoException;
import com.flatron.modelos.Proveedor;
import java.util.ArrayList;

/**
 *
 * @author Mateo Cignetti <mateocig18@gmail.com>
 */
public class RepositorioProveedor {

    private ArrayList<Proveedor> proveedoresGuardados;

    public RepositorioProveedor() {
        this.proveedoresGuardados = new ArrayList<>();
    }

    public void guardarProveedor(Proveedor proveedor) {
        this.proveedoresGuardados.add(proveedor);
    }
    
    public Proveedor obtenerProveedor(int id) throws ProveedorNoEncontradoException {
        for (Proveedor proveedor : this.proveedoresGuardados){
            if (proveedor.getId() == id){
                return proveedor;
            }
        }
        throw new ProveedorNoEncontradoException("¡No se ha encontrado el proveedor en el repositorio!");
    }

    public void eliminarProveedor(int id) throws ProveedorNoEncontradoException {
        for (Proveedor proveedor : this.proveedoresGuardados) {
            if (proveedor.getId() == id) {
                this.proveedoresGuardados.remove(proveedor);
                return;
            }
        }
        throw new ProveedorNoEncontradoException("¡No se ha encontrado el proveedor en el repositorio!");
    }
}
