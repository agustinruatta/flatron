package com.flatron.modelos;

import java.util.Collection;
import java.util.HashSet;

public class Cliente  implements java.io.Serializable {


     private Integer codigo;
     private String nombre;
     private String apellido;
     private String cuit;
     private String email;
     private String celular;
     private String direccion;
     private String localidad;
     private String provincia;
     private Collection<Venta> ventas = new HashSet(0);

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String cuit, String email, String celular, String direccion, String localidad, String provincia, Collection<Venta> ventas) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.cuit = cuit;
       this.email = email;
       this.celular = celular;
       this.direccion = direccion;
       this.localidad = localidad;
       this.provincia = provincia;
       this.ventas = ventas;
    }
   
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCuit() {
        return this.cuit;
    }
    
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getLocalidad() {
        return this.localidad;
    }
    
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    public String getProvincia() {
        return this.provincia;
    }
    
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public Collection<Venta> getVentas() {
        return this.ventas;
    }
    
    public void setVentas(Collection<Venta> ventas) {
        this.ventas = ventas;
    }

}