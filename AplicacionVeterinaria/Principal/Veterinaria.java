package Principal;
import javax.swing.*;
import java.awt.*;


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
       // setSize(1000,500);// por defecto 0,0
        //setLocation(2500,200);// por defecto 0,0
        //setBound sirve x los dos anteriores
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setIconImage(new Image() );
        setTitle("Veterinaria");
        setResizable(false);//por defecto es true
        //setExtendedState(Frame.MAXIMIZED_BOTH);//pantalla completa , se abre asi
        Toolkit pantalla =Toolkit.getDefaultToolkit();//propiedades de donde coorro la aplicacion
        Dimension dimension=pantalla.getScreenSize();
        //colocamos ventana en el centro de la pantalla y de tamaño la mitad de la pantalla
        setBounds((int)dimension.getWidth()/4,(int)dimension.getHeight()/4,(int)dimension.getWidth()/2,(int)dimension.getHeight()/2); //alto y ancho de la pantalla
        //le ponemos un icono de un gato :)
        setIconImage(pantalla.getImage("gsto.jpg"));

    }

    public static void main(String... a){

        Veterinaria v= new Veterinaria();

    }
}
