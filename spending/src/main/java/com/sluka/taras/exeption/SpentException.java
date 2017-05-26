package com.sluka.taras.exeption;

public class SpentException extends RuntimeException {

    public SpentException() {
        super();
    }

    public SpentException(String message) {
        super(message);
    }
}
