package GestionFicheros;
import java.io.*;
import java.io.RandomAccessFile;
import Clases.*;
import Enums.TamañoRegistroMascota;
import Enums.TamañoRegistroPersona;
import Excepciones.ExcepcionDiario;

/**
 * Created by aortiz on 17/05/2017.
 */
public class FicheroDiario /*extends Diario*/{

    private File diario;
    private File diarioMascota;
    private TamañoRegistroPersona bytesP;
    private TamañoRegistroMascota bytesM;
    private RandomAccessFile flujo;
    private int numeroRegistro;
    public FicheroDiario(){

        diario=new File("Diario.txt");
        diarioMascota=new File("DiarioMascota.txt");
    }

    /*cabecera:int contarRegistrosPersonas()
    * decripcion: funcion que devolvera el numero de Personas registradas en el archivo diario
    * entradas:ninguna
    * salidas:un entero
    * postcondiciones:asociado al nombre se devolvera el numero de registros*/
    public int contarRegistrosPersonas(){
        int registros=0;
        try {
            flujo = new RandomAccessFile(diario, "r");
            registros=(int)Math.ceil((double)flujo.length()/(double)bytesP.total.getBytes());
        }catch(IOException e){}/*finally {
            try{flujo.close();}catch(IOException e){}
        }*/
        return registros;
    }
    /*cabecera:int contarRegistrosMascotas()
    * decripcion: funcion que devolvera el numero de Mascotas registradas en el archivo diarioMascotas
    * entradas:ninguna
    * salidas:un entero
    * postcondiciones:asociado al nombre se devolvera el numero de registros*/
    public int contarRegistrosMascotas(){
        int registros=0;
        try{
            flujo=new RandomAccessFile(diarioMascota,"r");
            registros=(int)Math.ceil((double)flujo.length()/(double)bytesM.total.getBytes());
        }catch(IOException e){}finally {
            try{flujo.close();}catch(IOException e){}
        }
        return registros;
    }
    /*cabecra: void guardarPersona(Persona p)
    * descripcion: procedimiento que escribira en la posicion deseada del fichero diario una  persona de quererse incluir
    * en la posicion final , establezca pos como una llamada a la funcion contarRegistrosPersona
    * entradas:una persona,
    * precondiciones:ninguna*/
    public void  guardarPersona (Persona p,int pos)throws ExcepcionDiario {
        if(pos<0){throw new ExcepcionDiario("Debe escribir en una posicion correcta del archivo");}else{
        int posicion=pos * bytesP.total.getBytes();
        try {
            flujo = new RandomAccessFile(diario, "rw");
            flujo.seek(posicion);
            validarAtributosPersona(p);
            flujo.writeBytes(p.getNombre());
            flujo.seek(posicion+bytesP.ape.getBytes());
            flujo.writeBytes(p.getApellidos());
            flujo.seek(posicion+bytesP.f.getBytes());
            flujo.writeBytes(p.getFechaNac().toString());
            flujo.seek(posicion+bytesP.DNI.getBytes());
            flujo.writeBytes(p.getDNI());
            flujo.seek(posicion+bytesP.Tl.getBytes());
            flujo.writeBytes(p.getTelefono());
            flujo.seek(posicion+bytesP.Mvl.getBytes());
            flujo.writeBytes(p.getTelefonoM());
            flujo.seek(posicion+bytesP.Direc.getBytes());
            flujo.writeBytes(p.getDireccion());
            flujo.seek(posicion+bytesP.codP.getBytes());
            flujo.writeBytes(p.getCodPostal());
            flujo.seek(posicion+bytesP.nac.getBytes());
            flujo.writeBytes(p.getNacionalidad());
            flujo.seek(posicion+bytesP.esc.getBytes());
            flujo.writeChars("\n");
        }catch(FileNotFoundException efnf){}catch (IOException e){}
        }
    }

