/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flatron.presentadores;

import com.flatron.excepciones.DatoErroneoException;
import com.flatron.excepciones.ExceptionsMensajes;
import org.junit.Before;
import org.junit.Test;
import com.flatron.servicios.ServicioCiente;
import java.util.Enumeration;

/**
 *
 * @author nicolas
 */
public class ServicioClienteTest {

    private ServicioCiente servicioCiente;

    @Before
    public void setUp() {
        this.servicioCiente = new ServicioCiente();
    }

    @Test
    public void verificarDatosIngresadosCorrectos() throws DatoErroneoException {

        servicioCiente.registrarCLiente("pepe", "perez", "20-41769726-9", "algo@gamil.com", "liniers 874", "cordoba");

    }
    @Test(expected=DatoErroneoException.class)
    public void verificarNombresIngresadoIncorrecto() throws DatoErroneoException {
        servicioCiente.registrarCLiente("pepe85", "perez", "20-41769726-9", "algo@gamil.com", "liniers 874", "cordoba");
    }

        @Test(expected=DatoErroneoException.class)
    public void verificarApellidoIngresadoIncorrecto() throws DatoErroneoException {
        servicioCiente.registrarCLiente("pepe", "perez74", "20-41769726-9", "algo@gamil.com", "liniers 874", "cordoba");
    }
    
        @Test(expected=DatoErroneoException.class)
    public void verificarCuitIngresadoIncorrecto() throws DatoErroneoException {
        servicioCiente.registrarCLiente("pepe85", "perez", "20-417697269", "algo@gamil.com", "liniers 874", "cordoba");
    }
    
        @Test(expected=DatoErroneoException.class)
    public void verificarEmailIngresadoIncorrecto() throws DatoErroneoException {
        servicioCiente.registrarCLiente("pepe85", "perez", "20-41769726-9", "algo@gamilcom", "liniers 874", "cordoba");
    }
    
        @Test(expected=DatoErroneoException.class)
    public void verificarDireccionIngresadoIncorrecto() throws DatoErroneoException {
        servicioCiente.registrarCLiente("pepe85", "perez", "20-41769726-9", "algo@gamil.com", " ", "cordoba");
    }
    
        @Test(expected=DatoErroneoException.class)
    public void verificarProvinciaIngresadoIncorrecto() throws DatoErroneoException {
        servicioCiente.registrarCLiente("pepe85", "perez", "20-41769726-9", "algo@gamil.com", "liniers 874", "");
    }
}
