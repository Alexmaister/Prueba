package Clases;

import Excepciones.ExcepcionMascota;

/**
 * Created by aortiz on 17/01/2017.
 */
public class Mascota {
    private String nombre;
    public Mascota(String nombre)throws ExcepcionMascota{

        this.nombre=nombre;



    }
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
