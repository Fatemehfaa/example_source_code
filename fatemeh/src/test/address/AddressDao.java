package test.address;

import test.Repository;
import test.input.Input;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressDao  {
    private static PreparedStatement preparedStatement;
    private static List<AddressEn> listAddress;

    public AddressDao() throws Exception{

    }

    public static List<AddressEn> getListAddress(){
        if (listAddress==null || listAddress.isEmpty()){
            listAddress = new ArrayList<>();
            return listAddress;
        }
        return listAddress;
    }


    public static void insert(Integer id) throws Exception{

        preparedStatement =Repository.getConnection().prepareStatement("insert into address (id , street , zipcode) values (? ,? ,?)");

        preparedStatement.setInt(1 ,id);
        System.out.println("enter street: ");
        preparedStatement.setString(2,Input.getScanner().next());
        System.out.println("enter zip code: ");
        preparedStatement.setInt(3 ,Input.getScanner().nextInt());
        preparedStatement.executeUpdate();
        //connection.close();
        preparedStatement.close();
    }

    public static void update() throws Exception{
        preparedStatement = Repository.getConnection().prepareStatement("update address set street = ?, zipcode=?  where id = ?");
        System.out.println("update street :");
        preparedStatement.setString( 1 , Input.getScanner().next());
        System.out.println("update zip code: ");
        preparedStatement.setInt(2,Input.getScanner().nextInt());
        System.out.println("update id: ");
        preparedStatement.setInt(3, Input.getScanner().nextInt());
        preparedStatement.executeUpdate();
    /*    connection.close();
        preparedStatement.close();*/
    }

    public static void delete(Integer id) throws Exception{
        preparedStatement = Repository.getConnection().prepareStatement("delete from address where id =?");
        System.out.println("id delete ");
        preparedStatement.setInt(1 ,Input.getScanner().nextInt());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        //connection.close();
    }

/*    public static void count(int id) throws Exception{
        preparedStatement = Repository.getConnection().prepareStatement("select count(*) from address where id =id");
        try {
            AddressSer addressSer = new AddressSer();
            ArrayList<AddressEn> addressEnArrayList = addressSer.getAddress();
            for (AddressEn address : addressEnArrayList) {
                System.out.println(address.getId());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }*/

    public  ArrayList<AddressEn> select() throws Exception{
        preparedStatement =Repository.getConnection().prepareStatement("select * from address");
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
