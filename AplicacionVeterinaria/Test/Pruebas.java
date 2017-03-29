package Test;
import Clases.*;
import Gestion.GestionClientes;
import Gestion.GestionMapaClienteMascota;

import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * Created by aortiz on 21/03/2017.
 */
public class Pruebas {

    public static void main(String... a){
        List<Persona> listaP=new ArrayList<Persona>();
        List<Mascota> listaM=new ArrayList<Mascota>();
        listaM.add(new Mascota());
        listaM.add(new Mascota());
        listaM.add(new Mascota());
        System.out.println(listaM.toString());
        Map mapa=new LinkedHashMap<Persona ,Mascota>();
        Persona p1=new Persona();
        Mascota m1=new Mascota();
        m1.setEspecie("marina");
        mapa.put(p1,m1);
        m1.setEspecie("terrestre");
        GestionMapaClienteMascota mapa1=new GestionMapaClienteMascota();
        mapa1.crearMapa();
        System.out.println("Mapa como Map");
        System.out.println(mapa.toString());
        List<Map.Entry<Persona,Mascota>> mapaList=new LinkedList<Map.Entry<Persona, Mascota>>(mapa.entrySet());
        System.out.println("Mapa como List");
        System.out.println(mapaList.toString());
        GestionClientes gestion=new GestionClientes();
        System.out.println("\n\n Esteeeeeee");
        System.out.println(gestion.buscarClienteXDNI("12345678A"));
    }
}
