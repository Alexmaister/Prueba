package GestionFicheros;
import ClasesAbstractas.Master;
import java.io.*;
import Clases.*;
import Excepciones.ExcepcionMascota;
import Excepciones.ExcepcionPersona;
import Gestion.GestionMapaClienteMascota;

import java.util.*;

/**
 * Created by Ale on 17/05/2017.
 */
public class FicheroMaster extends Master{

    File master=new File("Master.txt");
    Scanner lector;
    FileWriter escritor ;
    GestionMapaClienteMascota gmapa=new GestionMapaClienteMascota();

    /*cabecera: void guardarRelacion(Map<Persona,ArrayList<Mascota>> relacion)
    descripcion: procedimiento que guardara en el master una relacion de persona con sus mascotas
    entradas: un mapa de personas como clave y una lista de mascotas como valor
    precondiciones:ninguna
    * */
    public void guardarRelacion(Map<Persona,ArrayList<Mascota>> relacion) {
    gmapa.setMapa(relacion);
       try {

               escritor = new FileWriter(master, true);
               escritor.write(gmapa.mapaACadena());

       }catch (IOException e){
           System.out.println(e);
       }finally{
           try {
               escritor.close();
           }catch(IOException e){}
       }
   }

   /*cabecera: Map<Persona,ArrayList<Mascota>> obtenerRelaciones()
   descripcion: funcion que devolvera todas las relaciones leidas en el fichero master
   salidas: un mapa con persona como valor y una lista de mascotas como clave
   postcondiciones: se devolvera un mapa asociado al nombre
   * */
    public Map<Persona,ArrayList<Mascota>> obtenerRelaciones(){
       String aux=null;
       String[] s={""};
       ArrayList<Mascota> m=new ArrayList<Mascota>();
       Map<Persona,ArrayList<Mascota>> relacion=new HashMap<Persona,ArrayList<Mascota>>();
        Map<Persona,ArrayList<Mascota>> relacionAux=new HashMap<Persona,ArrayList<Mascota>>();
       ArrayList<Map<Persona,ArrayList<Mascota>>> l=new ArrayList<Map<Persona,ArrayList<Mascota>>>();
       try {
           lector = new Scanner(master);
               while (lector.hasNext()) {
                   aux=lector.nextLine();
                   s=aux.split(";");
                   for(int i=0;i<s.length;i++) {
                       relacion.putAll(convertidorStringMap(s[i]));
                       //relacion=new LinkedHashMap<Persona,ArrayList<Mascota>>(convertidorStringMap(s[i]));
                       //personas.add(p=new Persona(relacion.keySet().toString()));
                   }
               }
       }catch(FileNotFoundException e) {
           System.out.println(e);
       }finally{
           lector.close();
       }

       for(Map.Entry<Persona,ArrayList<Mascota>> aux3:relacion.entrySet()) {
           relacionAux.put(aux3.getKey(),m);

           l.add(relacionAux);
       }
        return relacion;
    }

    /*cabecera: Map<Persona,ArrayList<Mascota>> convertidorStringMap(String mapa)
    descripcion: funcion que transformara un String pasado por parametros en un mapa de relaciones con personas como valor y una lista de mascotas como valor
    entrads: un string
    precondiciones:el string debe contener los datos adecuados y con el formato de la funcion mapaACadena()
                    de la clase de gestion GestionMapaClienteMascota para poder transformarlo
    salidas: un mapa de relaciones con personas como claves y una lista de mascotas como valores
    postcondiciones: se devolvera el mapa asociado al nombre
    * */
    private Map<Persona,ArrayList<Mascota>> convertidorStringMap(String mapa) {
        Map<Persona,ArrayList<Mascota>> map=new LinkedHashMap<Persona,ArrayList<Mascota>>();

        Persona p = null;
        Mascota m= null;
        ArrayList<Mascota> lista =new ArrayList<Mascota>();
        String[] s=null;
        String[] s2=null;
        s = mapa.split("-");
        try {
            p = new Persona(s[0]);
            if(s.length>1){
            s2 = s[1].split(",");
            for (int i=0;i<s2.length;i++) {
                m=new Mascota(s2[i]);
                lista.add(m);


                }}
            }catch (ExcepcionPersona ep) {
            }catch(ExcepcionMascota em){}

        map.put(p,lista);
    return map;
    }
    /*cabecera: Personas[] obtenerPersonas()
    descripcion: funcion que devolvera un array de personas leidas del fichero master
    salidas: un array de personas
    postcondiciones: se devolvera asociaso al nombre un array con todas las personas del archivo master
    * */
    public ArrayList<Persona> obtenerPersonas(){
        ArrayList<Persona> p=new ArrayList<Persona>();
        Map<Persona,ArrayList<Mascota>> map=obtenerRelaciones();
        for(Persona aux:map.keySet())
        p.add(aux);

        return p;
    }
    /*cabecera: ArrayList<Mascota> obtenerMascotas(Persona p)
    descripcion: funcion que devolvera un array de mascotas de una persona leidas del fichero master
    salidas: una lista de mascotas
    postcondiciones: se devolvera asociaso al nombre una lista con todas las mascotas de una persona del archivo master
    * */
    public ArrayList<Mascota> obtenerMascotas(Persona p){

        Map<Persona,ArrayList<Mascota>> map=obtenerRelaciones();
        return map.get(p);

    }


    /*cabecera: int mostrarMaster()
    descripcion: funcion que mostrara en pantalla todos los refistros del archivo master
    salidas: un entero
    postcondiciones: se devolvera un entero asociado al nombre, para indicar si hubo algun error, 0=No
    * */
    public int mostrarMaster(){
        try {
            Scanner lector = new Scanner(master);

            while(lector.hasNext()){

                System.out.println(lector.nextLine());

            }
        }catch(FileNotFoundException e){}

     return 0;
    }

    /*cabcera: int buscarPersona(Persona p)
    descripcion: funcion que devolvera la posicion de una persona
    entradas: Persona
    precondicones: ninguna
    salidas : un entero
    postcondiciones: se devolvera asociado al nombre un entero distinto de cero si hay errores si no 0
    * */
    public int buscarPersona(Persona p){
        int pos=-1;
        ArrayList<Persona> pl=obtenerPersonas();
        for(Persona aux:pl)
            if(aux.compareTo(p)==0)
                pos=pl.indexOf(aux);
        return pos;
    }

    /*cabecera:void borrarMaster()
    * */
    public void borrarMaster(){
        master.delete();
    }

    /*cabecera void guardarRelaciones(ArrayList<Map<Persona,ArrayList<Mascota>>>()
    * */
    public void guardarRelaciones(ArrayList<Map<Persona,ArrayList<Mascota>>> map){

        for(Map<Persona,ArrayList<Mascota>> aux:map)
            guardarRelacion(aux);
    }
    /*cabecera: void crear()
    descripcion: creara el archivo master
    * */
    public void crear(){
        this.master=new File("Master.txt");
    }
}
