package ClasesAbstractas;
import java.util.*;
import Clases.*;
/**
 * Created by aortiz on 15/05/2017.
 */
public abstract class Master {

    abstract void guardarRelacion(Map<Persona,ArrayList<Mascota>> relacion);
    abstract Persona[] leerPersonas();
    abstract List<ArrayList<Mascota>> leerMascotas(Persona p);
    abstract Map<Persona,List<Mascota>> obtenerRelaciones();
    abstract int mostrarMaster();
}
