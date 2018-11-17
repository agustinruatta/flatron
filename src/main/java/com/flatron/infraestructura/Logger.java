/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flatron.infraestructura;

/**
 *
 * @author laboratorio
 */
public class Logger {
    
    public static void error(String mensaje){
        System.err.println(mensaje);
    }
    
    public static void info(String mensaje){
        System.out.println(mensaje);
    }
}
