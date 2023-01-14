package Readers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TxtFileReader {
    public static ExpressionContainer read(String filename) {
        try {
            ExpressionContainer expressionContainer = new ExpressionContainer();
            FileInputStream fileInputStream = new FileInputStream("__fixtures__/" + filename);
            Scanner scanner = new Scanner(fileInputStream);

            while(scanner.hasNextLine()){
                expressionContainer.expressions.add(scanner.nextLine());
            }

            return expressionContainer;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(String filename, String data){
        try {
            PrintWriter printWriter = new PrintWriter("__fixtures__/" + filename);
            printWriter.println(data);
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
