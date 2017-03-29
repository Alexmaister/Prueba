package Gestion;
import Clases.*;
import Excepciones.*;
import java.io.*;
import java.lang.*;
import java.util.*;
/**
 * Created by aortiz on 28/03/2017.
 */
public class GestionMascotas {

    private List<Mascota> listaMascotas=new ArrayList<Mascota>();

    public List getListaMascotas(){
        return this.listaMascotas;
    }
    /*cabecera: public Mascota crearMascota()
    descripcion : funcion que devolvera un objeto Mascota con los atributos
    que se recojan de teclado
    salidas: un objeto tipo Mascota
    postcondciones: el objeto se devolvera con los datos que se hayan recogido de teclado
    * */
    public Mascota crearMascota(){

        BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
        Mascota m=new Mascota();
        char sexo;
        int dia,mes,año;
        try{
            System.out.println("Introduzca el nombre de la mascota :");
            m.setNombre(teclado.readLine());
            System.out.println("Introduzca la especie a la que pertenece :");
            m.setEspecie(teclado.readLine());
            System.out.println("Introduzca la raza :");
            m.setRaza(teclado.readLine());
            System.out.println("Introduzca la fecha de nacimiento :");
            try {
                System.out.println("Dia:");
                dia=Integer.parseInt(teclado.readLine());
                System.out.println("Mes:");
                mes=Integer.parseInt(teclado.readLine());
                System.out.println("Año:");
                año=Integer.parseInt(teclado.readLine());
                //modificamos la fecha de la mascota
                m.getFechaNacimiento().modificarFecha(dia,mes,año);
            }catch(ExcepcionFecha e){
                e.printStackTrace();
            }
            do {
                System.out.println("Indique el sexo del animal :(M/H)");
                sexo=Character.toUpperCase(teclado.readLine().charAt(0));
            }while((sexo!='M' && sexo!='H') &&(sexo!='m' && sexo!='h'));
            try {
                m.setSexo(sexo);
            } catch (ExcepcionMascota excepcionMascota) {
                excepcionMascota.printStackTrace();
            }
        }catch(IOException ioe){ioe.printStackTrace();}


        return m;
    }

    /*Cabecera: public void rellenarListaMascotas()
    descripcion: se añadiran tantas mascotas como se deseen al arrayList, los datos de las mascotas
    se recogeran por teclado, ¡¡Se creara una nueva lista!!
    * */

    public void rellenarListaMascotas(){

        BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
        listaMascotas=new ArrayList<Mascota>();
        char seguir=' ';
        do {
            listaMascotas.add(crearMascota());
            System.out.println("----------------------------");
            do {
                System.out.println("¿Desea introducir una nueva mascota?(S/N)");
                try {
                    seguir = Character.toUpperCase(teclado.readLine().charAt(0));
                }catch(IOException e){e.printStackTrace();}
            }while(seguir!='S'&& seguir!='N');
        }while(seguir=='S');

    }
}
