package test.phone;

import sun.dc.pr.PRError;
import test.Repository;
import test.input.Input;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneDao extends Repository {
    public PreparedStatement preparedStatement;
    private static PhoneEn phoneEn;
    PhoneDao() throws Exception{

    }

    public ArrayList<PhoneEn> select() throws Exception{
        preparedStatement=getConnection().prepareStatement("select * from phone");
        ResultSet resultSet= preparedStatement.executeQuery();

        ArrayList<PhoneEn> phoneEns = new ArrayList<>();
        while (resultSet.next()){
            PhoneEn phoneEn1 = new PhoneEn();
            phoneEn1.setId(resultSet.getInt("id"));
            phoneEn1.setPhoneNumber(resultSet.getInt("phone number"));
            phoneEns.add(phoneEn1);
        }
        return phoneEns;
    }


    public void insert() throws Exception{
        preparedStatement = getConnection().prepareStatement("insert into phone (id , phoneNumber) values (? ,?)");
        System.out.println("enter id");
        preparedStatement.setInt(1, Input.getScanner().nextInt());
        System.out.println("enter phone number");
        preparedStatement.setInt(2 ,Input.getScanner().nextInt());
        preparedStatement.executeUpdate();
        /*preparedStatement.close();
        connection.close();*/
    }


    public void update() throws Exception{
        preparedStatement = getConnection().prepareStatement("update phone set phonenumber=? where id = ? ");
        System.out.println("update phone number");
        preparedStatement.setInt(1,Input.getScanner().nextInt());
        System.out.println("id update");
        preparedStatement.setInt(2,Input.getScanner().nextInt());
        preparedStatement.executeUpdate();
      /*  preparedStatement.close();
        connection.close();*/
    }


    public void delete(int id) throws Exception{
        preparedStatement = getConnection().prepareStatement("delete from phone where id=?");
        System.out.println("id");
        preparedStatement.setInt(1 ,Input.getScanner().nextInt());
        preparedStatement.executeUpdate();
     /*   preparedStatement.close();
        connection.close();*/
    }



 /*   public static PhoneEn getPhone(){
        return phone;
    }*/


//    private static PhoneEn phone ;
//
//    private PhoneDao() {
//    }
//
//    public static PhoneEn getPhone(){
//        if(phone==null ){
//            phone= new PhoneEn();
//            return phone;
//        }
//        return phone;
//    }
}
