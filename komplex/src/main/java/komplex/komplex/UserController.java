package komplex.komplex;

import java.util.Scanner;

public class UserController {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Irjon be egy usernevet: ");
        String name = sc.nextLine();
        
        if (name.length() > 6 && !(name.contains(" "))) {
            User user = new User(name);
            System.out.println("User has been created with name: " + user.getName());
        } else {
            System.out.println("The username is either shorter than 6 character or contains a whitespace!");
        }
        
        sc.close();
    }
}
