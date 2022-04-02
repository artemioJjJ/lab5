package ru.itmo.p3131.student18.commands;

import ru.itmo.p3131.student18.collection.tools.CollectionManager;

public class RemoveFirstCommand implements Command {
    private CollectionManager manager;

    public RemoveFirstCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean isWithArgs() {
        return false;
    }

    @Override
    public void execute(String[] params) {
        manager.remove_first();
    }

    @Override
    public String getName() {
        return "remove_first";
    }
}
