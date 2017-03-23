package Test;
import Clases.*;
/**
 * Created by aortiz on 23/03/2017.
 */
public class VacunaTest {

    public static void main(String... a){

        Vacuna v=new Vacuna();
        v.añadirEnfermedad(new Enfermedad());
        v.añadirEnfermedad(new Enfermedad());
        v.añadirEnfermedad(new Enfermedad());
        v.añadirEnfermedad(new Enfermedad());
        System.out.println(v.getEnfermedad().toString());
        v.eliminarEnfermedad("Enfermedad");
        System.out.println(v.getEnfermedad().get(0).getNombre().toString());
        System.out.println(v.getEnfermedad().get(1).getNombre().toString());
        System.out.println(v.getEnfermedad().get(2).getNombre().toString());
        System.out.println(v.getEnfermedad().get(3).getNombre().toString());
        System.out.println(v.buscarEnfermedad("Enfermedad"));
        System.out.println(v.getEnfermedad().toString());
    }

}
