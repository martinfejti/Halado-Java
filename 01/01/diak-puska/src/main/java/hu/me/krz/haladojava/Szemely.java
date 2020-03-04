package hu.me.krz.haladojava;

public class Szemely {

    private final int age;
    private final String name;
    
    public Szemely(int age, String name) {
        this.age = age;
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    
}
