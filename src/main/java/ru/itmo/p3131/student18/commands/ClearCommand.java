package ru.itmo.p3131.student18.commands;

import ru.itmo.p3131.student18.collection.tools.CollectionManager;
import ru.itmo.p3131.student18.commands.tools.readers.DataReader;

public class ClearCommand implements Command {
    private CollectionManager manager;

    public ClearCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean isWithArgs() {
        return false;
    }

    @Override
    public void execute(String[] params) {
        if (new DataReader().ensurance()) {
            manager.clear();
        } else {
            System.out.println("Nothing changed.");
        }
    }

    @Override
    public String getName() {
        return "clear";
    }
}
