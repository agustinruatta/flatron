package com.flatron.modelos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Compra  implements java.io.Serializable {


     private Integer codigo;
     private Proveedor proveedor;
     private String numeroComprobante;
     private Date fecha;
     private Integer total;
     private Set detallecompras = new HashSet(0);

    public Compra() {
    }

    public Compra(Proveedor proveedor, String numeroComprobante, Date fecha, Integer total, Set detallecompras) {
       this.proveedor = proveedor;
       this.numeroComprobante = numeroComprobante;
       this.fecha = fecha;
       this.total = total;
       this.detallecompras = detallecompras;
    }
   
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public Proveedor getProveedor() {
        return this.proveedor;
    }
    
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
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
    public Integer getTotal() {
        return this.total;
    }
    
    public void setTotal(Integer total) {
        this.total = total;
    }
    public Set getDetallecompras() {
        return this.detallecompras;
    }
    
    public void setDetallecompras(Set detallecompras) {
        this.detallecompras = detallecompras;
    }

}