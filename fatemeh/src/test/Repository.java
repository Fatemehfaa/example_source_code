/*
package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class Repository2 {
    private static Connection connection;
    private String url = "jdbc:mysql://localhost:3306/practice";
    private String usrName = "root";
    private String password = "123456";

    private Repository2() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,usrName, password);
            System.out.println("new connection");
        } catch (Exception e) {
            System.out.println("error");
        }
    }
    public static Connection getConnection() {
        return connection;
    }
}
*/


package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;

public class Repository {
    private static Connection connection ;
/*  private Repository() throws Exception {

    }*/
      static {
        final String url = "jdbc:mysql://localhost:3306/practice";
        final String userName = "root";
        final String password = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("new connection");
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public Repository() {
          if(connection == null){

          }
    }

    public static Connection getConnection() {
        return connection;
    }
}


