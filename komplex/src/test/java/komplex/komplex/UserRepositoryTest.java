package komplex.komplex;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class UserRepositoryTest {

    @Test
    public void save() {
        List<User> userList = new ArrayList<User>();
        User user = mock(User.class);
        
        userList.add(user);
        
        Assert.assertEquals(1, userList.size());
    }
    
    @Test
    public void getByNektunKod() {
        UserRepository userRepository = new UserRepository();
        List<User> userList = new ArrayList<User>();
        String neptunKod = "aaaaaaa";
        User user = mock(User.class);
        userList.add(user);
        when(user.getNeptunkod()).thenReturn(neptunKod);
        
        userRepository.save(user);
        User foundUser = userRepository.getByNektunKod(neptunKod);

        Assert.assertEquals(foundUser.getNeptunkod(), neptunKod);
    }
    
    @Test
    public void findAll() {
        UserRepository userRepository = new UserRepository();
        List<User> userList = new ArrayList<User>();
        User user1 = mock(User.class);
        User user2 = mock(User.class);
        
        userList.add(user1);
        userList.add(user2);
        userRepository.save(user1);
        userRepository.save(user2);
        
        List<User> foundUsersList = userRepository.findAll();

        Assert.assertEquals(userList.size(), foundUsersList.size());
    }
    
    @Test
    public void findByEnabledIsTrue() {
        UserRepository userRepository = new UserRepository();
        List<User> userList = new ArrayList<User>();
        User user = mock(User.class);
        when(user.isEnabled()).thenReturn(true);
        
        userList.add(user);
        userRepository.save(user);
        
        List<User> foundEnabledUsersList = userRepository.findByEnabledIsTrue();
        
        Assert.assertEquals(foundEnabledUsersList.size(), userList.size());
    }
}
