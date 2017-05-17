package Enums;

/**
 * Created by aortiz on 17/05/2017.
 */
public enum TamañoRegistroPersona {
    nom(0),
    ape (40),
    f(140),
    DNI(160),
    Tl(179),
    Mvl(200),
    Direc(221),
    codP(241),
    nac(251),
    total(257);


    private final int bytes;

    TamañoRegistroPersona(int bytes){

        this.bytes=bytes;
    }

    public int getBytes(){
        return this.bytes;
    }
}
