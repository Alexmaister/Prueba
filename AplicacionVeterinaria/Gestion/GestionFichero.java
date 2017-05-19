package Gestion;
import java.io.*;
import java.util.*;
import Clases.*;
import Excepciones.*;
import GestionFicheros.*;


/**
 * Created by Ale on 05/04/2017.
 */
public class GestionFichero {
    FicheroDiario diario=new FicheroDiario();
    FicheroMaster master=new FicheroMaster();
    FicheroLog log=new FicheroLog();
    /*cabecera: void cargarDiario()
    descripcion: procedimiento que cargara el archivo diario con las personas y  mascotas que haya en Master
    * */
    public void cargarDiario(){
        ArrayList<Persona> p=null;
        ArrayList<Mascota> m=null;
        p=master.obtenerPersonas();
        for(int i=0;i<p.size();i++)
            try {
                diario.guardarPersona(p.get(i),i);
            } catch (ExcepcionDiario excepcionDiario) {}
    }

    /*cabecera: void actualizarMaster()
    descripcion: procedimiento que actualizara el Master con las modificaciones del Diario, y las registrara en el log
    * */
    public void actualizarMaster(){
        ArrayList<Persona> pl=null;
        ArrayList<Map<Persona,ArrayList<Mascota>>> map=null;
        Map<Persona,ArrayList<Mascota>> aux=new TreeMap<Persona,ArrayList<Mascota>>();
        Map<Persona,ArrayList<Mascota>> aux2=null;
        Map<Persona,ArrayList<Mascota>> aux5=null;
        Persona aux1=null;
        ArrayList<Mascota> ms=new ArrayList<Mascota>();

        ArrayList<Registro<Persona,Character>> auxR=log.obtenerRegistrosLog();

        log.actualizarLogPersona(obtenerRegistros());

        aux.putAll((Map<Persona,ArrayList<Mascota>>) master.obtenerRelaciones());

        for(int i=0;i<aux.size();i++) {
            aux5.put((Persona)aux.keySet().,ms);
            map.add(aux5);
        }

        for(Registro<Persona,Character> reg:auxR)
        if(reg.obtenerAccion()=='A') {
            pl.add(reg.obtenerObjeto());
        }else{
            aux1=reg.obtenerObjeto();
            aux2=new TreeMap<Persona,ArrayList<Mascota>>();
            aux2.put(aux1,ms);
            map.remove(new LinkedHashMap<Persona,ArrayList<Mascota>>(aux2));
        }

        for(Persona p: pl) {
            aux2 = new TreeMap<Persona, ArrayList<Mascota>>();
            aux2.put(p, ms);
            map.add(aux2);
        }
        master.borrarMaster();
        master.guardarRelaciones(map);

    }


      /*cabecera: ArrayList<Registro<Persona,Character>> obtenerRegistros()
    descripcion: funcion que obtendra los registros para poder actualizar el log
    * */
    private ArrayList<Registro<Persona,Character>> obtenerRegistros(){
        Persona p=null;
        ArrayList<Persona> pld=new ArrayList<Persona>();
        ArrayList<Persona> plm=new ArrayList<Persona>();
        ArrayList<Registro<Persona,Character>> reg=new ArrayList<Registro<Persona,Character>>();
        ArrayList<Mascota> m=new ArrayList<Mascota>();

        pld=diario.obtenerPersonas();
        plm=master.obtenerPersonas();
        for(Persona aux:pld)
            if(!plm.contains(aux))
                reg.add(new Registro<Persona,Character>(aux,'A'));
        pld=diario.obtenerPersonasMarcadas();
        for(Persona aux:pld)
            if(plm.contains(aux))
                reg.add(new Registro<Persona,Character>(aux,'B'));

        return reg;

    }
}