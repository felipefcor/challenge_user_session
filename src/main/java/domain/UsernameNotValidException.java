package domain;

public class UsernameNotValidException extends RuntimeException {
    String message = "username not valid";
    
    public String getMessage() {
        return message;
    }
}
