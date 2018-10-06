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
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mateo Cignetti <mateocig18@gmail.com>
 */
public class RepositorioProveedorTest {
    
    private RepositorioProveedor repositorioProveedor;
    
    public RepositorioProveedorTest() {
    }
    
    @Before
    public void setUp() {
        this.repositorioProveedor = new RepositorioProveedor();
    }

    @Test
    public void guardarProveedorTest(){
        Proveedor proveedor = new Proveedor("Nombre", "Apellido", "Razon social", "email", "telefono", "cuit", "direccion", "localidad", "provincia");
        repositorioProveedor.guardarProveedor(crearProveedorCorrecto());
    }
    
    @Test
    public void eliminarProveedorTest() throws ProveedorNoEncontradoException{
        repositorioProveedor.guardarProveedor(crearProveedorCorrecto());
        repositorioProveedor.eliminarProveedor(1);
    }
    
    @Test
    public void obtenerProveedorTest() throws ProveedorNoEncontradoException{
        repositorioProveedor.guardarProveedor(crearProveedorCorrecto());
        repositorioProveedor.obtenerProveedor(1);
    }
    
    private Proveedor crearProveedorCorrecto(){
        Proveedor proveedor = new Proveedor("Nombre", "Apellido", "Razon social", "email", "telefono", "cuit", "direccion", "localidad", "provincia");
        return proveedor;
    }
}
