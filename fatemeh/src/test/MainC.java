package test;

import test.address.AddressSer;
import test.input.Input;
import test.person.PersonSer;
import test.phone.PhoneSer;


public class MainC {

    public static void main(String[] args) throws Exception {
        boolean t = true;

        while (t) {
            System.out.println("1.address \t 2.phone \t 3.person \t 4.exit");
            System.out.println("select one number :");
            int select1 = Input.getScanner().nextInt();
            switch (select1) {
                case 1:
                    AddressSer.getMenuAddress();
                    break;
                case 2:
                    PhoneSer.getMenuphone();
                    break;
                case 3:
                    PersonSer.menuPerson();
                    break;
                case 4:
                    t = false;
                    break;
                default:
                    System.out.println("nooo");
            }
        }

    }
}

