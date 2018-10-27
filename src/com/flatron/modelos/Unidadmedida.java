package com.flatron.modelos;

import java.util.Collection;
import java.util.HashSet;

public class Unidadmedida  implements java.io.Serializable {


     private Integer codigo;
     private String nombre;
     private Collection productos = new HashSet(0);

    public Unidadmedida() {
    }

    public Unidadmedida(String nombre, Collection productos) {
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
    public Collection getProductos() {
        return this.productos;
    }
    
    public void setProductos(Collection productos) {
        this.productos = productos;
    }

}