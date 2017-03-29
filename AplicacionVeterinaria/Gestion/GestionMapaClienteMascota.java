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

    /*cabecera: public List<Entry<Persona,ArrayList<Mascota>>> pasarMapaALista()
    descripcion: pasará los datos contenidos en la variable local mapa a una Lista
    salidas:una lista
    postcondiciones:la lista contendra todos las claves y valores del mapa
    * */
    public List<Map.Entry<Persona,ArrayList<Mascota>>> pasarMapaALista(){

        List lista=new ArrayList<Map.Entry<Persona,ArrayList<Mascota>>>(mapaClienteMascota.entrySet());


       return lista;
    }

    /*cabecera: public void ordenarMapaXDNICliente()
    descripcion:procedimiento que modificará el orden de la variable local de tipo map
    * */
    public void ordenarXNombreCliente(){

        List lista=pasarMapaALista();
        lista.sort(new PersonaComparadorApellidosNombre());
        for(Map.Entry<Persona,ArrayList<Mascota>> claveValor:(List<Map.Entry<Persona,ArrayList<Mascota>>>)lista)
            mapaClienteMascota.put(claveValor.getKey(),claveValor.getValue());

    }
}
