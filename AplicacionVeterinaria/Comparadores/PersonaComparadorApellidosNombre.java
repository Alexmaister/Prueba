package Comparadores;
import Clases.*;
import java.util.*;

/**
 * Created by aortiz on 22/03/2017.
 */
public class PersonaComparadorApellidosNombre implements Comparator<Persona> {

    @Override
    public int compare(Persona persona, Persona pComparacion){


    return persona.getApellidos().compareTo(pComparacion.getApellidos());
    }

}
