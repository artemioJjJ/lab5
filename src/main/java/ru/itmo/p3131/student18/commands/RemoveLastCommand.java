package ru.itmo.p3131.student18.commands;

import ru.itmo.p3131.student18.collection.tools.CollectionManager;

public class RemoveLastCommand implements Command {
    private CollectionManager manager;

    public RemoveLastCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean isWithArgs() {
        return false;
    }

    @Override
    public void execute(String[] params) {
        manager.remove_last();
    }

    @Override
    public String getName() {
        return "remove_last";
    }
}
