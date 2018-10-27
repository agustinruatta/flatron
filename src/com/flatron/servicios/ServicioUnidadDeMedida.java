/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flatron.servicios;

import com.flatron.modelos.UnidadDeMedida;
import com.flatron.repositorios.RepositorioUnidadDeMedida;

/**
 *
 * @author laboratorio
 */
public class ServicioUnidadDeMedida {
    
    private RepositorioUnidadDeMedida repositorioUnidadDeMedida;
    
    public ServicioUnidadDeMedida() {
        
        this.repositorioUnidadDeMedida = new RepositorioUnidadDeMedida();
    }
    
    public void guardarUnidadDeMedida(String nombre, String simbolo) {
        
        this.validarNombre(nombre);
        this.validarSimbolo(simbolo);
        
        UnidadDeMedida unidadDeMedida = new UnidadDeMedida(nombre, simbolo);
        
        this.repositorioUnidadDeMedida.guardar(unidadDeMedida);
        
    }
    
    public void validarNombre(String nombre) {
        
        if (nombre.length() == 0) {
            throw new IllegalArgumentException("¡No ingreso el nombre!");
        }
        
    }
    
    public void validarSimbolo(String simbolo) {
        if (simbolo.length() == 0) {
            throw new IllegalArgumentException("¡No ingreso el símbolo!");
        }
    }
}
