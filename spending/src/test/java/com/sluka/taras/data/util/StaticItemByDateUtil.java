package com.sluka.taras.data.util;

import com.sluka.taras.data.model.Item;
import com.sluka.taras.data.model.ItemsByDate;
import com.sluka.taras.util.StaticDateUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StaticItemByDateUtil {

    public static ItemsByDate get_3_item_2017_05_20() {
        ItemsByDate itemsByDate = new ItemsByDate();
        itemsByDate.setDate(StaticDateUtil.getDate_2017_05_20());
        List<Item> itemList = new ArrayList<>();
        itemList.add(StaticItemUtil.getItem_Bread_1_EUR());
        itemList.add(StaticItemUtil.getItem_Yogurt_1_EUR());
        itemList.add(StaticItemUtil.getItem_Water_1_PLN());
        itemsByDate.setItem(itemList);
        return itemsByDate;
    }

    public static ItemsByDate get_3_item_2017_05_21() {
        ItemsByDate itemsByDate = new ItemsByDate();
        itemsByDate.setDate(StaticDateUtil.getDate_2017_05_20());
        List<Item> itemList = new ArrayList<>();
        itemList.add(StaticItemUtil.getItem_Bread_1_EUR());
        itemList.add(StaticItemUtil.getItem_Yogurt_1_USD());
        itemList.add(StaticItemUtil.getItem_Water_1_PLN());
        itemsByDate.setItem(itemList);
        return itemsByDate;
    }

    public static ItemsByDate get_1_item_2017_05_22() {
        ItemsByDate itemsByDate = new ItemsByDate();
        itemsByDate.setDate(StaticDateUtil.getDate_2017_05_20());
        itemsByDate.setItem(Arrays.asList(StaticItemUtil.getItem_Water_1_PLN()));
        return itemsByDate;
    }


}
