package com.sluka.taras.data.jaxb.impl;

import com.sluka.taras.data.model.Item;
import com.sluka.taras.data.model.ItemsByDate;
import com.sluka.taras.data.model.Spent;
import com.sluka.taras.data.util.StaticItemUtil;
import com.sluka.taras.util.StaticDateUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by taras on 24.05.2017.
 */
class StorageServiceImplTest {
    private static final String METHOD = "getFile";
    private StorageServiceImpl storageService = new StorageServiceImpl();


    @Test
    void addItem() {
        storageService.clearAllItems();
        Item item = StaticItemUtil.getItem_Bread_1_EUR();
        Date date = StaticDateUtil.getDate_2017_05_20();
        storageService.addItem(item, date);
        Spent spentStorage = storageService.getSpent();
        List<ItemsByDate> itemsByDateList = spentStorage.getListItem();
        assertTrue(itemsByDateList.size() == 1);
        assertTrue(itemsByDateList.get(0).getItem().size() == 1);
        assertTrue(itemsByDateList.get(0).getItem().get(0).equals(item));
    }

    @Test
    void clearItemsByDate() {
        storageService.clearAllItems();

        storageService.addItem(StaticItemUtil.getItem_Bread_1_EUR(), StaticDateUtil.getDate_2017_05_20());
        storageService.addItem(StaticItemUtil.getItem_Bread_1_EUR(), StaticDateUtil.getDate_2017_05_21());
        storageService.addItem(StaticItemUtil.getItem_Bread_1_EUR(), StaticDateUtil.getDate_2017_05_22());

        assertFalse(storageService.getSpent().equals(new Spent()));

        storageService.clearItemsByDate(StaticDateUtil.getDate_2017_05_21());

        assertTrue(storageService.getSpent().getListItem().size() == 2);
        assertTrue(storageService.getSpent().getListItem().get(0).getDate().equals((StaticDateUtil.getDate_2017_05_20())));
        assertTrue(storageService.getSpent().getListItem().get(1).getDate().equals((StaticDateUtil.getDate_2017_05_22())));

    }

    @Test
    void clearAllItems() {

        Item item = new Item("testName", 2.2, "USD");
        Date date = StaticDateUtil.getDate_2017_05_20();

        storageService.clearAllItems();
        assertTrue(new Spent().equals(storageService.getSpent()));

        storageService.addItem(item, date);
        Spent spentStorage = storageService.getSpent();
        assertFalse(spentStorage.equals(new Spent()));

    }

    @Test
    void getByDate() {
        storageService.clearAllItems();
        Spent spent = new Spent();
        List<ItemsByDate> itemsByDateList = new ArrayList<>();
        Item item = StaticItemUtil.getItem_Bread_1_EUR();

        Date date_2017_05_20 = StaticDateUtil.getDate_2017_05_20();
        Date date_2017_05_21 = StaticDateUtil.getDate_2017_05_21();

        ItemsByDate itemsByDate_20 = new ItemsByDate();
        itemsByDate_20.setItem(Arrays.asList(item, item));
        itemsByDate_20.setDate(date_2017_05_20);
        itemsByDateList.add(itemsByDate_20);

        ItemsByDate itemsByDate_21 = new ItemsByDate();
        itemsByDate_21.setDate(date_2017_05_21);
        itemsByDate_21.setItem(Arrays.asList(item, item));
        itemsByDateList.add(itemsByDate_21);

        spent.setListItem(itemsByDateList);

        storageService.addItem(item, date_2017_05_20);
        storageService.addItem(item, date_2017_05_20);
        storageService.addItem(item, date_2017_05_21);
        storageService.addItem(item, date_2017_05_21);

        assertTrue(storageService.getSpent().equals(spent));
        ItemsByDate storageItems_2017_05_20 = storageService.getByDate(date_2017_05_20);
        assertTrue(storageItems_2017_05_20.equals(itemsByDate_20));

        ItemsByDate storageItems_2017_05_21 = storageService.getByDate(date_2017_05_21);
        assertTrue(storageItems_2017_05_21.equals(itemsByDate_21));

        assertFalse(storageItems_2017_05_21.equals(itemsByDate_20));
        assertFalse(storageItems_2017_05_20.equals(itemsByDate_21));

        assertFalse(new ItemsByDate().equals(itemsByDate_21));
        assertFalse(storageItems_2017_05_20.equals(new ItemsByDate()));

    }


}