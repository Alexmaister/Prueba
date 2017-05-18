package ClasesAbstractas;
import Clases.*;

import java.io.RandomAccessFile;
import java.util.*;
/**
 * Created by aortiz on 15/05/2017.
 */
abstract class Diario {

    public abstract void guardarPersona(Persona p);
    public abstract void guardarMascota(Mascota m);
    public abstract void modificarPersona(int pos);
    public abstract void modificarAtributoPersona(int pos);
    public abstract void modificarMascota(int pos);
    public abstract void modificarAtributoMascota(int pos);
    public abstract void borrarPersona(int pos);
    public abstract void borrarMascota(int pos);
    public abstract void mostarDiario();
    public abstract void mostrarDiarioMascota();
    public abstract Persona obtenerPersona(int pos);
    public abstract List<Mascota> obtenerMascota(int pos);
}
