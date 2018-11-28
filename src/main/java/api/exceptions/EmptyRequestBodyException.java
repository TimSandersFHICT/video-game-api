package api.exceptions;

public class EmptyRequestBodyException extends Exception {
    public EmptyRequestBodyException(String message) {
        super(message);
    }
}
