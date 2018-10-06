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
package com.flatron.modelos;

/**
 *
 * @author Mateo Cignetti <mateocig18@gmail.com>
 */
public class Proveedor {

    private int id = 0;
    private String nombre;
    private String apellido;
    private String razonSocial;
    private String email;
    private String telefono;
    private String cuit;
    private String direccion;
    private String localidad;
    private String provincia;

    public Proveedor(
            String nombre,
            String apellido,
            String razon_social,
            String email,
            String telefono,
            String cuit,
            String direccion,
            String localidad,
            String provincia
    ) {
        this.id += 1;
        this.nombre = nombre;
        this.apellido = apellido;
        this.razonSocial = razon_social;
        this.email = email;
        this.telefono = telefono;
        this.cuit = cuit;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getApellido(){
        return apellido;
    }

    public String getRazon_social() {
        return razonSocial;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCuit() {
        return cuit;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getProvincia() {
        return provincia;
    }
}
