package Test;
import Excepciones.ExcepcionEnfermedad;
/**
 * Created by aortiz on 31/01/2017.
 */
import Clases.Enfermedad;
import Excepciones.ExcepcionEnfermedad;

public class EnfermedadTest {
    public static void main(String[]args){

    try {
        Enfermedad e=new Enfermedad();
        Enfermedad e1 = new Enfermedad("Virus", "Gripe", "Temporal con medicacion", "Nauseas", "Ibuprofeno", "Grave");
        Enfermedad e4 = new Enfermedad("Virus", "Gripe", "Temporal con medicacion", "Nauseas", "Ibuprofeno", "Grave");
        Enfermedad e2=new Enfermedad(e1);
        Enfermedad e3=e2.clone();


        System.out.println(e.toString()+"\n"+e1.toString()+"\n"+e2+"\n"+e3.toString());
        System.out.println(e1.compareTo(e3));
        System.out.println(e1.equals(e3));
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
        System.out.println(e3.hashCode());
        System.out.println(e3.hashCode());
        System.out.println(e4.hashCode());
    }catch(ExcepcionEnfermedad e){e.printStackTrace();}
    }
}
