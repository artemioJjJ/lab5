package ru.itmo.p3131.student18.commands.tools.readers;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class provides console input for
 * 1) initialization(user inserts name of file, which contains data structure with objects)
 * 2) exiting program, for which user have to accept that he is going to close program.
 */
public class DataReader {
    private boolean Successful_Scanning = false;

    public String nameOfFileScanning() {
        String nameOfFile = "";
        System.out.println("Insert json file name:");
        try {
            nameOfFile = InputStream.getInstance().nextLine().trim();
        } catch (NoSuchElementException e) {
            System.out.println("No value was found.");
        }
        return nameOfFile;
    }

    public boolean ensurance() {
        String answer = "";
        while (!Successful_Scanning) {
            System.out.println("Are you sure? (yes/no)");
            answer = InputStream.getInstance().nextLine().trim();
            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                Successful_Scanning = true;
                return true;
            } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                Successful_Scanning = true;
                return false;
            } else {
                System.out.println("........／＞　   フ.....................\n" +
                                   "　　　　　| 　_　 _|\n" +
                                   "　 　　　／`ミ _x 彡\n" +
                                   "　　 　 /　　　 　 |\n" +
                                   "　　　 /　 ヽ　　 ﾉ\n" +
                                   "　／￣|　　 |　|　|\n" +
                                   "　| (￣ヽ＿_ヽ_)_)\n" +
                                   "　＼二つ       Хочу да или нет...\n");
            }
        }
        return false;
    }
}