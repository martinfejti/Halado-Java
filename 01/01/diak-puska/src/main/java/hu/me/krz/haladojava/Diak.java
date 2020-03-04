package hu.me.krz.haladojava;

public class Diak extends Szemely implements Comparable<Diak> {
    
    private int numberOfPuska;
    
    public Diak(int numberOfPuska, int age, String name) {
        super(age, name);
        this.numberOfPuska = numberOfPuska;
    }
    
    public int getNumberOfPuska() {
        return numberOfPuska;
    }

    @Override
    public int compareTo(Diak o) {
        if (numberOfPuska == o.getNumberOfPuska()) {
            return 0;
        } else if (numberOfPuska > o.getNumberOfPuska()) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "numberOfPuska=" + numberOfPuska + ", age=" + super.getAge() + " name= " + super.getName();
    }
    
    

}
