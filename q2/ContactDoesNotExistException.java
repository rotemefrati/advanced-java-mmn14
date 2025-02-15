package main.java.com.maman14.q2;

public class ContactDoesNotExistException extends Exception {

    public ContactDoesNotExistException() {
        super();
    }

    public ContactDoesNotExistException(String message) {
        super(message);
    }
}
