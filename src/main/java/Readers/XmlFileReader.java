package Readers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class XmlFileReader {
    public static ExpressionContainer read(String filename){
        try {
            ExpressionContainer container = new ExpressionContainer();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse("__fixtures__/" + filename);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("expressions");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                //ExpressionContainer tempContainer = new ExpressionContainer();
                ArrayList<String> expressions = new ArrayList<>();
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    NodeList expList = eElement.getElementsByTagName("expression");
                    for (int count = 0; count < expList.getLength(); count++) {
                        Node node1 = expList.item(count);
                        if (node1.getNodeType() == node1.ELEMENT_NODE) {
                            Element exp = (Element) node1;
                            expressions.add(exp.getTextContent());
                        }
                    }
                }
                container.expressions = expressions;
            }
            return container;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
