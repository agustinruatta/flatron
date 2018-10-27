package com.flatron.modelos;

import java.util.HashSet;
import java.util.Set;

public class Producto  implements java.io.Serializable {


     private Integer codigo;
     private Unidadmedida unidadmedida;
     private String marca;
     private String nombre;
     private Double costo;
     private Double ganancia;
     private Double stock;
     private Double stockMinimo;
     private String rubro;
     private Set detalleventas = new HashSet(0);
     private Set detallecompras = new HashSet(0);

    public Producto() {
    }

    public Producto(Unidadmedida unidadmedida, String marca, String nombre, Double costo, Double ganancia, Double stock, Double stockMinimo, String rubro, Set detalleventas, Set detallecompras) {
       this.unidadmedida = unidadmedida;
       this.marca = marca;
       this.nombre = nombre;
       this.costo = costo;
       this.ganancia = ganancia;
       this.stock = stock;
       this.stockMinimo = stockMinimo;
       this.rubro = rubro;
       this.detalleventas = detalleventas;
       this.detallecompras = detallecompras;
    }
   
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public Unidadmedida getUnidadmedida() {
        return this.unidadmedida;
    }
    
    public void setUnidadmedida(Unidadmedida unidadmedida) {
        this.unidadmedida = unidadmedida;
    }
    public String getMarca() {
        return this.marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getCosto() {
        return this.costo;
    }
    
    public void setCosto(Double costo) {
        this.costo = costo;
    }
    public Double getGanancia() {
        return this.ganancia;
    }
    
    public void setGanancia(Double ganancia) {
        this.ganancia = ganancia;
    }
    public Double getStock() {
        return this.stock;
    }
    
    public void setStock(Double stock) {
        this.stock = stock;
    }
    public Double getStockMinimo() {
        return this.stockMinimo;
    }
    
    public void setStockMinimo(Double stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
    public String getRubro() {
        return this.rubro;
    }
    
    public void setRubro(String rubro) {
        this.rubro = rubro;
    }
    public Set getDetalleventas() {
        return this.detalleventas;
    }
    
    public void setDetalleventas(Set detalleventas) {
        this.detalleventas = detalleventas;
    }
    public Set getDetallecompras() {
        return this.detallecompras;
    }
    
    public void setDetallecompras(Set detallecompras) {
        this.detallecompras = detallecompras;
    }

}