package com.sluka.taras.command.impl;

import com.sluka.taras.command.CommandReqExcConstant;
import com.sluka.taras.data.jaxb.impl.StorageServiceImpl;
import com.sluka.taras.data.storage.StorageService;
import com.sluka.taras.util.DateUtil;
import org.apache.log4j.Logger;

import java.util.Date;

public class ClearByDateCommand extends AbstractCommand {
    private static final Logger LOGGER = Logger.getLogger(ClearByDateCommand.class);
    private static String reqEx = CommandReqExcConstant.REQ_EX_CLEAR_BY_DATE_COMMAND;
    private StorageService storageService = new StorageServiceImpl();

    public ClearByDateCommand() {
        super.reqEx = reqEx;
    }

    @Override
    public void execute(String request) {
        LOGGER.debug("execute method clear items by Date");
        String parameter = getParameterCommand(request);
        Date date = DateUtil.dateOfString(parameter);
        storageService.clearItemsByDate(date);
    }

}