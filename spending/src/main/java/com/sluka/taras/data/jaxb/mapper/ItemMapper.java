package com.sluka.taras.data.jaxb.mapper;

import com.sluka.taras.data.model.Item;
import com.sluka.taras.exchange.ExchangeException;
import com.sluka.taras.exchange.service.ConvertingService;
import com.sluka.taras.exchange.service.impl.ConvertingServiceImpl;
import com.sluka.taras.util.DateUtil;
import org.apache.log4j.Logger;

import java.util.Date;

public class ItemMapper {

    private static final Logger LOGGER = Logger.getLogger(ItemMapper.class);
    private static ConvertingService convertingService = new ConvertingServiceImpl();

    public static Date dateFromCommandAdd(String s) {
        s = s.trim();
        String mas[] = s.split(" ", 4);
        return DateUtil.dateOfString(mas[0]);
    }

    public static Item itemFromCommandAdd(String s) {
        s = s.trim();
        String mas[] = s.split(" ", 4);
        Item item = new Item();
        item.setCost(Double.valueOf(mas[1]));
        if (!convertingService.isValidCurrency(mas[2])) {
            throw new ExchangeException("Currency is not valid");
        }
        item.setCurrency(mas[2]);
        String name = mas[3];
        if (name.charAt(name.length() - 1) == '"' && '"' == name.charAt(0)) {
            name = name.substring(1, name.length() - 2);
        }
        item.setName(name);
        return item;
    }
}
