package komplex.komplex;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();
        List<Validator> validators = new ArrayList<Validator>();
        System.out.println("Repo created");
        
        validators.add(new SpaceValidator());
        validators.add(new LengthValidator());
        System.out.println("Input conditions are set");
        
        userRepository.save(new User("Attila", true, "abc123"));
        userRepository.save(new User("Béla", true, "abc456"));
        userRepository.save(new User("Csaba", false, "abc789"));
        
        for (User user : userRepository.findAll()) {
            System.out.println("User added: " + user.getName());
        }
        System.out.println("Done");
    }

}
