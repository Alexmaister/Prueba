package Clases;
import Clases.Enfermedad;
import java.util.*;

/**
 * Created by aortiz on 22/03/2017.
 */
public class Vacuna {

    private String nombre;
    private Double dosis;
    private List<Enfermedad> enfermedades;
    private double concentracion;
    private String agenteAc;

    Vacuna(){
        nombre="Rabia";
        dosis=0.50;
        enfermedades=new ArrayList<Enfermedad>();
        enfermedades.add(new Enfermedad());
        concentracion=0.5;
        agenteAc="Rubiminuoxitona";

    }
}
