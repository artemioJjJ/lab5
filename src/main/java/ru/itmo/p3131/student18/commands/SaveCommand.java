package ru.itmo.p3131.student18.commands;

import ru.itmo.p3131.student18.collection.tools.CollectionManager;
import ru.itmo.p3131.student18.collection.tools.CollectionSaver;

public class SaveCommand implements Command {
    private CollectionManager manager;

    public SaveCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean isWithArgs() {
        return false;
    }

    @Override
    public void execute(String[] params) {
        if (manager.getInputFile() != null) {
            CollectionSaver saver = new CollectionSaver(manager.getInputFile());
            saver.save(manager.getStack());
            System.out.println("Collection is saved.");
        } else {
            System.out.println("Collection was not loaded from any file.");
        }
    }

    @Override
    public String getName() {
        return "save";
    }
}
