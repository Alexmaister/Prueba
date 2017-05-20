package Principal;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

/**
 * Created by aortiz on 03/04/2017.
 *
 * Clase principal ,contendra el metodo main de la aplicacion
 * que maneja clientes y sus mascotas
 */

/*
* Analisis:
* Programa que mostrara un menu de opciones en el cual se podra mostrar una lista de personas
* ,las mascota de alguna persona,
* añadir ,borrar alguna mascota y
* clientes tambien.
* */

/*
* */

public class Veterinaria extends JFrame {

    public Veterinaria(){
        setVisible(true);//por defecto es false
        setSize(1000,500);// por defecto 0,0
        setLocation(2500,200);// por defecto 0,0
        //setBound sirve x los dos anteriores
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setIconImage(new Image() );
        setTitle("Veterinaria");
        setResizable(false);//por defecto es true
        setExtendedState(Frame.MAXIMIZED_BOTH);//pantalla completa , se abre asi

    }

    public static void main(String... a){

        Veterinaria v= new Veterinaria();

    }
}
