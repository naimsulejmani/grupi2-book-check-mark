package dev.naimsulejmani.grupi2bookcheckmark.exceptions;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(String message) {
        super(message);
    }

    public WrongPasswordException() {
        super("Wrong password!");
    }

}
