package Excepciones;

/**
 * Created by aortiz on 24/01/2017.
 */
public class ExcepcionPersona extends Exception{
    public ExcepcionPersona(String mensaje){
        System.out.println(mensaje);
    }
}
