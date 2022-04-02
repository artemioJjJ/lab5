package ru.itmo.p3131.student18;

import ru.itmo.p3131.student18.collection.tools.CollectionManager;
import ru.itmo.p3131.student18.commands.tools.CommandManager;
import ru.itmo.p3131.student18.commands.tools.readers.ConsoleCommandReader;

public class Main {
    public static void main(String[] args) {

        CollectionManager collectionManager = new CollectionManager();
        CommandManager commandManager = new CommandManager(collectionManager);
        ConsoleCommandReader consoleReader = new ConsoleCommandReader();
        consoleReader.startScanning();

    }

}
/*Runtime.getRuntime().addShutdownHook(new Thread(()->{

        }));*/ // Это для создания закрывающего потока в случае прерывания








