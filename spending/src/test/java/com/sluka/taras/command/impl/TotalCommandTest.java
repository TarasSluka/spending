package com.sluka.taras.command.impl;

import com.sluka.taras.exchange.ExchangeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by taras on 25.05.2017.
 */
class TotalCommandTest {

    private TotalCommand totalCommand = new TotalCommand();

    @Test
    void execute() {
        assertThrows(ExchangeException.class, () -> totalCommand.execute("total sss"));
        assertThrows(ExchangeException.class, () -> totalCommand.execute("total sss"));
        assertThrows(ExchangeException.class, () -> totalCommand.execute("total USSS"));
        assertThrows(ExchangeException.class, () -> totalCommand.execute("total UAH"));
    }

    @Test
    void isValidSignature() {
        assertTrue(totalCommand.isValidSignature("total USD"));
        assertTrue(totalCommand.isValidSignature("total Usd"));
        assertTrue(totalCommand.isValidSignature("total uSD"));
        assertTrue(totalCommand.isValidSignature("total USD "));
        assertTrue(totalCommand.isValidSignature(" total USD "));
        assertTrue(totalCommand.isValidSignature("  total uas"));
        assertTrue(totalCommand.isValidSignature(" total usd "));
        assertFalse(totalCommand.isValidSignature("total "));
        assertFalse(totalCommand.isValidSignature("  a total uas"));
        assertFalse(totalCommand.isValidSignature("Total USD"));
        assertFalse(totalCommand.isValidSignature("TOTAL USD asd"));
    }

}