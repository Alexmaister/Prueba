package Gestion;

import Clases.Persona;
import Excepciones.ExcepcionPersona;

import java.io.*;

/**
 * Created by aortiz on 07/04/2017.
 */
public class GestionFicheroBinario {

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

        } catch (IOException e) {

        }
    }
    public static void main(String... a){
        GestionFicheroBinario gfb=new GestionFicheroBinario();
        gfb.escribirPersona(new Persona());
        gfb.leerPersonas();
        System.out.println(gfb.getFile().length());
        System.out.println(gfb.getFile().getFreeSpace());
        System.out.println(gfb.getFile().getName());
        System.out.println(gfb.getFile().getParent());
        gfb.setFile("NuevoPruebas.txt");
        gfb.getFile().renameTo(new File("Espagueti con tomate.txt"));
        System.out.println(gfb.getFile().getName());
        System.out.println(gfb.getFile().getParent());
    }

}
