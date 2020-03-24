package komplex.komplex;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    List<User> users = new ArrayList<User>();
    
    public void save(User user) {
        if (!user.getName().contains(" ")) {
            users.add(user);            
            System.out.println("User has been created with name: " + user.getName());
        }
    }
    
    public void writeError() {
        System.out.println("The username is either shorter than 6 character or contains a whitespace!");
    }
    
    public User getByNeptunKod(String neptunKod) {
        for (User user : users) {
            if (user.getNeptunKod().equals(neptunKod)) {
                return user;
            }
        } 
        return null;
    }
    
    public List<User> findAll() {
        return users;
    }
}
