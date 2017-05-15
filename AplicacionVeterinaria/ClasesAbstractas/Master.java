package ClasesAbstractas;
import java.util.*;
import Clases.*;
/**
 * Created by aortiz on 15/05/2017.
 */
public abstract class Master {

    abstract void guardarPersona(Persona p);
    abstract void guardarMascota(Mascota m);
    abstract void guardarRelacion(Map<Persona,ArrayList<Mascota>> relacion);
    abstract List<Persona> leerPersona();
    abstract List<Mascota> leerMascotas(Persona p);
    abstract Map<Persona,List<Mascota>> leerRelacion();
}
