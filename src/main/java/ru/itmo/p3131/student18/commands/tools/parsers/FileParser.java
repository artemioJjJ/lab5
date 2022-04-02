package ru.itmo.p3131.student18.commands.tools.parsers;

import ru.itmo.p3131.student18.commands.tools.readers.DataReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileParser {
    private boolean parsingIsComplete = false;
    private File pathToFile;
    private Scanner fileDataScanner;

    public FileParser() {
        this.fileDataScanner = getScannerWithFile();
    }

    public FileParser(String name) throws FileNotFoundException {
        this.fileDataScanner = new Scanner(fileBuilder(name));
    }

    public String parseToString() {
        String data = "";
        while (!parsingIsComplete) {
            try {
                while (fileDataScanner.hasNextLine()) {
                    String line = fileDataScanner.nextLine();
                    data += line + "\n";
                }
                parsingIsComplete = true;
                fileDataScanner.close();
            } catch (NoSuchElementException e) {
                System.out.println("This field can not be empty.");
            }
        }
        return data;
    }

    private Scanner getScannerWithFile() {
        boolean nameOfFileIsScanned = false;
        while (!nameOfFileIsScanned) {
            try {
                fileDataScanner = new Scanner(fileBuilder());
                nameOfFileIsScanned = true;
            } catch (FileNotFoundException e) {
                System.out.println("No such file in project directory.");
            }
        }
        return fileDataScanner;
    }

    public File fileBuilder() {
        try {
            String fileName = new DataReader().nameOfFileScanning().trim();
            File directory = new File("");
            pathToFile = new File(directory.getCanonicalPath() + "\\src\\main\\resources\\Json\\" + fileName + ".json");
            if (!pathToFile.canRead() && pathToFile.exists()) {
                throw new SecurityException("User have no right to read file.");
            }
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Couldn't get absolute path.");
        }
        return pathToFile;
    }

    /**This method creates and returns an object of class File, which is saved in CollectionManager for "save" command.
     *
     * @param fileName name of file, which is used for creation of a File object.
     * @return File pathToFile
     */
    public File fileBuilder(String fileName) {
        try {
            File directory = new File("");
            pathToFile = new File(directory.getCanonicalPath() + "\\src\\main\\resources\\" + fileName + ".txt");
        } catch (IOException e) {
            System.out.print("");
        }
        return pathToFile;
    }

    public File getFilePath() {
        return pathToFile;
    }
}

