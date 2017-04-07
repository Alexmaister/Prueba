package Clases;
import Excepciones.ExcepcionFecha;
import Excepciones.ExcepcionPersona;

import java.io.Serializable;
import java.lang.*;
import java.util.*;

/**
 * Created by Ale on 10/02/2017.
 */
/*INTERFAZ:
int getDia()
setDia(int d)
int getMes()
setMes(int m)
int getAño()
setAño(int a)
int getHora();
setHora(int h)
int getMinutos()
setMinutos(int min)
int getSegundos()
setSegundos(int s)
boolean getFormatoAM()

cambiarConstante(String c)
void cambiarFormato()
boolean comprobarFecha(int a, int m, int d)
boolean comprobarHora(int h, int m, int s)
int diferenciaFechas(Fecha f)
avanzarDias(int n)
retrasarDias(int n)
* */
public class Fecha implements Cloneable,Comparable<Fecha>,Serializable{

   // private static final long SerialVersionUID= 2L;

    private int dia,mes,año;

    //constructor por defecto
    public Fecha(){

        this.dia=1;
        this.mes=1;
        this.año=1990;


    }
    //constructor por parametros
    public Fecha(int d, int m, int a) {

        this();
        if (!validarFecha(d, m, a)) {
            this.dia = d;
            this.mes = m;
            this.año = a;
        }
    }
    //constructor de copia
    public Fecha(Fecha f){

        this.dia=f.getDia();
        this.mes=f.getMes();
        this.año=f.getAño();
    }

    //constructor por Cadena
    public Fecha(String fecha)throws ExcepcionFecha{
        this();
        List atributos=Arrays.asList(fecha.split("/"));
        int d,m,a;
        if(atributos.size()!=3){
            throw new ExcepcionFecha("¡¡Error!!:El numero de atributos es diferente de 3");
        }else{
            d=Integer.parseInt((String) atributos.get(0));
            m=Integer.parseInt((String) atributos.get(1));
            a=Integer.parseInt((String) atributos.get(2));
            if(validarFecha(d,m,a)){
                this.dia=d;
                this.mes=m;
                this.año=a;
            }else throw new ExcepcionFecha("La fecha no es valida");
        }

    }

    //metodos modificadores
    public void modificarFecha(int d,int m,int a)throws ExcepcionFecha {
        if (validarFecha(d, m, a)){
            this.dia = d;
            this.mes = m;
            this.año = a;
        }else
            throw new ExcepcionFecha("Los parametros no coinciden con una fecha valida");
    }

    //metodos modificadores
    public int getDia(){
        return this.dia;
    }
    public int getMes(){
        return this.mes;
    }
    public int getAño(){
        return this.año;
    }


    public int compareTo(Fecha f){
        int resultado=0;

            if(f.getAño()==this.año)
                if(f.getMes()==this.mes)
                    if(f.getDia()>this.dia)
                        resultado=-1;
                    else
                        resultado=(f.getDia()<this.dia)?1:0;
                else
                    resultado=(f.getMes()>this.mes)?-1:1;
            else
                resultado=(f.getAño()>this.año)?-1:1;

        return resultado;
    }

    @Override
    public Fecha clone(){
        Fecha fechaClon=null;
        try{
            fechaClon= (Fecha) super.clone();
        }catch (CloneNotSupportedException err){
            err.printStackTrace();
        }


        return fechaClon;
    }

    /*cabecera: public boolean validarFecha(int d, int m, int a)
    descripcion: funcion que validara una fecha
    entradas: tres enteros
    salidas: un booleano
    precondiciones:ninguna
    postcondiciones:se devolvera true en caso de que la fecha sea valida y false en el contrario
    * */
    public boolean validarFecha(int d,int m,int a){
        boolean validacion =false;
        if (m >= 1 && m <= 12)
            switch (m) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (d >= 1 && d <= 30)
                        validacion = true;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (d >= 1 && d <= 30)
                        validacion = true;
                    break;
                case 2:
                    if ((a % 400 == 0) || ((a % 4 == 0) && (a % 100 != 0)))
                        if (d >= 1 && d <= 29)
                            validacion = true;
                        else if (d >= 1 && d <= 28)
                            validacion = true;
                    break;
            }
            return validacion;
    }

    @Override
    public boolean equals(Object obj){
        boolean igualdad=false;
        if(obj !=null && obj instanceof Fecha)
            igualdad= (this.compareTo((Fecha)obj)==0)?true:false;

        return igualdad;
    }

    @Override
    public String toString(){

        return this.getDia()+"/"+getMes()+"/"+this.getAño();
    }

    @Override
    public int hashCode(){
        return (this.getDia()*this.getMes()/21)*(this.getAño()/this.toString().hashCode());
    }
        /*cabecera: public boolean validarFecha(int d, int m, int a)
    descripcion: funcion que validara una fecha
    entradas: tres enteros
    salidas: un booleano
    precondiciones:ninguna
    postcondiciones:se devolvera true en caso de que la fecha sea valida y false en el contrario
    * */

    public boolean validarFecha(Fecha f){
        boolean validacion =false;
        if (f.getMes() >= 1 &&f.getMes() <= 12)
            switch (f.getMes()) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (f.getDia() >= 1 && f.getDia() <= 30)
                        validacion = true;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (f.getDia() >= 1 && f.getDia() <= 30)
                        validacion = true;
                    break;
                case 2:
                    if ((f.getAño() % 400 == 0) || ((f.getAño() % 4 == 0) && (f.getAño() % 100 != 0)))
                        if (f.getDia() >= 1 && f.getDia() <= 29)
                            validacion = true;
                        else if (f.getDia() >= 1 && f.getDia() <= 28)
                            validacion = true;
                    break;
            }
        return validacion;
    }




}
