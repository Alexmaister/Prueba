package Test;
import java.util.*;
/**
 * Created by aortiz on 15/05/2017.
 */
public class ParaLog {
    public static void main (String... a){
        String[] b,d,e;
        GregorianCalendar c = new GregorianCalendar();
        b=(c.getTime().toString().split(" "));
        for(String aux:b)
            System.out.println(aux);
        System.out.println(c.getTime());
    }
}
