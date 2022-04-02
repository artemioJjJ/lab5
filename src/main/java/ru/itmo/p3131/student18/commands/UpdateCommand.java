package ru.itmo.p3131.student18.commands;

import ru.itmo.p3131.student18.collection.tools.CollectionManager;
import ru.itmo.p3131.student18.commands.tools.parsers.HumanBeingParser;

public class UpdateCommand implements Command {
    private CollectionManager manager;

    public UpdateCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String[] params) {
        if (manager.isIdValid(Integer.parseInt(params[0]))) {
            HumanBeingParser parser = new HumanBeingParser();
            manager.update(parser.update(Integer.parseInt(params[0])));
        } else {
            System.out.println("There is no element with that id.");
        }
    }

    @Override
    public boolean isWithArgs() {
        return true;
    }

    @Override
    public String getName() {
        return "update";
    }
}
