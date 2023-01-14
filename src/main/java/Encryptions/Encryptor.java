package Encryptions;

import Readers.ExpressionContainer;
import Readers.JsonFileReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;

public class Encryptor {
    public static String decode(ExpressionContainer expressionContainer, String inputFile) {
        String deEncryptFileName = "deEncrypt-" + inputFile.split("\\.")[0] + ".json";
        ExpressionContainer decryptContainer = new ExpressionContainer();

        for (String data : expressionContainer.expressions) {
            byte[] decodedBytes = Base64.getDecoder().decode(data);
            String decodedString = new String(decodedBytes);
            decryptContainer.expressions.add(decodedString);
        }

        JsonFileReader.write(deEncryptFileName, decryptContainer);
        return deEncryptFileName;
    }
}
