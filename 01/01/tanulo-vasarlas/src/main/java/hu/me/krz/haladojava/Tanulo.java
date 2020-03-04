package hu.me.krz.haladojava;

public class Tanulo {
    
    private final String name;
    private int money;
    private int numberOfStudents;
    
    public Tanulo(String name, int money) {
        this.name = name;
        this.money = money;
        this.numberOfStudents++;
    }
    
    public Tanulo(String name) {
        this(name, 10000);
    }
    
    public String getName() {
        return name;
    }
    
    public int getMoney() {
        return money;
    }
    
    public int getAllStudents() {
        return numberOfStudents;
    }
    
    public void decreaseNumberOfStudents() {
        numberOfStudents--;
    }
    
    public boolean consumption(int moneyToDecrease) {
        money -= moneyToDecrease;
        if (money <= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Tanulo [name=" + name + ", money=" + money + "]";
    }
}
