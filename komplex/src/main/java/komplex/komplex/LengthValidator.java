package komplex.komplex;

public class LengthValidator implements Validator{

    public boolean isValid(User user) {
        return user.getName().length() > 5;
    }

}
