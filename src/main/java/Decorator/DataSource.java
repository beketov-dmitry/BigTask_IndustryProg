package Decorator;

import java.io.IOException;

public interface DataSource {
    void writeData(String data);

    String readData() throws IOException;
}
