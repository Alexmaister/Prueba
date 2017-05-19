package Test;

import Excepciones.ExcepcionDiario;
import Excepciones.ExcepcionFecha;
import Gestion.GestionClientes;
import GestionFicheros.FicheroDiario;
import Clases.*;
/**
 * Created by Ale on 18/05/2017.
 */
public class PruebaDiario {
    public static void main(String...a){
        GestionClientes gc=new GestionClientes();
        FicheroDiario diario=new FicheroDiario();
        Persona p=null;
        Persona p1=null;
            p = new Persona("Alejandro", "Ortiz Zurita", "45812032B",new Fecha(3,2,1993),"954770126" ,"654782788","maravilla 2","41100","esp");
            p1 = new Persona("Manuel", "Valderas Gomez", "45812032B",new Fecha(3,2,1993),"" ,"","","41100","");
        try {
           /* for(int i=0;i<diario.contarRegistrosPersonas();i++)
            diario.modificarAtributosPersona(p.getApellidos(),1,i);*/
         //  for(int i=0;i<5;i++)
           diario.guardarPersona(p1,diario.contarRegistrosPersonas());
          // diario.marcarPersona(diario.contarRegistrosPersonas()-1);
           System.out.println(p.getNombre());
           p=diario.obtenerPersona(0);
           System.out.println(p.toString());
           diario.mostrarDiario();
        } catch (ExcepcionDiario excepcionDiario) {

        }


    }
}
