package hu.me.krz.haladojava;

public class Szemely {

    private int kor;
    private String nev;
    
    public Szemely(int kor, String nev) {
        this.kor = kor;
        this.nev = nev;
    }
    
    public int getKor() {
        return kor;
    }
    
    public String getNev() {
        return nev;
    }
    
    @Override
    public String toString() {
        return "Szemely: " + "\t nev: " + nev + "\t kor: " + kor;
    }
}
