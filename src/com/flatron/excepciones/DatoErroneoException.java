/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flatron.excepciones;

/**
 *
 * @author nicolas
 */
public class DatoErroneoException extends Exception {
    private ExceptionsMensajes exceptionsMensajes;

    public DatoErroneoException(ExceptionsMensajes exceptionsMensajes) {
        
        super();
        
        this.exceptionsMensajes = exceptionsMensajes;
    }
    
   public ExceptionsMensajes getError(){
    return this.exceptionsMensajes;
   }
    
}
