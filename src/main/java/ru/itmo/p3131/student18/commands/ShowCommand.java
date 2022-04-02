package ru.itmo.p3131.student18.commands;

import ru.itmo.p3131.student18.collection.tools.CollectionManager;

public class ShowCommand implements Command {
    private CollectionManager manager;

    public ShowCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String[] params) {
        manager.show();
    }

    @Override
    public boolean isWithArgs() {
        return false;
    }

    @Override
    public String getName() {
        return "show";
    }
}
