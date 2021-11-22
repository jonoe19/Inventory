/**
 * Superclass for all employee types
 */
public abstract class Employee {

    String username;

    public abstract String getUsername();
    public static Boolean usernameValid(String username){
        return username != "";
    }

}
