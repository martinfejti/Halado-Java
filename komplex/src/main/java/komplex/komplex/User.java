package komplex.komplex;

public class User {

    private String name;
    private boolean enabled;
    private String neptunKod;
    
    public User(String name, boolean enabled, String neptunKod) {
        this.name = name;
        this.enabled = enabled;
        this.neptunKod = neptunKod;
    }
    
    public User(String name) {
        this.name = name;
    }
    
    public User() {
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isEnabled() {
        return enabled;
    }
    
    public String getNeptunKod() {
        return neptunKod;
    }
}
