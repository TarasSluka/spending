package com.sluka.taras.command.impl;

import com.sluka.taras.data.jaxb.impl.StorageServiceImpl;
import com.sluka.taras.data.model.Item;
import com.sluka.taras.data.model.ItemsByDate;
import com.sluka.taras.data.model.Spent;
import com.sluka.taras.data.storage.StorageService;
import com.sluka.taras.data.util.StaticItemUtil;
import com.sluka.taras.exchange.ExchangeException;
import com.sluka.taras.util.StaticDateUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Created by taras on 25.05.2017.
 */
class AddItemToListCommandTest {
    private AddItemToListCommand addItemToListCommand = new AddItemToListCommand();

    private StorageService storageService = new StorageServiceImpl();

    @Test
    void execute() {
        storageService.clearAllItems();
        Item item = StaticItemUtil.getItem_Bread_1_EUR();
        Date date = StaticDateUtil.getDate_2017_05_20();
        Spent spent = new Spent();
        spent.setListItem(Arrays.asList(new ItemsByDate(date, Arrays.asList(item))));
        addItemToListCommand.execute("add 2017-05-20 1 EUR Bread");
        assertTrue(storageService.getSpent().equals(spent));
        assertThrows(ExchangeException.class, () -> addItemToListCommand.execute("add 2017-04-25 1 euu Jogurt"));

    }

    @Test
    void isValidSignature() {

        assertTrue(addItemToListCommand.isValidSignature("add 2017-4-25 1 EUR Jogurt"));
        assertTrue(addItemToListCommand.isValidSignature("add 2017-4-5 1 EUR Jogurt"));

//        assertTrue(addItemToListCommand.isValidSignature("add 2017-04-25 1 EUR Jogurt"));
//        assertTrue(addItemToListCommand.isValidSignature("add 2017-04-25 0.323 usD bay ticket "));
//        assertTrue(addItemToListCommand.isValidSignature("add 2017-04-25 1.5 USD bus"));
//        assertTrue(addItemToListCommand.isValidSignature("add 2017-04-25 2 USD \"klasd asdasd\""));
//        assertTrue(addItemToListCommand.isValidSignature("add 2017-04-25 21.3 PLN \"klasd asdasd\""));
//
//        assertFalse(addItemToListCommand.isValidSignature("add 2017-04-25 2 US Jogurt"));
//        assertFalse(addItemToListCommand.isValidSignature("add 2017-11-25 2 U2D"));
//        assertFalse(addItemToListCommand.isValidSignature("ddd 2017-14-21 2 USD wasJogurt"));
//        assertFalse(addItemToListCommand.isValidSignature("add 2017-00-25 2 1SD Jogurt"));
//        assertFalse(addItemToListCommand.isValidSignature("add 2017-12-25 2, sSD Jogurt"));

    }

    @Test
    void getParameterCommand() {
        String res = addItemToListCommand.getParameterCommand("");
        assertEquals("2017-04-25 2 USD Jogurt", res);

        res = addItemToListCommand.getParameterCommand("");
        assertEquals("2017-04-25 2 USD Jogurt", res);


    }
}