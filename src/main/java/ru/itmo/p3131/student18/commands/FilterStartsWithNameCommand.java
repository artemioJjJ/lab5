package ru.itmo.p3131.student18.commands;

import ru.itmo.p3131.student18.collection.tools.CollectionManager;

public class FilterStartsWithNameCommand implements Command {
    private CollectionManager manager;

    public FilterStartsWithNameCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean isWithArgs() {
        return true;
    }

    @Override
    public void execute(String[] params) {
        manager.filter_starts_with_name(params[0]);
    }

    @Override
    public String getName() {
        return "filter_starts_with_name";
    }
}
