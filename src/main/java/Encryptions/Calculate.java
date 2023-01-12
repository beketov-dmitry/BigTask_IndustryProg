package Encryptions;
import org.mariuszgromada.math.mxparser.Expression;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Calculate {
    public static void defineMathExpression(String data, String outputFile){
        try {

            PrintWriter printWriter = new PrintWriter("__fixtures__/" + outputFile);

            Expression e = new Expression(data);
            Double res = e.calculate();

            printWriter.println(res);
            printWriter.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
