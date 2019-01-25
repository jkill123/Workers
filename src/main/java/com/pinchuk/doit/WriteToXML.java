package com.pinchuk.doit;

import org.jdom2.Namespace;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class WriteToXML {

  DocumentBuilder builder;

  public void Settings(){
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    try { builder = factory.newDocumentBuilder(); }
    catch (ParserConfigurationException e){ e.printStackTrace(); }
  }

  public void Write() throws TransformerException, IOException{
    Document doc = builder.newDocument();

    Element RootElement = doc.createElement("list");

      Element NameElementTitle=doc.createElement("person");
      RootElement.appendChild(NameElementTitle);

    doc.appendChild(RootElement);


    Transformer t=TransformerFactory.newInstance().newTransformer();

    t.setOutputProperty(OutputKeys.INDENT, "yes");
    DOMSource source = new DOMSource(doc);

    StreamResult console = new StreamResult(System.out);
    StreamResult file = new StreamResult(new File("list.xml"));

    t.transform(source, console);
    t.transform(source, file);

    t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream("list.xml")));
  }





  private static Node getPerson(Document doc, String id, String name, String surname, String dateBirthday, String dateStartWorking) {
    Element person = doc.createElement("Person");

    person.setAttribute("id", id);
    person.appendChild(getElements(doc, person, "name", name));
    person.appendChild(getElements(doc, person, "surname", surname));
    person.appendChild(getElements(doc, person, "dateBirthday", dateBirthday));
    person.appendChild(getElements(doc, person, "dateStartWorking", dateStartWorking));
    return person;
  }

  private static Node getElements(Document doc, Element element, String name, String value) {
    Element node = doc.createElement(name);
    node.appendChild(doc.createTextNode(value));
    return node;
  }

  public static void writeToXMLJDOM(List<Worker> workers, String fileName) throws IOException{
    org.jdom2.Document doc = new org.jdom2.Document();
    doc.setRootElement( new org.jdom2.Element("Company", Namespace.getNamespace("person")));
    for (Worker worker : workers){
      org.jdom2.Element workerElement = new org.jdom2.Element("Person", Namespace.getNamespace("person"));
      workerElement.setAttribute("id", String.valueOf(worker.getId()));
      workerElement.addContent(new org.jdom2.Element("name").setText(worker.getName()));
      workerElement.addContent(new org.jdom2.Element("surname").setText(worker.getSurname()));
      workerElement.addContent(new org.jdom2.Element("DateBirthday").setText(worker.getDateBirthday()));
      workerElement.addContent(new org.jdom2.Element("DateStartWorking").setText(worker.getDateStartWorking()));
      workerElement.addContent(new org.jdom2.Element("type").setText(" "));

      doc.getRootElement().addContent(workerElement);
    }

    XMLOutputter xmlWriter = new XMLOutputter(Format.getPrettyFormat());
    xmlWriter.output(doc, new FileOutputStream(fileName));
  }
}
