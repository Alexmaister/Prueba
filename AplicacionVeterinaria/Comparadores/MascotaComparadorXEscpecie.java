package Comparadores;

import Clases.Mascota;
import java.util.*;
/**
 * Created by aortiz on 27/03/2017.
 */
public class MascotaComparadorXEscpecie implements Comparator<Mascota>{
    public int compare(Mascota m1, Mascota m2){
        return m1.getEspecie().compareTo(m2.getEspecie());
    }
}
