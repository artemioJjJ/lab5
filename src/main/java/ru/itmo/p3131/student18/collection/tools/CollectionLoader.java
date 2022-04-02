package ru.itmo.p3131.student18.collection.tools;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import ru.itmo.p3131.student18.collection.CustomStack;
import ru.itmo.p3131.student18.commands.tools.parsers.FileParser;
import ru.itmo.p3131.student18.commands.tools.parsers.HumanBeingParser;
import ru.itmo.p3131.student18.objectclasses.HumanBeing;

import java.io.File;
import java.lang.reflect.Type;

public class CollectionLoader {
    private final Gson gson;
    private final FileParser fileParser;
    private File file;

    public CollectionLoader(Gson gson) {
        this.gson = gson;
        this.fileParser = new FileParser();
    }

    public CustomStack<HumanBeing> execute() throws JsonSyntaxException {
        Type humanType = new TypeToken<CustomStack<HumanBeing>>() {
        }.getType();
        CustomStack<HumanBeing> tmpStack = gson.fromJson(fileParser.parseToString(), humanType);
        file = fileParser.getFilePath();
        HumanBeingParser initParser = new HumanBeingParser();
        for (HumanBeing human : tmpStack) {
            initParser.initCheck(human);
        }
        return tmpStack;
    }

    public File getFile() {
        return file;
    }
}


