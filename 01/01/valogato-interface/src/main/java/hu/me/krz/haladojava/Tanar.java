package hu.me.krz.haladojava;

public class Tanar extends Szemely implements Valogato {
    private double jegyekAtlaga;
    
    public Tanar(int kor, String nev, double jegyekAtlaga) {
        super(kor, nev);
        this.jegyekAtlaga = jegyekAtlaga;
    }
    
    @Override
    public boolean joAlanyE(Szemely o) {
        if (super.getKor() < 30 && jegyekAtlaga > 4) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "Tanar: jegyek atlaga: " + jegyekAtlaga;
    }

}
