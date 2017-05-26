package com.sluka.taras.command.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by taras on 24.05.2017.
 */
class ListCommandTest {

    private ListCommand listCommand = new ListCommand();

    @Test
    void isValidSignature() {
        assertTrue(listCommand.isValidSignature("list"));
        assertTrue(listCommand.isValidSignature("list "));
        assertTrue(listCommand.isValidSignature(" list "));
        assertFalse(listCommand.isValidSignature(" list ads"));
        assertFalse(listCommand.isValidSignature("List "));
        assertFalse(listCommand.isValidSignature("List ads"));
        assertFalse(listCommand.isValidSignature("Sist ads"));

    }

}