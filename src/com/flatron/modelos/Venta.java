package com.flatron.modelos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Venta  implements java.io.Serializable {


     private Integer codigo;
     private Cliente cliente;
     private String numeroComprobante;
     private Date fecha;
     private Double total;
     private Double descuento;
     private Set detalleventas = new HashSet(0);

    public Venta() {
    }

    public Venta(Cliente cliente, String numeroComprobante, Date fecha, Double total, Double descuento, Set detalleventas) {
       this.cliente = cliente;
       this.numeroComprobante = numeroComprobante;
       this.fecha = fecha;
       this.total = total;
       this.descuento = descuento;
       this.detalleventas = detalleventas;
    }
   
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String getNumeroComprobante() {
        return this.numeroComprobante;
    }
    
    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Double getTotal() {
        return this.total;
    }
    
    public void setTotal(Double total) {
        this.total = total;
    }
    public Double getDescuento() {
        return this.descuento;
    }
    
    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }
    public Set getDetalleventas() {
        return this.detalleventas;
    }
    
    public void setDetalleventas(Set detalleventas) {
        this.detalleventas = detalleventas;
    }

}