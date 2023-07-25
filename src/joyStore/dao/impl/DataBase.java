package joyStore.dao.impl;

import joyStore.dao.DB;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class DataBase implements DB {
    public final File dataBase = new File("LogsDataBase.txt");
    @Override
    public void add(String text) throws IOException {
        Writer logsWriter = new FileWriter(dataBase, true);
        logsWriter.write(text);
        logsWriter.close();
    }
}
