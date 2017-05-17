package GestionFicheros;
import java.io.*;
import java.io.RandomAccessFile;
import Clases.*;
import Enums.TamañoRegistroMascota;
import Enums.TamañoRegistroPersona;

/**
 * Created by aortiz on 17/05/2017.
 */
public class FicheroDiario {

    File diario=new File("Diario.txt");
    TamañoRegistroPersona bytesP;
    TamañoRegistroMascota bytesM;


    FicheroDiario(){}

    public void  guardarPersona (Persona p) {
        try {
            RandomAccessFile raf = new RandomAccessFile(diario, "w");
            raf.writeChars(p.getNombre());
            raf.seek(0);
            raf.seek(bytesP.ape.getBytes());
            raf.writeChars(p.getApellidos());
            raf.seek(0);
            raf.seek(bytesP.f.getBytes());
            raf.writeChars(p.getFechaNac().toString());


        } catch (FileNotFoundException e) {
        }catch (IOException e){}
    }
}
