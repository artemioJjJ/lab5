package ru.itmo.p3131.student18.commands.tools;

import ru.itmo.p3131.student18.collection.tools.CollectionManager;
import ru.itmo.p3131.student18.commands.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CommandManager {
    private static final Map<String, Command> commands = new HashMap<>();

    public CommandManager(CollectionManager manager) {
        registerCommand(new HelpCommand());
        registerCommand(new AddCommand(manager));
        registerCommand(new InfoCommand(manager));
        registerCommand(new ShowCommand(manager));
        registerCommand(new UpdateCommand(manager));
        registerCommand(new RemoveByIdCommand(manager));
        registerCommand(new ClearCommand(manager));
        registerCommand(new ExitCommand());
        registerCommand(new RemoveFirstCommand(manager));
        registerCommand(new RemoveLastCommand(manager));
        registerCommand(new RemoveGreaterCommand(manager));
        registerCommand(new CountByImpactSpeedCommand(manager));
        registerCommand(new FilterStartsWithNameCommand(manager));
        registerCommand(new FilterLessThanImpactSpeedCommand(manager));
        registerCommand(new SaveCommand(manager));
        registerCommand(new ExecuteScriptCommand());
    }

    public static Map getCommands() {
        return commands;
    }

    /**
     * Method of a class CommandManager which returns a Command by its name, if this command is registered to static
     * HashMap "java.ru.itmo.p3131.student18.commands" of class CommandManager.
     *
     * @param name
     * @return Command
     */
    public static Command getSpecificCommand(String name) {
        return commands.get(name.toLowerCase(Locale.ROOT));
    }

    private void registerCommand(Command command) {
        commands.put(command.getName(), command);
    }

}
