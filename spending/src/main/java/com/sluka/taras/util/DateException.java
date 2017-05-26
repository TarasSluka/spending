package com.sluka.taras.util;

import com.sluka.taras.exeption.SpentException;

public class DateException extends SpentException {

    public DateException() {
    }

    public DateException(String message) {
        super(message);
    }
}
