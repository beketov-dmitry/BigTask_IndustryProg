import org.mariuszgromada.math.mxparser.Expression;

import java.io.*;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("__fixtures__/input.txt");
        Scanner scanner = new Scanner(fileInputStream);
        PrintWriter printWriter = new PrintWriter(new File("__fixtures__/output.txt"));

        FileInputStream fis = new FileInputStream("__fixtures__/input.txt");
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("__fixtures__/archive.zip"));
        ZipEntry zipEntry = new ZipEntry("exp.txt");
        zout.putNextEntry(zipEntry);
        zout.write(buffer);
        zout.closeEntry();
        zout.close();

        String exp = scanner.nextLine();

        Expression e = new Expression(exp);
        Double res = e.calculate();
        printWriter.println(res);
        printWriter.close();
    }
}
