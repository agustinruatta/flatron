/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flatron.servicios;

import com.flatron.modelos.Compra;
import com.flatron.repositorios.RepositorioCompra;
import java.util.Date;
/**
 *
 * @author santiago
 */
public class ServicioCompra {
    
    RepositorioCompra repositorioCompra;
    
    public ServicioCompra() {
        this.repositorioCompra = new RepositorioCompra();
    }
    
    public void guardarCompra(int proveedor, String numeroComprobante,Date fecha, int total) {
        
        Compra compra = new Compra(proveedor, numeroComprobante, fecha, total);
        this.repositorioCompra.GuardarCompra(compra);

    }
}
