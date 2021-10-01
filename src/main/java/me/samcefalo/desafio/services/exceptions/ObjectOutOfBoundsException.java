package me.samcefalo.desafio.services.exceptions;

public class ObjectOutOfBoundsException extends RuntimeException {

    public ObjectOutOfBoundsException(String message) {
        super(message);
    }

    public ObjectOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

}
