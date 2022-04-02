package ru.itmo.p3131.student18.commands.tools.readers;

import ru.itmo.p3131.student18.commands.tools.Invoker;
import ru.itmo.p3131.student18.exeptions.ExcessiveArgsException;
import ru.itmo.p3131.student18.exeptions.NoArgsException;

import javax.naming.InvalidNameException;

public class ConsoleCommandReader {
    private static boolean isFinished = false;
    private String[] arraysOfParams = {""};

    public static void finish() {
        isFinished = true;
        InputStream.getInstance().close();
    }

    public String[] getArrayOfParams() {
        return this.arraysOfParams;
    }

    public void startScanning() {
        Invoker invoker = new Invoker();
        while (!isFinished) {
            System.out.println("Insert a command name or \"help\" to get list of commands:");
            arraysOfParams = InputStream.getInstance().nextLine().trim().split(" +");
            String[] params = {""};
            if (arraysOfParams.length > 1) {
                params = new String[arraysOfParams.length - 1];
                System.arraycopy(arraysOfParams, 1, params, 0, arraysOfParams.length - 1);
            }
            if (params.length <= 1) {
                try {
                    invoker.findCommand(arraysOfParams[0], params);
                } catch (InvalidNameException | NoArgsException | ExcessiveArgsException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Use \"help\" to get list of commands and their parameters.");
            }
        }
    }
}
