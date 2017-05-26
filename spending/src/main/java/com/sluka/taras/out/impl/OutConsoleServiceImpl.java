package com.sluka.taras.out.impl;

import com.sluka.taras.data.model.ItemsByDate;
import com.sluka.taras.data.model.Spent;
import com.sluka.taras.out.OutService;
import com.sluka.taras.util.DateUtil;
import org.apache.log4j.Logger;

import java.util.List;

public class OutConsoleServiceImpl implements OutService {

    private static final Logger LOGGER = Logger.getLogger(OutConsoleServiceImpl.class);

    @Override
    public void printSpent(Spent spent) {
        assert spent != null;
        LOGGER.debug("out spent");
        List<ItemsByDate> itemsByDateList = spent.getListItem();
        if (itemsByDateList.size() != 0) {
            System.out.println();
            itemsByDateList.forEach(dateItem -> {
                System.out.println(("\t" + DateUtil.dateBySimpleFormat(dateItem.getDate())));
                dateItem.getItem().forEach(item -> {
                    System.out.println("\t" + item.getName() + "  " + item.getCost() + "   " + item.getCurrency());
                });
                System.out.println();
            });
        } else {
            System.out.println("your spend are empty");
        }
    }
}

