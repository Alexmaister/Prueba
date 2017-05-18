package ClasesAbstractas;
import java.util.*;
import Clases.*;
/**
 * Created by aortiz on 15/05/2017.
 */
public abstract class Master {

    public abstract void guardarRelacion(Map<Persona,ArrayList<Mascota>> relacion);
    public abstract Persona[] obtenerPersonas();
    public abstract ArrayList<Mascota> obtenerMascotas(Persona p);
    public abstract Map<Persona,ArrayList<Mascota>> obtenerRelaciones();
    public abstract int mostrarMaster();
}
