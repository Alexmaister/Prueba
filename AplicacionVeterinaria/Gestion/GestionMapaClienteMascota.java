package Gestion;
import Clases.*;

import java.io.BufferedReader;
import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * Created by aortiz on 29/03/2017.
 */
public class GestionMapaClienteMascota
{

    private Map MapaClienteMascota=new LinkedHashMap<Persona,ArrayList<Mascota>>();
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
            MapaClienteMascota.put(p, t);
            do{
            try{
                System.out.println("¿Desea introducir un nuevo CLiente?");
                seguir=Character.toUpperCase(teclado.readLine().charAt(0));}catch(IOException e){e.printStackTrace();}
            }while(seguir!='S'&& seguir!='N');
        }while(seguir=='S');

        try{teclado.close();}catch(IOException e){e.printStackTrace();}
    }


}
