package test;

import test.address.AddressSer;
import test.input.Input;
import test.person.PersonSer;
import test.phone.PhoneSer;

import java.util.Scanner;

public class MainC extends Repository{
    public MainC() throws Exception {
    }

    public static void main(String[] args) throws Exception {
        boolean t = true;

        while (t){
            System.out.println("1.address \t 2.person \t 3.phone \t\t 4.exit");
            System.out.println("select one number :");
            int select = Input.getScanner().nextInt();
            switch (select){
                case 1:
                    //AddressSer.getMenuAddress();
                    AddressSer addressSer = new AddressSer();
                    addressSer.registerAddress(addressSer);
                    break;
                case 2 :
                    PhoneSer.getMenuphone();
                    break;
                case 3:
                    //PersonSer.menuPerson();
                    PersonSer personSer = new PersonSer();
                    personSer.getPerson(personSer);

                    break;
                case 4:
                    t=false;
                    break;
            }
        }

    }
}
