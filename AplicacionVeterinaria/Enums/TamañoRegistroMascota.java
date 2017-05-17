package Enums;

/**
 * Created by aortiz on 17/05/2017.
 */
public enum TamañoRegistroMascota {
    nom(0),
    f(20),
    sex(40),
    raz(42),
    esp(62),
    total(82);

    private final int bytes;

    TamañoRegistroMascota(int bytes){
        this.bytes=bytes;

    }

    public int getBytes(){
        return this.bytes;
    }

}
