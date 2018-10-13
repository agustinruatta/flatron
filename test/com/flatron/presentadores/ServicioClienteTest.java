/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flatron.presentadores;

import com.flatron.excepciones.DatoErroneoException;
import org.junit.Before;
import org.junit.Test;
import com.flatron.servicios.ServicioCiente;

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

    @Test(expected = DatoErroneoException.class)
    public void verificarNombreIngresadoIncorrecto() throws DatoErroneoException {
        servicioCiente.registrarCLiente("pepe85", "perez", "20-41769726-9", "algo@gamil.com", "liniers 874", "cordoba");
    }

    @Test(expected = DatoErroneoException.class)
    public void verificarApellidoIngresadoIncorrecto() throws DatoErroneoException {
        servicioCiente.registrarCLiente("pepe", "perez74", "20-41769726-9", "algo@gamil.com", "liniers 874", "cordoba");
    }

    @Test(expected = DatoErroneoException.class)
    public void verificarCuitIngresadoIncorrecto() throws DatoErroneoException {
        servicioCiente.registrarCLiente("pepe", "perez", "20-41769726", "algo@gamil.com", "liniers 874", "cordoba");
    }

    @Test(expected = DatoErroneoException.class)
    public void verificarCuitIngresadoIncorrectoV2() throws DatoErroneoException {
        servicioCiente.registrarCLiente("pepe", "perez", "-41769726-9", "algo@gamil.com", "liniers 874", "cordoba");
    }

    @Test(expected = DatoErroneoException.class)
    public void verificarCuitIngresadoIncorrectoV3() throws DatoErroneoException {
        servicioCiente.registrarCLiente("pepe", "perez", "20417697269", "algo@gamil.com", "liniers 874", "cordoba");
    }

    @Test(expected = DatoErroneoException.class)
    public void verificarCuitIngresadoIncorrectoV4() throws DatoErroneoException {
        servicioCiente.registrarCLiente("pepe", "perez", "20-4176726-9", "algo@gamil.com", "liniers 874", "cordoba");
    }
    
    @Test(expected = DatoErroneoException.class)
    public void verificarEmailIngresadoIncorrecto() throws DatoErroneoException {
        servicioCiente.registrarCLiente("pepe", "perez", "20-41769726-9", "algo@gamilcom", "liniers 874", "cordoba");
    } 
    
    @Test(expected = DatoErroneoException.class)
    public void verificarEmailIngresadoIncorrectoV1() throws DatoErroneoException {
        servicioCiente.registrarCLiente("pepe", "perez", "20-41769726-9", "algo@.com", "liniers 874", "cordoba");
    }
    
    @Test(expected = DatoErroneoException.class)
    public void verificarEmailIngresadoIncorrectoV2() throws DatoErroneoException {
        servicioCiente.registrarCLiente("pepe", "perez", "20-41769726-9", "algogamil.com", "liniers 874", "cordoba");
    }
    
    @Test(expected = DatoErroneoException.class)
    public void verificarEmailIngresadoIncorrectoV3() throws DatoErroneoException {
        servicioCiente.registrarCLiente("pepe", "perez", "20-41769726-9", "@gamilcom", "liniers 874", "cordoba");
    }
    
    @Test(expected = DatoErroneoException.class)
    public void verificarDireccionIngresadoIncorrecto() throws DatoErroneoException {
        servicioCiente.registrarCLiente("pepe", "perez", "20-41769726-9", "algo@gamil.com", " ", "cordoba");
    }

    @Test(expected = DatoErroneoException.class)
    public void verificarProvinciaIngresadoIncorrecto() throws DatoErroneoException {
        servicioCiente.registrarCLiente("pepe", "perez", "20-41769726-9", "algo@gamil.com", "liniers 874", "");
    }

}
