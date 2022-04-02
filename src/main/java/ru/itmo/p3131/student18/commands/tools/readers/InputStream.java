package ru.itmo.p3131.student18.commands.tools.readers;

import java.util.Scanner;

public class InputStream {
    private static Scanner inputScanner;

    private InputStream() {
        inputScanner = new Scanner(System.in);
    }

    public static Scanner getInstance() {
        if (inputScanner == null) {
            new InputStream();
        } return inputScanner;
    }

}
