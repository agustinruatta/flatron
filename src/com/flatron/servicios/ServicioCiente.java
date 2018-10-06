
package com.flatron.servicios;

import com.flatron.excepciones.DatoErroneoException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.flatron.excepciones.ExceptionsMensajes;

/**
 *
 * @author nicolas
 */
public class ServicioCiente {

    private static final int CAMPO_NULO = 0;

    public ServicioCiente() {

    }

    public void registrarCLiente(String nombre, String apellido, String cuid, String email, String direccion, String provincia)throws DatoErroneoException{

        verificarDatos(nombre, apellido, cuid, email, direccion, provincia);

    }
    

    private void verificarDatos(String nombre, String apellido, String cuid, String email, String direccion, String provincia)throws DatoErroneoException{
        
        ExceptionsMensajes errores = new ExceptionsMensajes();
        
        if (esCampoVacio(nombre)) {
          errores.setError("nombre", "No a ingresado ningun nombre");
        } else if (!esSoloLetras(nombre)) {
            errores.setError("nombre", "Valor incorrecto");
        }

        if (esCampoVacio(apellido)) {
            errores.setError("apellido", "No a ingresado ningun apellido");
        } else if (!esSoloLetras(apellido)) {
            errores.setError("apellido", "Valor incorrecto");
        }

        if (esCampoVacio(cuid)) {
            errores.setError("cuid", "No a ingresado el cuid");
        } else if (esCuit(cuid)) {
            errores.setError("cuid", "Cuid ingresado incorrecto");
        }

        if (esCampoVacio(email)) {
            errores.setError("email", "No a ingresado ningun email");
        } else if (!esEmail(email)) {
            errores.setError("email", "email ingresado incorrecto");
        }

        if (esCampoVacio(direccion)) {
            errores.setError("direccion", "No a ingresado ninguna direccion");
        }

        if (esCampoVacio(provincia)) {
            errores.setError("provincia", "No a ingresado ninguna provincia");
        }
        
        if (errores.getError().size() != 0) {
            throw new DatoErroneoException(errores);
        }

    }

    private boolean esNumero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean esCampoVacio(String cadena) {
        if (cadena.length() == CAMPO_NULO) {
            return true;
        } else if (cadena.equals(" ")) {
            return true;
        }
        return false;
    }

    private boolean esSoloLetras(String cadena) {
        Pattern pat = Pattern.compile("[a-zA-Z]+");
        Matcher mat = pat.matcher(cadena);

        if (!mat.matches()) {
            return false;
        }
        return true;
    }

    private boolean esCuit(String cadena) {

        Pattern pat = Pattern.compile("/^\\d{2}\\-\\d{8}\\-\\d{1}$/");
        Matcher mat = pat.matcher(cadena);

        if (!mat.matches()) {
            return false;
        }
        return true;
    }
    
    private boolean esEmail(String cadena){
        
        String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
        
        Pattern pat = Pattern.compile(emailPattern);
        Matcher mat = pat.matcher(cadena);
        
        if (!mat.matches()) {
            return false;
        }
        return true;
    }
    
    
    

}
