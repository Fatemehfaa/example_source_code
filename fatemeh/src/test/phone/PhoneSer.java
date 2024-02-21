package test.phone;

import test.input.Input;

public class PhoneSer {


    public static void getMenuphone() {
        boolean t = true;
        while (t) {
            System.out.println("1.add phone \t 2.add type phone \t 3.show phone \t 4.exist");
            System.out.println("select one number :");
            int select1 = Input.getScanner().nextInt();
            switch (select1){
                case 1 :
                    PhoneEn phone = new PhoneEn();
                    System.out.println("enter your phone number:");
                    phone.setPhoneNumber(Input.getScanner().nextInt());
                    PhoneEn phoneEn = PhoneDao.getPhone();
                    break;
                case 2:
                    PhoneType mobile = PhoneType.MOBILE;
                    PhoneType phone1 = PhoneType.PHONE;
                    System.out.println("enter type phone:");
                    for (PhoneType person : PhoneType.values()) {
                        System.out.println(person);
                    }
                    break;
                case 3:

                case 4 :
                    t = false;
                    break;

            }
        }
    }
}
