package com.sluka.taras;

import com.sluka.taras.command.Command;
import com.sluka.taras.command.exception.UndefinedCommandException;
import com.sluka.taras.command.factory.CommandFactory;
import com.sluka.taras.exeption.SpentException;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Application {
    private static final Logger LOGGER = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Hello");
            Scanner scanner = new Scanner(System.in);
            CommandFactory commandFactory = CommandFactory.getInstance();
            String request = null;
            while (true) {
                System.out.print(">  ");
                request = scanner.nextLine();
                if (request.equals(""))
                    continue;
                request = request.trim();
                try {
                    Command command = commandFactory.getCommand(request);
                    if (!command.isValidSignature(request)) {
                        throw new UndefinedCommandException();
                    }
                    command.execute((request));
                } catch (SpentException e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            System.out.println("the system don't support Command-Line Arguments");
        }
    }
}

