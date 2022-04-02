package ru.itmo.p3131.student18.commands;

import ru.itmo.p3131.student18.collection.tools.CollectionManager;
import ru.itmo.p3131.student18.commands.tools.parsers.HumanBeingParser;

public class RemoveByIdCommand implements Command {
    private CollectionManager manager;

    public RemoveByIdCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean isWithArgs() {
        return true;
    }

    @Override
    public void execute(String[] params) {
        if (manager.isIdValid(Integer.parseInt(params[0]))) {
            HumanBeingParser parser = new HumanBeingParser();
            manager.remove_by_id(Integer.parseInt(params[0]));
        } else {
            System.out.println("There is no element with that id.");
        }
    }

    @Override
    public String getName() {
        return "remove";
    }
}
