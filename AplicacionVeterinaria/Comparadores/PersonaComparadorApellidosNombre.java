package Comparadores;
import Clases.Persona;
import java.util.Comparator;

/**
 * Created by aortiz on 22/03/2017.
 */
public class PersonaComparadorApellidosNombre implements Comparator<Persona> {

    @Override
    public int compare(Persona persona, Persona pComparacion){

        String p1=persona.getApellidos()+persona.getNombre();
        String p2=pComparacion.getApellidos()+pComparacion.getNombre();

    return p1.compareTo(p2);
    }

}
