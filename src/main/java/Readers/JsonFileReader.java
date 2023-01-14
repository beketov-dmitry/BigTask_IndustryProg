package Readers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileReader {
    public static ExpressionContainer read(String filename) {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader("__fixtures__/" + filename);
            ExpressionContainer expressionContainer = gson.fromJson(reader, ExpressionContainer.class);
            reader.close();
            return expressionContainer;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void write(String filename, ExpressionContainer container){
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = Files.newBufferedWriter(Paths.get("__fixtures__/" + filename));
            gson.toJson(container, writer);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
