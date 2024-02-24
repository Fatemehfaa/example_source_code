package test.address;

import test.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressDao extends Repository {
    private PreparedStatement preparedStatement;
    Scanner scanner = new Scanner(System.in);

    private static List<AddressEn> listAddress;

    AddressDao() throws Exception {
    }

    public static List<AddressEn> getListAddress(){
        if (listAddress==null || listAddress.isEmpty()){
            listAddress = new ArrayList<>();
            return listAddress;
        }
        return listAddress;
    }


    public void insert() throws Exception{

        preparedStatement = connection.prepareStatement("insert into address (id , street , zipcode) values (? ,? ,?)");
        System.out.println("enter id: ");
        preparedStatement.setInt(1 ,scanner.nextInt() );
        System.out.println("enter street: ");
        preparedStatement.setString(2,scanner.next());
        System.out.println("enter zip code: ");
        preparedStatement.setInt(3 , scanner.nextInt());
        preparedStatement.executeUpdate();
        connection.close();
        preparedStatement.close();
    }

    public void update() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice" , "root" , "123456");
        preparedStatement = connection.prepareStatement("update address set street = ?, zip code=?  where id = ?");
        System.out.println("update street :");
        preparedStatement.setString( 1 ,scanner.next());
        System.out.println("update zip code: ");
        preparedStatement.setInt(2,scanner.nextInt());
        System.out.println("update id: ");
        preparedStatement.setInt(3, scanner.nextInt());
        preparedStatement.executeUpdate();
        connection.close();
        preparedStatement.close();
    }

    public void delete(int id) throws Exception{
        preparedStatement = connection.prepareStatement("delete from address where id =?");
        System.out.println("id delete ");
        preparedStatement.setInt(1 , scanner.nextInt());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    public  ArrayList<AddressEn> select() throws Exception{
        preparedStatement = connection.prepareStatement("select * from address");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<AddressEn> address  = new ArrayList<>();

        while (resultSet.next()){
            AddressEn addressEn = new AddressEn();
            addressEn.setId(resultSet.getInt("id"));
            addressEn.setStreet(resultSet.getString("street"));
            addressEn.setZipCode(resultSet.getInt("zipCode"));

            address.add(addressEn);
        }
        return address;
    }




}
