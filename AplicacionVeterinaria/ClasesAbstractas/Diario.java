package ClasesAbstractas;
import Clases.*;

import java.io.RandomAccessFile;
import java.util.*;
/**
 * Created by aortiz on 15/05/2017.
 */
abstract class Diario {

    public abstract void guardarPersona(Persona p,int pos);
    public abstract void guardarMascota(Mascota m,int pos);
    @Deprecated
    public abstract void modificarPersona(int pos);

    public abstract void modificarAtributosPersona(String atributo,int at,int pos);
    @Deprecated
    public abstract void modificarMascota(int pos);
    public abstract void modificarAtributosMascota(String atributo,int at,int pos);
    public abstract void marcarPersona(int pos);
    public abstract void marcarMascota(int pos);
    public abstract void mostarDiario();
    public abstract void mostrarDiarioMascota();
    public abstract Persona obtenerPersona(int pos);
    public abstract List<Mascota> obtenerMascota(int pos);
}
