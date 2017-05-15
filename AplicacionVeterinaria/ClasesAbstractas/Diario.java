package ClasesAbstractas;
import Clases.*;

import java.io.RandomAccessFile;
import java.util.*;
/**
 * Created by aortiz on 15/05/2017.
 */
abstract class Diario {
    private RandomAccessFile diario;
    abstract void guardarPersona(Persona p);
    abstract void guardarMascota(Mascota m);
    abstract int buscarPersona(String nombre);
    abstract int buscarPersona(String nombre,String apellidos);
    abstract int buscarPersonaxDni(String DNI);
    abstract int buscarPersona(Mascota m);
    abstract void eliminarPersona(Persona p);
    abstract void eliminarMascota(Mascota m );
    abstract Persona leerPersona(int pos);
    abstract void mostrarPersona();
    abstract Mascota leerMascota(int pos);
    abstract void mostrarMascotas();
    abstract List<Mascota> buscarMascota(Persona p);
}
