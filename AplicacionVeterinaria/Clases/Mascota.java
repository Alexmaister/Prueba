package Clases;
import Excepciones.ExcepcionMascota;


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
//no se seguira el patron de alegacion
Persona getDueño()
setDueño(Persona Dueño)

 */
public class Mascota implements Cloneable{


    private String nombre;
    private char sexo;
    private Fecha fechaNacimiento;
    private String raza;
    private String especie;
    private Persona dueño;

    public Mascota(){

        nombre="Default";
        sexo='M';
        fechaNacimiento=new Fecha(1,1,1900);
        raza="Perro";
        especie="Mamifero";
        dueño=new Persona();
    }

    public Mascota(String nombre, char sexo, Fecha fecha, String raza, String especie,Persona p){
        this.nombre=nombre;
        this.sexo=sexo;
        this.fechaNacimiento=fecha;
        this.raza=raza;
        this.especie=especie;
        this.dueño=new Persona(p);
    }

    public Mascota(Mascota mascota){

        this.nombre=mascota.getNombre();
        this.sexo=mascota.getSexo();
        this.fechaNacimiento=mascota.getFechaNacimiento();
        this.raza=mascota.getRaza();
        this.especie=mascota.getEspecie();
        this.dueño=mascota.getDueño();
    }

    public String getNombre(){
        return this.nombre;
    }
    public char getSexo(){
        return this.sexo;
    }
    //patron de alegacion -- no implementado --fecha deberia ser un tipo ya q se trata en conjunto como uno solo
    public Fecha getFechaNacimiento(){
        return this.fechaNacimiento;
    }
    public String getRaza(){
        return this.raza;
    }
    public String getEspecie(){
        return this.especie;
    }
    public Persona getDueño(){return this.dueño;}
    public void setDueño(Persona d){this.dueño=new Persona(d);}
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setFechaNacimiento(Fecha f){
        this.fechaNacimiento=f;
    }
    public void setRaza(String raza){
        this.raza=raza;
    }
    public void setEspecie(String especie){
        this.especie=especie;
    }
    public void setSexo(char s)throws ExcepcionMascota{
        if((s!='M' && s!='H') ||(s!='m' && s!='h'))
            this.sexo=s;
        else throw new ExcepcionMascota("El seo debe ser M o F");
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

        codigo=(27+fechaNacimiento.getDia()/2*(int)(this.sexo))*fechaNacimiento.getMes();
        return codigo;
    }
}
