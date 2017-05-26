package com.sluka.taras.data.jaxb.mapper;

import com.sluka.taras.data.model.Item;
import com.sluka.taras.exchange.ExchangeException;
import com.sluka.taras.util.DateException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by taras on 24.05.2017.
 */
class ItemMapperTest {


    @Test
    void dateFromCommandAdd() {
        ItemMapper.dateFromCommandAdd("2017-12-12 2.7 usd ioasdmqwe");
        ItemMapper.dateFromCommandAdd("2018-11-11 2.7 asd ioasdmqwe");
        ItemMapper.dateFromCommandAdd("2018-1-1 2.7 asd ioasdmqwe");
        assertThrows(DateException.class, () -> ItemMapper.dateFromCommandAdd("2017-14-11 eur Jogurt"));
        assertThrows(DateException.class, () -> ItemMapper.dateFromCommandAdd("2017-12-32 eur Jogurt"));
    }

    @Test
    void itemFromString() {
        Item item = new Item("ioasdmqwe", 2.7, "usd");
        Item item1 = ItemMapper.itemFromCommandAdd("2017-12-12 2.7 usd ioasdmqwe");

        assertThrows(ExchangeException.class, () -> ItemMapper.itemFromCommandAdd("2017-04-21 1 euu Jogurt"));

        assertTrue(item.equals(item1));

    }


}