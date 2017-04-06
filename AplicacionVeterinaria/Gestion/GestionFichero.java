package Gestion;
import java.io.*;
import Clases.*;



/**
 * Created by Ale on 05/04/2017.
 */
public class GestionFichero {

    private File fichero;

    public File getFichero(){
        return this.fichero;
    }
    public void setFichero(String path){
        this.fichero=new File(path);
    }
    public static void main(String... a){

        GestionFichero gf=new GestionFichero();
        gf.setFichero("FicheroPrueba.txt");
        try {
            PrintWriter pw=new PrintWriter(gf.getFichero());

            pw.println(new Persona());

            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}
