package Enums;

/**
 * Created by aortiz on 17/05/2017.
 */
public enum TamañoRegistroMascota {
    nom(0),
    f(10),
    sex(20),
    raz(22),
    esp(32),
    total(42);

    private final int bytes;

    TamañoRegistroMascota(int bytes){
        this.bytes=bytes;

    }

    public int getBytes(){
        return this.bytes;
    }

}
