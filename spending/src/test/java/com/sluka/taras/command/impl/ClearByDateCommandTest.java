package com.sluka.taras.command.impl;

import com.sluka.taras.util.DateException;
import com.sluka.taras.util.StaticDateUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by taras on 22.05.2017.
 */
class ClearByDateCommandTest {

    private ClearByDateCommand clearByDateCommand = new ClearByDateCommand();

    @Test
    void execute() {
        assertThrows(DateException.class, () -> clearByDateCommand.execute("clear "+ StaticDateUtil.date_false_1));
        assertThrows(DateException.class, () -> clearByDateCommand.execute("clear "+ StaticDateUtil.date_false_2));
        assertThrows(DateException.class, () -> clearByDateCommand.execute("asd"+ StaticDateUtil.date_false_3));
        assertThrows(DateException.class, () -> clearByDateCommand.execute("asd"+ StaticDateUtil.date_false_4));

    }

    @Test
    void isValidSignature() {
        assertTrue(clearByDateCommand.isValidSignature("clear 1232-12-12"));
        assertTrue(clearByDateCommand.isValidSignature(" clear 1232-12-12 "));
        assertTrue(clearByDateCommand.isValidSignature(" clear 2018-32-12 "));

        assertFalse(clearByDateCommand.isValidSignature("Clear  1232-12-12"));
        assertFalse(clearByDateCommand.isValidSignature("cLear 1232-121-12"));
        assertFalse(clearByDateCommand.isValidSignature("cleA  1232-12-12"));
        assertFalse(clearByDateCommand.isValidSignature("asdr 1232-12-12 asd"));
        assertFalse(clearByDateCommand.isValidSignature("ads aclear 1232-12-12"));
    }

}