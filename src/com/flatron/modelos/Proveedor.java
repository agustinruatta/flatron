package com.flatron.modelos;

import java.util.HashSet;
import java.util.Set;

public class Proveedor  implements java.io.Serializable {


     private Integer codigo;
     private String nombre;
     private String apellido;
     private String razonSocial;
     private String email;
     private String telefono;
     private String cuit;
     private String direccion;
     private String localidad;
     private String provincia;
     private Set compras = new HashSet(0);

    public Proveedor() {
    }

    public Proveedor(String nombre, String apellido, String razonSocial, String email, String telefono, String cuit, String direccion, String localidad, String provincia, Set compras) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.razonSocial = razonSocial;
       this.email = email;
       this.telefono = telefono;
       this.cuit = cuit;
       this.direccion = direccion;
       this.localidad = localidad;
       this.provincia = provincia;
       this.compras = compras;
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
    public String getRazonSocial() {
        return this.razonSocial;
    }
    
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCuit() {
        return this.cuit;
    }
    
    public void setCuit(String cuit) {
        this.cuit = cuit;
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
    public Set getCompras() {
        return this.compras;
    }
    
    public void setCompras(Set compras) {
        this.compras = compras;
    }

}