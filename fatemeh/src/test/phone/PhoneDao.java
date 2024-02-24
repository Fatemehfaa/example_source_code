package test.phone;

import sun.dc.pr.PRError;
import test.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneDao extends Repository {
    public PreparedStatement preparedStatement;
    private static PhoneEn phoneEn;
    Scanner scanner = new Scanner(System.in);

    PhoneDao() throws Exception{

    }

    public void insert() throws Exception{
        preparedStatement = connection.prepareStatement("insert into phone set(id , phone number) values (? ,?)");
        System.out.println("enter id");
        preparedStatement.setInt(1, scanner.nextInt());
        System.out.println("enter phone number");
        preparedStatement.setInt(2 , scanner.nextInt());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }


    public void update() throws Exception{
        preparedStatement = connection.prepareStatement("update phone set phone number=? where id = ? ");
        System.out.println("update phone number");
        preparedStatement.setInt(1,scanner.nextInt());
        System.out.println("id update");
        preparedStatement.setInt(2, scanner.nextInt());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }


    public void delete(int id) throws Exception{
        preparedStatement = connection.prepareStatement("delete from phone where id=?");
        System.out.println("id");
        preparedStatement.setInt(1 , scanner.nextInt());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    public ArrayList<PhoneEn> select() throws Exception{
        preparedStatement= connection.prepareStatement("select * from phone");
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
