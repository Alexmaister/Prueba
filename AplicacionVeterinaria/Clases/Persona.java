package Clases;

import Excepciones.ExcepcionFecha;
import Excepciones.ExcepcionPersona;

import java.util.*;

/**
 * Created by aortiz on 24/01/2017.
 */
/*INTERFAZ:
    String getNombre()
    setNombre(String ne)
    String getApellidos()
    setApellidos(String a)
    Date getFechaNac()
    setFechaNac(Date f)
    String getDNI()
    setDNI(String dni)
    String getTelefono()
    String getTelefonoMovil()
    setTelefono(String tl)
    setTelefonoMovil(String tm)
    String getDireccion()
    setDireccion (String d)
    String getCodPostal()
    setCodPostal(String cp)
    String getNacionalidad()
    setNacionalidad(String n)


* */
public class Persona implements Cloneable,Comparable<Persona>{

    private String nombre;
    private String apellidos;
    private Fecha fechaNac;
    private String DNI;
    private String telefono;
    private String telefonoMovil;
    private String direccion;
    private String codPostal;
    private String nacionalidad;
    //constructor por defecto
    public Persona(){
        this.nombre="Default";
        this.apellidos=" ";
        this.fechaNac=new Fecha(1,1,1900);
        this.DNI="12345678A";
        this.telefono=" ";
        this.telefonoMovil=" ";
        this.direccion="Desconocida";
        this.codPostal="11111";
        this.nacionalidad="Desconocida";
    }
    public Persona(String n, String a, String dni, Fecha f, String tlf, String tlfm, String d, String cp, String nacionalidad){
        this.nombre=n;
        this.apellidos=a;
        this.fechaNac=f;
        this.telefono=tlf;
        this.telefonoMovil=tlfm;
        this.direccion=d;
        this.codPostal=cp;
        this.DNI=dni;
        this.nacionalidad = nacionalidad;
    }
   public Persona(Persona p){
        this.nombre=p.getNombre();
        this.apellidos=p.getApellidos();
        this.fechaNac=p.getFechaNac();

        this.DNI=p.getDNI();
        this.telefono=p.getTelefono();
        this.telefonoMovil=p.getTelefonoM();
        this.direccion=p.getDireccion();
        this.codPostal=p.getCodPostal();
        this.nacionalidad = p.getNacionalidad();
   }


    public Persona(String persona)throws ExcepcionPersona{
       this();
       List atributos=Arrays.asList(persona.split(","));

       if(atributos.size()!=9){
           throw new ExcepcionPersona("¡¡Error!!:El numero de atributos no es el correcto");
       }else{
           this.setNombre((String)atributos.get(0));
           this.setApellidos((String)atributos.get(1));
           try {
               this.setFechaNac(new Fecha((String)atributos.get(2)));
           } catch (ExcepcionFecha excepcionFecha) {
               System.out.println(excepcionFecha);
           }
           if(((String)atributos.get(3)).matches("[0-9]{8}[A-Z]")){
               this.setDNI((String)atributos.get(3));
           }else throw new ExcepcionPersona("El formato del DNI es incorrecto");
           this.setTelefono((String)atributos.get(4));
           this.setTelefonoM((String)atributos.get(5));
           this.setDireccion((String)atributos.get(6));
           if(((String)atributos.get(7)).matches("[0-9]{5}"))
           this.setCodPostal((String)atributos.get(7));
           else throw new ExcepcionPersona("¡Error!: El codigo postal no cumple el formato");
           this.setNacionalidad((String)atributos.get(8));
       }

    }
    public String getNombre(){
        return this.nombre;
    }

    public String getApellidos(){
        return this.apellidos;
    }

    public Fecha getFechaNac(){
        return this.fechaNac;
    }
    public String getDNI(){
        return this.DNI;
    }
    public String getTelefono(){
        return this.telefono;
    }
    public String getTelefonoM(){
        return this.telefonoMovil;
    }
    public String getDireccion(){
        return this.direccion;
    }
    public String getCodPostal(){
        return this.codPostal;
    }
    public String getNacionalidad(){
        return this.nacionalidad;
    }
    public void setNombre(String n){
        this.nombre=n;
    }
    public void setApellidos(String a){
        this.apellidos=a;
    }
    public void setFechaNac(Fecha f){
        this.fechaNac=new Fecha(f);
    }
    public void setDNI(String dni)throws ExcepcionPersona{
       if(dni.matches("[0-9]{8}+[A-Z]"))
        this.DNI=dni;
       else throw new ExcepcionPersona("El dni no cumple el formato");
    }
    public void setTelefono(String tlf){
        this.telefono=tlf;
    }
    public void setTelefonoM(String tlfm){
        this.telefonoMovil=tlfm;
    }
    public void setDireccion(String d){
        this.direccion=d;
    }
    public void setCodPostal(String cp)throws ExcepcionPersona{
        if(cp.matches("[0-9]{5}"))
        this.codPostal=cp;
        else throw new ExcepcionPersona(("El codigo postal no cumple el formato"));

    }
    public void setNacionalidad(String nac){
        this.nacionalidad=nac;
    }

    @Override
    public Persona clone(){
        Persona clon=null;
        try{
            clon=(Persona)super.clone();
        }catch(CloneNotSupportedException ce){
            System.out.println("LaPersona no se pudo clonar"+ce);
        }
        return clon;
    }
    @Override
    public int compareTo(Persona p){
        int comparacion;
        comparacion=this.getDNI().compareTo(p.getDNI());
        return comparacion;
    }
    @Override
    public boolean equals(Object obj){
       boolean comparacion=false;
        if(obj!= null && obj instanceof Persona){
            Persona p=(Persona) obj;
            if(this.getDNI()==p.getDNI())
                comparacion=true;
        }
        return comparacion;
    }
    @Override
    public String toString(){
        return nombre+","+apellidos+","+fechaNac+","+DNI+","+telefono+","+telefonoMovil+","+direccion+
                ","+codPostal+","+nacionalidad;
    }
    @Override
    public int hashCode(){
        return DNI.charAt(5)+3/codPostal.hashCode();
    }

}
