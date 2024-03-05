package test.phone;

import test.Repository;

import test.person.PersonDao;
import test.person.PersonEn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

            PersonEn personEn = PersonDao.getByIdPerson(resultSet.getInt("person_id"));
            phoneEn1.setPerson(personEn);
            phoneEns.add(phoneEn1);
        }
        return phoneEns;
    }


    public static void insert(PhoneEn phoneEn) throws Exception {
        preparedStatement = Repository.getConnection().prepareStatement("insert into phone (phoneNumber,phoneType,person_id) values (?, ?,?)");
        preparedStatement.setString(1, phoneEn.getPhoneNumber());
        preparedStatement.setString(2, phoneEn.getPhoneType().name());
        preparedStatement.setInt(3, phoneEn.getPerson().getId());
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

    public static List<PhoneEn> getAllPhoneByIdPerson(int idPerson){
        String query = "select * from phone where person_id = ?";
        List<PhoneEn> listPhoneByIdPerson = new ArrayList<>();
        try {
            PreparedStatement preparedStatement1 = Repository.getConnection().prepareStatement(query);
            preparedStatement1.setInt(1,idPerson);
            ResultSet resultSet = preparedStatement1.executeQuery();
            while (resultSet.next()){
                PhoneEn phone = new PhoneEn();
                phone.setId(resultSet.getInt("id"));
                phone.setPhoneNumber(resultSet.getString("phoneNumber"));
                phone.setPhoneType(resultSet.getString("phoneType"));
                PersonEn person = PersonDao.getByIdPerson(resultSet.getInt("person_id"));
                phone.setPerson(person);
                listPhoneByIdPerson.add(phone);
            }
            return listPhoneByIdPerson;
        }catch (Exception ex){
            System.out.println("by id person not found ... ");
        }
        return null;
    }


}


