package com.pinchuk.doit;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ShowAll {

  public static ArrayList<Worker> workers = new ArrayList<>();

  public static void showAll() throws ParserConfigurationException, IOException, SAXException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(new File("list.xml"));

    NodeList employeeEl = document.getDocumentElement().getElementsByTagName("Person");

    for (int i=0; i< employeeEl.getLength();i++){
      Node employee = employeeEl.item(i);
      NamedNodeMap attribute = employee.getAttributes();
      workers.add(new Worker(attribute.getNamedItem("id").getNodeValue(),attribute.getNamedItem("name").getNodeValue(),attribute.getNamedItem("surname").getNodeValue(),attribute.getNamedItem("DateBirthday").getNodeValue(),attribute.getNamedItem("DateStartWorking").getNodeValue()));
    }

    for (Worker  employee : workers)
      System.out.println(String.format(employee.getId(), employee.getName(),employee.getSurname(),employee.getDateBirthday(),employee.getDateStartWorking()));

  }
}
