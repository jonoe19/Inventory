public class InvalidProductNameException extends Exception{

    public InvalidProductNameException(String message){
        super(message);
    }

    public InvalidProductNameException(){
        this("Product name not valid!");
    }

}
