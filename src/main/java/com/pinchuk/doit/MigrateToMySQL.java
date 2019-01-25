package com.pinchuk.doit;

import com.mysql.jdbc.Connection;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MigrateToMySQL {
  String bdUrl = "jdbc:mysql://localhost:3306/mysql";
  String name = "root";
  String pwd = "root";
  Connection connection;

  {
    try {
      connection = (Connection) DriverManager.getConnection(bdUrl,name,pwd);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public Connection getConnection() throws SQLException {
    connection.createStatement()
            .execute("CREATE TABLE company(\n" +
                    "id text primary key auto_increment,\n"+
                    "name text not null, \n"+
                    "surname text not null, \n"+
                    "dateBirthday text not null, \n"+
                    "dateStartWorking text not null, \n"+
                    ")");
    return connection;
  }
  public static void migrate(String filename) throws ParserConfigurationException, IOException, SAXException {
    File file = new File(filename);
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document xmlDoc = builder.parse(file);

  }
}
