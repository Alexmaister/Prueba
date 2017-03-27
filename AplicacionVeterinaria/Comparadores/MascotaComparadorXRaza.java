package Comparadores;
import java.util.*;
import Clases.Mascota;
/**
 * Created by aortiz on 27/03/2017.
 */
public class MascotaComparadorXRaza implements Comparator<Mascota> {
    public int compare(Mascota m1, Mascota m2){
        return m1.getRaza().compareTo(m2.getRaza());
    }
}
