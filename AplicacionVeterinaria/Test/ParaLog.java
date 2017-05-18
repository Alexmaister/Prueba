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

        FicheroLog log=new FicheroLog();
        log.evento(new Persona(),true);
        log.evento(new Persona(),true);
        log.evento(new Persona(),true);
        Fecha f=new Fecha(17,5,2017);
        int i=log.mostrarLog('p',f);
    }
}
