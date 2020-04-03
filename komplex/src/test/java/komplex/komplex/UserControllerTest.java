package komplex.komplex;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class UserControllerTest {

    @Test
    public void save() {
        UserService userService = mock(UserService.class);
        NeptunCodeGenerator neptunCodeGenerator = mock(NeptunCodeGenerator.class);
        UserController userController = new UserController(userService, neptunCodeGenerator);
        UserDto userDto = mock(UserDto.class);
        User user = mock(User.class);
        
        userService.save(user);
        userController.save(userDto);
        
        verify(userService, times(1)).save(user);
    }
}
