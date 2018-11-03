<<<<<<< HEAD
/*
 * Copyright (C) 2018 Franco Morbidoni <fgmorbidoni@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.flatron.modelos;

/**
 *
 * @author Franco Morbidoni <fgmorbidoni@gmail.com>
 */
public class Producto {
    static int contador=0; //Variable temporal a remplazar una vez en funcionamiento la base de datos.
    int id;
    String nombreProducto;
    String marcaProducto;
    String unidadMedidaProducto; //TODO Cambiarlo por un objeto de la clase Unidad de Medida.
    float costoProducto;
    float gananciasProducto;
    float stockActualProducto;
    float stockMinimoProducto;
    String rubroProducto;

    public Producto(String nombreProducto, String marcaProducto, String unidadMedidaProducto, float costoProducto, float gananciasProducto, float stockActualProducto, float stockMinimoProducto, String rubroProducto) {
        contador++;
        this.id=contador;
        this.nombreProducto = nombreProducto;
        this.marcaProducto = marcaProducto;
        this.unidadMedidaProducto = unidadMedidaProducto;
        this.costoProducto = costoProducto;
        this.gananciasProducto = gananciasProducto;
        this.stockActualProducto = stockActualProducto;
        this.stockMinimoProducto = stockMinimoProducto;
        this.rubroProducto = rubroProducto;
    }

    public int getId() {
        return id;
    }   

    public void setId(int id) {
        this.id = id;
    }    

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public String getUnidadMedidaProducto() {
        return unidadMedidaProducto;
    }

    public float getCostoProducto() {
        return costoProducto;
    }

    public float getGananciasProducto() {
        return gananciasProducto;
    }

    public float getStockActualProducto() {
        return stockActualProducto;
    }

    public float getStockMinimoProducto() {
        return stockMinimoProducto;
    }

    public String getRubroProducto() {
        return rubroProducto;
    }
    
    public void validarStock(){
        
    }
    
    public void calcularPrecioVenta(){
        
    }
    
}
=======
package com.flatron.modelos;

import java.util.Collection;
import java.util.HashSet;

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
     private Collection<Detalleventa> detalleventas = new HashSet(0);
     private Collection<Detallecompra> detallecompras = new HashSet(0);

    public Producto() {
    }

    public Producto(Unidadmedida unidadmedida, String marca, String nombre, Double costo, Double ganancia, Double stock, Double stockMinimo, String rubro, Collection<Detalleventa> detalleventas, Collection<Detallecompra> detallecompras) {
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
    public Collection<Detalleventa> getDetalleventas() {
        return this.detalleventas;
    }
    
    public void setDetalleventas(Collection<Detalleventa> detalleventas) {
        this.detalleventas = detalleventas;
    }
    public Collection<Detallecompra> getDetallecompras() {
        return this.detallecompras;
    }
    
    public void setDetallecompras(Collection<Detallecompra> detallecompras) {
        this.detallecompras = detallecompras;
    }

}
>>>>>>> master
