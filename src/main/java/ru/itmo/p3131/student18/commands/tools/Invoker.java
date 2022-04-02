package ru.itmo.p3131.student18.commands.tools;

import ru.itmo.p3131.student18.exeptions.ExcessiveArgsException;
import ru.itmo.p3131.student18.exeptions.NoArgsException;

import javax.naming.InvalidNameException;

public class Invoker {


    public void findCommand(String name, String[] params) throws NoArgsException, ExcessiveArgsException, InvalidNameException {
        if (CommandManager.getSpecificCommand(name) == null)
            throw new InvalidNameException("There is no such command :(");
        else if ((CommandManager.getSpecificCommand(name).isWithArgs() == true) && (params[0] == "")) {
            throw new NoArgsException("This command works with arguments.");
        } else if ((CommandManager.getSpecificCommand(name).isWithArgs() == false) && (params[0] != "")) {
            throw new ExcessiveArgsException("This command works w/o arguments.");
        }
        CommandManager.getSpecificCommand(name).execute(params);
    }

}
