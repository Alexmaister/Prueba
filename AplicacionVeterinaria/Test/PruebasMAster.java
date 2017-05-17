package Test;
import Gestion.GestionMapaClienteMascota;
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
        GestionMapaClienteMascota gs=new GestionMapaClienteMascota();
        l.add(m);
        rel.put(p,l);
        master.guardarRelacion(rel);
        //ps=master.leerPersonas();
        rel=master.obtenerRelaciones();
        gs.setMapa(rel);

        gs.mostrarMapa();
        master.mostrarMaster();
    }
}
