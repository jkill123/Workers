package com.pinchuk.doit;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class Sort {

//  private static List<Worker> readXML(String filename){
//    List<Worker> workerList = new ArrayList<>();
//    Worker worker = null;
//    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
//    try{
//      XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(filename));
//
//      while (reader.hasNext()){
//        XMLEvent xmlEvent = reader.nextEvent();
//        StartElement startElement = xmlEvent.asStartElement();
//        if(startElement.getName().getLocalPart().equals("Person")){
//          worker = new Worker();
//
//          Attribute idAttr = startElement.getAttributeByName(new QName("id"));
//          if (idAttr !=null){
//            worker.setId(xmlEvent.asCharacters().getData());
//          }
//        }
//
//      }
//    }
//  }
}
