package GestionFicheros;
import java.util.*;
import Clases.*;
import Gestion.*;
import ClasesAbstractas.Log;
import jdk.nashorn.internal.ir.annotations.Immutable;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by aortiz on 07/04/2017.
 */
public class FicheroLog extends Log{

    private File fichero=null;
    private FileInputStream flujoEntrada;
    private ObjectInputStream lector=null;
    private FileOutputStream flujoSalida=null;
    private ObjectOutputStream escritor=null;
    private String nombreFichero="FicheroLogPersonas";
    private String nombreFicheroM="FicheroLogMascotas";
    private GestionTiempo gt;
    FicheroLog(){
        gt=new GestionTiempo();

        File fichero=new File(
                nombreFichero+gt.obtenerCadena()+".dat");
    }

    public File getFile(){
        return this.fichero;
    }

    public void setFile(String fecha){
        this.fichero=new File(nombreFichero+fecha+".dat");
    }

    /*cabecera: void evento(Persona p,boolean altaBaja)
    descripcion:procedimiento que registrara un evento de baja o alta de una persona en el fichero de log
    entradas:objeto a escribir y boleano para indicar alta o baja
    precondiciones: ninguna
    salidas: ninguna
    postcondiciones: el archivo de log con la fecha del dia actual se vera modificado con un registro mas, de no existir el fichero se creara
    * */
    public void evento(Persona p, boolean altaBaja){ //se escribira true en caso de estar dandose de alta y false si es una baja
        setFile(nombreFichero+gt.obtenerCadena()+".dat");
        try {
            flujoSalida = new FileOutputStream(fichero, true);
            try {
                escritor=new ObjectOutputStream(flujoSalida){
                @Override protected void writeStreamHeader(){}};

                escritor.writeObject(p);
                escritor.writeBoolean(altaBaja);

               //flujoSalida.close();
            } catch (IOException e) {
               System.out.println(e);
            }finally{
                try{
                    escritor.close();
                } catch(IOException e){

                }
            }
        }catch(FileNotFoundException e){System.out.println(e);
        }finally{
            try {
                flujoEntrada.close();
            } catch (IOException e) {

            }
        }
    }

    public void evento(Mascota m,boolean altaBaja){
        setFile(nombreFicheroM+gt.obtenerCadena()+".dat");

        try{
            flujoSalida=new FileOutputStream(fichero,true);
            try{
                escritor=new ObjectOutputStream(flujoSalida){@Override protected void writeStreamHeader(){}};
                escritor.writeObject(m);
                escritor.writeBoolean(altaBaja);

            }catch(IOException e){
                System.out.println(e);
            }finally{
            try{
                escritor.close();
            } catch(IOException e){

            }
        }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }finally{
            try {
                flujoEntrada.close();
            } catch (IOException e) {
            }
        }
    }
    @Deprecated
    public Persona[] leerPersonas() {
        Persona p = null;
        List<Persona> lista=new ArrayList<Persona>();
        try {
            flujoEntrada = new FileInputStream(fichero.getName());

            lector = new ObjectInputStream(flujoEntrada){@Override protected void readStreamHeader(){}};

            try {
                while ((p = new Persona((Persona) lector.readObject())) != null) {
                    lista.add(p);
                    System.out.println(p.toString());

                }
            } catch (ClassNotFoundException e) {
            }

            lector.close();
            flujoEntrada.close();
        } catch (IOException e) {

        }
        return (Persona[]) lista.toArray();
    }

    /*cabecera: int mostrarLog(char f)
    descripcion: funcion que mostrara por pantalla todos los eventos registrados en el archivo de log segun el caracter enviado por parametros
    entradas: un caracter
    precondiciones:ninguna
    salidas:un entero
    postcondiciones:El entero resultante sera 0 si no hay ningun error , o > de 0 expresando el error, se mostrara en pantalla toda la informacion
    del archivo de log actual de mascotas o personas
    * */
    public int mostrarLog(char f){
        int error=0;
        f=Character.toUpperCase(f);
        if(f!='P' && f!='M')
            error=10;
        else{

            switch(f){
                case 'P':

                    error=mostrarLogPersonas();
                    break;
                case 'M':

                    error=mostrarLogMascotas();
                    break;
            }
        }
      return error;
    }

    public int mostrarLogPersonas(){
        int error=0;
        Persona p = null;
        try {
            flujoEntrada = new FileInputStream(fichero.getName());

            lector = new ObjectInputStream(flujoEntrada) {@Override protected void readStreamHeader() {}};

                try {
                    while ((p = new Persona((Persona) lector.readObject())) != null) {
                        System.out.println(p.toString() + "-->" + lector.readBoolean());

                    }
                } catch (ClassNotFoundException e) {
                    error = 5;
                }finally{
                    lector.close();
                }
            } catch (IOException e) {
                error = 1;
            }finally {
            try {
                flujoEntrada.close();
            } catch (IOException e) {
                error=9;
            }

        }
        return error;
    }
    public int mostrarLogMascotas(){
        int error=0;
        Mascota m = null;
        try {
            flujoEntrada = new FileInputStream(fichero.getName());

            lector = new ObjectInputStream(flujoEntrada) {@Override protected void readStreamHeader() {}};

            try {
                while ((m = new Mascota((Mascota) lector.readObject())) != null) {
                    System.out.println(m.toString() + "-->" + lector.readBoolean());

                }
            } catch (ClassNotFoundException e) {
                error = 5;
            }finally{
                lector.close();
            }
        } catch (IOException e) {
            error = 1;
        }finally {
            try {
                flujoEntrada.close();
            } catch (IOException e) {
                error=9;
            }

        }
        return error;
    }

}
