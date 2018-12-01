package com.flatron.modelos;
import java.util.Date;

public class Compra  implements java.io.Serializable {


     private int codigo;
     private int proveedor;
     private String numeroComprobante;
     private Date fecha;
     private int total;

    public Compra() {
    }

    public Compra(int proveedor, String numeroComprobante, Date fecha, Integer total) {
       this.proveedor = proveedor;
       this.numeroComprobante = numeroComprobante;
       this.fecha = fecha;
       this.total = total;
    }
   
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public int getProveedor() {
        return this.proveedor;
    }
    
    public void setProveedor(int proveedor) {
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
}