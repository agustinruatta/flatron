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

import com.flatron.modelos.Proveedor;
import com.flatron.repositorios.RepositorioProveedor;
import java.util.ArrayList;

/**
 *
 * @author Mateo Cignetti <mateocig18@gmail.com>
 */
public class ServicioProveedor {
    
    private RepositorioProveedor repositorioProveedor;
    
    public ServicioProveedor(){
        this.repositorioProveedor = new RepositorioProveedor();
    }
    
    public void guardarProveedor(
            String nombre,
            String apellido,
            String razonSocial,
            String email,
            String telefono,
            String cuit,
            String direccion,
            String localidad,
            String provincia
    ){
        /*
        Validar datos. Si alguno es incorrecto, se va a lanzar una excepción y
        lo va a agarrar el presentador. El presentador debería mostrar un mensaje
        de error indicando por qué falló.
        */
        validarNombre(nombre);
        validarApellido(apellido);
        validarRazonSocial(razonSocial);
        validarEmail(email);
        validarTelefono(telefono);
        validarCuit(cuit);
        validarDireccion(direccion);
        validarLocalidad(localidad);
        validarProvincia(provincia);        
        
        //Creamos el modelo para guardarlo en la Base de Datos
        
        Proveedor proveedor = new Proveedor(
        nombre,
        apellido,
        razonSocial,
        email,
        telefono,
        cuit,
        direccion,
        localidad,
        provincia
        );
        
        //Guardamos en la base de datos
        
        this.repositorioProveedor.guardarProveedor(proveedor);
                        
    }
    
    public ArrayList obtenerProveedores(){
        
    }
    
    private void validarNombre(String nombre) {
        /*
        Si la cantidad de caracteres es igual a 0, entonces el usuario no 
        introdujo ningún nombre. Si es así, lanzar una excepción para
        que lo agarre el Presentador y muestre el mensaje de error.
        */
        if (nombre.length() == 0) {
            throw new IllegalArgumentException("¡El nombre es vacío!");
        }
    }
    
    private void validarApellido(String apellido) {
        if (apellido.length() == 0) {
            throw new IllegalArgumentException("¡El apellido es vacío!");
        }
    }
    
    private void validarRazonSocial(String razonSocial) {
        if (razonSocial.length() == 0) {
            throw new IllegalArgumentException("¡La razon social es vacía!");
        }
    }
    
    private void validarEmail(String email) {
        if (email.length() == 0) {
            throw new IllegalArgumentException("¡El email es vacío!");
        }
    }
    
    private void validarTelefono(String telefono) {
        if (telefono.length() == 0) {
            throw new IllegalArgumentException("¡El telefono es vacío!");
        }
    }
    
    private void validarCuit(String cuit) {
        if (cuit.length() == 0) {
            throw new IllegalArgumentException("¡El cuit es vacío!");
        }
    }
    
    private void validarDireccion(String direccion) {
        if (direccion.length() == 0) {
            throw new IllegalArgumentException("¡La dirección es vacía!");
        }
    }
    
    private void validarLocalidad(String localidad) {
        if (localidad.length() == 0) {
            throw new IllegalArgumentException("¡La localidad es vacía!");
        }
    }
    
    private void validarProvincia(String provincia) {
        if (provincia.length() == 0) {
            throw new IllegalArgumentException("¡La provincia es vacía!");
        }
    }
}
