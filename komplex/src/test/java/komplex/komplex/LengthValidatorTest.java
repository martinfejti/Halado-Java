package komplex.komplex;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

public class LengthValidatorTest {

    @Test
    public void isValid() {
        String name = "nonamee";
        User user = mock(User.class);
        when(user.getName()).thenReturn(name);
        
        LengthValidator lv = new LengthValidator();
        boolean isValid = lv.isValid(user);
        System.out.println(isValid);
        
        Assert.assertEquals(true, isValid);
        verify(user, times(1)).getName();
    }
}
