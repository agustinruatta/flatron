package com.flatron.modelos;

public class Detalleventa  implements java.io.Serializable {

    
     private Integer codigo;
     private Producto producto;
     private Venta venta;
     private Double cantidad;
     private Double importe;

    public Detalleventa() {
    }

    public Detalleventa(Producto producto, Venta venta, Double cantidad, Double importe) {
       this.producto = producto;
       this.venta = venta;
       this.cantidad = cantidad;
       this.importe = importe;
    }
   
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Venta getVenta() {
        return this.venta;
    }
    
    public void setVenta(Venta venta) {
        this.venta = venta;
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