import java.util.*;

public class LoginForm {
    private static final String validUsername = "user";
    private static final String validPassword = "pass123";

    public static boolean login(Scanner sc) {
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (username.equals(validUsername) && password.equals(validPassword)) {
            System.out.println("Login Successful!");
            return true;
        } else {
            System.out.println("Invalid credentials. Try again.");
            return false;
        }
    }
}