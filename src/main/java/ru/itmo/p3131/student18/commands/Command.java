package ru.itmo.p3131.student18.commands;

public interface Command {
    boolean isWithArgs();

    void execute(String[] params);

    String getName();
}
