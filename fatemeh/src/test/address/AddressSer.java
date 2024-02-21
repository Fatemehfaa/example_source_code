package test.address;

import test.Repository;
import test.input.Input;

public class AddressSer extends Repository {
    private static int id = 1;

    public AddressSer() throws Exception {
    }

    public void registerAddress(AddressSer addressSer) throws Exception{
        AddressDao addressDao = new AddressDao();
        addressDao.insert();
        addressDao.update();
    }

    public static void getMenuAddress(){
        boolean t = true;
        while (t){
            System.out.println("1.add Address \t 2.show all Address \t 3.find Address By ID \t 4.back");
            System.out.println("select one number: ");
            int select = Input.getScanner().nextInt();
            switch (select){
                case 1:
                    AddressEn address = new AddressEn();
                    address.setId(id);
                    System.out.println("enter street :");
                    address.setStreet(Input.getScanner().next());
                    System.out.println("enter zipCode");
                    address.setZipCode(Input.getScanner().nextInt());
                    AddressDao.getListAddress().add(address);


                    id++;
                    break;
                case 2:
                    for (AddressEn addressEn:AddressDao.getListAddress()) {
                        System.out.println(addressEn);
                    }
                    break;
                case 3:
                    System.out.println("enter id :");
                    int addressId = Input.getScanner().nextInt();
                    for (AddressEn addressEn:AddressDao.getListAddress()) {
                        if (addressEn.getId() == addressId)
                            System.out.println(addressEn);
                    }
                    break;
                case 4:
                    t=false;
                    break;
            }
        }
    }

}
