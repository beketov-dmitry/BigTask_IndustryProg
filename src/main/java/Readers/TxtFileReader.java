package Readers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TxtFileReader {
    public String read(String filename) {
        try {
            FileInputStream fileInputStream = new FileInputStream("__fixtures__/" + filename);
            Scanner scanner = new Scanner(fileInputStream);
            StringBuilder res = null;
            while(scanner.hasNextLine()){
                res.append(scanner.nextLine());
                res.append("\n");
            }
            return new String(res);
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
