package Gestion;
import Clases.*;
import Comparadores.PersonaComparadorApellidosNombre;

import java.io.BufferedReader;
import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * Created by aortiz on 29/03/2017.
 */
public class GestionMapaClienteMascota
{

    private Map mapaClienteMascota=new LinkedHashMap<Persona,ArrayList<Mascota>>();
    private GestionClientes clientes=new GestionClientes();
    private GestionMascotas mascotas=new GestionMascotas();
    Persona p;
    List<Mascota> t;


    public Map<Persona,ArrayList<Mascota>> getMapa(){
        return this.mapaClienteMascota;
    }
    /*
    * */
    public void crearMapa(){

        BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
        char seguir=' ';

        do {
            p = new Persona();
            p = clientes.crearPersona();

            System.out.println("Ahora introduciremos las mascotas del cliente -->");
            mascotas.rellenarListaMascotas();
            t = new ArrayList<Mascota>(mascotas.getListaMascotas());
            mapaClienteMascota.put(p, t);
            do{
            try{
                System.out.println("¿Desea introducir un nuevo CLiente?");
                seguir=Character.toUpperCase(teclado.readLine().charAt(0));}catch(IOException e){e.printStackTrace();}
            }while(seguir!='S'&& seguir!='N');
        }while(seguir=='S');

        try{teclado.close();}catch(IOException e){e.printStackTrace();}
    }

    //deprecated
    /*cabecera: public List<Entry<Persona,ArrayList<Mascota>>> pasarMapaALista()
    descripcion: pasará los datos contenidos en la variable local mapa a una Lista
    salidas:una lista
    postcondiciones:la lista contendra todos las claves y valores del mapa
    * */
    @Deprecated
    public List<Map.Entry<Persona,ArrayList<Mascota>>> pasarMapaALista(){

        List<Map.Entry<Persona,ArrayList<Mascota>>> lista= (List<Map.Entry<Persona,ArrayList<Mascota>>>) mapaClienteMascota.entrySet();


       return lista;
    }

    /*cabecera: public void ordenarMapaXDNICliente()
    descripcion:procedimiento que modificará el orden de la variable local de tipo map
    * */
    public void ordenarXNombreCliente(){

      Map<Persona,ArrayList<Mascota>> mapaSec= new TreeMap( new PersonaComparadorApellidosNombre());
        Set<Persona> persona=mapaSec.keySet();
        mapaSec.putAll(mapaClienteMascota);
        mapaClienteMascota=mapaSec;
    }

    /**cabecera: public void mostrarMapa()
     * descripcion: procedimiento que mostrara por pantalla el mapa de personas con sus respectivas mascotas
     */
    public void mostrarMapa(){
        Iterator entries = mapaClienteMascota.entrySet().iterator();
        int i=1;

        System.out.println("CLIENTE----------------------------MASCOTAS");
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
           Persona key = (Persona)entry.getKey();
            ArrayList<Mascota> value = (ArrayList<Mascota>)entry.getValue();
            System.out.println(+i+"--Nombre   :  "+key.getNombre());
            System.out.print("---Apellidos:  "+key.getApellidos());
            System.out.println("             "+value.size());
            System.out.println("---DNI      :  "+key.getDNI());

            System.out.println("-------------------------------------------");
            i++;
        }
    }

    /*cabecera public void mostrarMascotaPersona>(int pos)
    descripcion:procedimiento que mostrara una lista con todas las personas del mapa
    * */
    public void mostrarMascotasPersona(int pos){
        Iterator<Map.Entry<Persona,ArrayList<Mascota>>> iterador =mapaClienteMascota.entrySet().iterator();
        int i=1;
        Mascota mas;
        while(iterador.hasNext()){
            System.out.println("MASCOTA  : "+(i));
            mas=iterador.next().getValue().get(i-1);
            System.out.println((i)+"-Nombre   :  "+mas.getNombre());
            System.out.println("--Especie  :  "+mas.getEspecie());
            System.out.println("--Raza     :  "+mas.getRaza());
            System.out.println("--FechaNac :  "+mas.getFechaNacimiento().toString());
            System.out.println("--Sexo     :  "+mas.getSexo());
            System.out.println("-------------------------------------------");
            i++;
        }
    }

}
