package ClasesAbstractas;
import Clases.*;
/**
 * Created by aortiz on 02/05/2017.
 */
public abstract class Log {


   public abstract int mostrarLog(char f,Fecha fch);
   // abstract void crearLog(Fecha f);
    public abstract void eventoP(Registro<Persona,Character> registro);
    public abstract void eventoM(Registro<Registro<String,Mascota>,Character> registro);
}
