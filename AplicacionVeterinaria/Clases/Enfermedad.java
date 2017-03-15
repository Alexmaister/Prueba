package Clases;
import Excepciones.ExcepcionEnfermedad;
import com.sun.javafx.binding.StringFormatter;


/**
 * Created by aortiz on 31/01/2017.
 */
/*INTERFAZ:
String getTipo()
setTipo(String t)
String getNombre()
setNombre(String n)
String getEfecto()
setEfecto(String e)
String getSintomas()
setSintomas(String s)
String getremedio()
setRemedio(String r)
String getGravedad()
setGravedad(String g)
* */
import java.lang.*;
public class Enfermedad implements Cloneable,Comparable<Enfermedad>{
    private String tipo;
    private String nombre;
    private String efecto;
    private String sintomas;
    private String remedio;
    private String gravedad;
    //constructor por defecto
    public Enfermedad(){
        this.tipo="Desconocido";
        this.nombre="Enfermedad";
        this.efecto="Temporal";
        this.sintomas="Nauseas";
        this.remedio="Ibuprofeno";
        this.gravedad="Leve";
    }
    //constructor por parametros
    public Enfermedad(String tipo,String nombre,String efecto,String sintomas,String remedio,String gravedad)throws ExcepcionEnfermedad{
        if(gravedad.equals("Leve") ||gravedad.equals("Grave")|| gravedad.equals("Muy Grave")) {
            this.tipo = tipo;
            this.nombre = nombre;
            this.efecto = efecto;
            this.remedio = remedio;
            this.sintomas = sintomas;
            this.gravedad = gravedad;
        }else throw new ExcepcionEnfermedad("La gravedad debe ser: Leve, Grave o Muy Grave");
    }
    //constructor d copia
    public Enfermedad(Enfermedad e){
        this.tipo=e.getTipo();
        this.nombre=e.getNombre();
        this.efecto=e.getEfecto();
        this.sintomas=e.getSintomas();
        this.remedio=e.getRemedio();
        this.gravedad=e.getGravedad();
    }
    //metodos consultores
    public String getTipo(){
        return this.tipo;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getEfecto(){
        return this.efecto;
    }
    public String getSintomas(){
        return this.sintomas;
    }
    public String getRemedio(){
        return this.remedio;
    }
    public String getGravedad(){
        return this.gravedad;
    }
    //metodos modificadores
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setEfecto(String efecto){
        this.efecto=efecto;
    }
    public void setSintomas(String sintomas){
        this.sintomas=sintomas;
    }
    public void setRemedio(String remedio){
        this.remedio=remedio;
    }
    public void setGravedad(String gravedad)throws ExcepcionEnfermedad{
        if(gravedad.equals("Leve") ||gravedad.equals("Grave")|| gravedad.equals("Muy Grave"))this.gravedad=gravedad;
        else throw new ExcepcionEnfermedad("La gravedad debe ser: Leve, Grave o Muy Grave");
    }
    @Override
    public Enfermedad clone() {
        Enfermedad e = null;
        try {
                e= (Enfermedad) super.clone();
        } catch (CloneNotSupportedException ncse) {
            System.out.println("No se pudo clonar el objeto");
        }
        return e;
    }

    /*Criterio de comparacion: por Gravedad Muy Grave la mayor y leve la menor
    * */
    @Override
    public int compareTo(Enfermedad e){
        int comparacion=0;
       if(this.gravedad.equals(e.getGravedad())){
           comparacion=0;
       }else{

           switch (this.gravedad) {
               case "Leve":
                   comparacion=-1;
                   break;
               case "Muy Grave":
                   comparacion=1;
               case "Grave":
                   switch (e.getGravedad()) {
                       case "Leve":
                           comparacion = 1;
                           break;
                       case "Muy Grave":
                           comparacion=-1;
                           break;
                   }
                   break;
           }
       }
        return comparacion;
    }
    @Override
    public String toString(){
        return tipo+","+nombre+","+efecto+","+sintomas+","+remedio+","+gravedad;
    }
    /*Criterio de igualdad: por la gravedad de la enfermedad
    * */
    @Override
    public boolean equals(Object obj){
        boolean resultado=false;
        if(obj!=null && obj instanceof Enfermedad) {
            Enfermedad e = (Enfermedad) obj;
            resultado=(this.gravedad.equals(e.getGravedad()));
            }
        return resultado;
    }
    @Override
    public int hashCode(){
        int code=0;
        code=nombre.hashCode()+gravedad.hashCode()/tipo.hashCode()+super.hashCode()*15;
        return code;
    }
}
