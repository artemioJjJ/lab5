package ru.itmo.p3131.student18.commands;

import ru.itmo.p3131.student18.commands.tools.readers.ConsoleCommandReader;

public class ExitCommand implements Command {

    @Override
    public boolean isWithArgs() {
        return false;
    }

    @Override
    public void execute(String[] params) {
        ConsoleCommandReader.finish();
        System.out.println("Program stops working. Good bye!");
    }

    @Override
    public String getName() {
        return "exit";
    }
}
