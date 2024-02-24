package test;

import test.address.AddressEn;
import test.address.AddressSer;
import test.input.Input;
import test.person.PersonDao;
import test.person.PersonEn;
import test.person.PersonSer;
import test.phone.PhoneSer;

import java.util.ArrayList;

public class MainC extends Repository{
    public MainC() throws Exception {
    }

    public static void main(String[] args) throws Exception {
        boolean t = true;

        while (t){
            System.out.println("1.address \t 2.phone \t 3.person \t\t 4.exit");
            System.out.println("select one number :");
            int select = Input.getScanner().nextInt();
            switch (select){
                case 1:
                    //AddressSer.getMenuAddress();
                    AddressSer addressSer = new AddressSer();
                    addressSer.registerAddress(addressSer);
                    break;
                case 2 :
                    //PhoneSer.getMenuphone();
                    PhoneSer phoneSer = new PhoneSer();
                    phoneSer.getPhone();
                    break;
                case 3:
                    //PersonSer.menuPerson();
                    PersonSer personSer = new PersonSer();
                    personSer.getPerson();
                    ArrayList<PersonDao> personEnArrayList = personSer.getPerson();
                  /*  for (PersonEn person : personEnArrayList){
                        System.out.println(person.getId());
                        System.out.println(person.getFirstname());
                        System.out.println(person.getLastname());
                    }*/


                    break;
                case 4:
                    t=false;
                    break;
                default:
                    System.out.println("nooo");
            }
        }

    }
}
