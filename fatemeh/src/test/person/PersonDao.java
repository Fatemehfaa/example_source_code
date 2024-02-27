package test.person;

import test.Repository;
import test.input.Input;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PersonDao {
    public PersonDao() {
    }

    private static PreparedStatement preparedStatement;
    private static PersonEn personEn;
    private static ArrayList<PersonEn> personEn1;

    public static PersonEn getInstance(){
        if(personEn==null){
            personEn = new PersonEn();
            return personEn;
        }
        return personEn;
    }
    public static void insert(int id) throws Exception{
        preparedStatement =Repository.getConnection().prepareStatement("insert into person (id , firstname , lastname) values (? ,? ,?) ");
        System.out.println("enter id: ");
        preparedStatement.setInt(1 , Input.getScanner().nextInt());
        System.out.println("enter first name: ");
        preparedStatement.setString(2,Input.getScanner().next());
        System.out.println("enter last name: ");
        preparedStatement.setString(3,Input.getScanner().next());
        preparedStatement.executeUpdate();
       //connection.close();
        preparedStatement.close();


    }


    public static void update() throws Exception{
        preparedStatement =Repository.getConnection().prepareStatement("update person set (firstname = ? ,lastname = ? )  where id = ?");
        System.out.println("update first name: ");
        preparedStatement.setString(1,Input.getScanner().next());
        System.out.println("update last name: ");
        preparedStatement.setString(2,Input.getScanner().next());
        System.out.println("id: ");
        preparedStatement.setLong(4,Input.getScanner().nextInt());
        preparedStatement.executeUpdate();
        //connection.close();
        preparedStatement.close();

    }


    public static void delete (int id) throws  Exception{
        preparedStatement = Repository.getConnection().prepareStatement("delete from person where id = ?");
        preparedStatement.setInt(1 ,Input.getScanner().nextInt());
        preparedStatement.executeUpdate();
        //connection.close();
        preparedStatement.close();

    }

    public static ArrayList<PersonEn> select() throws Exception{

        preparedStatement = Repository.getConnection().prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<PersonEn> personEns = new ArrayList<>();

        while(resultSet.next()){
            PersonEn personEn1 = new PersonEn();
            personEn1.setId(resultSet.getInt("id"));
            personEn1.setFirstname(resultSet.getString("Firstname"));
            personEn1.setLastname(resultSet.getString("Lastname"));
            personEns.add(personEn1);
        }
        return personEns;

    }


}