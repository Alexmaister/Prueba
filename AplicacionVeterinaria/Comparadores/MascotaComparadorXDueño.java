package Comparadores;
import Clases.Mascota;
import java.util.*;
/**
 * Created by aortiz on 27/03/2017.
 */
public class MascotaComparadorXDueño implements Comparator<Mascota>{
    public int compare(Mascota m1, Mascota m2){

        return m1.getDueño().compareTo(m2.getDueño());
    }
}
