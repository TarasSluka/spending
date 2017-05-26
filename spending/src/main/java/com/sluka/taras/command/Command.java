package com.sluka.taras.command;

public interface Command {

    void execute(String request);

    boolean isValidSignature(String request);
}
