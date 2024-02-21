package test.person;

import test.Repository;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class PersonDao extends Repository {
    Scanner sc = new Scanner(System.in);
    public PreparedStatement preparedStatement;
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

    public void insert(PersonDao personDao) throws Exception{
        preparedStatement = connection.prepareStatement("insert into person set (id , first name , last name , address )values (? ,? ,? , ?) ");
        System.out.println("enter id: ");
        preparedStatement.setInt(1 , sc.nextInt());
        System.out.println("enter first name: ");
        preparedStatement.setString(2,sc.next());
        System.out.println("enter last name: ");
        preparedStatement.setString(3,sc.next());
        System.out.println("enter address: ");
        preparedStatement.setString(4,sc.next());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }


    public void update(PersonDao personDao) throws Exception{
        preparedStatement = connection.prepareStatement("update person first name = ? ,last name = ? , address = ? where id = ?");
        System.out.println("update first name: ");
        preparedStatement.setString(1, sc.next());
        System.out.println("update last name: ");
        preparedStatement.setString(2, sc.next());
        System.out.println("update address: ");
        preparedStatement.setString(3, sc.next());
        System.out.println("id: ");
        preparedStatement.setLong(4, sc.nextInt());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }


    public void delete (int id) throws  Exception{
        preparedStatement = connection.prepareStatement("delete from person where id = ?");
        preparedStatement.setInt(1 , sc.nextInt());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }






}