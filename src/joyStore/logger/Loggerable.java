package joyStore.logger;

import java.io.IOException;

public interface Loggerable {
    void log(String text) throws IOException;
}
