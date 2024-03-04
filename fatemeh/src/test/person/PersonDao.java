package test.person;

import test.Repository;
import test.address.AddressDao;
import test.address.AddressEn;
import test.input.Input;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PersonDao {
    public PersonDao() {
    }

    private static PreparedStatement preparedStatement;

    public static void insert(PersonEn personEn) throws Exception {
        preparedStatement = Repository.getConnection().prepareStatement("insert into person ( firstname , lastname ,gender , address_id) values (? ,? ,?, ?) ");
       // preparedStatement.setInt(1, id);

        preparedStatement.setString(1,personEn.getFirstname());
        preparedStatement.setString(2,personEn.getLastname());
        preparedStatement.setString(3,personEn.getGender().name());
        preparedStatement.setInt(4,personEn.getAddress().getId());

     /*   System.out.println("enter first name: ");
        preparedStatement.setString(1, Input.getScanner().next());
        System.out.println("enter last name: ");
        preparedStatement.setString(2, Input.getScanner().next());
        System.out.println("enter gender (MEN / WOMEN):");
        preparedStatement.setString(3, Input.getScanner().next());
        System.out.println("enter address ID: ");
        preparedStatement.setInt(4, Input.getScanner().nextInt());*/
        preparedStatement.executeUpdate();
        //connection.close();
        preparedStatement.close();


    }


    public static void update(PersonEn personEn) throws Exception {
        preparedStatement = Repository.getConnection().prepareStatement("update person set firstname = ? ,lastname = ? where id = ?");
        preparedStatement.setString(1,personEn.getFirstname());
        preparedStatement.setString(2, personEn.getLastname());
        preparedStatement.setInt(3, personEn.getId());
        preparedStatement.executeUpdate();
        //connection.close();
        preparedStatement.close();

    }


    public static void delete(int id) throws Exception {
        preparedStatement = Repository.getConnection().prepareStatement("delete from person where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        //connection.close();
        preparedStatement.close();

    }

    public static ArrayList<PersonEn> select() throws Exception {

        preparedStatement = Repository.getConnection().prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<PersonEn> personEns = new ArrayList<>();

        while (resultSet.next()) {
            PersonEn personEn1 = new PersonEn();
            personEn1.setId(resultSet.getInt("id"));
            personEn1.setFirstname(resultSet.getString("Firstname"));
            personEn1.setLastname(resultSet.getString("Lastname"));
            personEn1.setGender(resultSet.getString("gender"));
//            // lazy load
//            AddressEn addressEn = new AddressEn();
//            addressEn.setId(resultSet.getInt("address_id"));
//            personEn1.setAddress(addressEn);

            // eager load
            AddressEn address = AddressDao.getByIdAddress(resultSet.getInt("address_id"));
            personEn1.setAddress(address);

            personEns.add(personEn1);
        }
        return personEns;

    }


    public static PersonEn getByIdPerson(int id) {
        try {
            preparedStatement = Repository.getConnection().prepareStatement("select * from Person where id =?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            PersonEn personEn1 = new PersonEn();
            personEn1.setId(resultSet.getInt("id"));
            personEn1.setFirstname(resultSet.getString("firstname"));
            personEn1.setLastname(resultSet.getString("lastname"));
            personEn1.setGender(resultSet.getString("gender"));
            return personEn1;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException("person by id " + id + " not found ...");
        }

    }
}