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

        GestionMapaClienteMascota mapa1=new GestionMapaClienteMascota();
        mapa1.crearMapa();
        mapa1.ordenarXNombreCliente();
        System.out.println(mapa1.getMapa().toString());
    }
}
