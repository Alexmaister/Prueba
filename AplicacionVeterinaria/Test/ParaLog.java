package Test;
import java.util.*;

import Gestion.GestionTiempo;
import GestionFicheros.*;
import Clases.*;
/**
 * Created by aortiz on 15/05/2017.
 */
public class ParaLog {
    public static void main (String... a){
        GestionTiempo gt=new GestionTiempo();
      //  gt.pintarFecha();
      //  System.out.println(gt.obtenerFecha().toString());
        Registro<Registro<String,Mascota>,Character> registro= new Registro<Registro<String,Mascota>,Character>();
        FicheroLog log=new FicheroLog();
      //  log.eventoM(new Registro<Registro<String,Mascota>,Character>( new Registro<String,Mascota>(new Persona().getDNI(),new Mascota()),'A') );
       // log.eventoM(new Registro<Registro<String,Mascota>,Character>( new Registro<String,Mascota>(new Persona().getDNI(),new Mascota()),'A') );
        int i=log.mostrarLog('p',gt.obtenerFecha());
    }
}
