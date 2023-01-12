package Encryptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.Scanner;

public class Encryptor {
    public static String decode(String inputFile) {
        try {
            FileInputStream fileInputStream = new FileInputStream("__fixtures__/" + inputFile);
            Scanner scanner = new Scanner(fileInputStream);
            String data = scanner.nextLine();

            byte[] decodedBytes = Base64.getDecoder().decode(data);
            String decodedString = new String(decodedBytes);

            System.out.println(decodedString);

            return decodedString;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
