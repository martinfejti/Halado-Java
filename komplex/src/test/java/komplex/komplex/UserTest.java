package komplex.komplex;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void getName() {
        String name = "dummy name";
        User user = new User(name, true, "aaaaaaaa");
        
        Assert.assertEquals(user.getName(), name);
    }
    
    @Test
    public void isEnabled() {
        boolean enabled = true;
        User user = new User("dummy name", enabled, "aaaaaaaa");
        
        Assert.assertEquals(user.isEnabled(), enabled);
    }
    
    @Test
    public void getNeptunkod() {
        String neptunKod = "aaaaaaaaa";
        User user = new User("dummy name", true, neptunKod);
        
        Assert.assertEquals(user.getNeptunkod(), neptunKod);
    }
}
