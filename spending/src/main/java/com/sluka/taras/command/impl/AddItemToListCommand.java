package com.sluka.taras.command.impl;

import com.sluka.taras.command.CommandReqExcConstant;
import com.sluka.taras.data.jaxb.impl.StorageServiceImpl;
import com.sluka.taras.data.jaxb.mapper.ItemMapper;
import com.sluka.taras.data.model.Item;
import com.sluka.taras.data.storage.StorageService;
import com.sluka.taras.out.OutService;
import com.sluka.taras.out.impl.OutConsoleServiceImpl;
import org.apache.log4j.Logger;

import java.util.Date;

public class AddItemToListCommand extends AbstractCommand {
    private static final Logger LOGGER = Logger.getLogger(AddItemToListCommand.class);
    private static String reqEx = CommandReqExcConstant.REQ_EX_ADD_COMMAND;

    private OutService outService = new OutConsoleServiceImpl();
    private StorageService storageService = new StorageServiceImpl();

    public AddItemToListCommand() {
        super.reqEx = reqEx;
    }

    @Override
    public void execute(String request) {
        LOGGER.debug("execute command add to items");
        String parameter = getParameterCommand(request);
        Date date = ItemMapper.dateFromCommandAdd(parameter);
        Item item = ItemMapper.itemFromCommandAdd(parameter);
        storageService.addItem(item, date);
        outService.printSpent(storageService.getSpent());
    }

}
