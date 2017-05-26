package com.sluka.taras.command.impl;

import com.sluka.taras.command.CommandReqExcConstant;
import com.sluka.taras.util.ScannerSingleton;
import org.apache.log4j.Logger;

public class ExitCommand extends AbstractCommand {
    private static final Logger LOGGER = Logger.getLogger(ExitCommand.class);
    private static String reqEx = CommandReqExcConstant.REQ_EX_EXIT_COMMAND;

    public ExitCommand() {
        super.reqEx = reqEx;
    }

    @Override
    public void execute(String request) {
        LOGGER.debug("execute  exit command");
        ScannerSingleton.getInstance().closeScanner();// Close scanner
        System.out.println("Bye:)");
        System.exit(0);
    }


}
