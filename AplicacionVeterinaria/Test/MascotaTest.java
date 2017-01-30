package Test;

import Clases.Mascota;
import java.util.*;
/**
 * Created by aortiz on 30/01/2017.
 */
public class MascotaTest {
    public static void main(String[]args){
        long ti=System.currentTimeMillis();
        Mascota m=new Mascota();
        System.out.println(m.toString());
        Date fecha=new Date(3,2,1993);
        Mascota m1 = new Mascota("Pepito",'M',fecha,"Mastin","Perro");
        m=new Mascota(m1);
        System.out.println(m.toString());
        long tf=System.currentTimeMillis();
        System.out.println(ti+","+tf);



    }
}
