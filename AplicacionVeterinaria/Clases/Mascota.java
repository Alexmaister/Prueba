package Clases;


import java.io.*;
import java.util.*;
/**
 * Created by aortiz on 17/01/2017.
 */
/*INTERFAZ:
String getNombre()
setNombre(String nombre)
char getSexo()
setSexo(char sexo)
Date getFechaNac()
setFechaNac(Date fecha)
String getRaza()
setRaza(String raza)
Persona getDueño()
setDueño(Persona Dueño)
long getSerialVersionUID()
 */
public class Mascota implements Cloneable,Comparable<Mascota> {


    private String nombre;
    private char sexo;
    private Date fechaNacimiento;
    private String raza;
    private String especie;


    public Mascota(){

        nombre="Default";
        sexo='M';
        fechaNacimiento=new Date(1,1,1900);
        raza="Perro";
        especie="Mamifero";
    }

    public Mascota(String nombre, char sexo, Date fecha, String raza, String especie){
        this.nombre=nombre;
        this.sexo=sexo;
        this.fechaNacimiento=fecha;
        this.raza=raza;
        this.especie=especie;
    }

    public Mascota(Mascota mascota){

        this.nombre=mascota.nombre;
        this.sexo=mascota.sexo;
        this.fechaNacimiento=mascota.fechaNacimiento;
        this.raza=mascota.raza;
        this.especie=mascota.especie;
    }

    public String getNombre(){
        return this.nombre;
    }
    public char getSexo(){
        return this.sexo;
    }
    public Date getFechaNacimiento(){
        return this.fechaNacimiento;
    }
    public String getRaza(){
        return this.raza;
    }
    public String getESpecie(){
        return this.especie;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setFechaNacimiento(Date f){
        this.fechaNacimiento=f;
    }
    public void setRaza(String raza){
        this.raza=raza;
    }
    public void setEspecie(String especie){
        this.especie=especie;
    }

    @Override
    public Mascota clone(){
        Mascota copy=null;
        try{
            copy=(Mascota)super.clone();
        }catch(CloneNotSupportedException ce){
            System.out.println("El objeto no se ha podido clonar");
        }
        return copy;
    }
    @Override
    public int compareTo(Mascota m){
        int comparacion;
        comparacion=this.fechaNacimiento.compareTo(m.fechaNacimiento);
        return comparacion;
    }
    @Override
    public boolean equals(Object obj){
        boolean resultado=false;
        if(obj!=null && obj instanceof Mascota)
            if(fechaNacimiento==((Mascota) obj).fechaNacimiento && this.raza==((Mascota)obj).raza && this.especie==((Mascota)obj).especie
                    && this.sexo==((Mascota)obj).sexo && this.nombre==((Mascota)obj).nombre)
                resultado=true;
        return true;
    }
    @Override
    public String toString(){
        return nombre+","+fechaNacimiento+","+sexo+","+raza+","+especie;
    }
    @Override
    public int hashCode(){
        int codigo;

        codigo=(int)(Double.parseDouble(nombre)*(27/Double.parseDouble(this.raza))+(Double.parseDouble(this.fechaNacimiento.toString())*Double.parseDouble(this.especie))
        +2*(Double.parseDouble(nombre)+sexo));

        return codigo;
    }
}
