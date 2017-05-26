package com.sluka.taras.exchange.service.impl;

import com.sluka.taras.exchange.service.ConvertingService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by taras on 23.05.2017.
 */
class ConvertingServiceImplTest {

    private static final String FALSE_CURRENCY_1 = "as";
    private static final String FALSE_CURRENCY_2 = "qeq";
    private static final String FALSE_CURRENCY_3 = "asdqw";
    private static final String FALSE_CURRENCY_4 = "123aa";

    private static final String TRUE_CURRENCY_1 = "AUD";
    private static final String TRUE_CURRENCY_2 = "USD";
    private static final String TRUE_CURRENCY_3 = "ZAR";
    private static final String TRUE_CURRENCY_4 = "LTL";
    private static final String TRUE_CURRENCY_5 = "uSd";
    private static final String TRUE_CURRENCY_6 = "uSd";
    private ConvertingService unit = new ConvertingServiceImpl();

    @Test
    void getExchangeRate() {
    }

    @Test
    void isValidCurrency() {
        boolean f = false;
        f = unit.isValidCurrency(TRUE_CURRENCY_1);
        assertEquals(true, f);
        f = unit.isValidCurrency(TRUE_CURRENCY_2);
        assertEquals(true, f);
        f = unit.isValidCurrency(TRUE_CURRENCY_3);
        assertEquals(true, f);
        f = unit.isValidCurrency(TRUE_CURRENCY_4);
        assertEquals(true, f);
        f = unit.isValidCurrency(TRUE_CURRENCY_5);
        assertEquals(true, f);
        f = unit.isValidCurrency(TRUE_CURRENCY_6);
        assertEquals(true, f);

        f = unit.isValidCurrency(FALSE_CURRENCY_1);
        assertEquals(false, f);
        f = unit.isValidCurrency(FALSE_CURRENCY_2);
        assertEquals(false, f);
        f = unit.isValidCurrency(FALSE_CURRENCY_3);
        assertEquals(false, f);
        f = unit.isValidCurrency(FALSE_CURRENCY_4);
        assertEquals(false, f);
    }

}