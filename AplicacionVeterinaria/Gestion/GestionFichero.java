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

        log.actualizarLogPersona(obtenerRegistros());
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