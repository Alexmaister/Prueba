package Clases;
import Clases.Enfermedad;
import java.util.*;

/**
 * Created by aortiz on 22/03/2017.
 */
public class Vacuna {

    private String nombre;
    private double dosis;
    private List<Enfermedad> enfermedades;
    private double concentracion;
    private String agenteAc;

    public Vacuna() {
        nombre = "Rabia";
        dosis = 0.50;
        enfermedades = new ArrayList<Enfermedad>();
        enfermedades.add(new Enfermedad());
        concentracion = 0.5;
        agenteAc = "Rubiminuoxitona";

    }

    Vacuna(String n, String aac, double d, double c, List<Enfermedad> e) {

        this();
        this.nombre = n;
        this.agenteAc = aac;
        this.dosis = d;
        this.concentracion = c;
        this.enfermedades = new ArrayList<Enfermedad>(e);

    }

    //metodos consultores
    public String getNombre() {
        return this.nombre;
    }

    public double getDosis() {
        return this.dosis;
    }

    public double getConcentracion() {
        return this.concentracion;
    }

    public String getAgenteAc() {
        return this.agenteAc;
    }

    //no sigue el patron de alegación
    public ArrayList<Enfermedad> getEnfermedad() {
        return (ArrayList<Enfermedad>) this.enfermedades;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public void setDosis(double d) {
        this.dosis = d;
    }

    public void setConcentracion(double c) {
        this.concentracion = c;
    }

    public void setAgenteAc(String a){
        this.agenteAc=a;
    }

    public void añadirEnfermedad(Enfermedad f){
        this.enfermedades.add(f);
    }
    public void añadirEnfermedades(Enfermedad[]fs){
        for(Enfermedad f:fs){
            this.enfermedades.add(f);
        }

    }
    public void borrarEnfermedades(){
        this.enfermedades=new ArrayList<Enfermedad>();
    }
    public int buscarEnfermedad(String n){
        int resultado=0;
         for(Enfermedad e:this.enfermedades)
             if(e.getNombre().equals(n))
                 resultado=this.enfermedades.indexOf(e);

        return  resultado;
    }
    public  Enfermedad obtenerEnfermedad(String n){
        Enfermedad e=null;
       for(Enfermedad f:this.enfermedades){
           if(f.getNombre().equals(n))
                e=new Enfermedad(f);

       }
       return e;
    }
    public boolean containsEnfermedad(String n){
        boolean busqueda=false;
        for(Enfermedad f:this.enfermedades)
            if(f.getNombre().equals(n))
                busqueda=true;
        return busqueda;
    }
    public void eliminarEnfermedad(String n){
        int pos=-1;
        pos=buscarEnfermedad(n);
        this.enfermedades.remove(pos);

    }
    public void cambiarEnfermedades(Enfermedad[] es){

        this.enfermedades=new ArrayList<Enfermedad>(Arrays.asList(es));

    }

}
