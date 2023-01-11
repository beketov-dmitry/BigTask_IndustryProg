import Archivates.ZipArchivate;
import Encryptions.Calculate;
import Encryptions.Encryptor;
import Readers.ExpressionContainer;
import Readers.JsonFileReader;
import Readers.XmlFileReader;
import org.mariuszgromada.math.mxparser.Expression;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        XmlFileReader xmlFileReader = new XmlFileReader();
        ArrayList<ExpressionContainer> list = xmlFileReader.read("second.xml");
        System.out.println(list);
    }
}
