package Test;

import Clases.*;
import Excepciones.ExcepcionMascota;

import java.util.*;
/**
 * Created by aortiz on 30/01/2017.
 */
public class MascotaTest {
    public static void main(String[]args){
       // long ti=System.currentTimeMillis();
      /*  Mascota m=new Mascota();
        System.out.println(m.toString());
        Fecha fecha=new Fecha(3,2,1993);
        Mascota m1 = new Mascota("Pepito",'M',new Fecha(),"Mastin","Perro");
        Mascota m2=new Mascota(m1);
        System.out.println(m2.toString());
        m.setNombre("Alejandro");
        m.setFechaNacimiento(new Fecha(3,2,1993));
        m.setRaza("Humano");
        m.setEspecie("Mamifero");
        System.out.println(m.getNombre()+m.getEspecie()+m.getRaza()+m.getFechaNacimiento()+m.getSexo());

        System.out.println(m.equals(m1));
        System.out.println(m.hashCode());*/
        //long tf=System.currentTimeMillis();
        //System.out.println(ti+","+tf);
        Mascota mas=new Mascota();
        Mascota mas1=null;
        try {
            mas1 = new Mascota(mas.toString());
            System.out.println(mas1.toString());
        }catch(ExcepcionMascota em){}

    }
}
