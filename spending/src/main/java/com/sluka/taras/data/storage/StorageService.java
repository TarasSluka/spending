package com.sluka.taras.data.storage;

import com.sluka.taras.data.model.Item;
import com.sluka.taras.data.model.ItemsByDate;
import com.sluka.taras.data.model.Spent;

import java.util.Date;

public interface StorageService {

    Spent getSpent();

    void addItem(Item item, Date date);

    void clearItemsByDate(Date date);

    void clearAllItems();

    ItemsByDate getByDate(Date date);


}
