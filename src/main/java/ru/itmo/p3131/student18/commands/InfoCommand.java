package ru.itmo.p3131.student18.commands;

import ru.itmo.p3131.student18.collection.tools.CollectionManager;

public class InfoCommand implements Command {
    private CollectionManager manager;

    public InfoCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String[] params) {
        manager.info();
    }

    /**
     * @return Method returns true if command uses arguments and false if it doesn't
     */
    @Override
    public boolean isWithArgs() {
        return false;
    }

    @Override
    public String getName() {
        return "info";
    }

}
