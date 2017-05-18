package GestionFicheros;
import java.util.*;
import Clases.*;
import Gestion.*;
import ClasesAbstractas.Log;

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


    public FicheroLog(){
        gt=new GestionTiempo();
    String path=nombreFichero+gt.obtenerCadena()+".dat";
        File fichero=new File(path);
    }

    public File getFile(){
        return this.fichero;
    }

    public void setFile(String fecha){
        this.fichero=new File(nombreFichero+fecha+".dat");
    }

    /*cabecera: void eventoP(Registro<Persona,Character> registro)
    descripcion:procedimiento que registrara un evento de baja o alta de una persona en el fichero de log
    entradas:Registro<Persona,Character>
    precondiciones: ninguna
    salidas: ninguna
    postcondiciones: el archivo de log con la fecha del dia actual se vera modificado con un registro mas, de no existir el fichero se creara
    * */
    public void eventoP(Registro<Persona,Character> registro){
        try {
            String path=nombreFichero+gt.obtenerCadena()+".dat";
        fichero=new File(path);
            flujoSalida = new FileOutputStream(fichero,true);
            try {
                escritor=new ObjectOutputStream(flujoSalida){@Override protected void writeStreamHeader(){}};

                escritor.writeObject(registro);


            } catch (IOException e) {System.out.println(e);}finally{try {escritor.close();} catch (IOException e) {}}
        }catch(FileNotFoundException e){System.out.println(e);}finally{try {flujoSalida.close();} catch (IOException e) {}}
    }
    /*cabecera: void evento(MAscota m,boolean altaBaja)
       descripcion:procedimiento que registrara un evento de baja o alta de una mascota en el fichero de log
       entradas:objeto a escribir y boleano para indicar alta o baja
       precondiciones: ninguna
       salidas: ninguna
       postcondiciones: el archivo de log con la fecha del dia actual se vera modificado con un registro mas, de no existir el fichero se creara
       * */
    public void eventoM(Registro<Registro<String,Mascota>,Character> registro){
        try {
            String path=nombreFicheroM+gt.obtenerCadena()+".dat";
            fichero=new File(path);
            flujoSalida = new FileOutputStream(fichero,true);
            try {
                escritor=new ObjectOutputStream(flujoSalida){@Override protected void writeStreamHeader(){}};

                escritor.writeObject(registro);


            } catch (IOException e) {System.out.println(e);}finally{try {escritor.close();} catch (IOException e) {}}
        }catch(FileNotFoundException e){System.out.println(e);}finally{try {flujoSalida.close();} catch (IOException e) {}}
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
       } catch (IOException e) {}//try {flujoEntrada.close();} catch (IOException e) {}}
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
    public int mostrarLog(char f,Fecha fch){
        int error=0;
        f=Character.toUpperCase(f);
        if(f!='P' && f!='M')
            error=10;
        else{

            switch(f){
                case 'P':

                    error=mostrarLogPersonas(fch);
                    break;
                case 'M':

                    error=mostrarLogMascotas(fch);
                    break;
            }
        }
      return error;
    }
    /*cabecera: int mostrarLogPersonas()
    descripcion: funcion que mostrara en pantalla el fichero de los de personas de la fecha indicada por parametros
    entradas: una fecha
    precondiciones:ninguna
    salidas:un entero
    postcondiciones: el entero sera distinto de 0 de existir algun error
    * */
    public int mostrarLogPersonas(Fecha f){
        String[] fecha=f.toString().split("/");
        int error=0;
        Registro<Persona,Character> registro=null;
        Persona p = null;
        Character c=null;
        try {

            flujoEntrada = new FileInputStream(nombreFichero+fecha[0]+"-"+fecha[1]+"-"+fecha[2]+".dat");

            lector = new ObjectInputStream(flujoEntrada) {@Override protected void readStreamHeader() {}};

            try {
                    while ( (registro=new Registro<Persona,Character>((Registro<Persona,Character>)lector.readObject()))!=null ) {
                       registro.mostarRegistro();

                    }

                } catch (ClassNotFoundException e) {
                    error = 5;
                }finally{lector.close();}
            } catch (IOException e) {
                error = 1;
            }finally{try {flujoEntrada.close();} catch (IOException e) {}}

            return error;
    }

    /*cabecera: int mostrarLogMAscotas()
    descripcion: funcion que mostrara en pantalla el fichero de los de mascotas de la fecha indicada por parametros
    entradas: una fecha
     precondiciones:ninguna
    salidas:un entero
    postcondiciones: el entero sera distinto de 0 de existir algun error
 * */
    public int mostrarLogMascotas(Fecha f){
        String[] fecha=f.toString().split("/");
        int error=0;
        Registro<Registro<String,Mascota>,Character> registro=null;
        try {
            flujoEntrada = new FileInputStream(nombreFicheroM+fecha[0]+"-"+fecha[1]+"-"+fecha[2]+".dat");

            lector = new ObjectInputStream(flujoEntrada) {@Override protected void readStreamHeader() {}};

            try {
                while ( (registro=new Registro<Registro<String,Mascota>,Character>((Registro<Registro<String,Mascota>,Character>)lector.readObject()))!=null ) {
                    System.out.println(registro.obtenerObjeto().obtenerObjeto().toString()+"-->"+registro.obtenerObjeto().obtenerAccion().toString()+"--> "+registro.obtenerAccion());

                }

            } catch (ClassNotFoundException e) {
                error = 5;
            }finally{lector.close();}
        } catch (IOException e) {
            error = 1;
        }finally{try {flujoEntrada.close();} catch (IOException e) {}}


        return error;
    }

}
