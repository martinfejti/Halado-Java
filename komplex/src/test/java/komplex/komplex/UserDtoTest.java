package komplex.komplex;

import org.junit.Assert;
import org.junit.Test;

public class UserDtoTest {

    @Test
    public void getName() {
        String name = "dummy name";
        UserDto userDto = new UserDto(name);
        
        Assert.assertEquals(userDto.getName(), name);
    }
    
    @Test
    public void setName() {
        String name = "first name";
        String name2 = "second name";
        UserDto userDto = new UserDto(name);
        
        userDto.setName(name2);
        
        Assert.assertEquals(userDto.getName(), name2);
    }
}
