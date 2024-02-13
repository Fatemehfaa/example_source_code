package test.address;

import java.util.ArrayList;
import java.util.List;

public class AddressDao {

    private static List<AddressEn> listAddress;

    private AddressDao(){}

    public static List<AddressEn> getListAddress(){
        if (listAddress==null || listAddress.isEmpty()){
            listAddress = new ArrayList<>();
            return listAddress;
        }
        return listAddress;
    }

}
