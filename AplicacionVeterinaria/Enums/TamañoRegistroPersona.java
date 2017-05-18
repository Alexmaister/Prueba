package Enums;

/**
 * Created by aortiz on 17/05/2017.
 */
public enum TamañoRegistroPersona {
    nom(0),
    ape (20),
    f(40),
    DNI(50),
    Tl(59),
    Mvl(68),
    Direc(76),
    codP(96),
    nac(101),
    esc(104),
    total(106);


    private final int bytes;

    TamañoRegistroPersona(int bytes){

        this.bytes=bytes;
    }

    public int getBytes(){
        return this.bytes;
    }
}
