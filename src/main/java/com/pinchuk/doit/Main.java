package com.pinchuk.doit;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws TransformerException, IOException, ParserConfigurationException, SAXException {
//        WriteToXML writeToXML = new WriteToXML();
//        writeToXML.Settings();
//        writeToXML.Write();
     System.out.println("Welcome to my Test Command line App");
     String file = "text.txt";
//        StringBuilder string = new StringBuilder();
//        try{
//            InputStream ips = new FileInputStream(file);
//            InputStreamReader reader = new InputStreamReader(ips);
//            BufferedReader breader = new BufferedReader(reader);
//            String line;
//            while ((line = breader.readLine()) != null){
//
////                System.out.println(line);
//                string.append(line).append("\n");
//                List<String> list = Arrays.asList(line.split(" "));
//                System.out.println(list);
////            }
//            breader.close();
//        }
//        catch (Exception e){
//            System.out.println(e.toString());
//        }}
      FileInputStream fstream = new FileInputStream(file);
      String line;
      String delimiter = " ";
      StringTokenizer tokenizer;
      BufferedReader input = null;
      List<Worker> workers = new ArrayList<>();
      String fileName = "list.xml";
      try{

        input = new BufferedReader(new InputStreamReader(fstream));
        while ((line = input.readLine()) !=null){
          tokenizer = new StringTokenizer(line,delimiter);
          while (tokenizer.hasMoreElements()){

            String id = tokenizer.nextToken();
            String name = tokenizer.nextToken();
            String surname = tokenizer.nextToken();
            String dateBirthday = tokenizer.nextToken();
            String dateStartWorking = tokenizer.nextToken();
            //Добавлю элементы в список
            workers.add(new Worker(id,name,surname,dateBirthday,dateStartWorking));
          }
        }
        WriteToXML.writeToXMLJDOM(workers,fileName);

      }catch (FileNotFoundException e) {
        System.out.println("Unable to open file " + fstream);
      } catch (IOException e) {
        System.out.println("Unable to read from file " + fstream);
      }finally {
        try {
          if (input != null) {
            input.close();
          }
        } catch (IOException e) {
          System.out.println("Unable to close file " + fstream);
        }
      }
      ReadFromXMLJDOM.readFromXMLJDOM(fileName, "Pinchuk", "Manager");
      //trying parse xml and put the type of worker
      ShowAll.showAll();
    }
}