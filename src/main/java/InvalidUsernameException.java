public class InvalidUsernameException extends Exception{

    public InvalidUsernameException(String message){
        super(message);
    }

    public InvalidUsernameException(){
        this("Username not valid!");
    }

}
