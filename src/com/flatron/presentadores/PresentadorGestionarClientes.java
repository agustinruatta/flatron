/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flatron.presentadores;
import com.flatron.vistas.VistaGestionarClientes;
import com.flatron.servicios.ServicioCiente;

public class PresentadorGestionarClientes {
    
    private VistaGestionarClientes vistaGestionarClientes;
    
    private ServicioCiente servicioCiente ;

    public PresentadorGestionarClientes(VistaGestionarClientes vistaGestionarClientes) {
        
        this.vistaGestionarClientes = vistaGestionarClientes;
        
        this.servicioCiente = new ServicioCiente();
    
    }

    
    private void registrarCLiente(){
        
       String nombre = this.vistaGestionarClientes.getNombre();
        
       String apellido = this.vistaGestionarClientes.getApellido();
        
       String cuit = this.vistaGestionarClientes.getCuit();
        
       String email = this.vistaGestionarClientes.getEmail();
        
       String telefono = this.vistaGestionarClientes.getTelefono();
        
       String direccion = this.vistaGestionarClientes.getDireccion();
        
       String provincia = this.vistaGestionarClientes.getProvincia();
       
        try {
            
         this.servicioCiente.registrarCLiente(nombre, apellido, cuit, email, direccion, provincia);   
         
        } catch (Exception e) {
            
        } 
    
    }
    
    
    
    
}
