import Readers.ExpressionContainer;
import Readers.XmlFileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        XmlFileReader xmlFileReader = new XmlFileReader();
        ArrayList<ExpressionContainer> list = xmlFileReader.read("second.xml");
        System.out.println(list);
    }
}
