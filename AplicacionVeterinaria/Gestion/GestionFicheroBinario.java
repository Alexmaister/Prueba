package Gestion;

import Clases.Persona;

import java.io.*;

/**
 * Created by aortiz on 07/04/2017.
 */
public class GestionFicheroBinario {

    private File fichero;
    private FileInputStream flujoEntrada;
    private ObjectInputStream lector;
    private FileOutputStream flujoSalida;
    private ObjectOutputStream escritor;

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
                escritor=new ObjectOutputStream(flujoSalida);

                escritor.writeObject(p);
                escritor.writeChars("\n");
                escritor.close();

            } catch (IOException e) {
               System.out.println(e);
            }


        }catch(FileNotFoundException e){System.out.println(e);}
    }
    public void leerPersonas() {
        Persona p=null;
        try {
            flujoEntrada = new FileInputStream(fichero);
            try {
                lector = new ObjectInputStream(flujoEntrada);
                System.out.println(lector.readUnshared());
                for(int i=0;i<fichero.length();i++){

                    System.out.println(lector.readUnshared());
                }




            }catch(IOException e){} catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }catch(FileNotFoundException e){}
    }
    public static void main(String... a){
        GestionFicheroBinario gfb=new GestionFicheroBinario();
        gfb.escribirPersona(new Persona());
        gfb.escribirPersona(new Persona());
        gfb.escribirPersona(new Persona());
        gfb.leerPersonas();
    }

}
