package Test;
import GestionFicheros.FicheroMaster;
import java.util.*;
import Clases.*;
/**
 * Created by Ale on 17/05/2017.
 */
public class PruebasMAster {
    public static void main(String... args){
        FicheroMaster master=new FicheroMaster();
        Map<Persona,ArrayList<Mascota>> rel=new TreeMap<Persona, ArrayList<Mascota>>();
        Persona p=new Persona();
        Mascota m=new Mascota();
        ArrayList l=new ArrayList<Mascota>();
        List<Persona> ps=null;
        l.add(m);
        rel.put(p,l);
        master.guardarRelacion(rel);
        ps=master.leerPersonas();
        System.out.println(ps);
    }
}
