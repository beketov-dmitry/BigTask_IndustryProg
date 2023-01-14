package Encryptions;
import Readers.ExpressionContainer;
import Readers.JsonFileReader;
import org.mariuszgromada.math.mxparser.Expression;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Calculate {
    public static String defineMathExpression(ExpressionContainer expressionContainer, String inputFile){

        String calculateFileName = "calculate-" + inputFile.split("\\.")[0] + ".json";
        ExpressionContainer calculateExpressionContainer = new ExpressionContainer();

        for(String data : expressionContainer.expressions) {
            Expression e = new Expression(data);
            Double res = e.calculate();
            calculateExpressionContainer.expressions.add(res.toString());
        }
        JsonFileReader.write(calculateFileName, calculateExpressionContainer);

        return calculateFileName;
    }
}
