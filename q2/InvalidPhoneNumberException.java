package main.java.com.maman14.q2;

public class InvalidPhoneNumberException extends Exception {

    public InvalidPhoneNumberException() {
        super();
    }

    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}
