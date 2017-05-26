package com.sluka.taras.command.factory;

import com.sluka.taras.command.Command;
import com.sluka.taras.command.CommandNameConstant;
import com.sluka.taras.command.exception.UndefinedCommandException;
import com.sluka.taras.command.impl.*;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static final Logger LOGGER = Logger.getLogger(CommandFactory.class);
    private static CommandFactory instance = null;
    private final Map<String, Command> COMMANDS_MAP;

    private CommandFactory() {
        LOGGER.debug("change commands map to unmodifiable");
        COMMANDS_MAP = Collections.unmodifiableMap(initCommands());
    }

    public synchronized static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

    private static Map<String, Command> initCommands() {
        LOGGER.debug("initial commands map ");
        Map<String, Command> commands = new HashMap<>();
        // Add all commands to map
        commands.put(CommandNameConstant.ADD, new AddItemToListCommand());
        commands.put(CommandNameConstant.EXIT, new ExitCommand());
        commands.put(CommandNameConstant.TOTAL, new TotalCommand());
        commands.put(CommandNameConstant.LIST, new ListCommand());
        commands.put(CommandNameConstant.CLEAR, new ClearByDateCommand());
        return commands;
    }

    public Command getCommand(String request) {
        LOGGER.debug("get command width name: " + request);
        String commandName = getNameCommand(request);
        Command command = COMMANDS_MAP.get(commandName);
        if (command == null) {
            throw new UndefinedCommandException();
        }
        return command;
    }

    private String getNameCommand(String request) {
        String[] name = request.split(" ", 2);
        LOGGER.debug("execute getNameCommand() and it is : " + name[0]);
        return name[0];
    }
}
