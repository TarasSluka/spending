package com.sluka.taras.command.exception;

import com.sluka.taras.exeption.SpentException;
import com.sluka.taras.util.PropertyName;
import com.sluka.taras.util.PropertyUtils;

public class UndefinedCommandException extends SpentException {

    private static String undefinedCommand =
            "\nundefined command" +
                    "\n\tthis system support next type request" + "\n\t" +
                    PropertyUtils.getProperty(PropertyName.EXCEPTION_MESSAGE_BY_COMMAND_ADD) + "\n\t" +
                    PropertyUtils.getProperty(PropertyName.EXCEPTION_MESSAGE_BY_COMMAND_LIST) + "\n\t" +
                    PropertyUtils.getProperty(PropertyName.EXCEPTION_MESSAGE_BY_COMMAND_CLEAR_BY_DATE) + "\n\t" +
                    PropertyUtils.getProperty(PropertyName.EXCEPTION_MESSAGE_BY_COMMAND_TOTAL) + "\n\t" +
                    PropertyUtils.getProperty(PropertyName.EXCEPTION_MESSAGE_BY_COMMAND_EXIT);

    public UndefinedCommandException() {
        super(undefinedCommand);
    }

    public static void main(String[] args) {
        System.out.println(undefinedCommand);
    }
}
