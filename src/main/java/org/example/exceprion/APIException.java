package org.example.exceprion;

public abstract class APIException extends RuntimeException {

    public APIException(String message) {
        super(message);
    }
}
