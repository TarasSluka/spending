package com.sluka.taras.exchange;

import com.sluka.taras.exeption.SpentException;

public class ExchangeException extends SpentException {

    public ExchangeException() {
    }

    public ExchangeException(String message) {
        super(message);
    }
}
