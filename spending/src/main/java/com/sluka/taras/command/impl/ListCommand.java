package com.sluka.taras.command.impl;

import com.sluka.taras.command.CommandReqExcConstant;
import com.sluka.taras.data.jaxb.impl.StorageServiceImpl;
import com.sluka.taras.data.storage.StorageService;
import com.sluka.taras.out.OutService;
import com.sluka.taras.out.impl.OutConsoleServiceImpl;
import org.apache.log4j.Logger;

public class ListCommand extends AbstractCommand {
    private static final Logger LOGGER = Logger.getLogger(ListCommand.class);
    private final String reqEx = CommandReqExcConstant.REQ_EX_LIST_COMMAND;
    private OutService outService = new OutConsoleServiceImpl();
    private StorageService storageService = new StorageServiceImpl();

    public ListCommand() {
        super.reqEx = reqEx;
    }

    @Override
    public void execute(String request) {
        LOGGER.debug("execute  list command");
        outService.printSpent(storageService.getSpent());
    }
}
