package ru.itmo.p3131.student18.commands;

import ru.itmo.p3131.student18.commands.tools.parsers.FileParser;
import ru.itmo.p3131.student18.commands.tools.readers.RawParametersCommandReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;


public class ExecuteScriptCommand implements Command {
    private static Set<File> executedScripts = new HashSet<>();

    @Override
    public boolean isWithArgs() {
        return true;
    }

    @Override
    public void execute(String[] params) {
        try {
            FileParser parser = new FileParser(params[0]);
            if (!executedScripts.add(parser.getFilePath())) {
                throw new RuntimeException("This file has been already executed.");
            } else {
                RawParametersCommandReader commandReader = new RawParametersCommandReader();
                try {
                    commandReader.start(parser.parseToString());
                } catch (NullPointerException e) {
                    System.out.println("File is empty.");
                }
                executedScripts.remove(parser.getFilePath());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No such file.");
        } catch (RuntimeException e) {
            System.out.println("\nThere is a recursion. Script won't continue working.");
        }
    }

    @Override
    public String getName() {
        return "execute_script";
    }
}