    /*cabecera: void guardarMascota(Mascota m, int pos)
    descripcion: procedimiento que guardara una mascota en el archivo de diarioMascota en la posicion indicada por parametros
    entradas: objeto mascota, un entero
    precondiciones:ninguna
    postcondiciones:ninguna,  en caso de la posicion no ser valida se lanzara una ExcepcionDiario
    * */
    public void guardarmascota(Mascota m,int pos)throws ExcepcionDiario {
        if (pos < 0) {
            throw new ExcepcionDiario("Debe escribir en una posicion correcta del archivo");
        } else {
            int posicion = pos * bytesM.total.getBytes();
            try {
                flujo = new RandomAccessFile(diarioMascota, "rw");
                flujo.seek(posicion);
                flujo.writeBytes(m.getNombre());
                flujo.seek(posicion + bytesM.f.getBytes());
                flujo.writeBytes(m.getFechaNacimiento().toString());
                flujo.seek(posicion + bytesM.sex.getBytes());
                flujo.writeBytes(Character.toString(m.getSexo()));
                flujo.seek(posicion + bytesM.raz.getBytes());
                flujo.writeBytes(m.getRaza());
                flujo.seek(posicion + bytesM.esp.getBytes());
                flujo.writeBytes(m.getEspecie());
                flujo.seek(posicion + bytesM.esc.getBytes());
                flujo.writeChars("\n");
            } catch (FileNotFoundException efnf) {
            } catch (IOException e) {
            }
        }
    }

    /*cabecera:void modificarPersona(int pos)
    * */
    @Deprecated
    public void modificarPersona(int pos){

        System.out.println("No funca");

    }

    /*cabecera: public void modificarAtributosPersona(String atributo,int at,int pos)
    descripcion: procedimiento que modificara el atributo deseado de una persona
    entradas: String , dos enteros
    precondiciones:ninguna
    * */
    public void modificarAtributosPersona(String atributo,int at,int pos)throws ExcepcionDiario{
        if((at<1 || at>9)&&(pos<0)){throw new ExcepcionDiario("");}else{



        }
    }
    /*
    * */
    private int pasarNumeroAtributo(int pos){return bytesM.nom.getBytes();}


    /*cabecera: void validarAtributosPersona(Persona p)
    descripcion: procedimiento que modificara los atributos de una persona, acortandolos, si sobrepasan una longitud
    entradas/salidas: Persona a modificar
    precondiciones: ninguna
    postcondicones: se modificaran algunos atributos de la persona , acortandolos , en caso de ser necesario
    * */
    private void validarAtributosPersona(Persona p){
      /*  ( ( p.getNombre().length()>bytesP.nom.getBytes() ) && ( p.getApellidos().length()>bytesP.ape.getBytes() ) )
        ?(( p.setApellidos(p.getNombre().substring(19));)(p.setApellidos(p.getApellidos().substring(bytesP.f.getBytes()-bytesP.ape.getBytes()));))
        :(  (( p.getNombre().length()>bytesP.nom.getBytes() ))
        ?(p.setApellidos(p.getNombre().substring(19)))
        : (( p.getApellidos().length()>bytesP.ape.getBytes() ))
        ? p.setApellidos(p.getApellidos().substring(bytesP.f.getBytes()-bytesP.ape.getBytes()))
        :0);*/
        if(( p.getNombre().length()>bytesP.ape.getBytes() )&& ( p.getApellidos().length()>bytesP.ape.getBytes())  ) {
            p.setNombre(p.getNombre().substring(0,bytesP.ape.getBytes()-1));
            p.setApellidos(p.getApellidos().substring(0,bytesP.ape.getBytes()-1));
        }else if(p.getNombre().length()>bytesP.ape.getBytes()){
            p.setNombre(p.getNombre().substring(0, bytesP.ape.getBytes()-1));
        }else if  ( p.getApellidos().length()>bytesP.ape.getBytes()){
        p.setApellidos(p.getApellidos().substring(0,bytesP.ape.getBytes()-1));
        }
    }
}
