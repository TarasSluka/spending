package com.sluka.taras.data.util;

import com.sluka.taras.data.model.ItemsByDate;
import com.sluka.taras.data.model.Spent;

import java.util.ArrayList;
import java.util.List;

public class SpentUtil {

    static Spent getSpent_1_date_2017_05_20() {
        Spent spent = new Spent();
        List<ItemsByDate> itemsByDateList = new ArrayList<>();
        itemsByDateList.add(StaticItemByDateUtil.get_3_item_2017_05_20());
        itemsByDateList.add(StaticItemByDateUtil.get_3_item_2017_05_21());
        itemsByDateList.add(StaticItemByDateUtil.get_1_item_2017_05_22());
        spent.setListItem(itemsByDateList);
        return spent;
    }
}
