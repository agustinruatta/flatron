package com.flatron.modelos;

public class Detallecompra  implements java.io.Serializable {

    
     private Integer codigo;
     private Compra compra;
     private Producto producto;
     private Double cantidad;
     private Double importe;

    public Detallecompra() {
    }

    public Detallecompra(Compra compra, Producto producto, Double cantidad, Double importe) {
       this.compra = compra;
       this.producto = producto;
       this.cantidad = cantidad;
       this.importe = importe;
    }
   
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public Compra getCompra() {
        return this.compra;
    }
    
    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Double getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
    public Double getImporte() {
        return this.importe;
    }
    
    public void setImporte(Double importe) {
        this.importe = importe;
    }
    
}