package test.person;

import test.Repository;
import test.input.Input;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonDao extends Repository {
    private PreparedStatement preparedStatement;
    private static PersonEn personEn;

    PersonDao() throws Exception{
    }

    public static PersonEn getInstance(){
        if(personEn==null){
            personEn = new PersonEn();
            return personEn;
        }
        return personEn;
    }

    public void insert() throws Exception{
        preparedStatement = getConnection().prepareStatement("insert into person (id , firstname , lastname) values (? ,? ,?) ");
        System.out.println("enter id: ");
        preparedStatement.setInt(1 , Input.getScanner().nextInt());
        System.out.println("enter first name: ");
        preparedStatement.setString(2,Input.getScanner().next());
        System.out.println("enter last name: ");
        preparedStatement.setString(3,Input.getScanner().next());
        preparedStatement.executeUpdate();
       /* connection.close();
        preparedStatement.close();*/


    }


    public void update() throws Exception{
        preparedStatement = getConnection().prepareStatement("update person set (firstname = ? ,lastname = ? , address =?)  where id = ?");
        System.out.println("update first name: ");
        preparedStatement.setString(1,Input.getScanner().next());
        System.out.println("update last name: ");
        preparedStatement.setString(2,Input.getScanner().next());
        System.out.println("update address: ");
        preparedStatement.setString(3,Input.getScanner().next());
        System.out.println("id: ");
        preparedStatement.setLong(4,Input.getScanner().nextInt());
        preparedStatement.executeUpdate();
        //connection.close();
        preparedStatement.close();

    }


    public void delete (int id) throws  Exception{
        preparedStatement = getConnection().prepareStatement("delete from person where id = ?");
        preparedStatement.setInt(1 ,Input.getScanner().nextInt());
        preparedStatement.executeUpdate();
        //connection.close();
        preparedStatement.close();

    }

    public PersonEn select() throws Exception{

        preparedStatement = getConnection().prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<PersonEn> personEns = new ArrayList<>();
        while(resultSet.next()){
            PersonEn personEn1 = new PersonEn();
            personEn1.setId(resultSet.getInt("id"));
            personEn1.setFirstname(resultSet.getString("Firstname"));
            personEn1.setLastname(resultSet.getString("Lastname"));
            personEn1.setGender(resultSet.getString("Gender"));
            personEn1.setAddress(resultSet.getString("address"));
            personEns.add(personEn1);
        }
        return personEn;

    }






}