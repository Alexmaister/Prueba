package Gestion;
import java.util.*;
import Clases.Fecha;
import Excepciones.ExcepcionFecha;

/**
 * Created by Ale on 16/05/2017.
 */
/*Clase de gestion, para utilizar la fecha actual en el sistema
* */
public class GestionTiempo {

    GregorianCalendar tiempo;
    Fecha fecha;

    public GestionTiempo(){
        tiempo=new GregorianCalendar();
        fecha=obtenerFecha();

    }
    public Fecha obtenerFecha(){
        String[] f=this.tiempo.getTime().toString().split(" ");
        String cadena=f[2]+"/"+convertidorMes(f[1])+"/"+f[5];
        try {
            fecha = new Fecha(cadena);
        }catch(ExcepcionFecha ef){}
        return this.fecha;
    }

    /*
    @Deprecated
    public Fecha obtenerFecha(){
        Fecha fecha=new Fecha();

        try{
            fecha=new Fecha(f[2]+"/"+convertidorMes(f[1])+"/"+f[5]);
        }catch (ExcepcionFecha e){
            System.out.println(e);
        };
    return fecha;
    }*/
    public String convertidorMes(String m){
        String mes=" ";
        switch (m){
            case "Jan":
                mes="1";
                break;
            case "Feb":
                mes="2";
                break;
            case "Mar":
                mes="3";
                break;
            case "May":
                mes="5";
                break;
            case "Apr":
                mes="4";
                break;
            case "Jun":
                mes="6";
                break;
            case "Jul":
                mes="7";
                break;
            case "Aug":
                mes="8";
                break;
            case "Sep":
                mes="9";
                break;
            case "Oct":
                mes="10";
                break;
            case "Nov":
                mes="11";
                break;
            case "Dec":
                mes="12";
                break;
        }
        return mes;
    }

    public Fecha getFecha(){
        return this.fecha;
    }
    public void pintarFecha(){
        System.out.println(this.fecha.toString());
    }
    public String obtenerCadena(){
        obtenerFecha();
        String[] s=this.fecha.toString().split("/");
        return s[0]+"-"+s[1]+"-"+s[2];

    }

}
