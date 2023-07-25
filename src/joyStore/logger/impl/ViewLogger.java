package joyStore.logger.impl;


import joyStore.dao.impl.DataBase;
import joyStore.logger.Loggerable;

import java.io.IOException;
import java.time.LocalDateTime;

public class ViewLogger implements Loggerable {
    private DataBase db;

    public ViewLogger(DataBase dataBase) {
        this.db = new DataBase();
    }

    @Override
    public void log(String text) throws IOException {
        db.add(String.format("%s. Введенное значение: %s \n", LocalDateTime.now(), text));
    }
}
