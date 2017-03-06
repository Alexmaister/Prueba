package Clases;

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
public class Fecha {

    private static final String AM="AM", PM="PM";

    private int dia,mes,año;
    private int hora,minutos,segundos;

    private boolean formatoAM;


    public Fecha(){

        this.dia=1;
        this.mes=1;
        this.año=1990;
        this.hora=0;
        this.minutos=0;
        this.segundos=01;
        this.formatoAM=false;

    }

    public Fecha(int d, int m, int a){
        this.dia=d;
        this.mes=m;
        this.año=a;
        this.hora=0;
        this.minutos=0;
        this.segundos=01;
        this.formatoAM=false;
    }
    public Fecha(boolean f,int h, int m, int s){

        this.hora=h;
        this.minutos=m;
        this.segundos=s;
        this.formatoAM=f;

    }
    public Fecha(int d, int m, int a, int h, int min, int s){

    }

    //metodos consultores
    public int getDia(){
        return this.dia;
    }
    public int getMes(){
        return this.mes;
    }
    public int getAño(){
        return this.año;
    }
    /*cabecera: boolean getFormatoAM()
      descripción:procedimiento que devuelve el formato en el que se encuentra la hora
      entradas:ninguna;
      salidas: un buleano;
      precondiciones:ninguna;
      postcondiciones:se devuelve un buleano asociado al nombre,que sera true si la hora esta en el formato AM(12 horas)
                      o false si esta en el formato PM(24 horas)
     */
    public boolean getFormato(){
        return this.formatoAM;
    }
    public int getHora(){
        return this.hora;
    }
    public int getMinutos(){
        return this.minutos;
    }
    public int getSegundos(){
        return this.segundos;
    }

    //metodos modificadores
    public void setDia(int d){
        this.dia=d;
    }
    public void setMes(int m){
        this.mes=m;
    }
    public void setAño(int a){
        this.año=a;
    }
    /*cabecera: void cambiarFormato()
      decripción: funcion que modificará el formato;
      entradas: un buleano;
      salidas: ninguna;
      precondiciones: el booleano debe ser distinto de null;
      postcondiciones: cambiara el formato, en caso de que este en formatoAM
                       y la constante sea PM la hora  tambien cambiara;
     */


}
