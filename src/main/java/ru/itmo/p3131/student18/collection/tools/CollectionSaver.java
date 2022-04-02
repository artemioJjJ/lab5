package ru.itmo.p3131.student18.collection.tools;

import com.google.gson.Gson;
import ru.itmo.p3131.student18.collection.CustomStack;
import ru.itmo.p3131.student18.objectclasses.HumanBeing;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CollectionSaver {
    private File writingFile;

    public CollectionSaver(File file) {
        writingFile = file;
    }

    public void save(CustomStack<HumanBeing> stack) {
        if (writingFile.canWrite()) {
            Gson gson = new Gson();
            String json = gson.toJson(stack);
            byte[] buffer = json.getBytes(StandardCharsets.UTF_8);
            System.out.println(json);
            try (BufferedOutputStream outPut = new BufferedOutputStream((new FileOutputStream(writingFile)))) {
                outPut.write(buffer, 0, buffer.length);
            } catch (FileNotFoundException e) {
                System.out.println("No such file in project directory.");
            } catch (IOException e) {
                System.out.println("Failed to reach the file.");
            }
        } else {
            System.out.println("User have no right to write to the file.");
        }
    }
}
