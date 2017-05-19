package ClasesAbstractas;
import Clases.*;
import Excepciones.ExcepcionDiario;

import java.io.RandomAccessFile;
import java.util.*;
/**
 * Created by aortiz on 15/05/2017.
 */
public abstract class Diario {

    public abstract void guardarPersona(Persona p,int pos)throws ExcepcionDiario;
    public abstract void guardarMascota(Mascota m,int pos)throws ExcepcionDiario;
    @Deprecated
    public abstract void modificarPersona(int pos);

    public abstract void modificarAtributosPersona(String atributo,int at,int pos)throws ExcepcionDiario;
   // @Deprecated
    //public abstract void modificarMascota(int pos);
    //public abstract void modificarAtributosMascota(String atributo,int at,int pos);
    public abstract void marcarPersona(int pos)throws ExcepcionDiario;
    public abstract void desmarcarPersona(int pos)throws ExcepcionDiario;
    public abstract void mostrarPersonasMarcadas();
    //public abstract void marcarMascota(int pos);
    public abstract void mostrarDiario();
    //public abstract void mostrarDiarioMascota();
    public abstract Persona obtenerPersona(int pos)throws ExcepcionDiario;
    public abstract ArrayList<Persona> obtenerPersonas();
    public abstract ArrayList<Persona> obtenerPersonasMarcadas();
  //  public abstract List<Mascota> obtenerMascota(int pos);
}
