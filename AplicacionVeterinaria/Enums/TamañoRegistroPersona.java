package Enums;

/**
 * Created by aortiz on 17/05/2017.
 */
public enum TamañoRegistroPersona {
    nom(0),
    ape (21),
    f(42),
    DNI(51),
    Tl(61),
    Mvl(71),
    Direc(81),
    codP(102),
    nac(107),
    esc(110),
    total(112);


    private final int bytes;

    TamañoRegistroPersona(int bytes){

        this.bytes=bytes;
    }

    public int getBytes(){
        return this.bytes;
    }
}
