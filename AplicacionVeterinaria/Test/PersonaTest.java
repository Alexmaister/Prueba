package Test;

/**
 * Created by aortiz on 31/01/2017.
 */
import Clases.Persona;
import java.util.*;
public class PersonaTest {
    public static void main(String[]args){
        Persona p=new Persona();
        Persona p1 = new Persona("Ale","Ortiz Zurita","45812032B",new Date(1,3,2015),"954770126","654782788","ibiza,2","41100","España");
        Persona p2=new Persona(p1);
        Persona p3=p1.clone();
        System.out.println(p3.toString());
        System.out.println(p2.toString());
        System.out.println(p1.equals(p));
        System.out.println(p1.compareTo(p1));
        System.out.println(p1.hashCode());
    }
}
