package Clases;

import java.io.Serializable;

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


* */
public class Persona implements Cloneable,Comparable<Persona>,Serializable{
    private static final long serialVersionUID=1l;
    private String nombre;
    private String apellidos;
    private Date fechaNac;
    private String DNI;
    private String telefono;
    private String telefonoMovil;
    private String direccion;
    private String codPostal;

    //constructor por defecto
    public Persona(){

        this.nombre="Default";
        this.apellidos=" ";
        this.fechaNac=new Date(1,1,1900);
        this.DNI="12345678A";
    }
}
