package com.sluka.taras.data.jaxb.impl;

import com.sluka.taras.data.model.Item;
import com.sluka.taras.data.model.ItemsByDate;
import com.sluka.taras.data.model.Spent;
import com.sluka.taras.data.storage.StorageService;
import com.sluka.taras.util.PropertyName;
import com.sluka.taras.util.PropertyUtils;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class StorageServiceImpl implements StorageService {
    private static final Logger LOGGER = Logger.getLogger(StorageServiceImpl.class);

    @Override
    public Spent getSpent() {
        LOGGER.debug("get Spent");
        File file = getFile();
        Spent spent = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Spent.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            jaxbUnmarshaller.unmarshal(file);
            spent = (Spent) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return spent;
    }

    private void setSpent(Spent spent, File file) {
        LOGGER.debug("set spent");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Spent.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            spent = sortSpent(spent);
            jaxbMarshaller.marshal(spent, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private Spent sortSpent(Spent spent) {
        List<ItemsByDate> itemsByDates = spent.getListItem();
        itemsByDates.sort((o1, o2) -> o1.getDate().compareTo(o2.getDate()));
        return spent;
    }

    @Override
    public void addItem(Item item, Date date) {
        Spent spent = getSpent();
        List<ItemsByDate> itemsByDates = spent.getListItem();
        boolean f = false;
        if (itemsByDates != null) {
            for (ItemsByDate itemsByDate : itemsByDates) {
                if (date.equals(itemsByDate.getDate())) {
                    List<Item> tmp = new ArrayList<>(itemsByDate.getItem());
                    tmp.add(item);
                    itemsByDate.setItem(tmp);
                    f = true;
                    break;
                }
            }
            if (!f) {
                ItemsByDate itemsByDate = new ItemsByDate();
                itemsByDate.setDate(date);
                itemsByDate.setItem(Arrays.asList(item));
                List<ItemsByDate> list = spent.getListItem();
                list.add(itemsByDate);
                spent.setListItem(list);
            }
        } else {
            ItemsByDate itemsByDate = new ItemsByDate();
            itemsByDate.setDate(date);
            itemsByDate.setItem(Arrays.asList(item));
            spent.setListItem(Arrays.asList(itemsByDate));
        }
        setSpent(spent, getFile());
    }

    @Override
    public void clearItemsByDate(Date date) {
        LOGGER.debug("clear items by date: " + date);
        Spent spent = getSpent();
        List<ItemsByDate> itemsByDates = spent.getListItem();
        for (ItemsByDate itemsByDate : itemsByDates) {
            if (itemsByDate.getDate().equals(date)) {
                itemsByDates.remove(itemsByDate);
                break;
            }
        }
        setSpent(spent, getFile());
    }

    @Override
    public void clearAllItems() {
        File file = getFile();
        if (file.delete()) {
            LOGGER.debug("clear All Items");
        } else {
            LOGGER.error("eclear All Items ");
        }
    }

    @Override
    public ItemsByDate getByDate(Date date) {
        LOGGER.debug("get items by date: " + date);
        ItemsByDate result = null;
        List<ItemsByDate> itemsByDates = getSpent().getListItem();
        for (ItemsByDate itemsByDate : itemsByDates) {
            if (itemsByDate.getDate().equals(date)) {
                result = itemsByDate;
                break;
            }
        }
        return result;
    }

    private File getFile() {
        File file = new File(PropertyUtils.getProperty(PropertyName.FILE_PATH));
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            setSpent(new Spent(), file);
        }
        return file;
    }
}
