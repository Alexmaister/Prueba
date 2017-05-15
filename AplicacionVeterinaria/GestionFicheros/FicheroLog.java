package GestionFicheros;
import java.util.*;
import Clases.Persona;
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

    FicheroLog(){
        GregorianCalendar fecha=new GregorianCalendar();
        fecha.
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


}
