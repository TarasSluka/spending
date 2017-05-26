package com.sluka.taras.data.util;

import com.sluka.taras.data.model.Item;

public class StaticItemUtil {
    public static Item getItem_Water_1_PLN() {
        Item item = new Item();
        item.setCost(3);
        item.setCurrency("PLN");
        item.setName("Water");
        return item;
    }

    public static Item getItem_Bread_1_USD() {
        Item item = new Item();
        item.setCost(1);
        item.setCurrency("USD");
        item.setName("Bread");
        return item;
    }

    public static Item getItem_Bread_2_USD() {
        Item item = new Item();
        item.setCost(2);
        item.setCurrency("USD");
        item.setName("Bread");
        return item;
    }

    public static Item getItem_Bread_1_EUR() {
        Item item = new Item();
        item.setCost(1);
        item.setCurrency("EUR");
        item.setName("Bread");
        return item;
    }

    public static Item getItem_Yogurt_1_EUR() {
        Item item = new Item();
        item.setCost(1);
        item.setCurrency("EUR");
        item.setName("Yogurt");
        return item;
    }

    public static Item getItem_Yogurt_1_USD() {
        Item item = new Item();
        item.setCost(1);
        item.setCurrency("USD");
        item.setName("Yogurt");
        return item;
    }

}
