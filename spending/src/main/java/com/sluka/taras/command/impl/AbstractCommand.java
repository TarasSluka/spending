package com.sluka.taras.command.impl;

import com.sluka.taras.command.Command;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(AbstractCommand.class);
    protected String reqEx;

    protected String getParameterCommand(String request) {
        request = request.trim();
        LOGGER.debug("getParameterCommand() from: " + request);
        String[] name = request.split(" ", 2);
        String result = null;
        if (name.length > 0)
            result = name[1];
        LOGGER.debug("it is : " + request);
        return result;
    }

    public boolean isValidSignature(String request) {
        request = request.trim();
        assert request != null;
        Pattern p = Pattern.compile(reqEx);
        Matcher m = p.matcher(request);
        return m.matches();
    }
}
