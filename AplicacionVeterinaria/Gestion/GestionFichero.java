package Gestion;
import java.io.*;
import java.util.*;
import Clases.*;
import Excepciones.ExcepcionPersona;


/**
 * Created by Ale on 05/04/2017.
 */
public class GestionFichero {

    private File fichero;

    public GestionFichero(){
        this.fichero=new File("ArchivoPorDefecto.txt");
    }

    public File getFichero(){
        return this.fichero;
    }
    public void setFichero(String path){
        this.fichero=new File(path);
    }

    /*cabecera:public void guardarPersona(Persona p)
    descripcion: procedimiento que guardara en el archivo local de la clase
    la persona introducida por parametros, si no se establecio nombre del fichero se utilizara el por defecto
    entradas:un objecto Persona
    * */
    public void guardarPersona(Persona p){

        try {
            FileWriter escritor=new FileWriter(this.fichero,true);

            escritor.write(p.toString()+"\n");
            escritor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String... a){
        GestionFichero gf=new GestionFichero();
        gf.guardarPersona(new Persona());
        gf.guardarPersona(new Persona());
        gf.guardarPersona(new Persona());
        System.out.println(gf.cargarPersonas().toString());
    }

    public List<Persona> cargarPersonas() {
        List<Persona> lista = new ArrayList<Persona>();
        try {
            Scanner lector = new Scanner(this.getFichero());

            while (lector.hasNext()) {
                try {
                    lista.add(new Persona((String) lector.nextLine()));
                } catch (ExcepcionPersona e) {
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }

}
