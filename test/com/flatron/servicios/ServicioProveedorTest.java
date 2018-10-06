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
package com.flatron.servicios;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mateo Cignetti <mateocig18@gmail.com>
 */
public class ServicioProveedorTest {
    
    private ServicioProveedor servicioProveedor;
    
    public ServicioProveedorTest() {
    }
    
    @Before
    public void setUp() {
        this.servicioProveedor = new ServicioProveedor();
    }
    
    @Test
    public void guardarProveedorTest(){
        servicioProveedor.guardarProveedor("nombre", "apellido", "razonSocial", "email", "telefono", "cuit", "direccion", "localida", "provincia");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nombreVacioTest(){
        servicioProveedor.guardarProveedor("", "apellido", "razonSocial", "email", "telefono", "cuit", "direccion", "localidad", "provincia");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void apellidoVacioTest(){
        servicioProveedor.guardarProveedor("nombre", "", "razonSocial", "email", "telefono", "cuit", "direccion", "localidad", "provincia");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void razonSocialVaciaTest(){
        servicioProveedor.guardarProveedor("nombre", "apellido", "", "email", "telefono", "cuit", "direccion", "localidad", "provincia");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void emailVacioTest(){
        servicioProveedor.guardarProveedor("nombre", "apellido", "razonSocial", "", "telefono", "cuit", "direccion", "localidad", "provincia");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void telefonoVacioTest(){
        servicioProveedor.guardarProveedor("nombre", "apellido", "razonSocial", "email", "", "cuit", "direccion", "localidad", "provincia");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void cuitVacioTest(){
        servicioProveedor.guardarProveedor("nombre", "apellido", "razonSocial", "email", "telefono", "", "direccion", "localidad", "provincia");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void direccionVaciaTest(){
        servicioProveedor.guardarProveedor("nombre", "apellido", "razonSocial", "email", "telefono", "cuit", "", "localidad", "provincia");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void localidadVaciaTest(){
        servicioProveedor.guardarProveedor("nombre", "apellido", "razonSocial", "email", "telefono", "cuit", "direccion", "", "provincia");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void provinciaVaciaTest(){
        servicioProveedor.guardarProveedor("nombre", "apellido", "razonSocial", "email", "telefono", "cuit", "direccion", "localidad", "");
    }
    
}
