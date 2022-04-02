package ru.itmo.p3131.student18.commands;

import ru.itmo.p3131.student18.collection.tools.CollectionManager;

public class RemoveGreaterCommand implements Command {
    private CollectionManager manager;

    public RemoveGreaterCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean isWithArgs() {
        return true;
    }

    @Override
    public void execute(String[] params) {
        manager.remove_greater(Integer.parseInt(params[0]));
    }

    @Override
    public String getName() {
        return "remove_greater";
    }
}
