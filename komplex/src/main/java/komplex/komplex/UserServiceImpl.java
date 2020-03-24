package komplex.komplex;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserModify userModify;
    List<Validator> validators;
    
    public UserServiceImpl(UserModify userModify, List<Validator> validators) {
        this.userModify = userModify;
        this.validators = validators;
    }
    
    public void saveUser(User user) {
        if (isValid(user)) {
            userModify.save(user);
        }
    }
    
    private boolean isValid(User user) {
        boolean isValid = true;
        for (Validator validator : validators) {
            if (!validator.isValid(user)) {
                isValid = false;
            }
        }
        return isValid;
    }
    
}
