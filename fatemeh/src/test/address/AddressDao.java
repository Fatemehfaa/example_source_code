package test.address;

import test.Repository;
import test.input.Input;
import test.person.PersonEn;

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


    public static void insert(AddressEn addressEn) throws Exception{

        preparedStatement =Repository.getConnection().prepareStatement("insert into address ( street , zipcode) values (? ,?)");
       // preparedStatement.setInt(1 ,addressEn.getId());
        preparedStatement.setString(1,addressEn.getStreet());
        preparedStatement.setInt(2 ,addressEn.getZipCode());
        preparedStatement.executeUpdate();
        //connection.close();
        preparedStatement.close();
    }

    public static void update(AddressEn addressEn) throws Exception{
        preparedStatement = Repository.getConnection().prepareStatement("update address set street = ?, zipcode=?  where id = ?");
        preparedStatement.setString( 1 ,addressEn.getStreet());
        preparedStatement.setInt(2,addressEn.getZipCode());
        preparedStatement.setInt(3, addressEn.getId());
        preparedStatement.executeUpdate();
    /*    connection.close();
        preparedStatement.close();*/
    }

    public static void delete(Integer id) throws Exception{
        preparedStatement = Repository.getConnection().prepareStatement("delete from address where id =?");
        System.out.println("id delete ");
        preparedStatement.setInt(1 ,id);
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


    public static AddressEn getByIdAddress(int id) {
        try {
          preparedStatement= Repository.getConnection().prepareStatement("select * from address where id =?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            AddressEn addressEn1 = new AddressEn();
            addressEn1.setId(resultSet.getInt("id"));
            addressEn1.setStreet(resultSet.getString("street"));
            addressEn1.setZipCode(resultSet.getInt("zipCode"));
            return addressEn1;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException("address not found ...");
        }
    }




}
