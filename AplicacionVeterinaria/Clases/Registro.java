package Clases;
import java.io.Serializable;
import java.lang.Character;
/**
 * Created by Ale on 18/05/2017.
 */
public class Registro<T ,C> implements Serializable{
    private static final long serialVersionUID=1L;
    private T var;
    private C acc;
//public static void main(String...a){}
    public Registro(){

        var=(T)new Persona();
        acc=(C)new Character('A');
    }
    public Registro(T t,C c){
        var=t;
        acc=c;
    }
    public Registro(Registro<T,C> r){
        var=r.obtenerObjeto();
        acc=r.obtenerAccion();
    }
    public T obtenerObjeto(){
        return this.var;
    }
    public C obtenerAccion(){
        return this.acc;
    }
    public void mostarRegistro(){
        System.out.println(var.toString()+"-->"+Character.toUpperCase(acc.toString().charAt(0)));
    }
    public String devolverRegistro(){
        return var.toString()+","+Character.toUpperCase(acc.toString().charAt(0));
    }
}
