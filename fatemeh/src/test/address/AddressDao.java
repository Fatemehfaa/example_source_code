package test.address;

import test.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressDao extends Repository {
    private PreparedStatement preparedStatement;
    Scanner scanner = new Scanner(System.in);

    private static List<AddressEn> listAddress;

    AddressDao() throws Exception {
    }

    public static List<AddressEn> getListAddress(){
        if (listAddress==null || listAddress.isEmpty()){
            listAddress = new ArrayList<>();
            return listAddress;
        }
        return listAddress;
    }


    public void insert() throws Exception{
        System.out.println("enter id: ");
        int input = scanner.nextInt();
        System.out.println("enter street: ");
        String input1 = scanner.next();
        System.out.println("enter zip code: ");
        String input2 = scanner.next();
        preparedStatement = connection.prepareStatement("insert into address (id , street , zipcode) values (? ,? ,?)");
        preparedStatement.setInt(1 ,input );
        preparedStatement.setString(2,input1);
        preparedStatement.setString(3,input2);
        preparedStatement.executeUpdate();
        connection.close();
        preparedStatement.close();
    }

    public void update() throws Exception{
        preparedStatement = connection.prepareStatement("update address set street = ?, zip code=?  where id = ?");
        System.out.println("update street :");
        preparedStatement.setString( 1 ,scanner.next());
        System.out.println("update zip code: ");
        preparedStatement.setInt(2,scanner.nextInt());
        System.out.println("update id: ");
        preparedStatement.setInt(3, scanner.nextInt());
        preparedStatement.executeUpdate();
        connection.close();
        preparedStatement.close();

    }




}
