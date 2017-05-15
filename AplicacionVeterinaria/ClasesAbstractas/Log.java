package ClasesAbstractas;
import Clases.*;
/**
 * Created by aortiz on 02/05/2017.
 */
public abstract class Log {


    abstract void mostarLog(Fecha f);
    abstract void crearLog(Fecha f);
    abstract void evento(Persona p,String estado);
    abstract void evento(Mascota m, String estado);
}
