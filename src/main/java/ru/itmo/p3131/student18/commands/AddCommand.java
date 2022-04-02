package ru.itmo.p3131.student18.commands;

import ru.itmo.p3131.student18.collection.tools.CollectionManager;
import ru.itmo.p3131.student18.commands.tools.parsers.HumanBeingParser;

public class AddCommand implements Command {
    private CollectionManager manager;

    public AddCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String[] params) {
        HumanBeingParser parser = new HumanBeingParser();
        manager.add(parser.create());
    }

    @Override
    public boolean isWithArgs() {
        return false;
    }

    @Override
    public String getName() {
        return "add";
    }
}
