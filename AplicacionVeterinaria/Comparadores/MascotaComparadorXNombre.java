package Comparadores;
import java.util.*;
import Clases.Mascota;
/**
 * Created by aortiz on 27/03/2017.
 */
public class MascotaComparadorXNombre implements Comparator<Mascota> {
    public  int compare(Mascota m1, Mascota m2){
        return m1.getNombre().compareTo(m2.getNombre());
    }
}
