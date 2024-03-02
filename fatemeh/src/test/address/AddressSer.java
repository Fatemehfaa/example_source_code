package test.address;

import test.Repository;
import test.input.Input;

import java.util.ArrayList;

public class AddressSer {
    private static int id = 1;

    public AddressSer() throws Exception {
    }

    public static ArrayList<AddressEn> getAddress() {
        ArrayList<AddressEn> addressEnArrayList = new ArrayList<>();
        try {
            AddressDao addressDao = new AddressDao();
            addressEnArrayList = addressDao.select();

        } catch (Exception e) {
            System.out.println("error");
        }


        return addressEnArrayList;
    }

    public static void getMenuAddress() {
        boolean t = true;
        while (t) {
            System.out.println("1.add Address \t 2.update address \t 3.delete address \t 4.show all Address \t 5.back");
            System.out.println("select one number: ");
            int select1 = Input.getScanner().nextInt();
            switch (select1) {
                case 1:
                    try {
                        AddressEn addressEn = new AddressEn();
                        addressEn.setId(id);
                        System.out.println("enter street: ");
                        addressEn.setStreet(Input.getScanner().next());
                        System.out.println("enter zip code: ");
                        addressEn.setZipCode(Input.getScanner().nextInt());
                        AddressDao.insert(addressEn);
                    }catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    id++;
                    break;
                case 2:
                    try {
                        AddressDao.update();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try{
                        AddressDao.delete(id);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    /*System.out.println("enter id :");
                    int addressId = Input.getScanner().nextInt();
                    for (AddressEn addressEn : AddressDao.getListAddress()) {
                        if (addressEn.getId() == addressId)
                            System.out.println(addressEn);
                    }*/
                    break;
                case 4:
                    try {
                        AddressSer addressSer = new AddressSer();
                        ArrayList<AddressEn> addressEnArrayList = addressSer.getAddress();
                        for (AddressEn addressEn1 : addressEnArrayList) {
                            System.out.println(addressEn1.getId());
                            System.out.println(addressEn1.getStreet());
                            System.out.println(addressEn1.getZipCode());
                        }
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    t = false;
                    break;
            }
        }
    }

}
