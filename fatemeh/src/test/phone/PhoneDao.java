package test.phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PhoneDao {

    private static PhoneEn phone = new PhoneEn();

    private PhoneDao() throws Exception{
    }
    public static PhoneEn getPhone(){
        return phone;
    }


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
