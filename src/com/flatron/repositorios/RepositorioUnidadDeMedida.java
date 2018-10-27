/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flatron.repositorios;
import com.flatron.modelos.UnidadDeMedida;

/**
 *
 * @author laboratorio
 */
public class RepositorioUnidadDeMedida {
    
    private static UnidadDeMedida unidadDeMedidaguardada;
    
    public void guardar (UnidadDeMedida unidadDeMedida){
        
        this.unidadDeMedidaguardada = unidadDeMedida;
    }
    
}
