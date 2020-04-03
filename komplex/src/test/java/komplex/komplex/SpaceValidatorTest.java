package komplex.komplex;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

public class SpaceValidatorTest {

    @Test
    public void isValid() {
        String name = "nonameee";
        User user = mock(User.class);
        when(user.getName()).thenReturn(name);
        
        SpaceValidator sv = new SpaceValidator();
        boolean isValid = sv.isValid(user);
        System.out.println(isValid);
        
        Assert.assertEquals(true, isValid);
        verify(user, times(1)).getName();
        
    }
}
