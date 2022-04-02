package ru.itmo.p3131.student18.commands.tools.readers;

import ru.itmo.p3131.student18.commands.tools.Invoker;
import ru.itmo.p3131.student18.exeptions.ExcessiveArgsException;
import ru.itmo.p3131.student18.exeptions.NoArgsException;

import javax.naming.InvalidNameException;
import java.util.Scanner;

public class RawParametersCommandReader {
    private String[] arraysOfParams = {""};

    public String[] getArrayOfParams() {
        return this.arraysOfParams;
    }

    public void start(String data) {
        Invoker invoker = new Invoker();
        Scanner commandScanner = new Scanner(data);
        while (commandScanner.hasNextLine()) {
            //System.out.println("Insert a command name or \"help\" to get list of ru.itmo.p3131.student18.commands:");
            arraysOfParams = commandScanner.nextLine().split(" +");
            String[] params = {""};
            if (arraysOfParams.length > 1) {
                params = new String[arraysOfParams.length - 1];
                System.arraycopy(arraysOfParams, 1, params, 0, arraysOfParams.length - 1);
            }
            if (params.length <= 1) {
                try {
                    invoker.findCommand(arraysOfParams[0], params);
                } catch (InvalidNameException | NoArgsException | ExcessiveArgsException e) {
                    //System.out.println(e.getMessage());
                }
            }
        }
        commandScanner.close();
    }
}

