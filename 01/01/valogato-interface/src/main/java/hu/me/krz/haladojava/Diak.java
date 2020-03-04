package hu.me.krz.haladojava;

public class Diak extends Szemely implements Valogato{
    
    private int puskakSzama;
    
    public Diak(int kor, String nev, int puskakSzama) {
        super(kor, nev);
        this.puskakSzama = puskakSzama;
    }

    @Override
    public boolean joAlanyE(Szemely o) {
        if (puskakSzama == 0) {
            return true;
        } else {            
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "Diak: puskak szama: " + puskakSzama;
    }

}
