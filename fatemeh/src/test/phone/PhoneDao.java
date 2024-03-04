package test.phone;

import test.Repository;
import test.address.AddressDao;
import test.address.AddressEn;
import test.input.Input;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            phoneEn1.setPhoneNumber(resultSet.getString("phoneNumber"));
            phoneEn1.setPhoneType(resultSet.getString("phoneType"));
            //phoneEn1.setPerson(resultSet.getInt("person_id"));

            phoneEns.add(phoneEn1);
        }
        return phoneEns;
    }


    public static void insert(PhoneEn phoneEn) throws Exception {
        preparedStatement = Repository.getConnection().prepareStatement("insert into phone (phoneNumber,phoneType,person_id) values (?, ?,?)");
        //preparedStatement.setInt(1, phoneEn.getId());

        preparedStatement.setString(1, phoneEn.getPhoneNumber());

        preparedStatement.setString(2, phoneEn.getPhoneType().name());
        preparedStatement.setInt(3, phoneEn.getPersonEn().getId());
        preparedStatement.executeUpdate();
        /*preparedStatement.close();
        connection.close();*/
    }


    public static void update(PhoneEn phoneEn) throws Exception {
        preparedStatement = Repository.getConnection().prepareStatement("update phone set phonenumber=? where id = ? ");
        preparedStatement.setString(1, phoneEn.getPhoneNumber());
        preparedStatement.setInt(2, phoneEn.getId());
        preparedStatement.executeUpdate();
      /*  preparedStatement.close();
        connection.close();*/
    }


    public static void delete(int id) throws Exception {
        preparedStatement = Repository.getConnection().prepareStatement("delete from phone where id=?");
        System.out.println("id");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
     /*   preparedStatement.close();
        connection.close();*/
    }

    public static PhoneEn getPhoneByID(int id) {
        try {
            preparedStatement = Repository.getConnection().prepareStatement("select * from phone where id = ? ");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            PhoneEn phoneEn = new PhoneEn();
            phoneEn.setId(resultSet.getInt("id"));
            phoneEn.setPhoneNumber(resultSet.getString("phoneNumber"));
            phoneEn.setPhoneType(resultSet.getString("phoneType"));
            return phoneEn;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



}


