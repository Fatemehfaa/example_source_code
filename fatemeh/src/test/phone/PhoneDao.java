package test.phone;

import test.Repository;
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


    public static void update() throws Exception {
        preparedStatement = Repository.getConnection().prepareStatement("update phone set phonenumber=? where id = ? ");
        System.out.println("update phone number");
        preparedStatement.setString(1, Input.getScanner().next());
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

//    public static Integer getCountIdPhone() throws SQLException {
//        String query = "select count(*) from phone";
//        PreparedStatement preparedStatement1 = Repository.getConnection().prepareStatement(query);
//        ResultSet resultSet = preparedStatement1.executeQuery();
//        resultSet.next();
//        return resultSet.getInt(1);
//    }

}


