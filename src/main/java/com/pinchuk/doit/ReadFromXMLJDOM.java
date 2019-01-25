package com.pinchuk.doit;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReadFromXMLJDOM {
  public static void readFromXMLJDOM(String fileName, String workerName, String workerType){

    File file = new File(fileName);
    try{
      Document doc = new SAXBuilder().build(file);
      Element root = doc.getRootElement();
      List list = root.getChildren("Person");
      XMLOutputter xmlOut = new XMLOutputter();

      for (int i=0;i<list.size();i++) {

        Element node = (Element) list.get(i);
        if (node.getChildText("name").equals(workerName))
            node.getChild("type").setText(workerType);
        xmlOut.setFormat(Format.getPrettyFormat());
        xmlOut.output(doc, new FileWriter(fileName));
      }
    } catch (IOException | JDOMException io){
      System.out.println(io.getMessage());
    }
  }
}
