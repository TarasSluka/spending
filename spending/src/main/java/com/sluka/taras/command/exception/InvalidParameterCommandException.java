package com.sluka.taras.command.exception;

import com.sluka.taras.exeption.SpentException;

public class InvalidParameterCommandException extends SpentException {

    public  InvalidParameterCommandException(String message) {
        super(message);
    }
}
