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
    GestionTiempo tiempo=new GestionTiempo();
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
    public void actualizar(){
        Persona aux1=null;
        ArrayList<Persona> pl=new ArrayList<Persona>();
        ArrayList<Map<Persona,ArrayList<Mascota>>> lmap=new ArrayList<Map<Persona,ArrayList<Mascota>>>();
        ArrayList<Mascota> ms=new ArrayList<Mascota>();
        Map<Persona,ArrayList<Mascota>> map=new HashMap<Persona,ArrayList<Mascota>>();

        //cargamos personas del master
        master.obtenerPersonas().forEach(p->pl.add(p));
        //tenemos que cargar el log
        cargarLog();

        //cargamos todos los registros del log , altas y bajas
        ArrayList<Registro<Persona,Character>> listaR=log.obtenerRegistrosLog();
        //quitamos todos los que sean bajas y las altas las insertamos en la lista de personas si no estan ya
        for(Registro<Persona,Character> aux:listaR)
            if(aux.obtenerAccion()=='B') {
                pl.forEach(p->{if(aux.obtenerObjeto().compareTo(p)==0)pl.remove(aux.obtenerObjeto());});
                listaR.remove(aux);
            }else {
                pl.forEach(p->{if(aux.obtenerObjeto().compareTo(p)!=0)pl.add(aux.obtenerObjeto());});
            }

        //borramos el master
        master.borrarMaster();

        //añadimos las personas a un mapa con mascotas y todas ellas en una lista para guardarlas en master
        /*for(Persona aux:pl) {
            map=new HashMap<Persona,ArrayList<Mascota>>();
            map.put(new Persona(aux), ms);
            lmap.add(map);
        }*/
        pl.forEach(p->map.put(p,ms));
        map.forEach((p,m)->{
            Map<Persona,ArrayList<Mascota>> map1=new HashMap<Persona,ArrayList<Mascota>>();
            map1.put(p,m);
            lmap.add(map1);
                });
        //insertamos todas las relaciones en el master
        master.guardarRelaciones(lmap);
        //volvemos a cargar el diario de nuevo
        cargarDiario();
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

    /*cabecera: void cargarLog()
    descripcion:procedimiento que cargara el log con las personas actuales del diario ***proximamente tmb mascotas****
    * */
    private void cargarLog(){
        ArrayList<Registro<Persona,Character>> lregA=new ArrayList<Registro<Persona,Character>>();
        ArrayList<Registro<Persona,Character>> lregB=new ArrayList<Registro<Persona,Character>>();

        //madreee
        diario.obtenerPersonas().forEach((p)->lregA.add(new Registro(p,'A')));
        log.actualizarLogPersona(lregA);

        diario.obtenerPersonasMarcadas().forEach((p)->lregB.add(new Registro(p,'B')));
        log.actualizarLogPersona(lregB);
    }
}