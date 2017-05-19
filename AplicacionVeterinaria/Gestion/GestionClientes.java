package Gestion;
import Clases.*;
import Excepciones.ExcepcionFecha;
import Excepciones.ExcepcionPersona;

import java.io.*;
import java.util.*;
import java.lang.*;
/**
 * Created by aortiz on 31/01/2017.
 */
public class GestionClientes {

    private List listaClientes=new ArrayList<Persona>();

    public List getListaClientes(){
        return this.listaClientes;
    }
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
       //variables internas para comprobar dni , recidir los datos adicionales si estos se desean incluir..
       String DNI=new String();
       char datos=' ';
       int dia,mes,año;
       try {
           System.out.println("Introduzca el Nombre del Cliente :");
           p.setNombre(teclado.readLine());
           System.out.println("Introduzca los apellidos :");
           p.setApellidos(teclado.readLine());
           System.out.println("Introduzca la fecha de nacimiento :");

               System.out.println("Dia:");
               dia=Integer.parseInt(teclado.readLine());
               System.out.println("Mes:");
               mes=Integer.parseInt(teclado.readLine());
               System.out.println("Año:");
               año=Integer.parseInt(teclado.readLine());
                p.setFechaNac(new Fecha(dia,mes,año));


           do {
               System.out.println("Introduzca el DNI");
               DNI=teclado.readLine();
               try{p.setDNI(DNI);}catch(ExcepcionPersona e){System.out.println("El dni no es correcto");}

           }while(!DNI.matches("[0-9]{8}[A-Z]"));

           do{
           System.out.println("¿Desea introducir datos adicionales?(S/N)");
           datos=Character.toUpperCase(teclado.readLine().charAt(0));
           }while(datos!='S' && datos!='N');
           if(datos=='S') {
             datosAdicionales(p);
           }
       }catch(IOException e){

           e.printStackTrace();
       }

       return p;
   }

   /*cabecera: public void datosAdicionales(Persona p)
   descripcion: procedimiento que establecera a una persona introducida por parametros los datos adicionales como telf, etc
   que seran recogidos de teclado
   entradas/salidas: un objeto tipo Persona
   precondiciones:ninguna
   postcondiciones:se modificara el estado del objeto persona en los campos de tlf cp nacionalidad...
   * */
   public void datosAdicionales(Persona p){
       ArrayList<String> list = new ArrayList<String>();
       BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
        String codPostal=" ";
       try{
           System.out.println("Introduzca el telefono");
           p.setTelefono(teclado.readLine());
           System.out.println("Introduzca el telefono movil");
           p.setTelefonoM(teclado.readLine());
           System.out.println("Introduzca la direccion");
           p.setDireccion(teclado.readLine());
           do {
               try {
                   System.out.println("Introduzca el codigo postal");
                   codPostal=(teclado.readLine());
                   p.setCodPostal(codPostal);
               } catch (ExcepcionPersona ep) {
                   System.out.println("El formato no es el adecuado");
               }
           }while(!codPostal.matches("[0-9]{5}"));
           System.out.println("Introduzca la nacionalidad");
           p.setNacionalidad(teclado.readLine());
       }catch(IOException e){
           e.printStackTrace();
       }

   }

    /*
    cabecera: public void añadirCliente()
    descripcion: procedimiento que añadira personas con datos recogidos de teclado a la lista de clientes
    en el arrayList de la clase " ListaClientes ".
    */
   public void añadirClientes(){
        BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
        char nuevoCliente=' ';
       do {
           listaClientes.add(crearPersona());
           do {
               System.out.println("¿Desea introducir otro cliente?(S/N)");
               try {
                   nuevoCliente = Character.toUpperCase(teclado.readLine().charAt(0));
               } catch (IOException e) {
                  System.out.println(e);
               }
           }while(nuevoCliente!='S' && nuevoCliente!='N');
       }while (nuevoCliente=='S');

   }


    /*cabecera: public void borrarCliente(int pos)
    */
    public void borrar(int pos){

        listaClientes.remove(pos);
    }
    public void borrarXDNI(String DNI){

        borrar(buscarClienteXDNI(DNI));
    }


    /*cabecera: public int buscarClienteXDNI(String DNI)
    descripcion: funcion que devolvera la posicion que ocupa la primera persona en la lista con el dni dado
    entradas:String
    precondiciones:que el string cumpla el formato establecido de DNI
    salidas:un entero
    postcondiciones:el entero representara la posicion menos uno en la lista de clientes
    */
    public int buscarClienteXDNI(String dni){
        int pos=0;

        for(Persona c:(ArrayList<Persona>)this.listaClientes)
            if (c.getDNI().equals(dni))
                pos = listaClientes.indexOf(c);


        return pos;
    }



}
