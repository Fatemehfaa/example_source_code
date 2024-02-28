package test.phone;

import test.Repository;
import test.input.Input;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PhoneDao {

    public static PreparedStatement preparedStatement;

    public static ArrayList<PhoneEn> select() throws Exception {
        preparedStatement = Repository.getConnection().prepareStatement("select * from phone");
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<PhoneEn> phoneEns = new ArrayList<>();
        while (resultSet.next()) {
            PhoneEn phoneEn1 = new PhoneEn();
            phoneEn1.setId(resultSet.getInt("id"));
            phoneEn1.setPhoneNumber(resultSet.getInt("phone number"));
            phoneEns.add(phoneEn1);
        }
        return phoneEns;
    }


    public static void insert() throws Exception {
        preparedStatement = Repository.getConnection().prepareStatement("insert into phone (id , phoneNumber) values (? ,?)");
        System.out.println("enter id");
        preparedStatement.setInt(1, Input.getScanner().nextInt());
        System.out.println("enter phone number");
        preparedStatement.setInt(2, Input.getScanner().nextInt());
        preparedStatement.executeUpdate();
        /*preparedStatement.close();
        connection.close();*/
    }


    public static void update() throws Exception {
        preparedStatement = Repository.getConnection().prepareStatement("update phone set phonenumber=? where id = ? ");
        System.out.println("update phone number");
        preparedStatement.setInt(1, Input.getScanner().nextInt());
        System.out.println("id update");
        preparedStatement.setInt(2, Input.getScanner().nextInt());
        preparedStatement.executeUpdate();
      /*  preparedStatement.close();
        connection.close();*/
    }


    public static void delete(int id) throws Exception {
        preparedStatement = Repository.getConnection().prepareStatement("delete from phone where id=?");
        System.out.println("id");
        preparedStatement.setInt(1, Input.getScanner().nextInt());
        preparedStatement.executeUpdate();
     /*   preparedStatement.close();
        connection.close();*/
    }
}


