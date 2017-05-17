package ClasesAbstractas;
import Clases.*;

import java.io.RandomAccessFile;
import java.util.*;
/**
 * Created by aortiz on 15/05/2017.
 */
abstract class Diario {

    abstract void guardarPersona(Persona p);
    abstract void guardarMascota(Mascota m);
    abstract int buscarPersona(String nombre,String apellidos);
    abstract int buscarPersona(String DNI);
    abstract int buscarPersona(Mascota m);
    abstract int buscarMascota(Persona p);
    abstract int buscarMascota(String nombre);
    abstract void eliminarPersona(int pos);
    abstract void eliminarMascota(int pos);
    abstract Persona obtenerPersona(int pos);
    abstract void mostrarPersonas();
    abstract void mostrarMascotas();
    abstract List<Mascota> obtenerMascota(int pos);
}
