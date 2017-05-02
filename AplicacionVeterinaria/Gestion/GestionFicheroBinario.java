package Gestion;

import Clases.Persona;
import Excepciones.ExcepcionPersona;
import ClasesAbstractas.*;

import java.io.*;

/**
 * Created by aortiz on 07/04/2017.
 */
public class GestionFicheroBinario extends{

    private File fichero=null;
    private FileInputStream flujoEntrada;
    private ObjectInputStream lector=null;
    private FileOutputStream flujoSalida=null;
    private ObjectOutputStream escritor=null;

    GestionFicheroBinario(){
        fichero=new File("ArchivoPorDefectoBin.dat");
    }
    public File getFile(){
        return this.fichero;
    }
    public void setFile(String nombreFichero){
        this.fichero=new File(nombreFichero);
    }

    public void escribirPersona(Persona p){
        try {
            flujoSalida = new FileOutputStream(fichero, true);
            try {
                escritor=new ObjectOutputStream(flujoSalida){
                @Override protected void writeStreamHeader(){}};

                escritor.writeObject(p);
                escritor.close();
               //flujoSalida.close();
            } catch (IOException e) {
               System.out.println(e);
            }


        }catch(FileNotFoundException e){System.out.println(e);}
    }
    public void leerPersonas() {
        Persona p = null;

        try {
            flujoEntrada = new FileInputStream(fichero.getName());

            lector = new ObjectInputStream(flujoEntrada){@Override protected void readStreamHeader(){}};

            try {
                while ((p = new Persona((Persona) lector.readObject())) != null) {
                    System.out.println(p.toString());

                }
            } catch (ClassNotFoundException e) {
            }

            lector.close();
            flujoEntrada.close();
        } catch (IOException e) {

        }
    }


}
