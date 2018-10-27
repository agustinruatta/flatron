package com.flatron.modelos;

import java.util.HashSet;
import java.util.Set;

public class Unidadmedida  implements java.io.Serializable {


     private Integer codigo;
     private String nombre;
     private Set productos = new HashSet(0);

    public Unidadmedida() {
    }

    public Unidadmedida(String nombre, Set productos) {
       this.nombre = nombre;
       this.productos = productos;
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
    public Set getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set productos) {
        this.productos = productos;
    }

}