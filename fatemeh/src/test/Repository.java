package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;

public class Repository {
    public Connection connection;
    public ParameterMetaData parameterMetaData;

    public Repository() throws Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice" , "root" , "123456");
        System.out.println("new connection");
    }

}
