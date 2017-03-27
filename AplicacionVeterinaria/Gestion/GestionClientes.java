package Gestion;
import Clases.*;
import Excepciones.ExcepcionFecha;

import java.io.*;
import java.util.*;
/**
 * Created by aortiz on 31/01/2017.
 */
public class GestionClientes {

    List listaClientes=new ArrayList<Persona>();

   /*
   cabecera: public Persona crearPersona()
   descripcion:funcion que devolvera una persona con los atributos que se recojan por teclado
   salidas: un tipo persona
   postcondiciones:
   la persona tendra los atributos dados por teclado
   */
   public Persona crearPersona(){
       Persona p=new Persona();
       Fecha f=new Fecha();
       InputStreamReader flujo=new InputStreamReader(System.in);
       BufferedReader teclado=new BufferedReader(flujo);

       try {
           System.out.println("Introduzca el Nombre del Cliente :");
           p.setNombre(teclado.readLine());
           System.out.println("Introduzca los apellidos :");
           p.setApellidos(teclado.readLine());
           System.out.println("Introduzca la fecha de nacimiento :");
           try {
               System.out.println("Dia:");
               f.setDia(Integer.parseInt(teclado.readLine()));
               System.out.println("Mes:");
               f.setMes(Integer.parseInt(teclado.readLine()));
               System.out.println("Año:");
               f.setAño(Integer.parseInt(teclado.readLine()));
           }catch(ExcepcionFecha e){
               e.printStackTrace();
           }
       }catch(IOException e){

           e.printStackTrace();
       }
       return p;
   }

    /*
    cabecera: public void añadirCliente()
    descripcion: procedimiento que añadira una persona con datos recogidos de teclado
    en el arrayList de la clase " ListaClientes ".
    */
   public void añadirCliente(){

       listaClientes.add(crearPersona);

   }


    /*cabecera: public static void borrarCliente(Persona c, Persona[] ps)
    */
    /*cabecera. public static Persona buscarCliente(Persona p,Persona[] ps)
     */
    /*cabecera: public static void guardarCliente(Persona c , Persona[] ps)
    */

}
