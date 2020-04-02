package komplex.komplex;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();
        List<Validator> validators = new ArrayList<Validator>();
        validators.add(new LengthValidator());
        validators.add(new SpaceValidator());
        UserService userService = new UserServiceImpl(
                userRepository, validators
        );

        UserController userController = new UserController(
                userService, new NeptunCodeGenerator()
        );


        userController.save(new UserDto(" vanBenneSpace"));
        userController.save(new UserDto("rovid"));
        userController.save(new UserDto("nagyonjo"));
    }

}
