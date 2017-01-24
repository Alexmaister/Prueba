package Clases;


import java.io.Serializable;

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
public class Mascota implements Cloneable,Comparable<Mascota>,Serializable {

    private static final long serialVersionUID=1L;
    private String nombre;
    private char sexo;
    private date FechaNacimiento;
    private String raza;
    private Persona dueño;
}
